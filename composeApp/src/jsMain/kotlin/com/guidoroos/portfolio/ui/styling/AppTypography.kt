package com.guidoroos.portfolio.ui.styling


import org.jetbrains.compose.web.css.*

object AppTypography {
    // --- Font Family Stack ---
    val primaryFontFamily = "Inter, system-ui, -apple-system, sans-serif"

    // --- Font Weights ---
    val weightNormal =400
    val weightMedium = 500
    val weightSemiBold = 600
    val weightBold = 700

    // --- Font Sizes (Typographic Scale) ---
    val sizeH1 = 3.0.cssRem
    val sizeH2 = 2.0.cssRem
    val sizeH3 = 1.25.cssRem
    val sizeNav = 1.0.cssRem
    val sizeBodyLarge = 1.1.cssRem
    val sizeBody = 1.0.cssRem
    val sizeSmall = 0.875.cssRem
    val sizeTiny = 0.75.cssRem

    // --- Line Heights ---
    val lhTight = 1.2.toString()
    val lhNormal = 1.5.toString()
    val lhRelaxed = 1.625.toString()

    // --- Letter Spacing ---
    val lsTight = (-0.02).cssRem
    val lsNormal = 0.cssRem
    val lsWide = 0.05.cssRem
}