package com.guidoroos.portfolio.ui.component

import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.*
import com.guidoroos.portfolio.data.model.NavigationItem
import com.guidoroos.portfolio.data.model.Page
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

import com.guidoroos.portfolio.ui.styling.AppTypography
import com.guidoroos.portfolio.ui.styling.DarkTheme

@Composable
fun Navbar(
    currentPage: Page,
    toggleTheme: () -> Unit,
    onNavigate: (Page) -> Unit,

) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Nav(attrs = { classes(styles.navBar) }) {
        // TOP LEFT: Social Icons Row
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                gap(16.px)
            }
        }) {
            UrlIcon(svgName = "github", url = "https://github.com/guidoroos")
            UrlIcon(svgName = "linkedin", url = "https://linkedin.com/in/guido-roos91")
            UrlIcon(svgName = "email", url = "mailto:guidoroos@protonmail.com")
            UrlIcon(svgName = "cv", url = "https://rxresu.me/guidoroos/guido-roos")
        }

        // RIGHT: Navigation Items & Theme Toggle
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                gap(24.px)
            }
        }) {
            NavigationItem.entries.forEach { item ->
                val active = item.isActive(currentPage)
                Span(attrs = {
                    classes(styles.navLink, styles.navLabel)
                    if (active) {
                        style {
                            color(theme.primary)
                            fontWeight(AppTypography.weightBold)
                            property("border-bottom", "2px solid ${theme.primary}")
                        }
                    }
                    onClick { onNavigate(item.rootPage) }
                }) {
                    Text(item.label)
                }
            }

            // Theme Toggle
            Span(attrs = {
                classes(styles.navLink)
                style { fontSize(1.2.em) }
            }) {
                val icon = if (theme is DarkTheme)  "sun" else "moon"
                ActionIcon(svgName = icon) {
                    toggleTheme()
                }
            }
        }
    }
}