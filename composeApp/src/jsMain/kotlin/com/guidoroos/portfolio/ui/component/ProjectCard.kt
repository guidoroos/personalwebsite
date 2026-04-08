package com.guidoroos.portfolio.ui.component


import LocalAppTheme
import LocalLanguage
import LocalStyles
import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.data.model.Project
import com.guidoroos.portfolio.data.model.ProjectType
import com.guidoroos.portfolio.ui.styling.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun ProjectCard(project: Project, onClick:(Project) -> Unit) {
    val styles = LocalStyles.current
    val theme = LocalAppTheme.current
    val currentLanguage = LocalLanguage.current

    Div(attrs = {
        classes(styles.card)
        style {
            cursor("pointer")
            padding(AppSpacing.md)
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            gap(4.px)
            minHeight(160.px)
        }
        onClick { onClick(project) }
    }) {
        // 1. Bedrijfsnaam als de "Main" Title
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.SpaceBetween)
                alignItems(AlignItems.Center)
                paddingBottom(AppSpacing.md)
            }
        }) {
            H3(attrs = {
                style {
                    margin(0.px)
                    fontSize(1.1.cssRem)
                    fontWeight("bold")

                    color(theme.primary) // Bedrijf in de accentkleur
                }
            }) {
                val entityLabel = when (project.type) {
                    ProjectType.Employment -> project.clientName ?: project.entityName
                    else -> project.entityName
                }
                Text(entityLabel.uppercase())
            }

            Span(attrs = {
                style {
                    fontSize(0.8.cssRem)
                    opacity(0.6)
                }
            }) {
                Text(if (project.startDate == project.endDate) {
                    project.startDate
                } else if (project.endDate == null) {
                    "${project.startDate} - ${if (currentLanguage == AppLanguage.NL) "heden" else "present"}"
                }  else  {
                    "${project.startDate} - ${project.endDate} "
                }
                )
            }
        }

        // 2. Project Titel (Nu kleiner/subtieler)
        Span(attrs = {
            style {
                fontSize(0.95.cssRem)
                fontWeight(600)
                color(theme.textPrimary)
            }
        }) {
            Text(project.title)
        }

        // 3. Beschrijving (Compacter)
        P(attrs = {
            style {
                fontSize(0.90.cssRem)
                margin(AppSpacing.xs, 0.px)
                color(theme.textSecondary)
                // Limiteer tot 2 regels om kaarten gelijk te houden
                property("display", "-webkit-box")
                property("-webkit-line-clamp", "2")
                property("-webkit-box-orient", "vertical")
                overflow("hidden")
            }
        }) {
            Text(project.shortDescription)
        }

        Div(attrs = {
            style {
                flex(1)
                minHeight(AppSpacing.xs)
            }
        })

        // 4. Tech Tags (Kleiner en cleaner)
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                gap(6.px)
                marginTop(AppSpacing.xs)
            }
        }) {
            project.techStack.take(4).forEach { tech -> // Toon max 4 om grootte te beperken
                Span(attrs = {
                    style {
                        fontSize(0.8.cssRem)
                        color(theme.textPrimary)
                        backgroundColor(theme.surfaceHover)
                        padding(2.px, 8.px)
                        borderRadius(4.px)
                        opacity(0.8)
                    }
                }) {
                    Text(tech)
                }
            }
        }
    }
}