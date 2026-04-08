package com.guidoroos.portfolio.data.content

import com.guidoroos.portfolio.data.model.Project
import com.guidoroos.portfolio.data.model.ProjectDetail
import com.guidoroos.portfolio.data.model.ProjectType

object ProjectContentEN {
    val projects = listOf(
        // --- SIDE PROJECTS ---
        Project(
            id = "personal-website-compose",
            type = ProjectType.SideProject,
            entityName = "Side project",
            title = "This Portfolio Website",
            shortDescription = "Professional portfolio built with Compose Multiplatform for Web.",
            longDescription = "A technical showcase demonstrating the power of the Kotlin stack for web development. Fully type-safe and modular.",
            startDate = "2025",
            techStack = listOf("Kotlin Multiplatform", "Compose HTML", "Kotlin/JS"),
            details = ProjectDetail(
                challenge = "Building a modern, responsive UI in Kotlin without traditional JS frameworks.",
                role = "Solo Developer",
                solution = "Leveraged Compose HTML with a custom styling engine.",
                keyAchievements = listOf(
                    "100% Kotlin codebase",
                    "Optimized for performance and SEO",
                    "Reusable UI component library"
                ),
                repoUrl = "https://github.com/guidoroos/personalwebsite"
            )
        ),
        Project(
            id = "autochef-cooking-app",
            type = ProjectType.SideProject,
            entityName = "Side project",
            title = "Autochef Cooking App",
            shortDescription = "AI-driven recipe app launched on the Google Play Store.",
            longDescription = "An independently developed application using Gemini AI to intelligently parse and store recipes.",
            startDate = "2024",
            endDate = "Present",
            shouldHighlight = true,
            techStack = listOf("Android", "Kotlin", "Gemini AI", "Room"),
            details = ProjectDetail(
                challenge = "Converting unstructured web data into usable recipe models using LLMs.",
                role = "Creator & Developer",
                solution = "Integrated Gemini AI models for real-time parsing and Room for on-device storage.",
                keyAchievements = listOf(
                    "Live in Google Play Store since July 2025",
                    "Developed an on-device caching system",
                    "iOS version currently in active development"
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
            title = "White-label Banking Solution",
            shortDescription = "Full-stack mobile development for international banks like Aruba Bank.",
            longDescription = "Responsible for the Android, iOS, and KMP layers of a scalable banking platform.",
            startDate = "2023",
            endDate = "2026",
            techStack = listOf("Kotlin Multiplatform", "Compose", "SwiftUI", "LLM Integration"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Building a generic platform that remains highly customizable for various banking clients.",
                role = "Senior Mobile Engineer",
                solution = "Developed a custom screenshot testing solution and a UI testing framework with LLM integration.",
                keyAchievements = listOf(
                    "Delivered impact for clients including Aruba Bank",
                    "Automated UI verification through AI-powered tooling"
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
            shortDescription = "Custom pathfinding navigation for outdoor nature trails.",
            longDescription = "Developed a specialized route app featuring a custom-built navigation engine.",
            startDate = "2023",
            techStack = listOf("React Native", "Docker", "OSRM", "Pathfinding"),
            details = ProjectDetail(
                challenge = "Providing accurate route guidance on unpaved trails in nature reserves.",
                role = "Mobile Specialist",
                solution = "Deployed a custom OSRM Docker container for advanced path-snapping.",
                keyAchievements = listOf(
                    "Implemented complex logic for route progression and real-time instructions",
                    "Successfully integrated intricate geospatial data"
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
            shortDescription = "Refactoring a monolithic banking app into a modular structure.",
            longDescription = "Led the transition to a scalable architecture to accelerate future feature development.",
            startDate = "2023",
            techStack = listOf("Android", "Kotlin", "Dagger/Hilt", "Modularization"),
            details = ProjectDetail(
                challenge = "Splitting a legacy monolithic codebase without disrupting daily operations.",
                role = "Lead Android Architect",
                solution = "Implemented a modular setup using Dependency Injection.",
                keyAchievements = listOf(
                    "Significant improvement in build times and testability",
                    "Successful transition to a reusable directory structure"
                )
            )
        ),
        Project(
            id = "viaplay-viascore",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Viaplay",
            title = "Viascore App Launch",
            shortDescription = "Greenfield development of the Viascore Android app.",
            longDescription = "Built the entire Android codebase from the first line through to the final release.",
            startDate = "2023",
            techStack = listOf("Android", "Kotlin", "Firebase", "Node.js"),
            details = ProjectDetail(
                challenge = "Fast time-to-market for a new sports application.",
                role = "Lead Android Developer",
                solution = "Contributed to both the mobile apps and the Firebase Node.js backend.",
                keyAchievements = listOf(
                    "Delivered a complete Android application from scratch",
                    "Ensured stability across cross-platform backend services"
                )
            )
        ),
        Project(
            id = "bnp-paribas-io",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "BNP Paribas",
            title = "Contract E-sign & Loan Flows",
            shortDescription = "Digital transformation of loan application processes.",
            longDescription = "Developed critical flows for e-signing and loan applications on both Android and iOS.",
            startDate = "2023",
            techStack = listOf("Android", "iOS", "Mobile Security", "Fintech"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Making complex legal flows user-friendly and secure on mobile devices.",
                role = "Mobile Engineer",
                solution = "Released new features specifically for contract signing and application flows.",
                keyAchievements = listOf("Successfully launched updated application flows")
            )
        ),
        Project(
            id = "duivelaar-ble",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Duivelaar Pompen",
            title = "BLE Water Pump Interface",
            shortDescription = "Specialized hardware data extraction via Bluetooth Low Energy.",
            longDescription = "Maintained and improved a specialist app for managing industrial water pumps.",
            startDate = "2025",
            shouldHighlight = true,
            techStack = listOf("Android", "Bluetooth Low Energy (BLE)", "Hardware Integration"),
            details = ProjectDetail(
                challenge = "Ensuring stable communication with hardware sensors in varied environments.",
                role = "Android Engineer",
                solution = "Enhanced BLE polling logic and data processing.",
                keyAchievements = listOf("Improved reliability of pump data transmissions")
            )
        ),

        // --- ABN AMRO ---
        Project(
            id = "abn-amro-private-banking",
            type = ProjectType.Employment,
            entityName = "ABN AMRO Bank",
            clientName = "ABN AMRO Bank",
            title = "Legacy-to-Native Migration",
            shortDescription = "Migrating high-net-worth banking apps to Kotlin MVVM.",
            longDescription = "Responsible for transitioning from a hybrid JS framework to a modern native stack for international markets.",
            startDate = "2020",
            endDate = "2022",
            techStack = listOf("Kotlin", "MVVM", "Security", "Payments"),
            details = ProjectDetail(
                challenge = "Maintaining security for payment transactions during a major architectural migration.",
                role = "Android Developer",
                solution = "Implemented a modern MVVM structure using Kotlin.",
                keyAchievements = listOf(
                    "Successful migration from a legacy hybrid Javascript framework",
                    "Enhanced stability for login and payment procedures",
                    "Live across multiple countries for high-net-worth clients"
                )
            )
        )
    )
}