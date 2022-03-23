package ru.mirea.khelimskiy.z6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText("Просто надпись");
        Button thebutton = findViewById(R.id.button);
        thebutton.setText("Другая кнопка");
        CheckBox box = findViewById(R.id.checkBox);
        box.setChecked(true);
    }
}