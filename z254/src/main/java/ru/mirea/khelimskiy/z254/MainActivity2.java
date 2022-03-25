package ru.mirea.khelimskiy.z254;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
private TextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text4 = (TextView)findViewById(R.id.textView5);

    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView text2 = (TextView)findViewById(R.id.textView4);
        String a1 = (String) getIntent().getSerializableExtra("key");
        String a2 = (String) getIntent().getSerializableExtra("key2");
        text2.setText(a1);
        text4.setText(a2);

    }



    public void Clickoff(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        String s = text4.getText().toString();
        intent.putExtra("edit",s);
        startActivity(intent);
    }
}