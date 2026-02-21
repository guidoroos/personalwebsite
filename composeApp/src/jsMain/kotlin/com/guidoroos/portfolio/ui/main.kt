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

        CompositionLocalProvider(LocalAppTheme provides theme) {
            // Root Container
            Div(attrs = {
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
                Main(attrs = { classes(styles.container) }) {
                    when (val page = currentPage.value) {
                        Page.Home -> HomePage()
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
                    style {
                        property("margin-top", "auto")
                        padding(2.cssRem)
                        textAlign("center")
                        color(theme.textSecondary)
                        property("border-top", "1px solid ${theme.border}")
                    }
                }) {
                    Text("© ${2026} Guido Roos - Senior Kotlin Developer")
                }
            }
        }
    }
}
