package ru.mirea.khelimskiy.z266_dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class DialogFragment extends androidx.fragment.app.DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Здравствуй МИРЭА!")
                .setMessage("Успех близок?")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Иду дальше", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((MainActivity)getActivity()).onOkClicked();
                        dialog.cancel();
                      /*  Toast toast = Toast.makeText(getActivity(), "Точно?", Toast.LENGTH_SHORT);
                        toast.show();*/
                    }
                })
                .setNeutralButton("На паузе",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                Toast toast = Toast.makeText(getActivity(), "Окей, подожду", Toast.LENGTH_SHORT);
                                toast.show();
                        }})
                .setNegativeButton("Нет",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                Toast toast = Toast.makeText(getActivity(), "Грустно", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });
        return builder.create();
    }
}
