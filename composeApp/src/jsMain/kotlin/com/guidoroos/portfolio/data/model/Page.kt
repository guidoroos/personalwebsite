package com.guidoroos.portfolio.data.model

sealed class Page {
    object Home : Page()
    object Projects : Page()
    data class ProjectDetail(val project: Project) : Page()
}