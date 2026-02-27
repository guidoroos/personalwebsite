package com.guidoroos.portfolio.ui.component


import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun UrlIcon(svgName: String, url: String) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    A(
        href = url,
        attrs = {
            classes (styles.hoverIcon)
            attr("target", "_blank")
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Center)

                width(40.px)
                height(40.px)

                borderRadius(6.px)
                property("transition", "background-color 0.2s")
            }


        }
    ) {
        Img(src = "./$svgName.svg") {

            style {

                val scale = when (svgName) {
                    "linkedin" -> 28.px
                    "github" -> 30.px
                    else -> 32.px
                }

                width(scale)
                height(scale)

                property("object-fit", "contain")

                display(DisplayStyle.Block)
                styles.hoverIcon
            }
        }
    }
}