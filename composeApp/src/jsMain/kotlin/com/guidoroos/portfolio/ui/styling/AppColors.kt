package com.guidoroos.portfolio.ui.styling

import org.jetbrains.compose.web.css.*

interface AppTheme {
    // Brand & Accents
    val primary: CSSColorValue
    val kmpHighlight: CSSColorValue
    val locationPin: CSSColorValue
    val success: CSSColorValue

    // Surface & Layout
    val background: CSSColorValue
    val background2: CSSColorValue
    val background3: CSSColorValue
    val surface: CSSColorValue
    val surfaceVariant: CSSColorValue
    val surfaceHover: CSSColorValue
    val border: CSSColorValue
    val gridDot: CSSColorValue

    // Typography
    val textPrimary: CSSColorValue
    val textSecondary: CSSColorValue
    val textMuted: CSSColorValue
    val iconBase: CSSColorValue
}

// Make sure both are objects for consistency
object DarkTheme : AppTheme {
    override val primary = Color("#6366f1")
    override val kmpHighlight = Color("#ADFF2F")
    override val locationPin = Color("#f43f5e")
    override val success = Color("#10b981")
    override val background = Color("#0b0f1a")
    override val background2 = Color("#1e293b59")
    override val background3 = Color("#05070a")
    override val surface = Color("#161e2d")
    override val surfaceVariant = Color("#232d3f")
    override val surfaceHover = Color("#1e293b")
    override val border = Color("#1e293b")
    override val gridDot = Color("#242f42")
    override val textPrimary = Color("#f8fafc")
    override val textSecondary = Color("#94a3b8")
    override val textMuted = Color("#475569")
    override val iconBase = Color("#94a3b8")
}

object LightTheme : AppTheme {
    override val primary = Color("#4f46e5")
    override val kmpHighlight = Color("#6FB31B")
    override val locationPin = Color("#e11d48")
    override val success = Color("#059669")
    override val background = Color("#f8fafc")
    override val background2 = Color("#f1f5f9b3")
    override val background3 = Color("#f8fafc")
    override val surface = Color("#ffffff")
    override val surfaceVariant = Color("#F5F3FF")
    override val surfaceHover = Color("#f1f5f9")
    override val border = Color("#e2e8f0")
    override val gridDot = Color("#cbd5e1")
    override val textPrimary = Color("#0f172a")
    override val textSecondary = Color("#475569")
    override val textMuted = Color("#64748b")
    override val iconBase = Color("#64748b")
}