package ru.mirea.khelimskiy.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView unik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unik = findViewById(R.id.tv1);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            String university = data.getStringExtra("name");
            unikw(university);
        }
    }

    private void unikw(String university){
        unik.setText(university);
    }


    public void Update(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivityForResult(intent, 1);
    }
}