package ru.mirea.khelimskiy.z266_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialog(View view) {
            DialogFragment dialogFragment = new DialogFragment();
            dialogFragment.show(getSupportFragmentManager(), "mirea");
        }
    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }

    public void openPD(View view) {
        ProgressDial PDW = new ProgressDial(this);
      PDW.ShPD();
    }

    public void DATE(View view) {
        {
            DatePickerD datePicker = new DatePickerD();
            datePicker.show(getSupportFragmentManager(), "date picker");
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar d = Calendar.getInstance();
            d.set(Calendar.YEAR, year);
            d.set(Calendar.MONTH, month);
            d.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(d.getTime());

            TextView textView = (TextView) findViewById(R.id.textView3);
            textView.setText(currentDateString);

    }

    public void TIME(View view) {
        TimePICK timePicker = new TimePICK();
        timePicker.show(getSupportFragmentManager(), "time picker");
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView2 = (TextView) findViewById(R.id.textView4);
        textView2.setText("Hour: " + hourOfDay + " Minute: " + minute);
    }
}
