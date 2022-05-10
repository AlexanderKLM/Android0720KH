package ru.mirea.khelimskiy.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
private EditText edittextFilename;
private EditText edittextBloknot;
private SharedPreferences preferences;
private Button Save;
private Button LoadFile;
final String SAVED_TEXT = "saved_text";
    final String SAVED_TEXT2 = "saved_text2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittextBloknot = findViewById(R.id.editTextBloknot);
        edittextFilename = findViewById(R.id.editTextFile);
        Save = findViewById(R.id.buttonSave);
        LoadFile = findViewById(R.id.buttonLoad);
        preferences = getPreferences(MODE_PRIVATE);

    }
    public void onSaveText(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        // Сохранение значения по ключу SAVED_TEXT
        editor.putString(SAVED_TEXT, edittextBloknot.getText().toString());
        String filename = edittextFilename.getText().toString() + ".txt";
        if (filename == null){
            filename = "default.txt";
        } else {}
        editor.putString(SAVED_TEXT2, filename);
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(edittextBloknot.getText().toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        editor.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
    public void onLoadText(View view) {
        FileInputStream fin = null;
        try {
            fin = openFileInput(preferences.getString(SAVED_TEXT2, "Empty"));
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            Log.d(LOG_TAG, text);
            edittextBloknot.setText(text);

        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
