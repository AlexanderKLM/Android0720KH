package ru.mirea.khelimskiy.loadermanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    public final String TAG = this.getClass().getSimpleName();
    public TextView TV;
    public EditText ET;
    public String S1;
    private int LoaderID = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.button);
        setContentView(R.layout.activity_main);

    }
    public void Chtext(View view) {
        TV = findViewById(R.id.textView);
        ET = findViewById(R.id.editTextTextPersonName);
        Bundle bundle = new Bundle();
        S1 = ET.getText().toString();
        Log.d("dfg",S1);
        bundle.putString(NLoader.ARG_WORD, S1);
        getSupportLoaderManager().initLoader(LoaderID, bundle, this).forceLoad();
    }
        @Override
        public void onLoaderReset (@NonNull Loader < String > loader) {

            Log.d(TAG, "onLoaderReset");
        }

        @NonNull
        @Override
        public Loader<String> onCreateLoader ( int i, @Nullable Bundle bundle){
            if (i == LoaderID) {
                Toast.makeText(this, "Создаюсь", Toast.LENGTH_SHORT).show();
                return new NLoader(this, bundle);
            }
            return null;
        }

        @Override
        public void onLoadFinished (@NonNull Loader < String > loader, String s){
            if (loader.getId() == LoaderID) {
                Log.d(TAG, "onLoadFinished" + s);
                Toast.makeText(this, "onLoadFinished:" + s, Toast.LENGTH_SHORT).show();
                TV.setText(s);
            }
        }


}