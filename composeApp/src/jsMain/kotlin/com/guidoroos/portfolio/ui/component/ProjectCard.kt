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
fun ProjectCard(project: Project, onClick: (Project) -> Unit) {
    val styles = LocalStyles.current
    val theme = LocalAppTheme.current
    val currentLanguage = LocalLanguage.current

    A(
        href = "/projects/${project.id}",
        attrs = {

            style {
                textDecoration("none")
                display(DisplayStyle.Block)
                cursor("pointer")
            }

            onClick { event ->
                event.preventDefault()
                onClick(project)
            }
        }
    ) {
        Article(attrs = {
            attr("itemscope", "")
            attr("itemtype", "https://schema.org/CreativeWork")
            classes(styles.card)
            style {
                padding(AppSpacing.md)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                gap(4.px)
                minHeight(160.px)

                backgroundColor(theme.surface)
                border(1.px, LineStyle.Solid, theme.border)
                borderRadius(8.px)

                // Zorg dat de kaart mooi reageert op hover (optioneel, maar lekker voor UX)
                property("transition", "transform 0.2s ease, box-shadow 0.2s ease")
            }
        }) {
            // 1. Header: Bedrijfsnaam en Periode
            Header(attrs = {
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
                        color(theme.primary)
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
                        color(theme.textPrimary)
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

            // 2. Project Titel (Bold Span voor hiërarchie)
            Span(attrs = {
                attr("itemprop", "name")
                style {
                    fontSize(0.95.cssRem)
                    fontWeight("bold")
                    color(theme.textPrimary)
                    display(DisplayStyle.Block)
                }
            }) {
                Text(project.title)
            }

            // 3. Beschrijving (Met Line Clamp)
            P(attrs = {
                attr("itemprop", "description")
                style {
                    fontSize(0.90.cssRem)
                    margin(AppSpacing.xs, 0.px)
                    color(theme.textSecondary)
                    property("display", "-webkit-box")
                    property("-webkit-line-clamp", "2")
                    property("-webkit-box-orient", "vertical")
                    overflow("hidden")
                }
            }) {
                Text(project.shortDescription)
            }

            // Spacer om tags onderaan te houden
            Div(attrs = { style { flex(1); minHeight(AppSpacing.xs) } })

            // 4. Footer: Tech Tags
            Footer(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexWrap(FlexWrap.Wrap)
                    gap(6.px)
                    marginTop(AppSpacing.xs)
                }
            }) {
                project.techStack.take(4).forEach { tech ->
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
}