package com.guidoroos.portfolio.data.content

import com.guidoroos.portfolio.data.model.Project
import com.guidoroos.portfolio.data.model.ProjectDetail
import com.guidoroos.portfolio.data.model.ProjectType

object ProjectContent {
    val projects = listOf(
        Project(
            id = "bnp-paribas-io",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "BNP Paribas",
            title = "Global Design System Migration",
            shortDescription = "Het vertalen van complexe bancaire UI-componenten naar een herbruikbare library.",
            longDescription = """
                Bij iO werkte ik als lead aan de migratie van de mobiele bank-omgeving. 
                De uitdaging was om legacy schermen te vervangen zonder de stabiliteit te 
                beïnvloeden, terwijl we voldeden aan de strikte security-eisen van de bank.
            """.trimIndent(),
            startDate = "2022",
            endDate = "2023",
            techStack = listOf("Kotlin", "Android SDK", "Jetpack Compose", "MVI"),
            details = ProjectDetail(
                challenge = "Consistentie bewaren over 50+ schermen in een legacy omgeving.",
                role = "Lead Android Developer",
                solution = "Implementatie van een Atomic Design System met Jetpack Compose.",
                keyAchievements = listOf(
                    "UI-consistentie verhoogd naar 100%",
                    "Reductie van boilerplate code met 40%",
                    "Succesvolle migratie zonder downtime"
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=com.bnpp.mobile",
                    "App Store" to "https://apps.apple.com/app/bnp-paribas"
                )
            )
        ),
        Project(
            id = "fintech-consultancy-2026",
            type = ProjectType.Freelance,
            entityName = "Guido Roos Software",
            clientName = "GreenFinance",
            title = "Ktor Backend Refactor",
            shortDescription = "Architectuur-audit en herstructurering van een schaalbaar backend platform.",
            longDescription = """
                Als freelancer ben ik ingehuurd om de bottleneck in de API-performance 
                op te lossen. Door over te stappen op een non-blocking architectuur met 
                Ktor en Coroutines is de latency met 40% verlaagd.
            """.trimIndent(),
            startDate = "2026",
            endDate = null,
            techStack = listOf("Ktor", "Kotlin Coroutines", "PostgreSQL", "Exposed"),
            details = ProjectDetail(
                challenge = "Hoge latency en thread-blocking issues bij piekbelasting.",
                role = "Senior Backend Consultant",
                solution = "Volledige rewrite van de API-layer naar Ktor en Coroutines.",
                keyAchievements = listOf(
                    "Latency reductie van 40%",
                    "Schalingscapaciteit verdrievoudigd op dezelfde infra",
                    "Type-safe database migratie met Exposed"
                )
            )
        ),
        Project(
            id = "portfolio-site-compose",
            type = ProjectType.SideProject,
            entityName = "Eigen beheer",
            clientName = null,
            title = "Miles Ahead Portfolio",
            shortDescription = "Een technisch showcase project gebouwd met de nieuwste Kotlin/JS tools.",
            longDescription = """
                Dit project dient als levend bewijs dat de Kotlin-stack superieur is 
                aan de traditionele JS-chaos. Volledig type-safe en modulair.
            """.trimIndent(),
            startDate = "2025",
            endDate = null,
            techStack = listOf("Compose HTML", "Kotlin/JS", "Kotlin CSS DSL"),
            details = ProjectDetail(
                challenge = "Een modern portfolio bouwen zonder de overhead van zware JS frameworks.",
                role = "Solo Developer",
                solution = "Gebruik van Compose HTML voor een volledig reactieve UI in Kotlin.",
                keyAchievements = listOf(
                    "100% Kotlin codebase (frontend & backend)",
                    "Extreem snelle laadtijden",
                    "Modulaire opzet voor eenvoudige uitbreiding"
                ),
                repoUrl = "https://github.com/guido-roos/miles-ahead-portfolio"
            )
        )
    )
}