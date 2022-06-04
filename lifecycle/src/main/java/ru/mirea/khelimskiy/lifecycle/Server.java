package ru.mirea.khelimskiy.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Server implements LifecycleObserver {
    private String TAG = "lifecycle";

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connect() {
        Log.d(TAG,"connect to web-server");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disconnect() {
        Log.d(TAG,"disconnect");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void stateUpdated() {
        //будет вызваться при каждом изменении состояния жизненого цикла у activity.
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void res() {
        Log.d(TAG,"resume");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void des() {
        Log.d(TAG,"destroyed");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void pause() {
        Log.d(TAG,"pause");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void cr() {
        Log.d(TAG,"created");
    }


}
