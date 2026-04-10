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
            title = "White-label Banking Solution",
            shortDescription = "Full-stack mobile development voor een schaalbaar KMP bankenplatform voor internationale banken.",
            longDescription = "Medior engineer in een team van 8 man voor de ontwikkeling van een white-label app voor Aruba Bank, Orco Bank, Handelsbanken en Optimix. Focus op de integratie tussen KMP en native platformen.",
            startDate = "2023",
            endDate = "2026",
            techStack = listOf("Kotlin Multiplatform", "Compose", "SwiftUI", "Swift TCA", "Ktor", "Koin", "Kotlin Wasm", "LLM Integration", "Figma API"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Het bouwen van een generiek platform dat per bank zeer specifiek configureerbaar moet blijven zonder code-duplicatie.",
                role = "Mobile Engineer",
                solution = "Gerealiseerd door gedeelde business logica in KMP te combineren met robuuste native UI-lagen en geavanceerde interne tooling.",
                keyAchievements = listOf(
                    "Ontwikkelde de glue code om KMP Use Cases naadloos te integreren in iOS (SwiftUI en TCA).",
                    "Bouwde een Figma-to-code exporter via de Figma API om design-configuraties te automatiseren.",
                    "Realiseerde een AI-driven UI testing framework met UIAutomator en screenshot testing plugin.",
                    "Verantwoordelijk voor complexe features zoals Device Overview, Zendesk chat integratie en gelinkte apparaten.",
                    "Verbeterde de stabiliteit door bugfixes in de CI/CD pipeline  en het bouwen van een mock-omgeving voor lokale development.",
                    "Ontwikkelde een custom intern dashboard met Kotlin Wasm."
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
            title = "Navigatie & Outdoor App",
            shortDescription = "Greenfield ontwikkeling van een React Native navigatie-app voor 500+ routes, in 3,5 maand van start naar release.",
            longDescription = "High-speed greenfield project met de focus op een custom geospatial engine. Gebouwd om realtime GPS-data en offline routebeheer te combineren voor een vlekkeloze wandelervaring.",
            startDate = "2026",
            endDate = "2026",
            techStack = listOf("React Native", "TypeScript", "Expo", "Apollo Client", "MMKV", "Supabase", "Expo Maps"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Het realiseren van een betrouwbare navigatie-engine voor onverharde paden binnen een extreem strakke deadline van 3,5 maand.",
                role = "Lead Mobile Engineer",
                solution = "Een custom client-side snapping engine ontwikkeld op basis van point-to-segment projectie en Haversine formules.",
                keyAchievements = listOf(
                    "Greenfield Release: In 14 weken van de eerste regel code naar een volledige lancering in de App Stores.",
                    "Custom Navigatie-Engine: Realtime snapping op GPX-polylines voor de berekening van voortgang, resterende afstand en afslag-instructies.",
                    "Map & Heading Optimalisatie: Vloeiende kaartrotatie via low-pass filtering en 'lookahead' logica voor complexe overlappende route-lussen.",
                    "Performance Architectuur: Gebruik van useRef en useMemo om hoogfrequente sensordata te verwerken zonder UI-jank",
                    "Offline-First: Robuuste netwerklaag met Apollo Client en MMKV-caching voor gebruik in gebieden zonder bereik."
                ),
                productUrls = mapOf(
                    "Google Play(Natuurmonumenten)" to "https://play.google.com/store/apps/details?id=nl.natuurmonumenten.natuurmonumenten",
                ),
            )
        ),
        Project(
            id = "van-lanschot-android",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Van Lanschot Kempen",
            shouldHighlight = true,
            title = "Banking Fusie & Architectuur Transformatie",
            shortDescription = "Android integratie voor een bankfusie en het omzetten van een monolithische codebase naar een modulaire Hilt-architectuur.",
            longDescription = "Ingezet om een kritieke fusie-deadline te halen voor Van Lanschot Kempen. Na dit succes de leiding genomen in het moderniseren van de verouderde architectuur om de schaalbaarheid van de app te waarborgen.",
            startDate = "2023",
            endDate = "2023",
            techStack = listOf("Android", "Kotlin", "Dagger Hilt", "Clean Architecture", "Modularization", "GitLab CI"),
            details = ProjectDetail(
                challenge = "Een harde deadline halen voor de technische samenvoeging van apps, terwijl de codebase werd gehinderd door een inefficiënte monolithische structuur en handmatige Dependency Injection.",
                role = "Android developer en consultant",
                solution = "Gerealiseerde fusie-deadline en vervolgens de transitie ingezet naar Clean Architecture en Dagger Hilt voor betere testbaarheid en onderhoudbaarheid.",
                keyAchievements = listOf(
                    "Succesvolle Fusie: De deadline voor het mergen van de systemen na de overname behaald, waardoor de continuïteit voor eindgebruikers gewaarborgd bleef.",
                    "Modernisering DI: De handmatige Dependency Injection via de Application-class vervangen door Dagger Hilt, wat leidde tot minder overhead en stabielere code.",
                    "Start Modularisatie: Een fundament gelegd voor een multi-module mappenstructuur volgens Clean Architecture principes.",
                    "Team Alignment: Het team en de vaste senior developers overtuigd van moderne standaarden, wat resulteerde in een transitie naar een toekomstbestendige werkwijze."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=com.LoginApp&hl=nl"
                )
            )
        ),
        Project(
            id = "bnp-paribas-io",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "BNP Paribas",
            title = "Lening-aanvraag & E-Sign Platform",
            shortDescription = "Digitale transformatie van lening-processen met complexe validatie-rules en digitale handtekening-integraties.",
            longDescription = "Ontwikkeling van een white-label oplossing voor persoonlijke leningen waarbij meerdere providers onder één app vallen met eigen styling. Verantwoordelijk voor de technische realisatie van complexe aanvraag-trajecten en de beveiliging van contract-ondertekening.",
            startDate = "2023",
            endDate = "2023",
            techStack = listOf("Android", "Kotlin", "Jetpack Compose", "OpenAPI CodeGen", "Custom Chrome Tabs", "Deep Linking", "Kotlin Coroutines"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Het waarborgen van een soepele gebruikerservaring tijdens complexe data-entry flows die afhankelijk zijn van zware backend-berekeningen en strikte validatie-regels.",
                role = "Mobile Engineer",
                solution = "Gerealiseerd door geavanceerde debouncing en flow-cancellations te implementeren, waardoor de backend niet overbelast raakt terwijl de UI realtime feedback geeft.",
                keyAchievements = listOf(
                    "E-Sign Handover: Integratie van digitale handtekening-trajecten via Custom Chrome Tabs en Deep Linking, waarbij de app accuraat reageert op return-URL's van externe providers.",
                    "Geavanceerde UI-interactie: Ontwikkeling van gesynchroniseerde inputs (slider en tekstveld) met complexe onderlinge afhankelijkheden en directe validatie.",
                    "Performance Engineering: Implementatie van een debouncing-strategie op de netwerklaag om 'sluggishness' te voorkomen bij constante calculatie-verzoeken naar de backend.",
                    "Smart Caching: Realisatie van een tijdelijke caching-laag die gegevens alleen vasthoudt zolang de aanvraag-flow actief is, conform security-protocollen.",
                    "Integratie-expert: Gewerkt met OpenAPI-gebaseerde codegeneratie voor de koppeling met complexe legacy backend-systemen en adresvalidatie-services.",
                    "Stakeholder Management: Effectief samengewerkt in een grote bancaire organisatie met diverse stakeholders en strenge juridische kaders."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=uk.co.bnpparibaspf.strategicoam&hl=en"
                )
            )
        ),
        Project(
            id = "viaplay-viascore",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Viaplay",
            title = "Viascore Greenfield Launch",
            shortDescription = "End-to-end development of the Viascore Android app and supporting Firebase backend.",
            longDescription = "Built the entire Android codebase from the first line of code to full production release. Managed the Firebase/Node.js backend and integrated complex video streaming services.",
            startDate = "2023",
            endDate = "2023",
            techStack = listOf("Android", "Kotlin", "Jetpack Compose", "Firebase", "Node.js", "Google Play Billing"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Launching a high-traffic sports app with video streaming and subscriptions within a tight time-to-market window.",
                role = "Lead Mobile Developer",
                solution = "Modern Kotlin/Compose stack combined with a Node.js Firebase backend for real-time scalability.",
                keyAchievements = listOf(
                    "Greenfield Android: Engineered the full app architecture using Jetpack Compose and Retrofit.",
                    "Video Streaming: Integrated 3rd-party streaming libraries for high-performance sports clip playback.",
                    "Monetization: Implemented Google Play Subscription model for full transaction lifecycles.",
                    "Full-Stack Ownership: Managed Firebase Node.js backend with 24/7 standby support during launch."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=com.viaplay.clipapp&hl=nl"
                ),
            )
        ),
        Project(
            id = "duivelaar-ble",
            type = ProjectType.Employment,
            entityName = "iO",
            clientName = "Duivelaar Pompen",
            title = "Industriële BLE Waterpomp Interface",
            shortDescription = "Gespecialiseerde hardware-uitlezing en debugging van Bluetooth Low Energy (BLE) verbindingen.",
            longDescription = "Ingezet voor het oplossen van complexe stabiliteitsproblemen in een Android-app die monteurs gebruiken voor het beheer van waterpompen in flatgebouwen. De focus lag op het betrouwbaar inlezen en aanpassen van hardware-instellingen via BLE.",
            startDate = "2025",
            endDate = "2025",
            techStack = listOf("Android", "Kotlin", "Bluetooth Low Energy (BLE)", "GATT Services & Characteristics", "Hardware Simulator"),
            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Het reproduceren en verhelpen van ongrijpbare bugs in de communicatie tussen mobiele devices en industriële hardware-sensoren.",
                role = "Android Specialist",
                solution = "On-site onderzoek uitgevoerd bij de klant met hardware-simulatoren om de exacte oorzaak van synchronisatieproblemen te achterhalen.",
                keyAchievements = listOf(
                    "Veldonderzoek: Directe samenwerking met de klant op locatie om met hardware-simulatoren 'edge-case' scenario's te testen die in een kantooromgeving niet reproduceerbaar waren.",
                    "Lifecycle Optimalisatie: Een fundamenteel probleem opgelost waarbij de app alle data opnieuw ging inladen zodra deze naar de achtergrond ging, wat door de trage BLE-verbinding tot enorme vertragingen leidde.",
                    "BLE Expertise: Geoptimaliseerd van het inlezen van Services en Characteristics voor een snellere en stabielere data-overdracht naar de monteurs.",
                    "Stabiliteitsslag: Een bestaande codebase geprofessionaliseerd en bugs verholpen die cruciaal waren voor de dagelijkse operatie van de monteurs.",
                    "Betrouwbaarheid: De overdracht van pomp-data en het aanpassen van hardware-parameters via de app weer 100% betrouwbaar gemaakt."
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
            title = "Native Migratie & Platform Leiderschap",
            shortDescription = "Leiding gegeven aan de afronding van een kritieke transitie van hybride naar native Android voor Private Banking.",
            longDescription = "Verantwoordelijk voor het vlottrekken van een gestagneerde migratie. Complexe modules omgezet naar Kotlin, waardoor het hybride framework binnen een maand volledig kon worden uitgefaseerd.",
            startDate = "2020",
            endDate = "2022",
            techStack = listOf("Android", "Kotlin", "Java", "MVVM", "Retrofit", "Mobile Security (OTP)", "Unit Testing"),

            shouldHighlight = true,
            details = ProjectDetail(
                challenge = "Het binnen één maand migreren van complexe en bedrijfskritische logica (OTP en login) van Java naar Kotlin om de legacy-platform deadline te halen.",
                role = "Android Developer & Coördinator",
                solution = "Snelle refactoring van legacy Java-code naar Kotlin, gecombineerd met intensieve scenario-testing met backend teams voor een foutloze livegang.",
                keyAchievements = listOf(
                    "Voltooide Migratie: Door het overnemen van achterstallige modules kon de afdeling een maand later live zonder het hybride framework.",
                    "Security Refactoring: Complexe Java-code voor web-login en transactiegoedkeuring (OTP) succesvol vertaald naar Kotlin en geoptimaliseerd.",
                    "Standardisatie: Initiatief genomen voor app-brede migratie naar Retrofit voor API-calls en het hergebruik van UI-componenten tussen teams.",
                    "Technisch Leiderschap: Voorzitter van de 'Android Developer Circle' (7 man), waarbij ik technische afstemming en best-practices binnen de afdeling coördineerde.",
                    "Stakeholder Alignment: Nauw samengewerkt met backend-engineers om alle transactie-scenario's voor Private Banking klanten te valideren."
                ),
                productUrls = mapOf(
                    "Google Play" to "https://play.google.com/store/apps/details?id=com.abnamro.privatebanking.belgium&hl=nl"
                ),
            )

        )
    )
}