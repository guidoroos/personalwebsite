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

    A(
        href = "/projects/${project.id}",
        attrs = {
            style {
                textDecoration("none")
                display(DisplayStyle.Block)
            }

            onClick { event ->
                event.preventDefault()
                onClickProject(project)
            }
        }
    ) {
        Article(attrs = {
            attr("itemscope", "")
            attr("itemtype", "https://schema.org/CreativeWork")
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                padding(AppSpacing.md)

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
                // Gebruik H3 in plaats van Span voor betere hiërarchie
                H3(attrs = {

                    classes(styles.h3Card)
                    style {
                        marginTop(0.px)
                        marginBottom(4.px)
                    }
                }) {
                    Text(clientName)
                }
            } else {
                H3(attrs = {

                    classes(styles.bodyRegular)
                    style {
                        color(theme.textPrimary)
                        fontWeight(AppTypography.weightBold)
                        marginTop(0.px)
                        marginBottom(4.px)
                    }
                }) {
                    Text(project.entityName)
                }
            }

            // --- DESCRIPTION ---
            P(attrs = {
                attr("itemprop", "name")
                classes(styles.bodySmall)
                style {
                    color(theme.textSecondary)
                    margin(0.px)
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
}