package ru.mirea.khelimskiy.z266_dialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DatePickerD extends DialogFragment {

       /* AlertDialog.Builder b2 = new AlertDialog.Builder(getActivity());
        b2.setTitle("Datepicker")
                .setMessage("Выбери дату")
                .setIcon(R.mipmap.ic_launcher_round)
                .seth*/
   @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar d = Calendar.getInstance();
        int year = d.get(Calendar.YEAR);
        int month = d.get(Calendar.MONTH);
        int day = d.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);

}
}
