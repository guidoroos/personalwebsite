package com.guidoroos.portfolio.ui.page

import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.data.model.Project
import com.guidoroos.portfolio.ui.styling.AppSpacing
import com.guidoroos.portfolio.ui.styling.AppTypography
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ProjectDetailPage(project: Project, onBack: () -> Unit) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Div(attrs = { classes(styles.container) }) {

        // 1. Navigation Back
        Span(attrs = {
            style {
                cursor("pointer")
                color(theme.textSecondary)
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                gap(AppSpacing.xs)
                marginBottom(AppSpacing.lg)
            }
            onClick { onBack() }
        }) {
            Text("← Terug naar overzicht")
        }

        // 2. Header: Title & Context
        Header(attrs = { style { marginBottom(AppSpacing.xl) } }) {
            H1 { Text(project.title) }
            P(attrs = { style { color(theme.textSecondary); fontSize(AppTypography.sizeH3) } }) {
                val context = if (project.clientName != null) "${project.clientName} via ${project.entityName}" else project.entityName
                Text("$context  •  ${project.startDate}${project.endDate?.let { " — $it" } ?: " — Heden"}")
            }
        }

        // 3. De Content Grid (Challenge & Solution)
        project.details.let { details ->
            Div(attrs = {
                style {
                    display(DisplayStyle.Grid)
                    property("grid-template-columns", "repeat(auto-fit, minmax(300px, 1fr))")
                    gap(AppSpacing.xl)
                    marginBottom(AppSpacing.xl)
                }
            }) {
                // Challenge Blok
                Section {
                    H3 { Text("De Uitdaging") }
                    P { Text(details.challenge) }
                }

                // Solution Blok
                Section {
                    H3 { Text("Mijn Oplossing") }
                    P { Text(details.solution) }
                }
            }

            // 4. Key Achievements (De 'Results')
            Section(attrs = { style { marginBottom(AppSpacing.xl) } }) {
                H3 { Text("Belangrijkste Resultaten") }
                Ul {
                    details.keyAchievements.forEach { achievement ->
                        Li(attrs = { style { marginBottom(AppSpacing.xs) } }) {
                            Text(achievement)
                        }
                    }
                }
            }

            // 5. Links & Tech Stack
            Footer(attrs = {
                style {
                    padding(AppSpacing.lg, 0.px)
                    property("border-top", "1px solid ${theme.border}")
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    gap(AppSpacing.md)
                }
            }) {
                // De URLs uit de productUrls lijst + GitHub
                Div(attrs = { style { display(DisplayStyle.Flex); gap(AppSpacing.md) } }) {
                    details.productUrls.forEach { url ->
                        A(href = url, attrs = { target(ATarget.Blank) }) {
                            Text("Bekijk Product ↗")
                        }
                    }
                    details.repoUrl?.let { url ->
                        A(href = url, attrs = { target(ATarget.Blank) }) {
                            Text("Source op GitHub ↗")
                        }
                    }
                }

                // Tech stack dots (hergebruik van je eerdere logica)
                P(attrs = { style { color(theme.textSecondary); fontSize(AppTypography.sizeTiny) } }) {
                    Text("STACK: " + project.techStack.joinToString(" • ").uppercase())
                }
            }
        }
    }
}