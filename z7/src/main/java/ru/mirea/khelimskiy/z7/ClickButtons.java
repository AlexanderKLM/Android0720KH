package ru.mirea.khelimskiy.z7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ClickButtons extends AppCompatActivity {
    private TextView textic;
    private Button butok;
    private Button butno;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_buttons);
        textic = (TextView) findViewById(R.id.textic);
        butok = (Button) findViewById(R.id.butok);
        butno = (Button) findViewById(R.id.butno);
        button2 = (Button) findViewById(R.id.buttonC2);


        View.OnClickListener prbutok = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textic.setText("Нажата кнопка ОК");
            }
        };
        butok.setOnClickListener(prbutok);
        View.OnClickListener prcancel = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textic.setText("Нажата кнопка Cancel");
            }
        };
        butno.setOnClickListener(prcancel);

    }

    public void doONclick(View view) {
        Toast.makeText(this, "Ещё один способ!", Toast.LENGTH_SHORT).show();
    }
}