package pk.inlab.app.apparch

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class AppLifecycleObserver: LifecycleObserver  {
    private val LOG_TAG = "LifecycleObserver"
    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    fun onCreateEvent(){
        Log.i(LOG_TAG, "OnCreate()")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
    fun onStartEvent(){
        Log.i(LOG_TAG, "OnStart()")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun onResumeEvent(){
        Log.i(LOG_TAG, "OnResume()")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    fun onPauseEvent(){
        Log.i(LOG_TAG, "OnPause()")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_STOP)
    fun onStopEvent(){
        Log.i(LOG_TAG, "OnStop()")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    fun onDestroyEvent(){
        Log.i(LOG_TAG, "OnDestroy()")
    }


}