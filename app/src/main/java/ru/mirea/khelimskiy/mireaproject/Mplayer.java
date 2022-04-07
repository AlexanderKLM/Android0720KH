package ru.mirea.khelimskiy.mireaproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.TelephonyCallback;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.concurrent.TimeUnit;

public class Mplayer extends Service {
    private MediaPlayer mediaPlayer;



    public Mplayer() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        mediaPlayer= MediaPlayer.create(this, R.raw.song);
        mediaPlayer.setLooping(true);


    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }
}