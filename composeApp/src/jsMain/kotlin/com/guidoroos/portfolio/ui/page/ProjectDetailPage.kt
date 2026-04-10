package com.guidoroos.portfolio.ui.page

import LocalAppTheme
import LocalLanguage
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
    val currentLanguage = LocalLanguage.current

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
                cursor("pointer")
                fontSize(AppTypography.sizeBodyLarge)
            }
            onClick { onBack() }
        }) {
            Text("← Terug naar overzicht")
        }

        // 2. Header (Reversed Importance)
        Header(attrs = { style { marginBottom(AppSpacing.lg) } }) {
            // Priority 1: De Opdrachtgever / Entiteit
            H2(attrs = {
                classes(styles.h2Section)
                style {
                    color(theme.primary)
                    marginTop(0.px)
                    marginBottom(0.25.cssRem)
                }
            }) {
                val context =
                    if (project.clientName != null) "${project.clientName} via ${project.entityName}" else project.entityName
                Text(context)
            }

            // Priority 2: Project Titel
            Div(attrs = {
                classes(styles.h3Card)
                style {
                    color(theme.textPrimary)
                    fontWeight("bold")
                    fontSize(1.25.cssRem)
                    marginBottom(0.5.cssRem)
                }
            }) {
                Text(project.title)
            }

            // Priority 3: Metadata (Rol & Datum)
            Div(attrs = {
                classes(styles.tagLabel)
                style {
                    color(theme.textSecondary)
                    fontSize(0.9.cssRem)
                }
            }) {
                val dateRange =
                    "${project.startDate}${project.endDate?.let { " — $it" } ?: " — Heden"}"
                Text("${project.details.role} • $dateRange")
            }
        }

        // 3. Narrative
        Section(attrs = { style { marginBottom(AppSpacing.lg) } }) {
            Div(attrs = { classes(styles.bodyRegular) }) {
                Text(project.longDescription)
            }
        }

        project.details.let { details ->
            // 4. Tight Content Grid
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
                Section(attrs = {
                    classes(styles.card);
                    style { width(90.percent) }
                }) {
                    Div(attrs = {
                        classes(styles.h3Card)
                        style {
                            color(theme.textPrimary)
                            marginBottom(AppSpacing.xs)
                        }
                    }) {
                        Text(if (currentLanguage == AppLanguage.NL) "De Uitdaging" else "The Challenge")
                    }
                    Div(attrs = {
                        classes(styles.bodyLarge)
                        style { color(theme.textSecondary) }
                    }) { Text(details.challenge) }
                }

                Section(attrs = { classes(styles.card); style { width(90.percent) } }) {
                    Div(attrs = {
                        classes(styles.h3Card)
                        style {
                            marginBottom(AppSpacing.xs)
                            color(theme.textPrimary)
                        }
                    }) {
                        Text(if (currentLanguage == AppLanguage.NL) "Mijn Oplossing" else "My Solution")
                    }
                    Div(attrs = {
                        classes(styles.bodyLarge)
                        style { color(theme.textSecondary) }
                    }) { Text(details.solution) }
                }
            }

            // 5. Results
            Section(attrs = {
                style {
                    marginBottom(AppSpacing.xl)
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    alignItems(AlignItems.Center)
                }
            }) {
                Div(attrs = {
                    classes(styles.h2Section)
                    style {
                        marginBottom(AppSpacing.md)
                        textAlign("left")
                    }
                }) {
                    Text(if (currentLanguage == AppLanguage.NL) "Resultaten" else "Results")
                }
                Ul(attrs = {
                    style {
                        listStyleType("disc") // Gebruik standaard bullets
                        paddingLeft(1.5.em)   // Ruimte voor de bullets
                        property("color", theme.primary) // Kleur van de bullet
                    }
                }) {
                    details.keyAchievements.forEach { achievement ->
                        Li(attrs = {
                            classes(styles.bodyRegular)
                            style {
                                marginBottom(AppSpacing.sm)
                                textAlign("left")
                                // Zet de tekstkleur terug naar normaal als de bullet gekleurd is
                                property("color", theme.textPrimary)
                            }
                        }) {
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
                        display(DisplayStyle.Flex)
                        flexWrap(FlexWrap.Wrap)
                        gap(AppSpacing.sm)
                        marginBottom(AppSpacing.xl)
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

                // Links
                Div(attrs = {
                    style {
                        display(DisplayStyle.Flex)
                        flexWrap(FlexWrap.Wrap)
                        gap(AppSpacing.xl)
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