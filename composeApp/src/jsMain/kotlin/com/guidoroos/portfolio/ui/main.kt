import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

import com.guidoroos.portfolio.ui.styling.AppStylesheet
import com.guidoroos.portfolio.data.model.Page
import com.guidoroos.portfolio.ui.component.Navbar
import com.guidoroos.portfolio.ui.page.HomePage
import com.guidoroos.portfolio.ui.page.ProjectDetailPage
import com.guidoroos.portfolio.ui.styling.AppTheme
import com.guidoroos.portfolio.ui.styling.DarkTheme
import com.guidoroos.portfolio.ui.styling.LightTheme
import com.guidoroos.portfolio.util.isSystemInDarkMode


val LocalAppTheme = staticCompositionLocalOf<AppTheme> { DarkTheme }
val LocalStyles = staticCompositionLocalOf { AppStylesheet(DarkTheme) }

fun main() {
    renderComposable(rootElementId = "root") {
        val currentPage = remember { mutableStateOf<Page>(Page.Home) }
        var isDark by remember { mutableStateOf(isSystemInDarkMode()) }
        val theme = if (isDark) DarkTheme else LightTheme
        val styles  = remember(theme) { AppStylesheet(theme) }
        Style(styles)

        val currentYear = kotlin.js.Date().getFullYear()

        CompositionLocalProvider(LocalAppTheme provides theme) {
            // Root Container
            Div(attrs = {
                classes(styles.backgroundPattern)
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    overflow("hidden")
                    minHeight(100.vh)
                }
            }) {

                // --- NAVBAR COMPONENT ---
                Navbar(
                    currentPage = currentPage.value,
                    toggleTheme = { isDark = !isDark }
                ) { currentPage.value = it }

                // --- MAIN CONTENT AREA ---
                Main(attrs = {
                    classes(styles.container) }) {
                    when (val page = currentPage.value) {
                        Page.Home -> HomePage{pageToNavigate ->
                            currentPage.value = pageToNavigate
                        }
                        Page.Projects -> ProjectsPage { project ->
                            currentPage.value = Page.ProjectDetail(project)
                        }

                        is Page.ProjectDetail -> ProjectDetailPage(page.project) {
                            currentPage.value = Page.Projects
                        }
                    }
                }

                // --- FOOTER ---
                Footer(attrs = {
                    // We keep the layout properties in the inline style for the container
                    // but we could also move this to a 'footerContainer' class in your Stylesheet!
                    style {
                        property("margin-top", "auto")
                        padding(2.cssRem)
                        textAlign("center")
                        property("border-top", "0.5px solid ${theme.border}")

                        marginTop(40.px)
                        marginLeft(40.px)
                        marginRight(40.px)
                    }
                }) {
                    // The "Stand out" line using your custom highlight style
                    Div(attrs = {
                        classes(styles.bodyRegular)
                        style {
                            color(theme.primary)
                            marginBottom(0.5.cssRem)
                            fontWeight("bold") // Manual override to make it pop
                        }
                    }) {
                        Text("Built with Kotlin Multiplatform for web")
                    }

                    // The standard copyright using your muted small text style
                    Div(attrs = {
                        classes(styles.bodySmall)
                        style {
                            color(theme.textMuted)
                        }
                    }) {
                        Text("© $currentYear Guido Roos")
                    }
                }
            }
        }
    }
}
