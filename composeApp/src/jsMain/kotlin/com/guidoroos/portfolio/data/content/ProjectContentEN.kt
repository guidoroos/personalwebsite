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
            startDate = "2026",
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
                productUrls = mapOf("Google Play" to "https://play.google.com/store/apps/details?id=com.guidoroos.cookbook"),
                repoUrl = "https://github.com/guidoroos/OcrGeminiSampleProject"

            )
        ),

        // --- iO PROJECTS ---
        Project(
            id = "banking-right-io",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "BankingRight",
            title = "White-label Banking Solution",
            shortDescription = "Full-stack mobile development for a scalable KMP banking platform serving international banks.",
            longDescription = "Key contributor in an 8-man team delivering a multi-tenant banking solution for Aruba Bank, Orco Bank, Handelsbanken, and Optimix. Responsible for cross-platform feature parity and developer experience tooling.",
            startDate = "2023",
            endDate = "2026",
            techStack = listOf("Kotlin Multiplatform", "Compose", "SwiftUI", "Swift TCA", "Ktor", "Koin", "Kotlin Wasm", "LLM Integration", "Figma API"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Managing complex white-label configurations and maintaining architectural integrity across KMP and native layers.",
                role = "Mobile Engineer",
                solution = "Developed a bridge between KMP Use Cases and native UI frameworks while automating testing and design synchronization.",
                keyAchievements = listOf(
                    "Architected glue code to consume KMP business logic within SwiftUI and Swift TCA environments.",
                    "Built a Figma-to-code exporter (Figex) using the Figma API to automate UI configuration updates.",
                    "Implemented an AI-powered UI testing framework with UIAutomator and custom screenshot testing plugin.",
                    "Developed critical features including Device Management, Zendesk chat integration, and ISO date formatting for international banking standards.",
                    "Optimized build pipelines by resolving architecture-specific issues and implementing mock environment overrides for testing.",
                    "Engineered an internal dashboard from scratch using Kotlin Wasm."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/search?q=aruba%20bank&c=apps&hl=en",
                    "App Store" to "https://apps.apple.com/nl/app/aruba-bank-app/id1533254729"
                )
            )
        ),
        Project(
            id = "natuurmonumenten-app",
            type = ProjectType.Employment,
            entityName = "Natuurmonumenten",
            clientName = "Natuurmonumenten",
            title = "High-Performance Navigation App",
            shortDescription = "Greenfield development of a React Native navigation app for 500+ routes, built from scratch in 3.5 months.",
            longDescription = "Rapid greenfield execution focusing on a custom geospatial engine. Engineered to handle real-time GPS data, offline trail management, and high-frequency map interactions under a strict release deadline.",
            startDate = "2026",
            endDate = "2026",
            techStack = listOf("React Native", "TypeScript", "Expo", "Apollo Client", "MMKV", "Supabase", "Expo Maps"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Building a reliable, offline-first navigation engine for unpaved terrain within an aggressive 3.5-month timeframe.",
                role = "Lead Mobile Engineer",
                solution = "Developed a custom client-side snapping engine using point-to-segment projection and Haversine logic to keep users on-trail without backend reliance.",
                keyAchievements = listOf(
                    "Greenfield Delivery: Delivered a production-ready app from zero to App Store/Play Store in 14 weeks.",
                    "Custom Navigation Engine: Built real-time snapping logic to calculate route progress, remaining distance, and bearings on GPX polylines.",
                    "Orientation & Map Logic: Implemented low-pass filtered heading rotation and 'lookahead' progress tracking to handle overlapping trail loops.",
                    "Optimized State: Engineered a global Route Context for efficient data pre-fetching and filtering, maintaining responsivesness using useRef/useMemo.",
                    "Resilient Caching: Architected a persistent network layer with Apollo Client and MMKV for offline use in nature areas."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=nl.natuurmonumenten.natuurmonumenten",
                ),
            )
        ),
        Project(
            id = "van-lanschot-android",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Van Lanschot Kempen",
            shouldHighlight = true,
            title = "Banking Merger & Architectural Modernization",
            shortDescription = "Led the Android integration for a high-stakes banking merger while spearheading a transition to Dagger Hilt and Modularization.",
            longDescription = "Initially brought in to meet a critical hard deadline for merging Van Lanschot Kempen's systems with a newly acquired entity. Following a successful launch, I transitioned the team from a legacy monolithic architecture to a modern, scalable foundation.",
            startDate = "2023",
            endDate = "2023",
            techStack = listOf("Android", "Kotlin", "Dagger Hilt", "Clean Architecture", "Modularization", "Coroutines"),
            details = ProjectDetail(
                challenge = "Integrating two distinct banking infrastructures under a strict deadline within a monolithic codebase that relied on manual Dependency Injection via the Application class.",
                role = "Android developer & Consultant",
                solution = "Delivered the merger on time, then refactored the legacy DI layer to Dagger Hilt and introduced a multi-module Clean Architecture pattern.",
                keyAchievements = listOf(
                    "Successful Merger: Met the critical business deadline for the technical integration of the acquired entity's banking services.",
                    "Architectural Overhaul: Replaced inefficient manual DI (via Android Application class) with Dagger Hilt, significantly reducing boilerplate and memory leaks.",
                    "Modularization Strategy: Initiated the transition from a monolith to a feature-based multi-module structure, improving build times and code ownership.",
                    "Technical Advocacy: Successfully mentored the existing team and senior developers on modern architecture, overcoming initial resistance to complex patterns like Clean Architecture."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=com.LoginApp&hl=nl"
                )
            ),


        ),
        Project(
            id = "viaplay-viascore",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Viaplay",
            title = "Viascore Greenfield Launch",
            shortDescription = "Complete end-to-end development of the Viascore Android app and supporting Firebase backend.",
            longDescription = "Acted as the lead developer for the Android launch within an international Swedish team. Built the application from the first line of code to a full-scale production release, managing everything from UI/UX implementation to server-side logic.",
            startDate = "2023",
            endDate = "2023",
            techStack = listOf("Android", "Kotlin", "Jetpack Compose", "SwiftUI", "Firebase (Functions & Auth)", "Node.js", "Retrofit", "Google Play Billing"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Launching a high-traffic sports application with integrated video streaming and subscription models within a very tight time-to-market window.",
                role = "Lead Mobile Developer & Backend Support",
                solution = "Leveraged a modern Kotlin/Compose stack for rapid UI development and a Node.js-based Firebase backend to ensure scalability and real-time updates.",
                keyAchievements = listOf(
                    "Greenfield Android Development: Engineered the entire Android codebase using Jetpack Compose and Retrofit, ensuring a modular and testable architecture.",
                    "Video Integration: Successfully integrated and optimized a complex 3rd-party video streaming library for high-performance playback.",
                    "Monetization: Implemented a robust Google Play Subscription model, handling full transaction lifecycles and entitlement checks.",
                    "Backend Ownership: Managed and maintained the Firebase Node.js backend services, providing 24/7 standby support for the entire application ecosystem during launch.",
                    "Cross-Platform Contribution: Collaborated on the iOS implementation using SwiftUI to maintain feature parity across platforms.",
                    "International Collaboration: Served as the primary point of contact for the Dutch market within a remote Swedish engineering team."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=com.viaplay.clipapp&hl=nl"
                )
            ),
        ),
        Project(
            id = "bnp-paribas-io",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "BNP Paribas",
            title = "Personal Loan & E-Sign Ecosystem",
            shortDescription = "High-stakes Fintech application for personal loans, featuring multi-provider support and complex digital contract signing.",
            longDescription = "Engineered intricate loan application flows within a multi-tenant architecture, supporting various providers each with unique white-label styling. Focused on securing the digital signing process and managing high-frequency data validation across complex UI states.",
            startDate = "2023",
            endDate = "2023",
            techStack = listOf("Android", "Kotlin", "Jetpack Compose", "OpenAPI (Code Gen)", "Custom Chrome Tabs", "Deep Linking", "Coroutines Flow"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Managing synchronized UI states (e.g., slider and input field) across complex, multi-screen loan flows while preventing backend overload from real-time validations.",
                role = "Mobile Engineer",
                solution = "Implemented sophisticated debounce and flow-cancellation logic to optimize backend interaction, combined with Deep Linking for seamless e-signature handovers.",
                keyAchievements = listOf(
                    "E-Signature Integration: Orchestrated digital signing flows via Custom Chrome Tabs and Deep Linking, mediating between multiple third-party contract providers.",
                    "Dynamic Data Entry: Developed a high-performance loan calculator UI with synchronized dual-input methods (Sliders & TextFields) and real-time input validation.",
                    "Backend Optimization: Engineered a custom debouncing strategy to handle high-frequency data entry, ensuring 'smooth' UI responsiveness without flooding legacy backend systems.",
                    "State & Cache Management: Architected a short-lived caching layer that persists data only during the active loan flow to balance user convenience with strict security requirements.",
                    "API Integration: Worked with OpenAPI-generated models to integrate complex banking services, including external address description services and real-time loan calculations.",
                    "Stakeholder Management: Successfully navigated the requirements and constraints of a large-scale corporate banking environment with multiple organizational stakeholders."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=uk.co.bnpparibaspf.strategicoam&hl=en"
                )
            )
        ),
        Project(
            id = "duivelaar-ble",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Duivelaar Pompen",
            title = "Industrial BLE Pump Interface",
            shortDescription = "High-stakes debugging and optimization of a Bluetooth Low Energy (BLE) interface for industrial water pump maintenance.",
            longDescription = "Stepped in to resolve critical stability issues in a legacy Android application used by field engineers to diagnose and configure industrial pumps in high-rise buildings. Focused on hardware-to-app communication reliability and lifecycle management.",
            startDate = "2025",
            endDate = "2025",
            techStack = listOf("Android", "Kotlin", "Bluetooth Low Energy (BLE)", "GATT Services & Characteristics", "Hardware Simulation"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Identifying and reproducing non-deterministic BLE connection drops and data-sync delays that only occurred in specific field conditions.",
                role = "Specialist Android Engineer",
                solution = "Conducted on-site field testing with hardware simulators to identify a critical Android Lifecycle flaw causing redundant data reloads over the slow BLE protocol.",
                keyAchievements = listOf(
                    "On-site Diagnostics: Bridged the gap between software and hardware by performing on-site testing with specialized simulators and mobile devices.",
                    "Protocol Optimization: Fixed a major performance bottleneck where the app triggered full GATT service re-discovery and data reloads upon background/foreground transitions.",
                    "Hardware Interaction: Expertly navigated BLE Services and Characteristics to enable reliable reading and writing of industrial pump settings.",
                    "Legacy Refactoring: Stabilized a junior-developed codebase, transforming it into a reliable tool for professional field engineers.",
                    "Lifecycle Mastery: Resolved deep-seated Android Activity/Fragment lifecycle issues that were interfering with persistent hardware connections."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=com.boostercontrol.duijvelaar"
                )
            )
        ),

        // --- ABN AMRO ---
        Project(
            id = "abn-amro-private-banking",
            type = ProjectType.Employment,
            entityName = "ABN AMRO",
            clientName = "ABN AMRO Private Banking",
            title = "Native Migration & Platform Leadership",
            shortDescription = "Led the final phase of a high-stakes legacy-to-native migration for international Private Banking apps.",
            longDescription = "Stepped in to rescue a stalled migration from a hybrid JavaScript framework to native Android. Successfully transitioned complex Java-based security modules to Kotlin, enabling the department to meet its sunset deadline for the legacy platform.",
            startDate = "2020",
            endDate = "2022",
            techStack = listOf("Android", "Kotlin", "Java", "MVVM", "Retrofit", "Mobile Security (OTP)", "Unit Testing"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Completing a delayed migration of business-critical security modules (OTP & Web Login) within a one-month hard deadline.",
                role = "Android Developer & Team Coordinator",
                solution = "Rapidly refactored complex legacy Java code into a clean Kotlin implementation and coordinated cross-departmental testing to ensure a zero-defect release.",
                keyAchievements = listOf(
                    "Legacy Sunset: Successfully eliminated the hybrid framework by delivering the final native modules, leading to a major release for international markets (Belgium, France, Germany).",
                    "Security Migration: Refactored and modernized critical Java code for web login and transaction approval via One-Time Password (OTP) flows.",
                    "Architectural Standardization: Coordinated the department-wide migration to Retrofit for API calls and promoted the reuse of shared UI components.",
                    "Community Leadership: Led the 'Android Developer Circle' (7 engineers), facilitating knowledge sharing and technical alignment across the Private Banking department.",
                    "Testing Excellence: Collaborated with backend engineers to perform exhaustive scenario-based testing for high-net-worth client transactions."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=com.abnamro.privatebanking.belgium&hl=nl"
                ),
            )
        )
    )
}