package sjw.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import sjw.core.designsystem.AppTheme
import sjw.core.designsystem.MonkeyTheme

@Composable
fun MonkeyThemeTestScreen(

) {
    val typo = AppTheme.typography   // ← 실제 접근자 이름에 맞게 수정

    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
   
        TypoRow("display", typo.display)
        Text("비교 크기", fontSize = 32.sp)
        TypoRow("title", typo.title)
        TypoRow("subTitle", typo.subTitle)
        TypoRow("body", typo.body)
        TypoRow("label", typo.label)
        TypoRow("caption", typo.caption)
        TypoRow("buttonLarge", typo.buttonLarge)
        TypoRow("buttonMedium", typo.buttonMedium)
        TypoRow("buttonSmall", typo.buttonSmall)
    }
}

@Composable
private fun TypoRow(name: String, style: TextStyle) {
    Text(
        text = "$name · 안녕하세요 몽키 Aa 123ㅁㄴㅇㄹㅁㄹㅁㄹㅇㅁㄴㄹㅁㄴㅇㄹㅁㄴㄹㅁㄴㅇㄹㅁㄴㅇㄹㅁㄴㄹㅁㄴㅇㄹㅁㄴㅇㄹ 래ㅜ",
        style = style,
    )
}

@Preview(
    showBackground = true,
    widthDp = 960,
    heightDp = 600,

    )
@Composable
private fun MonkeyThemeTestScreenPreview() {
    MonkeyTheme {
        MonkeyThemeTestScreen()
    }
}