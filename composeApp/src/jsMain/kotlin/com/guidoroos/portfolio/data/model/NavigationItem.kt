package com.guidoroos.portfolio.data.model


enum class NavigationItem(
    val labelNL: String,
    val labelEN: String,
    val rootPage: Page,
) {
    Home(
        labelEN = "Home",
        labelNL = "Home",
        rootPage = Page.Home,
    ),
    Projects(
        labelEN = "Projects",
        labelNL = "Projecten",
        rootPage = Page.Projects,
    );

    fun isActive(currentPage: Page): Boolean = when (this) {
        Home -> currentPage is Page.Home
        Projects -> currentPage is Page.Projects || currentPage is Page.ProjectDetail
    }

}