package com.guidoroos.portfolio.ui.component


import LocalAppTheme
import androidx.compose.runtime.*
import com.guidoroos.portfolio.ui.styling.DarkTheme
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun UrlIcon(svgName: String, url: String) {

    A(
        href = url,
        attrs = {
            attr("target", "_blank")
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Center)

                width(32.px)
                height(32.px)

                borderRadius(6.px)
                property("transition", "background-color 0.2s")
            }
        }
    ) {
        Img(src = "./$svgName.svg") {
            style {

                val scale = when (svgName) {
                    "linkedin" -> 20.px
                    "github" -> 22.px
                    else -> 24.px
                }

                width(scale)
                height(scale)

                property("object-fit", "contain")

                display(DisplayStyle.Block)
            }
        }
    }
}