package com.guidoroos.portfolio.ui.component


import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.data.model.Project
import com.guidoroos.portfolio.data.model.ProjectType
import com.guidoroos.portfolio.ui.styling.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun ProjectCard(project: Project, onClick: () -> Unit) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Div(attrs = {
        classes(styles.card)
        style {
            cursor("pointer")
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
        }
        onClick { onClick() }
    }) {

        // 1. Label Sectie (Type & Klant)
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.SpaceBetween)
                alignItems(AlignItems.Center)
                marginBottom(AppSpacing.sm)
            }
        }) {
            // De "Subtitle" logica voor Entity vs Client
            Span(attrs = {
                style {
                    fontSize(AppTypography.sizeTiny)
                    fontWeight(AppTypography.weightBold)
                    color(theme.primary)
                    letterSpacing(AppTypography.lsWide)
                }
            }) {
                val label = when (project.type) {
                    ProjectType.Employment -> "${project.entityName} @ ${project.clientName}"
                    ProjectType.Freelance -> project.clientName ?: project.entityName
                    ProjectType.SideProject -> "Side Project"
                }
                Text(label)
            }

            // Periode
            Span(attrs = {
                style {
                    fontSize(AppTypography.sizeTiny)
                    color(theme.textSecondary)
                }
            }) {
                val period = if (project.endDate == null) "${project.startDate} — Heden" else "${project.startDate} — ${project.endDate}"
                Text(period)
            }
        }

        // 2. Titel
        H3(attrs = {
            style {
                fontSize(AppTypography.sizeH3)
                fontWeight(AppTypography.weightBold)
                marginTop(0.px)
                marginBottom(AppSpacing.xs)
            }
        }) {
            Text(project.title)
        }

        // 3. Beschrijving
        P(attrs = {
            classes(styles.bodySmall)
            style {
                color(theme.textSecondary)
                flex(1) // Zorgt dat de kaartjes in een grid even hoog lijken
                marginBottom(AppSpacing.md)
            }
        }) {
            Text(project.shortDescription)
        }

        // 4. Tech Stack
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                gap(AppSpacing.xs)
                marginTop(AppSpacing.md)
            }
        }) {
            val displayedTech = project.techStack.joinToString("  •  ")

            Span(attrs = {
                style {
                    fontSize(AppTypography.sizeTiny)
                    color(theme.textSecondary)
                    fontWeight(AppTypography.weightBold)
                    letterSpacing(1.px)
                }
            }) {
                Text(displayedTech)
            }
        }
    }
}