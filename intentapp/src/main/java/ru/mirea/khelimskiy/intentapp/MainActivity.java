package ru.mirea.khelimskiy.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
private TextView stocktime;
private TextView newtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long dateInMillis = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        stocktime = findViewById(R.id.textView2);
        String ST;
        ST = sdf.format(new Date(dateInMillis));
        stocktime.setText(ST);
    }

    public void SENDT(View view) {
        Intent times = new Intent(this, MainActivity2.class);
        String ot = stocktime.getText().toString();
        times.putExtra("keyt", ot);
        startActivity(times);

    }
}