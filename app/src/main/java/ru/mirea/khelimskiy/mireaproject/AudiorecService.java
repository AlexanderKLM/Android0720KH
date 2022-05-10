package ru.mirea.khelimskiy.mireaproject;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class AudiorecService extends Service {
    private MediaPlayer mediaPlayer;
    private String finalt;


    public AudiorecService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this,Uri.parse("/storage/emulated/0/Android/data/ru.mirea.khelimskiy.mireaproject/files/Music/mirea9.3gp"));
        mediaPlayer.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
            mediaPlayer.start();
            Toast toast = Toast.makeText(getApplicationContext(), "Воспроизведение файла...", Toast.LENGTH_LONG);
            toast.show();
            Log.d("j", "Сообщение " + finalt);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {

    }
}
