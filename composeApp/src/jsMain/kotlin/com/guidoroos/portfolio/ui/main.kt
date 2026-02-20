import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import com.guidoroos.portfolio.ui.styling.AppColors
import com.guidoroos.portfolio.ui.styling.AppStylesheet
import com.guidoroos.portfolio.data.model.Page
import com.guidoroos.portfolio.ui.component.Navbar
import com.guidoroos.portfolio.ui.page.HomePage
import com.guidoroos.portfolio.ui.page.ProjectDetailPage


fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)

        // State voor navigatie
        val currentPage = remember { mutableStateOf<Page>(Page.Home) }

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
            Navbar(currentPage.value) { currentPage.value = it }

            // --- MAIN CONTENT AREA ---
            Main(attrs = { classes(AppStylesheet.container) }) {
                when (val page = currentPage.value) {
                    Page.Home -> HomePage()
                    Page.Projects -> ProjectsPage { project -> currentPage.value = Page.ProjectDetail(project) }
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
                    color(AppColors.textSecondary)
                    property("border-top", "1px solid ${AppColors.border}")
                }
            }) {
                Text("© ${2026} Guido Roos - Senior Kotlin Developer")
            }
        }
    }
}
