package ru.mirea.khelimskiy.z262_toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void CLICK(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Здравствуй MIREA! ХАА",
                Toast.LENGTH_SHORT);
        ConstraintLayout toastContainer = (ConstraintLayout) toast.getView();
        ImageView catImageView = new ImageView(getApplicationContext());
        catImageView.setImageResource(R.drawable.ic_launcher_background);
        toast.show();
    }
}