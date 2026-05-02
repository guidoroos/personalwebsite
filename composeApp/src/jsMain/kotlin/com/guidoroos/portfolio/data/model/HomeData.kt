package com.guidoroos.portfolio.data.model

data class HomeData(
    val fullName:String = "Guido Roos",
    val subtitle: String,
    val profileImageUrl:String = "profielfoto.jpg",
    val title: String,
    val locationInfo: String,
    val pitch: String,
    val capabilitiesTitle: String,
    val capabilities: List<String>,
    val projectsTitle: String,
    val allProjectsTitle: String,
    val ctaTitle: String,
    val ctaLinkText: String,
    val ctaEmail: String = "guido@roosmobile.nl",
    val metaDescription: String
)