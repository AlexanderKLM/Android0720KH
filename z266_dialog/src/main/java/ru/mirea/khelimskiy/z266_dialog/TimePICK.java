package ru.mirea.khelimskiy.z266_dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;

public class TimePICK extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar t = Calendar.getInstance();
        int hour = t.get(Calendar.HOUR_OF_DAY);
        int minute = t.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(), hour, minute, DateFormat.is24HourFormat(getActivity()));
    }
}
