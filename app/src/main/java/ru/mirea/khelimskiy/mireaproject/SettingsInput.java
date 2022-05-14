package ru.mirea.khelimskiy.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsInput#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsInput extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button b1;
    private EditText date;
    private EditText info;
    private EditText res;
private SharedPreferences preferences;
    final String SAVED_Date = "saved_date";
    final String SAVED_Info = "saved_info";
    final String SAVED_Result = "saved_res";
    public SettingsInput() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsInput.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsInput newInstance(String param1, String param2) {
        SettingsInput fragment = new SettingsInput();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 =  inflater.inflate(R.layout.fragment_settings_input, container, false);

        b1 = view1.findViewById(R.id.button5);
        date = view1.findViewById(R.id.editTextTextPersonName4);
        info = view1.findViewById(R.id.editTextTextPersonName3);
        res = view1.findViewById(R.id.editTextTextPersonName2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 preferences = getActivity().getSharedPreferences("storage", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = preferences.edit();
                // Сохранение значения по ключу SAVED_TEXT
                editor.putString(SAVED_Date, date.getText().toString());
                editor.putString(SAVED_Info, info.getText().toString());
                editor.putString(SAVED_Result, res.getText().toString());
                editor.apply();
                Toast.makeText(getContext(), "Text saved", Toast.LENGTH_SHORT).show();
            }
        });

        return view1;
    }
}