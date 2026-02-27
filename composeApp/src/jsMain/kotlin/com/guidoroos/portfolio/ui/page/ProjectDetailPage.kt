package com.guidoroos.portfolio.ui.page

import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.data.model.Project
import com.guidoroos.portfolio.ui.styling.AppSpacing
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ProjectDetailPage(project: Project, onBack: () -> Unit) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Div(attrs = {
        classes(styles.container)
        style {
            maxWidth(750.px)
        }
    }) {

        // 1. Navigation
        Span(attrs = {
            classes(styles.navLink)
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                gap(AppSpacing.xs)
                marginBottom(AppSpacing.xl)
                marginLeft(0.px)
            }
            onClick { onBack() }
        }) {
            Text("← Terug naar overzicht")
        }

        // 2. Header
        Header(attrs = { style { marginBottom(AppSpacing.lg) } }) {
            Div(attrs = {
                classes(styles.tagLabel)
                style { color(theme.primary); marginBottom(AppSpacing.xs) }
            }) {
                val context =
                    if (project.clientName != null) "${project.clientName} via ${project.entityName}" else project.entityName
                Text("$context • ${project.startDate}${project.endDate?.let { " — $it" } ?: " — Heden"}")
            }

            H2(attrs = {
                classes(styles.h2Section);
                style {
                    color(theme.textPrimary)
                    marginTop(0.px);
                    marginBottom(0.5.cssRem)
                }
            }) {
                Text(project.title)
            }

            Div(attrs = {
                classes(styles.h3Card);
                style {
                    fontWeight("bold")
                    color(theme.textSecondary)
                }
            }) {
                Text(project.details.role)
            }
        }

        // 3. Narrative
        Section(attrs = { style { marginBottom(AppSpacing.lg) } }) {
            Div(attrs = { classes(styles.bodyRegular) }) {
                Text(project.longDescription)
            }
        }

        project.details.let { details ->
            // 4. Tight Content Grid (Back to the 300px min-max)
            Div(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    gap(AppSpacing.lg)
                    maxWidth(500.px)
                    alignItems(AlignItems.Center)
                    marginBottom(AppSpacing.lg)
                    property("margin-left", "auto")
                    property("margin-right", "auto")
                }
            }) {
                Section(attrs = { classes(styles.card) }) {
                    Div(attrs = {
                        classes(styles.h3Card);
                        style {
                            color(theme.textPrimary)
                            marginBottom(AppSpacing.xs)
                        }
                    }) {
                        Text("De Uitdaging")
                    }
                    Div(attrs = {
                        classes(styles.bodySmall)
                        style {
                            color(theme.textSecondary)
                        }
                    }) { Text(details.challenge) }
                }

                Section(attrs = { classes(styles.card) }) {
                    Div(attrs = {
                        classes(styles.h3Card);
                        style {
                            marginBottom(AppSpacing.xs)
                            color(theme.textPrimary)
                        }
                    }) {
                        Text("Mijn Oplossing")
                    }
                    Div(attrs = {
                        classes(styles.bodySmall)
                        style {
                            color(theme.textSecondary)
                        }
                    }) { Text(details.solution) }
                }
            }

            // 5. Results
            Section(attrs = {
                style {
                    marginBottom(AppSpacing.xl)
                    alignItems(AlignItems.Center)
                }
            }) {
                Div(attrs = { classes(styles.h2Section); style { marginBottom(AppSpacing.md) } }) {
                    Text("Resultaten")
                }
                Ul(attrs = { style { listStyleType("none"); padding(0.px) } }) {
                    details.keyAchievements.forEach { achievement ->
                        Li(attrs = {
                            classes(styles.bodyRegular)
                            style {
                                marginBottom(AppSpacing.sm); display(DisplayStyle.Flex); gap(
                                AppSpacing.sm
                            )
                            }
                        }) {
                            Span(attrs = { style { color(theme.primary) } }) { Text("•") }
                            Text(achievement)
                        }
                    }
                }
            }

            // 6. Footer: Tech & Links
            Footer(attrs = {
                style {
                    padding(AppSpacing.xl, 0.px)
                    property("border-top", "1px solid ${theme.border}")
                }
            }) {
                // Tech Chips
                Div(attrs = {
                    style {
                        display(DisplayStyle.Flex); flexWrap(FlexWrap.Wrap); gap(AppSpacing.xs); marginBottom(
                        AppSpacing.xl
                    )
                    }
                }) {
                    project.techStack.forEach { tech ->
                        Span(attrs = {
                            classes(styles.tagLabel)
                            style {
                                color(theme.textPrimary)
                                backgroundColor(theme.border)
                                padding(0.25.cssRem, 0.75.cssRem)
                                borderRadius(100.px)
                                fontSize(0.75.cssRem)
                            }
                        }) { Text(tech) }
                    }
                }

                // Links from Map
                Div(attrs = {
                    style {
                        display(DisplayStyle.Flex); flexWrap(FlexWrap.Wrap); gap(
                        AppSpacing.xl
                    )
                    }
                }) {
                    details.productUrls.forEach { (name, url) ->
                        A(href = url, attrs = {
                            classes(styles.ctaLink, styles.buttonLabel)
                            target(ATarget.Blank)
                        }) {
                            Text("$name ↗")
                        }
                    }

                    details.repoUrl?.let { url ->
                        A(href = url, attrs = {
                            classes(styles.ctaLink, styles.buttonLabel)
                            target(ATarget.Blank)
                        }) {
                            Text("Repository ↗")
                        }
                    }
                }
            }
        }
    }
}