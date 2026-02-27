package com.guidoroos.portfolio.data.content

import com.guidoroos.portfolio.data.model.HomePageModel

object homePageContent {
    val fullName = "Guido Roos"
    val title = "Freelance Senior Mobile App Developer"
    val profileImageUrl = "profielfoto.jpg"

    val locationInfo = "Based in Eindhoven. Available for on-site collaboration as well in Amsterdam, Rotterdam, Den Haag, Utrecht, Nijmegen, Maastricht, Antwerpen, Düsseldorf, Köln."


    val yearsExperience = kotlin.js.Date().getFullYear() - 2018
    val kmpPitch = """
    As a Senior Developer with $yearsExperience years experience, I bridge the gap between native performance and cross-platform efficiency. I leverage Kotlin Multiplatform to architect robust, shared systems that eliminate redundant effort without compromising the 100% native experience your users expect.

I help businesses bypass the "double-cost" of separate iOS and Android teams, delivering a more stable, long-term alternative to traditional cross-platform tools. My approach ensures you ship faster, maintain one source of truth, and scale with technical confidence.
""".trimIndent()

    val capabilitiesTitle = "Area of expertise"
    val capabilities = listOf(
        "KMP Mobile",
        "Native Android",
        "Native iOS",
        "Full Stack Kotlin (Web & Ktor)"
    )

    val projectsTitle = "Previous projects"
    val allProjectsTitle = "More projects"

    val ctaTitle = "Klaar voor de volgende stap?"
    val ctaEmail = "guidoroos@protonmail.com"
    val ctaLinkText = "Neem contact op"
}