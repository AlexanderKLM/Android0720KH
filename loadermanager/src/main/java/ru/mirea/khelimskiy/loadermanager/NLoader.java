package ru.mirea.khelimskiy.loadermanager;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.EdgeEffect;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NLoader extends AsyncTaskLoader<String> {
    public EditText ET;
        private String firstName;
        public static final String ARG_WORD = "What?";
        public NLoader(@NonNull Context context, Bundle args) {
            super(context);
            if (args != null) {
                firstName = args.getString(ARG_WORD);
                List<String> characters = Arrays.asList(firstName.split(""));
                Collections.shuffle(characters);
                String afterShuffle = "";
                for (String character : characters)
                {
                    afterShuffle += character;
                }
                firstName = afterShuffle;
            }
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }

  /*  @Override
    protected void onForceLoad() {
        super.onForceLoad();
        ET.findViewById(R.id.editTextTextPersonName);
        firstName = ET.getText().toString();
    }*/

    @Override
        public String loadInBackground() {

            SystemClock.sleep(3000);

            return firstName;
        }

}
