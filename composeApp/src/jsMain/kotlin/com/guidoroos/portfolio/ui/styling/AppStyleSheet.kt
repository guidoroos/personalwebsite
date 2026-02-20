package com.guidoroos.portfolio.ui.styling


import org.jetbrains.compose.web.css.*

object AppStylesheet : StyleSheet() {

    // --- Font Family & Global Reset ---
    init {
        "body" style {
            fontFamily("Inter", "system-ui", "-apple-system", "sans-serif")
            lineHeight(1.5.toString())
            property("-webkit-font-smoothing", "antialiased")
        }
    }

    // --- Headings ---
    val h1Hero by style {
        fontSize(AppTypography.sizeH1)
        fontWeight(AppTypography.weightBold)
        lineHeight(1.1.toString())
        property("letter-spacing", "-0.02em") // Iets strakker voor grote titels
    }

    val h2Section by style {
        fontSize(AppTypography.sizeH2)
        fontWeight(AppTypography.weightBold)
        lineHeight(1.3.toString())
        property("letter-spacing", "-0.01em")
    }

    val h3Card by style {
        fontSize(1.25.cssRem)
        fontWeight(AppTypography.weightMedium)
        lineHeight(1.4.toString())
    }

    // --- Body Text ---
    val bodyRegular by style {
        fontSize(AppTypography.sizeBody)
        fontWeight(AppTypography.weightNormal)
        lineHeight(1.6.toString())
    }

    val bodySmall by style {
        fontSize(0.875.cssRem)
        fontWeight(AppTypography.weightNormal)
        lineHeight(1.5.toString())
    }

    // --- UI Components ---
    val navLabel by style {
        fontSize(AppTypography.sizeNav)
        fontWeight(AppTypography.weightMedium)
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


    // 2. Layout Classes
    val container by style {
        maxWidth(AppSpacing.containerMaxWidth)

        // De meest veilige manier voor 'margin: 0 auto'
        flex(1) // Zorgt dat de main area de rest van de ruimte pakt
        overflowY("auto")
        property("margin", "0 auto")
        padding(AppSpacing.lg)

        media("(max-width: 768px)") {
            self style {
                padding(AppSpacing.md)
            }
        }
    }


    // 3. Component Classes
    val card by style {
        backgroundColor(AppColors.surface)
        border(1.px, LineStyle.Solid, AppColors.border)
        borderRadius(AppSpacing.borderRadius)
        padding(AppSpacing.lg)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(AppSpacing.md)

        // Subtiele schaduw
        property("box-shadow", "0 4px 6px -1px rgba(0, 0, 0, 0.1)")
    }

    val navBar by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        padding(AppSpacing.md, AppSpacing.lg)
        backgroundColor(AppColors.surface)
        property("border-bottom", "1px solid ${AppColors.border}")
    }

    val navLink by style {
        color(AppColors.textSecondary)
        property("cursor", "pointer")
        property("transition", "color 0.2s ease")
        marginLeft(AppSpacing.md)

        self + hover style {
            color(AppColors.primary)
        }
    }

    val divider by style {
        height(1.px)
        border(0.px)
        backgroundColor(AppColors.border)
        marginTop(AppSpacing.xl)
        marginBottom(AppSpacing.xl)
        opacity(0.3)
        width(100.percent)
    }

}