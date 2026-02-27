package com.guidoroos.portfolio.data.model

data class ProjectDetail(
    val challenge: String,
    val role: String,
    val solution: String,
    val keyAchievements: List<String>,
    val productUrls: Map<String, String> = emptyMap(),
    val repoUrl: String? = null
)