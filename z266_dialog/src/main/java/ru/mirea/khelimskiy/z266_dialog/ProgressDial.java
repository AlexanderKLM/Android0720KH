package ru.mirea.khelimskiy.z266_dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class ProgressDial {
    Context context;
    Dialog dialog;
    public ProgressDial(Context context){
        this.context=context;
    }
    public void ShPD(){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.pd_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.create();
        dialog.show();

    }
}
