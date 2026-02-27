package com.guidoroos.portfolio.ui.page

import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.data.content.ProjectContent.projects
import com.guidoroos.portfolio.ui.styling.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.guidoroos.portfolio.data.content.homePageContent
import com.guidoroos.portfolio.data.model.Page
import com.guidoroos.portfolio.ui.component.ActionIcon
import com.guidoroos.portfolio.ui.component.ProjectCard
import com.guidoroos.portfolio.ui.component.StandoutProjectCard

@Composable
fun HomePage(onNavigate: (Page) -> Unit) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Div(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
            textAlign("center")
            gap(AppSpacing.sm)
            paddingTop(AppSpacing.md)
            paddingBottom(AppSpacing.xl)
        }
    }) {
        // 1. Hero Header
        H1(attrs = { classes(styles.h1Hero) }) {
            Text(homePageContent.fullName)
        }
        H2(attrs = {
            style {
                marginTop((-16).px)
                color(theme.primary)
                fontSize(1.5.cssRem)
            }
        }) {
            Text(homePageContent.title)
        }

        // 2. Profile Image
        Img(
            src = homePageContent.profileImageUrl,
            alt = "Guido Roos",
            attrs = {
                style {
                    width(250.px); height(250.px)
                    borderRadius(50.percent)
                    property("object-fit", "cover")
                    property("object-position", "center 35%")
                    property("box-shadow", "0 10px 25px -5px rgba(0, 0, 0, 0.2)")
                    marginTop(AppSpacing.md)
                }
            }
        )

        // 3. The Pitch & Location
        Div(attrs = { style { maxWidth(800.px); padding(0.px, AppSpacing.md) } }) {
            P(attrs = { classes(styles.bodyRegular);
                style {
                marginTop(AppSpacing.lg)
                property("white-space", "pre-line")
                }
            }) {
                Text(homePageContent.kmpPitch)
            }
        }


        Section(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Center)
            }
        }) {
            // Reference the variable, no hardcoding
            H3(attrs = {
                // Stick to the design system class
                classes(styles.h3Card)

                style {
                    // Only keep what's strictly unique to this specific UI section
                    color(theme.textSecondary)
                    marginBottom(AppSpacing.md)
                    property("letter-spacing", "0.05em")

                    // fontSize is already handled by styles.h3Card
                }
            }) {
                Text(homePageContent.capabilitiesTitle)
            }

            Div(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    gap(AppSpacing.md)
                    justifyContent(JustifyContent.Center)
                    flexWrap(FlexWrap.Wrap)
                }
            }) {
                homePageContent.capabilities.forEach { capability ->
                    Div(attrs = {
                        style {
                            padding(AppSpacing.sm, AppSpacing.md)
                            backgroundColor(theme.surface)
                            border(0.5.px, LineStyle.Solid, theme.border)
                            borderRadius(AppSpacing.borderRadius)
                            fontWeight(AppTypography.weightBold)
                            fontSize(0.9.cssRem)
                        }
                    }) { Text(capability) }
                }
            }
        }

        Div(attrs = {
            style {
                fontSize(0.9.cssRem)
                color(theme.textSecondary)
                fontStyle("italic")
                marginTop(AppSpacing.md)
                maxWidth(800.px)

            }
        }) {
            Text(homePageContent.locationInfo)
        }

        H3(attrs = {
            // Stick to the design system class
            classes(styles.h3Card)

            style {
                // Only keep what's strictly unique to this specific UI section
                color(theme.textSecondary)
                property("letter-spacing", "0.05em")

                // fontSize is already handled by styles.h3Card
            }
        }) {
            Text(homePageContent.projectsTitle)
        }

        // 1. The Grid Container
        Div(attrs = {
            style {
                display(DisplayStyle.Grid)
                // Responsive 3-column target
                gridTemplateColumns("repeat(auto-fit, minmax(280px, 1fr))")
                gap(AppSpacing.md)
                // Removed marginBottom to close the gap to the button
                width(100.percent)
            }
        }) {
            projects.forEach { project ->
                StandoutProjectCard(project) { selectedProject ->
                    onNavigate(Page.ProjectDetail(project = selectedProject))
                }
            }
        }

// 2. The Text Button (No vertical spacing)
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
                padding(AppSpacing.md, 0.px) // Only horizontal padding/internal vertical
            }
        }) {
            Span(attrs = {
                onClick { onNavigate(Page.Projects) }

                classes(styles.bodyRegular)
                style {
                    cursor("pointer")
                    fontWeight(AppTypography.weightBold)
                    color(theme.textPrimary)

                    // Text button styling
                    textDecoration("underline")

                }
            }) {
                Text(homePageContent.allProjectsTitle)
            }
        }

        // 6. Contact Section
        Div(attrs = {
            style {
                marginTop(AppSpacing.lg)
                padding(AppSpacing.md)
                paddingBottom(AppSpacing.lg)
                backgroundColor(theme.surfaceVariant)
                borderRadius(AppSpacing.borderRadiusLarge)
                property("border", "2px solid ${theme.border}")
                maxWidth(500.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Center)
                textAlign("center")
                cursor("pointer")
                property("box-shadow", "0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24)")
            }
        }) {
            H3(attrs = { classes(styles.navLabel); }) {
                Text(homePageContent.ctaTitle)
            }
            A(href = "mailto:${homePageContent.ctaEmail}", attrs = {
                classes(styles.ctaLink)
                style {
                    display(DisplayStyle.Flex)
                    alignItems(AlignItems.Center)
                    gap(8.px)

                    // Use one of the slightly darker tints for better readability on white
                    color(Color("#86CC22")) // Or theme.kmpHighlight if you prefer the neon

                    textDecoration("none")
                    fontSize(1.4.cssRem) // Bumped up slightly to catch the eye
                    fontWeight(AppTypography.weightBold)

                    // Add a subtle transition for the hover state
                    property("transition", "transform 0.2s ease-in-out, filter 0.2s ease")
                }
            }) {
                // 1. Text first for readability
                Text(homePageContent.ctaLinkText)

                // 2. ActionIcon inherits the parent color due to the mask-image approach
                ActionIcon(
                    svgName = "send",
                    styleModifier = { backgroundColor(theme.kmpHighlight) }
                ) {
                    /* Click handled by A tag */
                }
            }
        }
    }
}
