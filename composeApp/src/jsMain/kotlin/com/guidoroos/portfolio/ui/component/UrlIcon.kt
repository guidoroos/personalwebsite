package com.guidoroos.portfolio.ui.component


import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun UrlIcon(svgName: String, url: String) {
    val styles = LocalStyles.current
    val label = svgName.replaceFirstChar { it.uppercase() }

    A(
        href = url,
        attrs = {
            attr("target", "_blank")
            attr("rel", "noopener noreferrer")
            attr("aria-label", label)
            classes(styles.iconLinkFrame, styles.hoverIcon)
        }
    ) {
        Img(src = "/$svgName.svg", alt = "$label icon") {
            style {
                val iconSize = when {
                    svgName.contains("linkedin") -> 24.px
                    else -> 26.px
                }
                width(iconSize)
                height(iconSize)
                property("object-fit", "contain")
                display(DisplayStyle.Block)
            }
        }
    }
}