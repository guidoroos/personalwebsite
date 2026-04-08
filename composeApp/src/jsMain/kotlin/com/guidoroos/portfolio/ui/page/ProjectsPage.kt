import androidx.compose.runtime.Composable
import com.guidoroos.portfolio.data.content.ProjectContentEN
import com.guidoroos.portfolio.data.content.ProjectContentNL
import com.guidoroos.portfolio.data.content.projectsPageDataEN
import com.guidoroos.portfolio.data.content.projectsPageDataNL
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
    val language = LocalLanguage.current
    val projectsPageData =
        if (language == AppLanguage.NL) projectsPageDataNL else projectsPageDataEN
    val projects =
        if (language == AppLanguage.NL) ProjectContentNL.projects else ProjectContentEN.projects

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

    Section(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center) // Centreert items horizontaal
            textAlign("center")           // Centreert tekst binnen de items
            width(100.percent)
        }
    }) {
        H2 { Text(title) }

        P(attrs = {
            style {
                color(theme.textSecondary)
                marginBottom(AppSpacing.md)
                maxWidth(600.px)
            }
        }) { Text(subtitle) }

        Div(attrs = {
            classes(styles.projectGrid)
        }) {
            projects.forEach { project ->
                ProjectCard(project, onClick = { onProjectSelect(project) })
            }
        }
    }
}