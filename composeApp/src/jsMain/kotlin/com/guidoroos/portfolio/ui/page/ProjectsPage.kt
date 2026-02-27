
import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.data.content.projectsPageData
import com.guidoroos.portfolio.data.content.ProjectContent.projects
import com.guidoroos.portfolio.data.model.Project
import com.guidoroos.portfolio.data.model.ProjectType
import com.guidoroos.portfolio.ui.component.ProjectCard
import com.guidoroos.portfolio.ui.styling.AppStylesheet
import com.guidoroos.portfolio.ui.styling.AppSpacing

// Compose HTML imports
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ProjectsPage(
    onProjectSelect: (Project) -> Unit
) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Div(attrs = { classes(styles.container) }) {

        // Pagina Header
        H1 { Text(projectsPageData.title) }
        P(attrs = { style { color(theme.textSecondary); marginBottom(AppSpacing.lg) } }) {
            Text(projectsPageData.subtitle)
        }

        // 1. FREELANCE
        ProjectSection(
            title = projectsPageData.freelanceTitle,
            subtitle = projectsPageData.freelanceSubtitle,
            projects = projects.filter { it.type == ProjectType.Freelance },
            onProjectSelect = onProjectSelect
        )


        // 2. LOONDIENST
        ProjectSection(
            title = projectsPageData.employmentTitle,
            subtitle = projectsPageData.employmentSubtitle,
            projects = projects.filter { it.type == ProjectType.Employment },
            onProjectSelect = onProjectSelect
        )

        // 3. SIDE PROJECTS
        ProjectSection(
            title = projectsPageData.sideProjectTitle,
            subtitle = projectsPageData.sideProjectSubtitle,
            projects = projects.filter { it.type == ProjectType.SideProject },
            onProjectSelect = onProjectSelect
        )
    }
}

@Composable
fun ProjectSection(
    title: String,
    subtitle: String,
    projects: List<Project>,
    onProjectSelect: (Project) -> Unit
) {
    if (projects.isEmpty()) return
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Section {
        H2 { Text(title) }
        P(attrs = {
            style {
                color(theme.textSecondary);
                marginBottom(AppSpacing.md);
                maxWidth(600.px)
            }
        }) { Text(subtitle) }

        Div(attrs = {
            style {
                display(DisplayStyle.Grid)
                property("grid-template-columns", "repeat(auto-fill, minmax(300px, 1fr))")
                gap(AppSpacing.md)
            }
        }) {
            projects.forEach { project ->
                ProjectCard(project, onClick = { onProjectSelect(project) })
            }
        }
    }
}