package com.guidoroos.portfolio.ui.styling

import org.jetbrains.compose.web.css.*

class AppStylesheet(val theme: AppTheme) : StyleSheet() {

    // --- Font Family & Global Reset ---
    init {
        "body" style {
            fontFamily("Inter", "system-ui", "-apple-system", "sans-serif")
            lineHeight(1.5.toString())
            backgroundColor(theme.background) // Reactive background
            color(theme.textPrimary)          // Reactive default text
            property("-webkit-font-smoothing", "antialiased")
            margin(0.px)
        }
    }

    // --- Headings ---
    val h1Hero by style {
        fontSize(AppTypography.sizeH1)
        fontWeight(AppTypography.weightBold)
        color(theme.textPrimary)
        lineHeight(1.1.toString())
        property("letter-spacing", "-0.02em")
    }

    val h2Section by style {
        fontSize(AppTypography.sizeH2)
        fontWeight(AppTypography.weightBold)
        color(theme.textPrimary)
        lineHeight(1.3.toString())
        property("letter-spacing", "-0.01em")
    }

    val h3Card by style {
        fontSize(1.25.cssRem)
        fontWeight(AppTypography.weightMedium)
        color(theme.textPrimary)
        lineHeight(1.4.toString())
    }

    // --- Body Text ---
    val bodyRegular by style {
        fontSize(AppTypography.sizeBody)
        fontWeight(AppTypography.weightNormal)
        color(theme.textSecondary)
        lineHeight(1.6.toString())
    }

    val bodySmall by style {
        fontSize(0.875.cssRem)
        fontWeight(AppTypography.weightNormal)
        color(theme.textMuted)
        lineHeight(1.5.toString())
    }

    // --- UI Components Labels ---
    val navLabel by style {
        fontSize(AppTypography.sizeNav)
        fontWeight(AppTypography.weightMedium)
        color(theme.textPrimary)
        property("letter-spacing", "0.01em")
        property("text-transform", "lowercase")
    }

    val buttonLabel by style {
        fontSize(0.9.cssRem)
        fontWeight(AppTypography.weightBold)
        property("text-transform", "uppercase")
        property("letter-spacing", "0.05em")
    }

    val tagLabel by style {
        fontSize(0.75.cssRem)
        fontWeight(AppTypography.weightMedium)
        property("text-transform", "uppercase")
    }

    // --- Layout Classes ---
    val container by style {
        maxWidth(AppSpacing.containerMaxWidth)
        flex(1)
        overflowY("auto")
        property("margin", "0 auto")

        media("(max-width: 768px)") {
            self style {
                padding(AppSpacing.md)
            }
        }
    }

    // --- Component Classes ---
    val card by style {
        backgroundColor(theme.surface)
        border(1.px, LineStyle.Solid, theme.border)
        borderRadius(AppSpacing.borderRadius)
        padding(AppSpacing.lg)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(AppSpacing.md)
        property("transition", "color 0.3s ease")

        if (theme is LightTheme) {
            property("box-shadow", "0 4px 6px -1px rgba(0, 0, 0, 0.1)")
        }
    }

    val navBar by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        padding(AppSpacing.md, AppSpacing.lg)
        backgroundColor(theme.surface)
        property("border-bottom", "1px solid ${theme.border}")
    }

    val navLink by style {
        color(theme.textSecondary)
        property("cursor", "pointer")
        property("transition", "color 0.2s ease")
        marginLeft(AppSpacing.md)

        self + hover style {
            color(theme.primary)
        }
    }

    val divider by style {
        height(1.px)
        border(0.px)
        backgroundColor(theme.border)
        marginTop(AppSpacing.xl)
        marginBottom(AppSpacing.xl)
        opacity(0.3)
        width(100.percent)
    }

    val backgroundPattern by style {
        backgroundColor(theme.background)
        backgroundImage("radial-gradient(${theme.gridDot} 1.2px, transparent 0)")
        property("background-size", "45px 45px")
        backgroundAttachment("fixed")
        property("transition", "background-color 0.4s ease-in-out")
    }
}