package ru.mirea.khelimskiy.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link History#newInstance} factory method to
 * create an instance of this fragment.
 */
public class History extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String s1[];
    String s2[];
    String s3[];
    RecyclerView recyclerView;
    private EditText ed1;
    private SharedPreferences preferences;
    final String SAVED_Date = "saved_date";
    final String SAVED_Info = "saved_info";
    final String SAVED_Result = "saved_res";
    private FloatingActionButton FAC;
    private Button b8;
    private Button b7;
    Fragment fragment;
    FragmentManager fragmentManager;
    private ArrayList<ExampleItem> mExampleList;
    private ArrayList<ExampleItem> mExampleList2;
    private List<String> m1;
    private List<String> m2;
    private List<String> m3;
    private RecyclerView.LayoutManager LayoutManager;
    private static final String TAG = MainActivity.class.getSimpleName();

    public History() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment History.
     */
    // TODO: Rename and change types and number of parameters
    public static History newInstance(String param1, String param2) {
        History fragment = new History();
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
        View view1 = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view1.findViewById(R.id.RecView);
        FAC = view1.findViewById(R.id.fab);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterN a1 = new AdapterN(mExampleList);
        AdapterN b1 = new AdapterN(mExampleList);
        b8 = view1.findViewById(R.id.button8);
        b7 = view1.findViewById(R.id.button7);
        createExampleList();
        buildRecyclerView();

b8.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Integer g = 0;
        preferences = getActivity().getSharedPreferences("storage", Context.MODE_PRIVATE);
        String text = preferences.getString(SAVED_Date, "Empty");
        String text2 = preferences.getString(SAVED_Info, "Empty");
        String text3 = preferences.getString(SAVED_Result, "Empty");
        a1.addItem(mExampleList, text, text2, text3,g);

String ways;

        for (int i = 0; i<mExampleList.size(); i++) {
            ways = "way" + i;
            preferences = getActivity().getSharedPreferences(ways, Context.MODE_PRIVATE);

            ExampleItem v = mExampleList.get(i);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(SAVED_Date , v.textdate());
            editor.putString(SAVED_Info, v.textdesc());
            editor.putString(SAVED_Result, v.textres());
            Log.d(TAG, " Текст1" + v.textdate());
            Log.d(TAG, " Текст2 " + v.textdesc());
            Log.d(TAG, " Текст3 " + v.textres());
            Log.d(TAG, "Размер массива " + i + "Massaa" + mExampleList.size());
            editor.apply();
        }

        buildRecyclerView();
    }
});
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 20; i++){
                    String ways = "way" + i;
                    preferences = getActivity().getSharedPreferences(ways, Context.MODE_PRIVATE);
                    String text = preferences.getString(SAVED_Date, "Empty");
                    String text2 = preferences.getString(SAVED_Info, "Empty");
                    String text3 = preferences.getString(SAVED_Result, "Empty");
                    Log.d(TAG, "Размер массива " + i + "Mass" + mExampleList.size());
                    a1.addItem2(i,mExampleList, text,text2,text3,i);
                    buildRecyclerView();
                }
            }
        });

        FAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentManager3 = getFragmentManager().beginTransaction();
                fragmentManager3.add(R.id.HF,new Saveinfo(),null).addToBackStack(null).commit();
            }
        });
        return view1;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem("Test", "Test", "Test"));


    }
    public void buildRecyclerView() {
AdapterN a2 = new AdapterN(mExampleList);
        recyclerView.setHasFixedSize(false);
        LayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(a2);
    }

}

