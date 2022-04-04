package ru.mirea.khelimskiy.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
private EditText etext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etext = findViewById(R.id.editTextTextPersonName);
    }

    public void GoBack(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", etext.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}