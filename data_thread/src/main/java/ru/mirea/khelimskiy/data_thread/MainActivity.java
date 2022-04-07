package ru.mirea.khelimskiy.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvInfo;
            setContentView(R.layout.activity_main);
            tvInfo = findViewById(R.id.textView2);
            final Runnable runn1 = new Runnable() {
                public void run() {
                    tvInfo.setText("runn1");
                }
            };
            final Runnable runn2 = new Runnable() {
                public void run() {
                    tvInfo.setText("runn2");
                }
            };
            final Runnable runn3 = new Runnable() {
                public void run() {
                    tvInfo.setText("runn3");
                }
            };
        final Runnable runn4 = new Runnable() {
            public void run() {
                tvInfo.setText("runn4");
            }
        };
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        tvInfo.post(runn2);

                        TimeUnit.SECONDS.sleep(2);

                        tvInfo.postDelayed(runn3, 8000);
                        runOnUiThread(runn1);// приоритетные вместе с post выполняются в зависимости от положения в коде
                        tvInfo.post(runn4);// приоритетные вместе с uithread выполняются в зависимости от положения в коде
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }

    }
