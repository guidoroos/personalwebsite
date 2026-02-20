package com.guidoroos.portfolio.data.model


data class HomePageModel(
    val title: String,
    val fullName: String,
    val profileImageUrl: String,
    val aboutMe: String,
    val techStack: List<String>,
    val ctaTitle: String,
    val ctaEmail: String,
    val ctaLinkText: String
)