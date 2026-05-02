package com.guidoroos.portfolio.util

import AppLanguage
import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.data.content.ProjectContentEN
import com.guidoroos.portfolio.data.content.ProjectContentNL
import com.guidoroos.portfolio.data.content.projectsPageDataEN
import com.guidoroos.portfolio.data.content.projectsPageDataNL
import com.guidoroos.portfolio.data.model.Project

fun ProjectSchema(project: Project):String {
    return """
        {
          "@context": "https://schema.org",
          "@type": "CreativeWork",
          "url": "https://guidoroos.nl/projects/${'$'}{project.id}",
          "name": "${project.title}",
          "description": "${project.shortDescription}",
          "author": {
            "@type": "Person",
            "name": "Guido Roos"
          },
          "keywords": "${project.techStack.joinToString(", ")}"
        }
    """.trimIndent()

}


fun HomeSchema(language: AppLanguage): String {
    val description = if (language == AppLanguage.NL) {
        "Freelance Senior Mobile Developer gespecialiseerd in Android, iOS en Kotlin Multiplatform (KMP). Expert in System Design, CI/CD en Mobile Architecture."
    } else {
        "Freelance Senior Mobile Developer specializing in Android, iOS, and Kotlin Multiplatform (KMP). Expert in System Design, CI/CD, and Mobile Architecture."
    }

    return  """
        {
          "@context": "https://schema.org",
          "@type": "Person",
          "name": "Guido Roos",
          "jobTitle": "Freelance Senior Mobile Apps Developer",
          "url": "https://guidoroos.nl",
          "description": "$description",
          "image": "https://guidoroos.nl/profielfoto.jpg",
          "sameAs": [
            "https://www.linkedin.com/in/guido-roos91/",
            "https://github.com/guidoroos"
          ],
          "knowsAbout": [
            "Android Development", 
            "iOS Development", 
            "Kotlin Multiplatform (KMP)", 
            "Compose Multiplatform", 
            "CI/CD", 
            "Software Testing", 
            "Design Patterns", 
            "System Design", 
            "UX Design"
          ],
          "worksFor": {
            "@type": "ProfessionalService",
            "name": "RoosMobile",
            "legalName": "RoosMobile",
            "address": {
              "@type": "PostalAddress",
              "addressLocality": "Eindhoven",
              "addressRegion": "Noord-Brabant",
              "addressCountry": "NL"
            }
          }
        }
    """.trimIndent()
}

fun ProjectDetailsSchema(project: Project): String {
    return """
        {
          "@context": "https://schema.org",
          "@type": "CreativeWork",
          "name": "${project.title}",
          "headline": "${project.title} - Mobile Development Project",
          "description": "${project.shortDescription}",
          "author": {
            "@type": "Person",
            "name": "Guido Roos"
          },
          "url": "https://guidoroos.nl/projects",
          "keywords": "${project.techStack.joinToString(", ")}",
          "publisher": {
            "@type": "ProfessionalService",
            "name": "RoosMobile"
          },
          "mainEntityOfPage": "https://guidoroos.github.io/projects/${project.id}"
        }
    """.trimIndent()

}

fun ProjectsPageSchema(language: AppLanguage):String {
    val pageData = if (language == AppLanguage.NL) projectsPageDataNL else projectsPageDataEN
    val projects = if (language == AppLanguage.NL) ProjectContentNL.projects else ProjectContentEN.projects

    val listItems = projects.mapIndexed { index, project ->
        """
        {
          "@type": "ListItem",
          "position": ${index + 1},
          "url": "https://guidoroos.nl/projects/${project.id}",
          "name": "${project.title}"
        }
        """.trimIndent()
    }.joinToString(",")

    return """
        {
          "@context": "https://schema.org",
          "@type": "ItemList",
          "name": "${pageData.title}",
          "description": "${pageData.metaDescription}",
          "url": "https://guidoroos.nl/projects",
          "numberOfItems": ${projects.size},
          "itemListElement": [
            $listItems
          ]
        }
    """.trimIndent()

}
