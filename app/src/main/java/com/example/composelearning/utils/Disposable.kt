package com.example.composelearning.utils
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun LifecycleComposable(
    onLifeCycleEvent: Lifecycle.Event.() -> Unit
) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {

        val observer = LifecycleEventObserver { _, event ->
           onLifeCycleEvent.invoke(event)
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

fun Lifecycle.Event.onPause(funtion:() -> Unit) {
    if (this == Lifecycle.Event.ON_PAUSE) {
        funtion()
    }
}

fun Lifecycle.Event.onStart(funtion:() -> Unit) {
    if (this == Lifecycle.Event.ON_START) {
        funtion()
    }
}

fun Lifecycle.Event.onCreate(funtion:() -> Unit) {
    if (this == Lifecycle.Event.ON_CREATE) {
        funtion()
    }
}

fun Lifecycle.Event.onResume(funtion:() -> Unit) {
    if (this == Lifecycle.Event.ON_RESUME) {
        funtion()
    }
}

fun Lifecycle.Event.onDestroy(funtion:() -> Unit) {
    if (this == Lifecycle.Event.ON_DESTROY) {
        funtion()
    }
}

