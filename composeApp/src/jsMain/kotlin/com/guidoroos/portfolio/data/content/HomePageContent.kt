package com.guidoroos.portfolio.data.content

import com.guidoroos.portfolio.data.model.HomePageModel

val homePageContent = HomePageModel(
    title = "Senior Kotlin Developer",
    fullName = "Guido Roos",
    profileImageUrl = "https://placehold.co/400x400",
    aboutMe = """
        Met meer dan 8 jaar ervaring bij diverse agencies transformeer ik 
        complexe vraagstukken naar robuuste Kotlin-oplossingen. 
        Van Android-diepten tot schaalbare backends en moderne web-apps.
     """.trimIndent(),
    techStack = listOf(
        "Kotlin",
        "Compose HTML",
        "Ktor",
        "Android Studio",
        "Gradle",
        "Architecture"
    ),
    ctaTitle = "Klaar voor de volgende stap?",
    ctaEmail = "hallo@guidoroos.nl",
    ctaLinkText = "Laten we koffie drinken →"
)