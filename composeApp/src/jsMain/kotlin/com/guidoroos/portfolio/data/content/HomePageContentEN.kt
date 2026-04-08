package com.guidoroos.portfolio.data.content

import com.guidoroos.portfolio.data.model.HomeData
import com.guidoroos.portfolio.util.yearsExperience


val HomePageContentEN = HomeData(
    title = "Mobile Architect & Senior Developer",
    subtitle = "Roos Mobile",
    locationInfo = "Based in Eindhoven. Available for on-site collaboration in Amsterdam, Rotterdam, Utrecht, Antwerp, and Düsseldorf.",
    kmpPitch = """
    With $yearsExperience+ years of experience in native Android and iOS development, I bridge the gap between high-end performance and cross-platform efficiency. Drawing on deep expertise in both platforms, I leverage Kotlin Multiplatform (KMP) to architect robust, shared systems that eliminate redundant effort without compromising the 100% native experience.

    Through Roos Mobile, I help businesses bypass the "double-cost" of separate teams by delivering a stable, long-term alternative to traditional cross-platform tools. Whether delivering full native solutions or shared architectures, my approach ensures a single source of truth, faster shipping cycles, and technical scalability.
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
    ctaTitle = "Ready for the next step?",
    ctaLinkText = "Get in touch"
)