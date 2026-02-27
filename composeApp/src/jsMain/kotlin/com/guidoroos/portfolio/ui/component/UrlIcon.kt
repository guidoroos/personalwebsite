package com.guidoroos.portfolio.ui.component


import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun UrlIcon(svgName: String, url: String) {
    val styles = LocalStyles.current

    A(
        href = url,
        attrs = {
            attr("target", "_blank")
            // styles.hoverIcon handles your existing animation
            classes(styles.iconLinkFrame, styles.hoverIcon)
        }
    ) {
        Img(src = "./$svgName.svg") {
            style {
                // Optical sizing so they don't look weirdly different sizes
                val iconSize = when {
                    svgName.contains("linkedin") -> 22.px
                    svgName.contains("github") -> 24.px
                    else -> 24.px
                }
                width(iconSize)
                height(iconSize)
                property("object-fit", "contain")
                display(DisplayStyle.Block)
            }
        }
    }
}