package ru.mirea.khelimskiy.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
private TextView newTIME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        newTIME = findViewById(R.id.textView4);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String B = (String) getIntent().getSerializableExtra("keyt");
        newTIME.setText(B);
    }
}