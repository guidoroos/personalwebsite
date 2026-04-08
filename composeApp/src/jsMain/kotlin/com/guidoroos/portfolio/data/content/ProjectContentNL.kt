package com.guidoroos.portfolio.data.content

import com.guidoroos.portfolio.data.model.Project
import com.guidoroos.portfolio.data.model.ProjectDetail
import com.guidoroos.portfolio.data.model.ProjectType

object ProjectContentNL {
    val projects = listOf(
        // --- FREELANCE / SIDE PROJECTS ---
        Project(
            id = "personal-website-compose",
            type = ProjectType.SideProject,
            entityName = "Eigen beheer",
            title = "Deze Portfolio Website",
            shortDescription = "Mijn professionele portfolio gebouwd met Compose Multiplatform voor Web.",
            longDescription = "Een technisch showcase project waarin ik de kracht van de Kotlin-stack demonstreer voor web-ontwikkeling. Volledig type-safe en modulair opgezet.",
            startDate = "2025",
            techStack = listOf("Kotlin Multiplatform", "Compose HTML", "Kotlin/JS"),
            details = ProjectDetail(
                challenge = "Een moderne, responsieve UI bouwen in Kotlin zonder traditionele JS-frameworks.",
                role = "Solo Developer",
                solution = "Gebruik van Compose HTML en een custom styling engine.",
                keyAchievements = listOf(
                    "100% Kotlin codebase",
                    "Geoptimaliseerd voor performance en SEO",
                    "Herbruikbare UI-componenten"
                ),
                repoUrl = "https://github.com/guidoroos/personalwebsite"
            )
        ),
        Project(
            id = "autochef-cooking-app",
            type = ProjectType.SideProject,
            entityName = "Eigen beheer",
            title = "Autochef Cooking App",
            shortDescription = "AI-gedreven recepten-app gelanceerd in de Play Store.",
            longDescription = "Zelfstandig ontwikkelde applicatie die gebruikmaakt van AI voor het intelligent scrapen en opslaan van recepten.",
            startDate = "2024",
            endDate = "heden",
            shouldHighlight = true,
            techStack = listOf("Android", "Kotlin", "Gemini AI", "Room"),
            details = ProjectDetail(
                challenge = "Het omzetten van ongestructureerde webdata naar bruikbare recepten middels LLM's.",
                role = "Creator & Developer",
                solution = "Integratie van Gemini AI-modellen voor real-time parsing.",
                keyAchievements = listOf(
                    "Live in Google Play Store sinds juli 2025",
                    "On-device caching systeem ontwikkeld",
                    "iOS-versie momenteel in actieve ontwikkeling"
                ),
                productUrls = mapOf("Google Play" to "https://play.google.com/store/apps/details?id=com.guidoroos.cookbook")
            )
        ),

        // --- iO PROJECTS ---
        Project(
            id = "banking-right-io",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "BankingRight",
            title = "White-label Banking App",
            shortDescription = "Full-stack mobile development voor internationale banken zoals Aruba Bank.",
            longDescription = "Verantwoordelijk voor de Android, iOS en KMP-lagen van een schaalbaar bankplatform.",
            startDate = "2023",
            endDate = "heden",
            shouldHighlight = true,
            techStack = listOf("Kotlin Multiplatform", "Compose", "SwiftUI", "LLM Integration"),
            details = ProjectDetail(
                challenge = "Het bouwen van een generiek platform dat per bank klantspecifiek aanpasbaar is.",
                role = "Senior Mobile Engineer",
                solution = "Ontwikkeling van een UI testing framework met LLM-integratie en screenshot testing.",
                keyAchievements = listOf(
                    "Gerealiseerde impact voor o.a. Aruba Bank",
                    "Automatisering van UI-verificatie via AI-tooling"
                )
            )
        ),
        Project(
            id = "natuurmonumenten-io",
            type = ProjectType.Employment,
            entityName = "iO",
            shouldHighlight = true,
            clientName = "Natuurmonumenten",
            title = "Advanced Navigation Engine",
            shortDescription = "Custom pathfinding navigatie voor natuurgebieden.",
            longDescription = "Ontwikkeling van een gespecialiseerde route-app met een eigen navigatie-engine.",
            startDate = "2023",
            techStack = listOf("React Native", "Docker", "OSRM", "Pathfinding"),
            details = ProjectDetail(
                challenge = "Nauwkeurige routebegeleiding op onofficiële paden.",
                role = "Mobile Specialist",
                solution = "Inzet van een custom OSRM Docker-container voor complexe path-snapping.",
                keyAchievements = listOf(
                    "Real-time route-instructies en progressie-logica",
                    "Succesvolle integratie van complexe geospatial data"
                )
            )
        ),
        Project(
            id = "van-lanschot-android",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Van Lanschot Kempen",
            shouldHighlight = true,
            title = "Android Architecture Transformation",
            shortDescription = "Refactoring van een monolithische banking app naar een modulaire structuur.",
            longDescription = "Geleid de transitie naar een schaalbare architectuur om toekomstige feature-ontwikkeling te versnellen.",
            startDate = "2023",
            techStack = listOf("Android", "Kotlin", "Dagger/Hilt", "Modularization"),
            details = ProjectDetail(
                challenge = "Een verouderde monolithische codebase opsplitsen zonder de dagelijkse operatie te verstoren.",
                role = "Lead Android Architect",
                solution = "Implementatie van een modulaire opzet met Dependency Injection.",
                keyAchievements = listOf(
                    "Significante verbetering van build-tijden en testbaarheid",
                    "Succesvolle transitie naar een herbruikbare mappenstructuur"
                )
            )
        ),
        Project(
            id = "viaplay-viascore",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Viaplay",
            title = "Viascore App Launch",
            shortDescription = "Greenfield ontwikkeling van de Viascore Android app.",
            longDescription = "De volledige Android-codebase vanaf de grond af opgebouwd tot aan de uiteindelijke release.",
            startDate = "2023",
            techStack = listOf("Android", "Kotlin", "Firebase", "Node.js"),
            details = ProjectDetail(
                challenge = "Snelle time-to-market voor een nieuwe sport-app.",
                role = "Lead Android Developer",
                solution = "Samenwerking aan zowel de mobiele apps als de Firebase Node.js backend.",
                keyAchievements = listOf(
                    "Complete Android-applicatie opgeleverd vanaf nul",
                    "Bijgedragen aan de stabiliteit van de cross-platform backend"
                )
            )
        ),
        Project(
            id = "bnp-paribas-io",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "BNP Paribas Personal Finance",
            title = "Contract E-sign & Loan Flows",
            shortDescription = "Digitale transformatie van leningaanvragen.",
            longDescription = "Ontwikkeling van kritieke flows voor e-signing en leningaanvragen op zowel Android als iOS.",
            startDate = "2023",
            shouldHighlight = true,
            techStack = listOf("Android", "iOS", "Mobile Security", "Fintech"),
            details = ProjectDetail(
                challenge = "Complexe juridische flows gebruiksvriendelijk en veilig maken op mobiel.",
                role = "Mobile Engineer",
                solution = "Ontwikkeling en release van nieuwe features voor contractondertekening.",
                keyAchievements = listOf("Succesvolle release van nieuwe aanvraag-flows")
            )
        ),
        Project(
            id = "duivelaar-ble",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Duivelaar Pompen",
            title = "BLE Waterpomp Interface",
            shortDescription = "Specialistische hardware-uitlezing via Bluetooth Low Energy.",
            longDescription = "Onderhoud en verbetering van een specialistische app voor het beheer van industriële waterpompen.",
            startDate = "2023",
            shouldHighlight = true,
            techStack = listOf("Android", "Bluetooth Low Energy (BLE)", "Hardware Integration"),
            details = ProjectDetail(
                challenge = "Stabiele communicatie met hardware-sensoren in variërende omstandigheden.",
                role = "Android Engineer",
                solution = "Verbetering van de BLE-uitleeslogica en data-verwerking.",
                keyAchievements = listOf("Verhoogde betrouwbaarheid van pomp-data overdracht")
            )
        ),

        // --- ABN AMRO ---
        Project(
            id = "abn-amro-private-banking",
            type = ProjectType.Employment,
            entityName = "ABN AMRO Bank N.V.",
            clientName = "Private Banking Digital",
            title = "Legacy-to-Native Migration",
            shortDescription = "Migratie van high-net-worth banking apps naar Kotlin MVVM.",
            longDescription = "Verantwoordelijk voor de overgang van een hybride JS-framework naar een moderne native stack voor internationale markten.",
            startDate = "2020",
            endDate = "2022",
            techStack = listOf("Kotlin", "MVVM", "Security", "Betalingsverkeer"),
            details = ProjectDetail(
                challenge = "Het waarborgen van security bij betalingsverkeer tijdens een ingrijpende migratie.",
                role = "Android Developer",
                solution = "Implementatie van een moderne MVVM-structuur met Kotlin.",
                keyAchievements = listOf(
                    "Succesvolle migratie van hybride Javascript framework",
                    "Verhoogde stabiliteit van inlogprocedures",
                    "App live in meerdere landen voor vermogende klanten"
                )
            )
        )
    )
}