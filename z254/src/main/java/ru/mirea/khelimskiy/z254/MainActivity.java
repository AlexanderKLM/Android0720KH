package ru.mirea.khelimskiy.z254;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private EditText text2;
    private TextView text3;
    private Button buttof;
    private String b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text2 = (EditText) findViewById(R.id.editText23);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
        String a3 = (String) getIntent().getSerializableExtra("edit");
        text2.setText(a3);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);
        b = text2.getText().toString();
        outState.putString("edit", b);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");

    }

    @Override
    protected void onRestoreInstanceState( Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        b = savedInstanceState.getString("edit");
        text2.setText(b);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    public void onClickNewActivity(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("key","MIREA - Хелимский Александр Александрович");
        String s = text2.getText().toString();
        intent.putExtra("key2",s);
        startActivity(intent);
    }

}