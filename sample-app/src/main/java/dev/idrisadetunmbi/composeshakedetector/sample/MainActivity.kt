package dev.idrisadetunmbi.composeshakedetector.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.idrisadetunmbi.composeshakedetector.ComposeShakeDetector
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.compose.OnParticleSystemUpdateListener
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.PartySystem
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var shouldShowConfetti by remember { mutableStateOf(false) }
            val confettiDisplayUpdateListener = remember {
                object : OnParticleSystemUpdateListener {
                    override fun onParticleSystemEnded(
                        system: PartySystem,
                        activeSystems: Int,
                    ) {
                        shouldShowConfetti = false
                    }
                }
            }

            ComposeShakeDetector {
                shouldShowConfetti = true
            }

            Surface {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Shake device for some magic",
                        modifier = Modifier.align(Alignment.Center),
                    )
                }

                if (shouldShowConfetti) {
                    val emitter = Emitter(duration = 3, timeUnit = TimeUnit.SECONDS)
                        .perSecond(amount = 30)
                    KonfettiView(
                        parties = listOf(Party(emitter = emitter)),
                        modifier = Modifier.fillMaxSize(),
                        updateListener = confettiDisplayUpdateListener
                    )
                }
            }
        }
    }
}
