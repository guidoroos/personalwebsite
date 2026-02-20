package com.guidoroos.portfolio.data.model


enum class NavigationItem(
    val label: String,
    val rootPage: Page,
) {
    Home(
        label = "Home",
        rootPage = Page.Home,
    ),
    Projects(
        label = "Projects",
        rootPage = Page.Projects,
    );

    fun isActive(currentPage: Page): Boolean = when (this) {
        Home -> currentPage is Page.Home
        Projects -> currentPage is Page.Projects || currentPage is Page.ProjectDetail
    }

}