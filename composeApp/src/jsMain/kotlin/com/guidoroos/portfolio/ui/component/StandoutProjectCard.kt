package com.guidoroos.portfolio.ui.component

import LocalAppTheme
import LocalStyles
import com.guidoroos.portfolio.data.model.Project


import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.ui.styling.AppSpacing
import com.guidoroos.portfolio.ui.styling.AppTypography
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun StandoutProjectCard(
    project: Project,
    onClickProject: (Project) -> Unit
) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Div(attrs = {
        onClick { onClickProject(project) }

        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            padding(AppSpacing.md)

            // White background & standard border
            backgroundColor(theme.surface)
            border(1.px, LineStyle.Solid, theme.border)
            borderRadius(8.px)
            cursor("pointer")

            property("transition", "transform 0.2s ease, box-shadow 0.2s ease")
        }
    }) {
        // --- TITLE LOGIC ---
        val clientName = project.clientName

        if (clientName != null) {
            // Primary Title: Client Name
            Span(attrs = {
                classes(styles.h3Card)
                style { marginBottom(4.px) }
            }) {
                Text(clientName)
            }
        } else {
            // Fallback Title: Non-nullable entityName (Smaller)
            Span(attrs = {
                classes(styles.bodyRegular)
                style {
                    color(theme.textPrimary)
                    fontWeight(AppTypography.weightBold)
                    marginBottom(4.px)
                }
            }) {
                Text(project.entityName)
            }
        }

        // --- DESCRIPTION ---
        Span(attrs = {
            classes(styles.bodySmall)
            style {
                color(theme.textSecondary)
                // Line clamping to keep the card height consistent
                property("display", "-webkit-box")
                property("-webkit-line-clamp", "2")
                property("-webkit-box-orient", "vertical")
                overflow("hidden")
            }
        }) {
            Text(project.shortDescription)
        }
    }
}