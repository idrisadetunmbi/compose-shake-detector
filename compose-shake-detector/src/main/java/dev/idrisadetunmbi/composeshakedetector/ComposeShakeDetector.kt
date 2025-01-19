package dev.idrisadetunmbi.composeshakedetector

import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity.SENSOR_SERVICE
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import com.squareup.seismic.ShakeDetector

@Composable
fun ComposeShakeDetector(onShakeDetected: () -> Unit) {
    val context = LocalContext.current

    DisposableEffect(context) {
        val listener = ShakeDetector.Listener(onShakeDetected)
        val shakeDetector = ShakeDetector(listener)

        val sensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager
        shakeDetector.start(sensorManager, SensorManager.SENSOR_DELAY_GAME)

        onDispose {
            shakeDetector.stop()
        }
    }
}
