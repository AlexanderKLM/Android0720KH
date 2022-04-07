package ru.mirea.khelimskiy.mireaproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFR#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFR extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private double startTime = 0;

    Mplayer finalTime;
    private MediaPlayer mp;
    public static int oneTimeOnly = 0;

    public MusicFR() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicFR.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicFR newInstance(String param1, String param2) {
        MusicFR fragment = new MusicFR();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 = inflater.inflate(R.layout.fragment_mplayer, container, false);
        Button b1 = view1.findViewById(R.id.button);
        Button b2 = view1.findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                requireActivity().startService(new Intent(getContext(), Mplayer.class));

            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                requireActivity().stopService(new Intent(getContext(), Mplayer.class));

            }
        });
        return view1;
        }

}
