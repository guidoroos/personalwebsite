package com.guidoroos.portfolio.data.content

import com.guidoroos.portfolio.data.model.HomeData
import com.guidoroos.portfolio.util.yearsExperience


val HomePageContentNL = HomeData(
    title = "Mobile Architect & Senior Developer",
    subtitle = "Roos Mobile",
    locationInfo = "Gevestigd in Eindhoven. Beschikbaar voor on-site samenwerking in Amsterdam, Rotterdam, Utrecht, Antwerpen en Düsseldorf.",
    kmpPitch = """
    Met meer dan $yearsExperience jaar ervaring in native Android en iOS development overbrug ik de kloof tussen hoogwaardige performance en cross-platform efficiëntie. Vanuit mijn diepe kennis van beide platformen zet ik Kotlin Multiplatform (KMP) in om gedeelde systemen te bouwen die dubbel werk elimineren, zonder concessies te doen aan de 100% native ervaring.

    Via Roos Mobile help ik organisaties de "dubbele kosten" van gescheiden teams te vermijden met een stabieler alternatief voor traditionele cross-platform tools. Of het nu gaat om volledige native implementaties of een gedeelde architectuur: mijn aanpak garandeert één 'source of truth', snellere releases en technische schaalbaarheid.
    """.trimIndent(),
    capabilitiesTitle = "Expertise",
    capabilities = listOf(
        "Kotlin Multiplatform (KMP)",
        "Native Android (Compose)",
        "Native iOS (SwiftUI)",
        "Full Stack Kotlin (Web & Ktor)"
    ),
    projectsTitle = "Geselecteerde Projecten",
    allProjectsTitle = "Bekijk alle projecten",
    ctaTitle = "Klaar voor de volgende stap?",
    ctaLinkText = "Neem contact op"
)