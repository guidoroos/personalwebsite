package com.guidoroos.portfolio.ui.page

import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.ui.styling.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.guidoroos.portfolio.data.content.homePageContent

@Composable
fun HomePage() {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Div(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
            textAlign("center")
            gap(AppSpacing.lg)
            paddingTop(AppSpacing.md)
        }
    }) {
        // 1. Titel
        H1(attrs = { classes(styles.h1Hero) }) {
            Text(homePageContent.title)
        }

        // 2. Foto Rounded
        Img(
            src = homePageContent.profileImageUrl,
            alt = "Profielfoto van ${homePageContent.fullName}", // Naam uit data voor alt text
            attrs = {
                style {
                    width(200.px)
                    height(200.px)
                    borderRadius(50.percent)
                    property("object-fit", "cover")
                    property("box-shadow", "0 10px 15px -3px rgba(0, 0, 0, 0.1)")
                }
            }
        )

        // 3. About Me Textblok
        Div(attrs = { style { maxWidth(700.px) } }) {
            P(attrs = { classes(styles.bodyRegular) }) {
                Text(homePageContent.aboutMe)
            }
        }

        // 4. Techstack Sectie
        Section(attrs = { style { marginTop(AppSpacing.lg) } }) {
            H2(attrs = {
                classes(styles.bodyRegular)
                style { fontWeight(AppTypography.weightBold); marginBottom(AppSpacing.md) }
            }) {
                Text("Techstack")
            }

            Div(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexWrap(FlexWrap.Wrap)
                    justifyContent(JustifyContent.Center)
                    gap(AppSpacing.sm)
                }
            }) {
                homePageContent.techStack.forEach { tech ->
                    TechBadge(tech)
                }
            }
        }

        // 5. Contact Sectie (CTA)
        Div(attrs = {
            style {
                marginTop(AppSpacing.xl)
                padding(AppSpacing.lg)
                backgroundColor(theme.surface)
                borderRadius(AppSpacing.borderRadius)
                property("border", "1px solid ${theme.border}")
            }
        }) {
            H3(attrs = { classes(styles.navLabel); style { marginBottom(AppSpacing.sm) } }) {
                Text(homePageContent.ctaTitle)
            }
            A(href = "mailto:${homePageContent.ctaEmail}", attrs = {
                style {
                    color(theme.primary)
                    fontWeight(AppTypography.weightBold)
                    textDecoration("none")
                }
            }) {
                Text(homePageContent.ctaLinkText)
            }
        }
    }
}

@Composable
fun TechBadge(text: String) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Span(attrs = {
        style {
            padding(0.4.cssRem, 0.8.cssRem)
            backgroundColor(theme.background)
            borderRadius(8.px) // Agency-style: iets minder rond is vaak strakker
            fontSize(AppTypography.sizeSmall)
            fontWeight(AppTypography.weightMedium)
            property("border", "1px solid ${theme.border}")
        }
    }) {
        Text(text)
    }
}