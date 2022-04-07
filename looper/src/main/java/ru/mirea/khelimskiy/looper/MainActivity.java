package ru.mirea.khelimskiy.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity {


NLooper b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NLooper b  = new NLooper();
        b.start();
    }

    public void Klik(View view) {

            Message msg = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("KEY", "mirea");
            msg.setData(bundle);
            if (b != null) {
                b.handler.sendMessage(msg);
            }

    }
}