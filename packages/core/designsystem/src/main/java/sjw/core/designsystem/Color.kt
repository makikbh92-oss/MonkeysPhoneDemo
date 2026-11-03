package sjw.core.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import sjw.core.designsystem.Gray_AA
import sjw.core.designsystem.Gray_EA
import sjw.core.designsystem.White


private val White = Color(0xFFFFFFFF)
// Black
private val Black = Color(0xFF000000)
private val Black_A60 = Color(0xA6000000)
private val Black_500 = Color(0x50000000)
// Gray
private val Gray_2F = Color(0xFF2F2F2F)
private val Gray_33 = Color(0xFF333333)
private val Gray_44 = Color(0xFF444444)
private val Gray_62 = Color(0xFF626262)
private val Gray_55 = Color(0xFF555555)
private val Gray_66 = Color(0xFF666666)
private val Gray_70 = Color(0xFF707070)
private val Gray_8D = Color(0xFF8D8D8D)
private val Gray_99 = Color(0xFF999999)
private val Gray_AA = Color(0xFFAAAAAA)
private val Gray_A6F = Color(0xA6FFFFFF)
private val Gray_BB = Color(0xFFBBBBBB)
private val Gray_CA = Color(0xFFCACACA)
private val Gray_AAF = Color(0xAAFFFFFF)
private val Gray_CE = Color(0xFFCECECE)
private val Gray_DA = Color(0xFFDADADA)
private val Gray_D7 = Color(0xFFD7D7D7)
private val Gray_E0 = Color(0xFFE0E0E0)
private val Gray_E4 = Color(0xFFE4E4E4)
private val Gray_EA = Color(0xFFEAEAEA)
private val Gray_F4 = Color(0xFFF4F4F4)
private val Gray_F5 = Color(0xFFF5F5F5)
private val Gray_F7 = Color(0xFFF7F7F7)
private val Gray_F1 = Color(0xFFF1F1F1)
private val Gray_E6 = Color(0xFFE6E6E6)
private val Gray_EC = Color(0xFFECECEC)
// Red
private val Red_DF0 = Color(0xFFDF0001)
// Pink
private val Pink_EB4 = Color(0xFFEB4079)
private val Pink_FD8 = Color(0xFFFD82AC)
// Peach
private val Peach_FEA = Color(0xFFFEAAAA)
// Orange
private val Orange_E36 = Color(0xFFE3633E)
// Yellow
private val Yellow_FFC = Color(0xFFFFC746)
private val Yellow_FF0 = Color(0xFFFFF089)
private val Yellow_F1 = Color(0xFFFFF100)
// Blue
private val Blue_3D5 = Color(0xFF3D5EC9)
private val Blue_405 = Color(0xFF405EBE)
private val Blue_045 = Color(0xFF0451b9)
private val Blue_047 = Color(0xFF0471B9)
private val Blue_147 = Color(0xFF147FCD)
// Purple
private val Purple_7E6 = Color(0xFF7E6EB1)
private val Purple_687 = Color(0xFF6872A9)
private val Purple_BDC = Color(0xFFBDC9F1)
private val Purple_DD9 = Color(0xFFDD99D3)
// Green
private val Green_0B = Color(0xFF00BD1C)
// Mint
private val Mint_06B = Color(0xFF06B3AD)
// Aquamarine
private val Aquamarine_C3E = Color(0xFFC3EBC9)



data class MonkeyColors(
    val primary: Color,
    val primaryContainer: Color,
    val secondary: Color,
    val secondaryContainer: Color,
    val tertiary: Color,
    val tertiaryContainer: Color,
    val accent: Color,
    val background: Color,
    val secondaryBackground: Color,
    val tertiaryBackground: Color,
    val outlined: Color,
    val outlinedVariant: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textDisabled: Color
)

val DefaultColorPalette = MonkeyColors(
    primary = Gray_33,
    primaryContainer = Gray_33,
    secondary = Gray_AA,
    secondaryContainer = Gray_AA,
    tertiary  = Gray_D7,
    tertiaryContainer = Gray_D7,
    accent = Pink_EB4,
    background = White,
    secondaryBackground = Gray_F4,
    tertiaryBackground = Gray_EA,
    outlined = Gray_D7,
    outlinedVariant = Gray_F4,
    textPrimary = Gray_33,
    textSecondary = Gray_66,
    textDisabled = Gray_99
)

val LocalSimpleMonkeyColors = staticCompositionLocalOf {
    DefaultColorPalette
}