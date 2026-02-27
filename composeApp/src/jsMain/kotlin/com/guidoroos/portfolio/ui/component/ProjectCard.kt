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
    val styles = LocalStyles.current
    val theme = LocalAppTheme.current

    Div(attrs = {
        classes(styles.card)
        style {
            cursor("pointer")
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
        }
        onClick { onClick() }
    }) {

        // 1. Label Row
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.SpaceBetween)
                marginBottom(AppSpacing.sm)
            }
        }) {
            Span(attrs = {
                classes(styles.tagLabel)
                style { color(theme.primary) }
            }) {
                val label = when (project.type) {
                    ProjectType.Employment -> "${project.entityName} @ ${project.clientName}"
                    ProjectType.Freelance -> project.clientName ?: project.entityName
                    ProjectType.SideProject -> "Side Project"
                }
                Text(label)
            }

            Span(attrs = {
                classes(styles.bodySmall)
                style {
                    color(theme.textPrimary)
                }
            }) {
                // Year logic: Show one year if same or endDate is null and startDate is current year
                val period = when {
                    project.endDate == null -> "${project.startDate} — Heden"
                    project.startDate == project.endDate -> project.startDate
                    else -> "${project.startDate} — ${project.endDate}"
                }
                Text(period)
            }
        }

        // 2. Title
        H3(attrs = {
            classes(styles.h3Card)
            style { marginTop(0.px); marginBottom(AppSpacing.xs) }
        }) {
            Text(project.title)
        }

        // 3. Description
        P(attrs = {
            classes(styles.bodySmall)
            style {
                flex(1)
                marginBottom(AppSpacing.md)
                color(theme.textSecondary)
            }
        }) {
            Text(project.shortDescription)
        }

        // 4. Tech Stack as Chips
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                gap(AppSpacing.xs)
                marginTop(AppSpacing.md)
            }
        }) {
            project.techStack.forEach { tech ->
                Span(attrs = {
                    classes(styles.tagLabel)
                    style {
                        color(theme.textPrimary)
                        backgroundColor(theme.surfaceHover) // Subtle background for the chip
                        padding(0.2.cssRem, 0.6.cssRem)
                        borderRadius(12.px)
                        fontSize(0.7.cssRem)
                    }
                }) {
                    Text(tech)
                }
            }
        }
    }
}