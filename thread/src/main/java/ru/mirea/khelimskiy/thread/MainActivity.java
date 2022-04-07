package ru.mirea.khelimskiy.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    EditText am;
    EditText ch;
    Float f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView infoTextView = findViewById(R.id.textView2);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Текущий поток: " + mainThread.getName());
// Меняем имя и выводим в текстовом поле
        mainThread.setName("MireaThread");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
        TextView b2 = findViewById(R.id.textView3);
    }


    public void Something(View view) {
         am = findViewById(R.id.editTextTextPersonName);
         ch = findViewById(R.id.editTextTextPersonName2);
         String s1 = am.getText().toString();
         String s2 = ch.getText().toString();
        TextView b2 = findViewById(R.id.textView3);
        Thread thread = new Thread(new Runnable() {
            @Override
                public void run() {
                    int numberThread = counter++;
                    Log.i("ThreadProject", "Запущен поток № " + numberThread);
                    long endTime = System.currentTimeMillis() + 20 * 1000;
                    Float f1 = Float.parseFloat(s1)/Float.parseFloat(s2);

                    while (System.currentTimeMillis() < endTime) {
                        synchronized (this) {
                            try {
                                wait(endTime -
                                        System.currentTimeMillis());
                            } catch (Exception e) {
                            }
                        } b2.post(new Runnable() {
                            @Override
                            public void run() {
                                b2.setText(Float.toString(f1));
                            }
                        });
                    }
                    Log.i("ThreadProject", "Выполнен поток № " + numberThread);
                }
        });thread.start();

        }
    }