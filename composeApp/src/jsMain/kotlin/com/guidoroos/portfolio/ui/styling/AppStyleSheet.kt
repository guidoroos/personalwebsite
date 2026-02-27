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
    val bodyLarge by style {
        fontSize(AppTypography.sizeBody)
        fontWeight(AppTypography.weightNormal)
        color(theme.textSecondary)
        lineHeight(1.6.toString())
    }

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
        fontSize(0.8.cssRem)
        fontWeight(AppTypography.weightMedium)
        property("text-transform", "uppercase")
    }

    // --- Layout Classes ---
    val container by style {
        maxWidth(AppSpacing.containerMaxWidth)
        flex(1)
        overflowY("auto")
        paddingTop(64.px)

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
        // Your base styles
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        padding(AppSpacing.md, AppSpacing.lg)
        backgroundColor(theme.surface)
        property("border-bottom", "1px solid ${theme.border}")

        // Structural styles for the fixed top bar
        position(Position.Fixed)
        top(0.px)
        left(0.px)
        right(0.px)
        height(48.px)
        width(100.percent)
        property("z-index", "1000")
        property("box-sizing", "border-box")
    }

    val navLink by style {
        fontSize(AppTypography.sizeBodyLarge)
        color(theme.textSecondary)
        property("cursor", "pointer")
        property("transition", "color 0.2s ease")
        marginLeft(AppSpacing.md)

        self + hover style {
            color(theme.primary)
        }
    }

    val ctaLink by style {
        color(theme.kmpHighlight)
        property("cursor", "pointer")
        property("transition", "color 0.2s ease")

        self + hover style {
            color(theme.primary)
        }
    }


    val backgroundPattern by style {
        backgroundColor(theme.background)

        // By using 100% spread, the colors "pool" in the corners and
        // fade out across the whole screen, making the contrast easier to see.
        backgroundImage(
            "radial-gradient(at 0% 0%, ${theme.background} 0%, transparent 100%), " +
                    "radial-gradient(at 100% 100%, ${theme.background3} 0%, transparent 100%), " +
                    "radial-gradient(at 50% 0%, ${theme.background2} 0%, transparent 80%)"
        )

        backgroundAttachment("fixed")

        property("transition", "background-color 0.8s cubic-bezier(0.4, 0, 0.2, 1), background-image 0.5s ease")
    }

    val hoverIcon by style {
        (self + hover) style {
            property("transform", "scale(1.2)")
        }
    }
// --- Navbar Styles ---


    val navSectionLeft by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        gap(16.px)

        media("(max-width: 768px)") {
            self style {
                gap(8.px)

            }
        }
    }

    val navSectionRight by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        gap(20.px)

        media("(max-width: 768px)") {
            self style {
                gap(10.px)

            }
        }
    }

    val navLinkActive by style {
        color(theme.primary)
        fontWeight(AppTypography.weightBold)
        property("border-bottom", "2px solid ${theme.primary}")
    }

    val iconMaskBase by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)

        width(36.px)  // Slightly smaller base size
        height(36.px)
        cursor("pointer")

        property("mask-repeat", "no-repeat")
        property("mask-position", "center")
        property("mask-size", "90%") // Slightly smaller icon inside the container
        property("-webkit-mask-repeat", "no-repeat")
        property("-webkit-mask-position", "center")
        property("-webkit-mask-size", "90%")

        backgroundColor(theme.iconBase)

        // Smooth color transition for theme switching
        property("transition", "background-color 0.2s ease")

        media("(max-width: 768px)") {
            self style {
                width(28.px)
                height(28.px)
            }
        }
    }

    val socialIconGroup by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        gap(16.px)

        media("(max-width: 768px)") {
            self style {
                gap(8.px) // Tighten up on mobile
            }
        }
    }

    val iconLinkFrame by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        width(40.px)
        height(40.px)

        media("(max-width: 768px)") {
            self style {
                width(32.px)
                height(32.px)
            }
        }
    }


}