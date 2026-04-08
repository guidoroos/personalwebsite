package com.guidoroos.portfolio.data.model

enum class ProjectType(val label: String) {
    Freelance("Freelance"),
    Employment("Loondienst"),
    SideProject("Side Project")
}

data class Project(
    val id: String,
    val type: ProjectType,
    val title: String,
    val shortDescription: String,
    val longDescription: String,
    val entityName: String,
    val clientName: String? = null,
    val startDate: String,
    val endDate: String? = null,
    val techStack: List<String>,
    val details: ProjectDetail,
    val shouldHighlight: Boolean = false
)