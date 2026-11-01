package sjw.core.monkeysphone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import sjw.core.designsystem.MonkeyTheme
import sjw.feature.home.MonkeyThemeTestScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonkeyThemeTestScreen()
        }
    }
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

