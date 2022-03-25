package ru.mirea.khelimskiy.z264_notificationapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
private static final String CHANNEL_ID = "Android";
private int ID_MSG= 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSendNotification(View view) {
        NotificationManager notMan = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intentr = new Intent(this, MainActivity.class);
        PendingIntent Pintent = PendingIntent.getActivity(this,0, intentr,PendingIntent.FLAG_IMMUTABLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notChan =new NotificationChannel(CHANNEL_ID, "My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            notChan.setDescription("Descriptione");
            notChan.enableLights(true);
            notChan.setLightColor(Color.WHITE);
            notChan.setVibrationPattern(new long[]{0,200,0,200});
            notChan.enableVibration(true);
            notMan.createNotificationChannel(notChan);

            NotificationCompat.Builder bob = new NotificationCompat.Builder(this,CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Что-то важное")
                    .setContentText("Уведомление сэр")
                    .setWhen(System.currentTimeMillis())
                    .setProgress(1000,10,false)
                    .setContentIntent(Pintent);
            Notification notification = bob.build();
            notMan.notify(ID_MSG++,notification);

        }
    }
}