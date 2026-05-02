import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

import com.guidoroos.portfolio.ui.styling.AppStylesheet
import com.guidoroos.portfolio.data.model.Page
import com.guidoroos.portfolio.ui.component.Navbar
import com.guidoroos.portfolio.ui.page.HomePage
import com.guidoroos.portfolio.ui.page.ProjectDetailPage
import com.guidoroos.portfolio.ui.styling.AppTheme
import com.guidoroos.portfolio.ui.styling.DarkTheme
import com.guidoroos.portfolio.ui.styling.LightTheme
import com.guidoroos.portfolio.util.HomeSchema
import com.guidoroos.portfolio.util.ProjectSchema
import com.guidoroos.portfolio.util.ProjectsPageSchema
import com.guidoroos.portfolio.util.currentYear
import com.guidoroos.portfolio.util.decodeInitialPage
import com.guidoroos.portfolio.util.getBrowserLanguage
import com.guidoroos.portfolio.util.isSystemInDarkMode
import com.guidoroos.portfolio.util.updateDataForPage
import kotlinx.browser.document
import kotlinx.browser.window


val LocalAppTheme = staticCompositionLocalOf<AppTheme> { DarkTheme }
val LocalStyles = staticCompositionLocalOf { AppStylesheet(DarkTheme) }

enum class AppLanguage { NL, EN }

val LocalLanguage = staticCompositionLocalOf { AppLanguage.EN }

fun main() {
    val root = document.getElementById("root")

    // We maken de root leeg zodat de 'oude' Puppeteer-meuk
    // de nieuwe Compose-render niet in de weg zit.
    root?.innerHTML = ""

    renderComposable(rootElementId = "root") {
        val currentPage = remember { mutableStateOf<Page>(Page.Home) }
        var isDark by remember { mutableStateOf(isSystemInDarkMode()) }
        val theme = if (isDark) DarkTheme else LightTheme
        val styles = remember(theme) { AppStylesheet(theme) }
        Style(styles)
        var currentLang by remember { mutableStateOf(getBrowserLanguage()) }
        val lastRenderedPage = remember { mutableStateOf<Pair<Page, AppLanguage>?>(null) }


        LaunchedEffect(Unit) {
            currentPage.value = decodeInitialPage()
            window.onpopstate = {
                currentPage.value = decodeInitialPage()

            }
        }


        CompositionLocalProvider(
            LocalAppTheme provides theme,
            LocalLanguage provides currentLang
        ) {
            // Root Container
            Div(attrs = {
                classes(styles.backgroundPattern)
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    overflow("hidden")
                    minHeight(100.vh)
                }
            }) {

                // --- NAVBAR COMPONENT ---
                Navbar(
                    currentPage = currentPage.value,
                    toggleTheme = { isDark = !isDark },
                    setLanguage = { currentLang = it },
                ) {
                    currentPage.value = it


                }

                // --- MAIN CONTENT AREA ---
                Main(attrs = {
                    classes(styles.container)
                }) {
                    if (lastRenderedPage.value != currentPage.value to currentLang) {
                        updateDataForPage(currentPage.value, currentLang)
                        lastRenderedPage.value = currentPage.value to currentLang
                    }

                    when (val page = currentPage.value) {
                        Page.Home -> HomePage { pageToNavigate ->
                            currentPage.value = pageToNavigate
                        }

                        Page.Projects -> ProjectsPage { project ->
                            currentPage.value = Page.ProjectDetail(project)
                        }

                        is Page.ProjectDetail -> ProjectDetailPage(page.project) {
                            currentPage.value = Page.Projects
                        }
                    }
                }

                // --- FOOTER ---
                Footer(attrs = {
                    // We keep the layout properties in the inline style for the container
                    // but we could also move this to a 'footerContainer' class in your Stylesheet!
                    style {
                        property("margin-top", "auto")
                        padding(2.cssRem)
                        textAlign("center")
                        property("border-top", "0.5px solid ${theme.border}")

                        marginTop(40.px)
                        marginLeft(40.px)
                        marginRight(40.px)
                    }
                }) {
                    // The "Stand out" line using your custom highlight style
                    Div(attrs = {
                        classes(styles.bodyRegular)
                        style {
                            color(theme.primary)
                            marginBottom(0.5.cssRem)
                            fontWeight("bold") // Manual override to make it pop
                        }
                    }) {
                        Text("Built with Kotlin Multiplatform for web")
                    }

                    // The standard copyright using your muted small text style
                    Div(attrs = {
                        classes(styles.bodySmall)
                        style {
                            color(theme.textMuted)
                        }
                    }) {
                        Text("© $currentYear Guido Roos")
                    }

                    Div(attrs = {
                        classes(styles.bodySmall)
                        style {
                            color(theme.textMuted)
                            marginTop(0.25.cssRem)
                            fontSize(0.8.cssRem) // Iets subtieler font
                        }
                    }) {
                        Text("KVK: 42026757 | BTW: NL005440357B35")
                    }
                }
            }
        }
    }
}
