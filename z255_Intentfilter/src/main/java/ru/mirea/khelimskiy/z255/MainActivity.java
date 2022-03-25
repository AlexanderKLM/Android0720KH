package ru.mirea.khelimskiy.z255;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.butweb);
    }


    public void GOURL(View view) {
       Uri address = Uri.parse("https://www.mirea.ru/");
        Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(openLinkIntent);
    }

    public void GOTONOTES(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Хелимский Александр Александрович");
        startActivity(shareIntent.createChooser(shareIntent,"My LN FN MN"));
    }
}