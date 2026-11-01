package sjw.core.designsystem

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
@Immutable
data class MonkeySpacing(
    // 기본 스케일 (4dp 그리드)
    val xxs: Dp,
    val xs: Dp,
    val sm: Dp,
    val md: Dp,
    val lg: Dp,
    val xl: Dp,
    val xxl: Dp,

    // 용도별 값
    val screenHorizontal: Dp,   // 화면 좌우 패딩
    val screenVertical: Dp,     // 화면 상하 패딩
    val cardPadding: Dp,        // 카드 내부 패딩
    val section: Dp,            // 섹션 사이 간격
    val item: Dp,               // 리스트 아이템 사이 간격
    val buttonHorizontal: Dp,   // 버튼 좌우 패딩
    val buttonVertical: Dp,     // 버튼 상하 패딩
)

// 폰용
val DefaultSpacing = MonkeySpacing(
    xxs = 2.dp,
    xs = 4.dp,
    sm = 8.dp,
    md = 12.dp,
    lg = 16.dp,
    xl = 24.dp,
    xxl = 32.dp,

    screenHorizontal = 16.dp,
    screenVertical = 16.dp,
    cardPadding = 16.dp,
    section = 24.dp,
    item = 8.dp,
    buttonHorizontal = 24.dp,
    buttonVertical = 12.dp,
)

// 태블릿용
val TabletSpacing = MonkeySpacing(
    xxs = 4.dp,
    xs = 8.dp,
    sm = 12.dp,
    md = 16.dp,
    lg = 24.dp,
    xl = 32.dp,
    xxl = 48.dp,

    screenHorizontal = 32.dp,
    screenVertical = 24.dp,
    cardPadding = 24.dp,
    section = 40.dp,
    item = 16.dp,
    buttonHorizontal = 32.dp,
    buttonVertical = 16.dp,
)

val LocalMonkeySpacing = staticCompositionLocalOf<MonkeySpacing> {
    DefaultSpacing
}