import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun LanguageSelector(
    currentLanguage: AppLanguage,
    attrsModifier: AttrsScope<HTMLDivElement>.() -> Unit = {},
    onLanguageChange: (AppLanguage) -> Unit

) {
    val styles = LocalStyles.current
    val theme = LocalAppTheme.current

    Div(attrs = {
        classes(styles.navSectionRight, styles.hideOnMobile)
        attrsModifier()
        style {
            alignItems(AlignItems.Center)
            gap(8.px)
        }
    }) {
        AppLanguage.entries.forEachIndexed { index, lang ->
            Span(attrs = {
                classes(styles.navLink, styles.navLabel)
                if (currentLanguage == lang) classes(styles.navLinkActiveNoUnderline)

                style {
                    cursor("pointer")
                    // Visuele feedback voor de selectie
                    opacity(if (currentLanguage == lang) 1.0 else 0.7)
                    fontWeight(if (currentLanguage == lang) "bold" else "normal")
                    textDecoration("none")
                    property("text-decoration", "none")
                }

                onClick { onLanguageChange(lang) }
            }) {
                Text(lang.name)
            }

            if (index < AppLanguage.entries.size - 1) {
                Span(attrs = {
                    style {
                        opacity(0.3)
                        color(theme.textMuted)
                    }
                }) {
                    Text("|")
                }
            }
        }
    }
}