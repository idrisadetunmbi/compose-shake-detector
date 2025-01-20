# Compose Shake Detector
A library for detecting device shake in an Android app using Compose. It is a based on seismic (from Square).

## Usage

Add the library to your build config

```
implementation(dev.idrisadetunmbi.composeshakedetector:1.0.0)
```

and in your Composable:

```
...
import dev.idrisadetunmbi.composeshakedetector.ComposeShakeDetector
...

@Composable
fun SampleComposable() {
  ComposeShakeDetector {
    // handle shake detection
  }
}

```

See sample-app module in project for a full usage sample.

## Contributing

## License


