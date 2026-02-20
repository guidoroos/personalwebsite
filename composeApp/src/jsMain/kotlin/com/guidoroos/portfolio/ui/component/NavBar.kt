package com.guidoroos.portfolio.ui.component

import androidx.compose.runtime.*
import com.guidoroos.portfolio.data.model.NavigationItem
import com.guidoroos.portfolio.data.model.Page
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.guidoroos.portfolio.ui.styling.AppColors
import com.guidoroos.portfolio.ui.styling.AppStylesheet
import com.guidoroos.portfolio.ui.styling.AppTypography

@Composable
fun Navbar(currentPage: Page, onNavigate: (Page) -> Unit) {
    Nav(attrs = { classes(AppStylesheet.navBar) }) {
        // Logo - Gebruikt nu de navLabel preset
        Span(attrs = {
            classes(AppStylesheet.navLabel)
            style {
                cursor("pointer")
                color(AppColors.primary) // Branding kleur override
            }
            onClick { onNavigate(Page.Home) }
        }) {
            Text("GuidoRoos.kt")
        }

        // Menu items
        Div {
            NavigationItem.entries.forEach { item ->
                val active = item.isActive(currentPage)

                Span(attrs = {
                    // Combineer de algemene navLink style met de tekst presets
                    classes(AppStylesheet.navLink, AppStylesheet.navLabel)

                    if (active) {
                        style {
                            color(AppColors.primary)
                            // Gebruik de Int waarde uit je nieuwe AppTypography
                            fontWeight(AppTypography.weightBold)
                            property("border-bottom", "2px solid ${AppColors.primary}")
                        }
                    }
                    onClick { onNavigate(item.rootPage) }
                }) {
                    Text(item.label)
                }
            }
        }
    }
}