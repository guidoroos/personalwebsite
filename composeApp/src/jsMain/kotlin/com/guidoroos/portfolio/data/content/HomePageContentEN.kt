package com.guidoroos.portfolio.data.content

import com.guidoroos.portfolio.data.model.HomeData
import com.guidoroos.portfolio.util.yearsExperience


val HomePageContentEN = HomeData(
    title = "Freelance Mobile Architect & Senior Developer",
    subtitle = "Roos Mobile",
    locationInfo = "Based in Eindhoven. Available for on-site collaboration as well in for example in Amsterdam, Rotterdam, Utrecht, Antwerp, and Düsseldorf",
    pitch = """
    A successful app starts with the right technical strategy for your budget. Whether it's scaling a new idea through the efficiency of Kotlin Multiplatform, or delivering the high-end native UI that users expect on iOS and Android: I ensure the technology supports your business goals. By sharing logic where possible and building native where it matters, I offer a solution that sits right between 'fully separate teams' and 'limited cross-platform tools.' 

    This approach is backed by $yearsExperience years of experience in mobile development, sharpened through numerous projects for a wide range of clients at a leading agency. From rescuing stalled projects to strategically reinforcing established development teams: I provide the seniority needed to make apps technically sound and future-proof.
""".trimIndent(),
    capabilitiesTitle = "Areas of Expertise",
    capabilities = listOf(
        "Kotlin Multiplatform (KMP)",
        "Native Android (Compose)",
        "Native iOS (SwiftUI)",
        "Full Stack Kotlin (Web & Ktor)"
    ),
    projectsTitle = "Featured Projects",
    allProjectsTitle = "View all projects",
    ctaTitle = "Interested in working together?",
    ctaLinkText = "Email Guido",
    metaDescription = "Freelance Mobile Architect & Senior Developer. Specialist in Native Android, iOS, and Kotlin Multiplatform (KMP). Delivering high-performance mobile solutions with 100% native experience."
)