package com.guidoroos.portfolio.data.content

import com.guidoroos.portfolio.data.model.HomeData
import com.guidoroos.portfolio.util.yearsExperience


val HomePageContentNL = HomeData(
    title = "Freelance Mobile Architect & Senior Developer",
    subtitle = "Roos Mobile",
    locationInfo = "Gevestigd in Eindhoven. Beschikbaar voor on-site samenwerking ook in bijvoorbeeld Amsterdam, Rotterdam, Utrecht, Antwerpen en Düsseldorf",
    pitch = """
    Een succesvolle app begint bij de juiste technische strategie voor jouw budget. Of het nu gaat om het schaalbaar opbouwen van een nieuw idee via de efficiëntie van Kotlin Multiplatform, of het realiseren van de hoogwaardige native UI die gebruikers verwachten op iOS en Android: ik zorg dat de techniek jouw business ondersteunt. Door logica slim te delen waar het kan en native te bouwen waar het moet, bied ik een oplossing die precies tussen 'volledig gescheiden teams' en 'beperkte cross-platform tools' in zit.

    Deze aanpak stoelt op $yearsExperience jaar ervaring in mobile development, aangescherpt tijdens talloze projecten voor uiteenlopende klanten bij een toonaangevende agency. Van het redden van vastgelopen projecten tot het strategisch versterken van ervaren development-teams: ik breng de nodige senioriteit mee om apps technisch gezond en toekomstbestendig te maken.
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
    ctaTitle = "Benieuwd naar de mogelijkheden?",
    ctaLinkText = "Mail Guido ",
    metaDescription = "Freelance Mobile Developer in Eindhoven. Meer dan 8 jaar ervaring in Native Android, iOS en Kotlin Multiplatform (KMP)."
)