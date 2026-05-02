package com.guidoroos.portfolio.util

import AppLanguage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.guidoroos.portfolio.data.content.HomePageContentEN
import com.guidoroos.portfolio.data.content.HomePageContentNL
import com.guidoroos.portfolio.data.content.ProjectContentEN
import com.guidoroos.portfolio.data.content.ProjectContentNL
import com.guidoroos.portfolio.data.content.projectsPageDataEN
import com.guidoroos.portfolio.data.content.projectsPageDataNL
import com.guidoroos.portfolio.data.model.Page
import com.guidoroos.portfolio.data.model.Project
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.events.Event

fun isSystemInDarkMode(): Boolean {
    // This returns true if the browser/OS is set to dark mode
    return window.matchMedia("(prefers-color-scheme: dark)").matches
}

fun getBrowserLanguage(): AppLanguage {
    val browserLang = window.navigator.language.take(2).lowercase()

    return when (browserLang) {
        "nl" -> AppLanguage.NL
        "en" -> AppLanguage.EN
        else -> AppLanguage.EN
    }
}

@Composable
fun rememberWindowWidth(): Int {
    var width by remember { mutableStateOf(window.innerWidth) }
    DisposableEffect(Unit) {
        val listener = { _: Event -> width = window.innerWidth }
        window.addEventListener("resize", listener)
        onDispose { window.removeEventListener("resize", listener) }
    }
    return width
}

fun updateUrl(page: Page, language: AppLanguage) {
    val langPrefix = if (language == AppLanguage.NL) "/nl" else "/en"

    val pagePath = when (page) {
        Page.Home -> "" // Wordt /nl of /en
        Page.Projects -> "/projects"
        is Page.ProjectDetail -> "/projects/${page.project.id}"
    }

    val fullPath = "$langPrefix$pagePath"
    window.history.replaceState(null, "", fullPath)
}

fun decodeInitialPage(): Page {
    val path = window.location.pathname.removePrefix("/")
    val segments = path.split("/").filter { it.isNotEmpty() }

    // 1. Bepaal de taal (eerste segment)
    val lang = segments.getOrNull(0) ?: "nl"
    // Hier kun je jouw taal-state updaten, bijv: language.value = lang

    // 2. Bepaal de pagina op basis van de rest van de segmenten
    val pagePath = segments.drop(1).joinToString("/")

    return when {
        pagePath == "projects" -> Page.Projects
        pagePath.startsWith("projects/") -> {
            val id = pagePath.substringAfterLast("/")
            // Gebruik de juiste content op basis van de gedetecteerde taal
            val projectList = if (lang == "en") ProjectContentEN.projects else ProjectContentNL.projects
            val project = projectList.find { it.id == id }

            if (project == null) Page.Projects else Page.ProjectDetail(project)
        }
        else -> Page.Home
    }
}

fun updateMetadata(page: Page, language: AppLanguage) {
    val doc = kotlinx.browser.document

    when (page) {
        Page.Home -> {
            // Gok: Je objecten heten HomePageContentNL / HomePageContentEN
            val content = if (language == AppLanguage.NL) HomePageContentNL else HomePageContentEN

            doc.title = content.title // Of content.seoTitle
            updateMetaDescription(content.metaDescription)
        }
        Page.Projects -> {
            // Gok: ProjectPageContentNL / ProjectPageContentEN
            val content = if (language == AppLanguage.NL) projectsPageDataNL else projectsPageDataEN

            doc.title = content.title
            updateMetaDescription(content.metaDescription)
        }
        is Page.ProjectDetail -> {
            // Voor een specifiek project zoeken we in je ProjectContent lijst
            val projectList = if (language == AppLanguage.NL) ProjectContentNL.projects else ProjectContentEN.projects
            val project = projectList.find { it.id == page.project.id }

            project?.let {
                doc.title = "${it.title} | Portfolio Guido Roos"
                updateMetaDescription(it.shortDescription)
            }
        }
    }
}

// Hulpmiddel om de meta tag echt aan te passen
fun updateMetaDescription(description: String) {
    val doc = kotlinx.browser.document
    var element = doc.querySelector("meta[name='description']")

    if (element == null) {
        // Als de tag niet bestaat, maak hem aan (fallback voor SEO)
        element = doc.createElement("meta").apply {
            setAttribute("name", "description")
            doc.head?.appendChild(this)
        }
    }
    element.setAttribute("content", description)
}


fun jsonLd(json: String) {
        val scriptId = "structured-data-schema"

        // 1. Verwijder het oude script als dat er al staat
        document.getElementById(scriptId)?.remove()

        // 2. Maak het nieuwe script aan
        val script = document.createElement("script")
        script.setAttribute("type", "application/ld+json")
        script.setAttribute("id", scriptId) // Geef het een ID
        script.textContent = json

        document.head?.appendChild(script)
}

fun updateDataForPage (page: Page, language: AppLanguage) {
    updateUrl(page = page, language = language)
    updateMetadata(page, language)
    val schemaJson = when (page) {
        Page.Home -> HomeSchema(language)
        Page.Projects -> ProjectsPageSchema(language)
        is Page.ProjectDetail -> ProjectDetailsSchema(page.project)
    }
    jsonLd(schemaJson)
}