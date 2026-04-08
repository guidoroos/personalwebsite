package com.guidoroos.portfolio.ui.component

import AppLanguage
import LanguageSelector
import LocalAppTheme
import LocalLanguage
import LocalStyles
import androidx.compose.runtime.*
import com.guidoroos.portfolio.data.model.NavigationItem
import com.guidoroos.portfolio.data.model.Page
import com.guidoroos.portfolio.ui.styling.AppSpacing
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

import com.guidoroos.portfolio.ui.styling.AppTypography
import com.guidoroos.portfolio.ui.styling.DarkTheme

@Composable
fun Navbar(
    currentPage: Page,
    toggleTheme: () -> Unit,
    setLanguage: (AppLanguage) -> Unit,
    onNavigate: (Page) -> Unit,
) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current
    val isDark = theme is DarkTheme
    val currentLanguage = LocalLanguage.current


    Nav(attrs = { classes(styles.navBar) }) {

        // Socials
        Div(attrs = { classes(styles.navSectionLeft) }) {
            UrlIcon(
                svgName = if (isDark) "githubDark" else "github",
                url = "https://github.com/guidoroos"
            )
            UrlIcon(svgName = "linkedin", url = "https://linkedin.com/in/guido-roos91")
            UrlIcon(
                svgName = if (isDark) "emailDark" else "email",
                url = "mailto:guidoroos@protonmail.com"
            )
            UrlIcon(
                svgName = if (isDark) "cvDark" else "cv",
                url = "https://rxresu.me/guidoroos/guido-roos"
            )
        }

        // Navigation & Theme
        Div(attrs = {
            classes(styles.navSectionRight, styles.socialIconGroup)
        }) {
            NavigationItem.entries.forEach { item ->
                val active = item.isActive(currentPage)

                Span(attrs = {
                    classes(styles.navLink, styles.navLabel)
                    style {
                        marginLeft(AppSpacing.md)
                    }

                    if (active) classes(styles.navLinkActive)
                    onClick { onNavigate(item.rootPage) }
                }) {
                    Text(if (currentLanguage == AppLanguage.NL) item.labelNL else  item.labelEN)
                }
            }

            LanguageSelector(
                currentLanguage = currentLanguage,
                attrsModifier = {
                    classes(styles.hideOnMobile)

                    style {
                        marginLeft(AppSpacing.md)
                    }
                }
            ) { newLanguage ->
                setLanguage(newLanguage)
            }

            ActionIcon(
                svgName = if (isDark) "sun" else "moon",
                attrsModifier = {
                    classes(styles.hideOnMobile)

                    style {
                        marginLeft(AppSpacing.md)
                    }
                }
            ) {
                toggleTheme()
            }
        }
    }
}