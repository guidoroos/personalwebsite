package com.guidoroos.portfolio.data.model

data class ProjectDetail(
    val challenge: String,
    val role: String,
    val solution: String,
    val keyAchievements: List<String>,
    val productUrls: List<String> = emptyList(),
    val repoUrl: String? = null
)