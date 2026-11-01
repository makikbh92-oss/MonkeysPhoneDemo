package sjw.core.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration


@Composable
fun MonkeyTheme(
    colors: MonkeyColors = DefaultColorPalette,
    spacing: MonkeySpacing = if (LocalConfiguration.current.screenWidthDp >= 600) {
        TabletSpacing
    } else {
        DefaultSpacing
    },
    typography:  MonkeyTypoGraphy = if (LocalConfiguration.current.screenWidthDp >= 600) {
        TabletTypography
    } else {
        DefaultTypography
    },
    content: @Composable () -> Unit
)   {

    CompositionLocalProvider(
        LocalSimpleMonkeyColors provides colors,
        LocalMonkeyTypography provides typography,
        LocalMonkeySpacing provides spacing
    ){
        content()
    }
}

object AppTheme {
    val colors: MonkeyColors
        @Composable
        get() = LocalSimpleMonkeyColors.current

    val typography
        @Composable
        get() = LocalMonkeyTypography.current


    val spacing
        @Composable
        get() = LocalMonkeySpacing.current

}