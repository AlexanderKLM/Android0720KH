package ru.mirea.khelimskiy.mireaproject.ui.Calc;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.khelimskiy.mireaproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentCalc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentCalc extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private TextView textic;
    private EditText textic1;
    private String showtext;
    private float oldnum;
    private String newnum;
    private String getsym;
    private String getnum;

    public BlankFragmentCalc() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param param3 Parameter 3.
     * @return A new instance of fragment BlankFragmentCalc.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentCalc newInstance(String param1, String param2, String param3) {
        BlankFragmentCalc fragment = new BlankFragmentCalc();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_calc, container, false);
        textic = view.findViewById(R.id.textView2);
        textic1 = view.findViewById(R.id.editTextTextPersonName);
        textic1.setShowSoftInputOnFocus(false);
        getsym="";

        Button N0 = view.findViewById(R.id.Calcb0);
        Button N1 = view.findViewById(R.id.Calcb1);
        Button N2 = view.findViewById(R.id.Calcb2);
        Button N3 = view.findViewById(R.id.Calcb3);
        Button N4 = view.findViewById(R.id.Calcb4);
        Button N5 = view.findViewById(R.id.Calcb5);
        Button N6 = view.findViewById(R.id.Calcb6);
        Button N7 = view.findViewById(R.id.Calcb7);
        Button N8 = view.findViewById(R.id.Calcb8);
        Button N9 = view.findViewById(R.id.Calcb9);

        Button DEL = view.findViewById(R.id.CalcbDEL);
        Button PLUS = view.findViewById(R.id.CalcbP);
        Button Minus = view.findViewById(R.id.CalcbM);
        Button Irrat = view.findViewById(R.id.CalcbIrrat);
        Button Multiply = view.findViewById(R.id.CalcbMnoj);
        Button DIVIDE = view.findViewById(R.id.CalcbDiv);
        Button Equals = view.findViewById(R.id.CalcbEquals);
        Button Dot = view.findViewById(R.id.CalcbDot);

        N0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "0");
            }
        });

        N1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "1");

            }
        });

        N2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "2");
            }
        });

        N3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "3");
            }
        });

        N4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "4");
            }
        });

        N5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "5");
            }
        });

        N6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "6");
            }
        });

        N7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "7");
            }
        });

        N8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "8");
            }
        });

        N9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext + "9");
            }
        });

        DEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textic.setText("");
                textic1.setText("");
                getsym="";
                DIVIDE.setEnabled(true);
                PLUS.setEnabled(true);
                Minus.setEnabled(true);
                Multiply.setEnabled(true);
                Irrat.setEnabled(true);
                Dot.setEnabled(true);

            }
        });

        DIVIDE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                oldnum = Float.parseFloat(showtext);
                textic.setText(showtext + "/");
                getsym="/";
                if (getsym == "/"){
                    DIVIDE.setEnabled(false);
                    PLUS.setEnabled(false);
                    Multiply.setEnabled(false);
                    Minus.setEnabled(false);
                    Irrat.setEnabled(true);
                    Dot.setEnabled(true);

                }
            }
        });

        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                oldnum = Float.parseFloat(showtext);
                textic.setText(showtext + "-");
                getsym="-";
                if (getsym == "-"){
                    Minus.setEnabled(false);
                    PLUS.setEnabled(false);
                    DIVIDE.setEnabled(false);
                    Multiply.setEnabled(false);
                    Irrat.setEnabled(true);
                    Dot.setEnabled(true);
                }
            }
        });

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                oldnum = Float.parseFloat(showtext);
                textic.setText(showtext + "*");
                getsym="*";
                if (getsym == "*"){
                    Multiply.setEnabled(false);
                    PLUS.setEnabled(false);
                    DIVIDE.setEnabled(false);
                    Minus.setEnabled(false);
                    Irrat.setEnabled(true);
                    Dot.setEnabled(true);
                }
            }
        });

        Equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showtext = textic.getText().toString();
                float result = 0;

                switch (getsym){
                    case "-":
                        String Calc = showtext.substring( showtext.lastIndexOf("-")+1);
                        result = oldnum - Float.parseFloat(0 + Calc);
                        textic1.setText(Float.toString(result));
                        Dot.setEnabled(false);
                        Irrat.setEnabled(false);
                        break;
                    case "*":
                        String Calc2 = showtext.substring( showtext.indexOf("*")+1);
                        result = oldnum * Float.parseFloat(0 + Calc2);
                        textic1.setText(Float.toString(result));
                        Dot.setEnabled(false);
                        Irrat.setEnabled(false);
                        break;
                    case "/":
                        String Calc3 = showtext.substring(showtext.indexOf("/")+1);
                        result = oldnum / Float.parseFloat(0 + Calc3);
                        textic1.setText(Float.toString(result));
                        Dot.setEnabled(false);
                        Irrat.setEnabled(false);
                        break;
                    case "+":
                        String Calc4 = showtext.substring(showtext.indexOf("+")+1);
                        result = oldnum + Float.parseFloat(0 + Calc4);
                        textic1.setText(Float.toString(result));
                        Dot.setEnabled(false);
                        Irrat.setEnabled(false);
                        break;
                    case "":
                        newnum = textic.getText().toString();
                        textic1.setText(newnum);
                        Dot.setEnabled(false);
                        Irrat.setEnabled(false);
                        break;
                }
            }

        });

        PLUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                oldnum = Float.parseFloat(showtext);
                textic.setText(showtext + "+");
                getsym="+";
                if (getsym == "+"){
                    PLUS.setEnabled(false);
                    DIVIDE.setEnabled(false);
                    Multiply.setEnabled(false);
                    Minus.setEnabled(false);
                    Irrat.setEnabled(true);
                    Dot.setEnabled(true);
                }

            }
        });

        Irrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                switch (getsym) {
                    case "":
                        newnum = textic.getText().toString();
                        textic.setText("-" + newnum);
                        Irrat.setEnabled(false);
                        break;
                    case"-":
                        getnum = showtext.substring(showtext.lastIndexOf("-")+1);
                        textic.setText( Float.toString(oldnum) + "+" +getnum);
                        getsym="+";
                        Irrat.setEnabled(false);
                        break;
                    case"+":
                        getnum = showtext.substring(showtext.indexOf("+")+1);
                        textic.setText(Float.toString(oldnum) + "-" + getnum);
                        Irrat.setEnabled(false);
                        getsym="-";
                        break;
                    case"*":
                        getnum = showtext.substring(showtext.indexOf("*")+1);
                        textic.setText(oldnum + "*" + "-" + getnum);
                        Irrat.setEnabled(false);
                        break;
                    case"/":
                        getnum = showtext.substring(showtext.indexOf("/")+1);
                        textic.setText(oldnum + "/"+"-" + getnum);
                        Irrat.setEnabled(false);
                        break;
                }


            }
        });

        Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtext = textic.getText().toString();
                textic.setText(showtext);;
                switch(getsym) {
                    case "":
                        newnum = textic.getText().toString();
                        textic.setText(newnum+".");
                        Dot.setEnabled(false);
                        break;
                    case"-":
                        getnum = showtext.substring(showtext.lastIndexOf("-")+1);
                        textic.setText( oldnum + "-" + getnum + ".");
                        Dot.setEnabled(false);
                        break;
                    case"+":
                        getnum = showtext.substring(showtext.indexOf("+")+1);
                        textic.setText(oldnum + "+" +getnum + ".");
                        Dot.setEnabled(false);
                        break;
                    case"*":
                        getnum = showtext.substring(showtext.indexOf("*")+1);
                        textic.setText(oldnum + "*" +getnum + ".");
                        Dot.setEnabled(false);
                        break;
                    case"/":
                        getnum = showtext.substring(showtext.indexOf("/")+1);
                        textic.setText(oldnum + "/" +getnum + ".");
                        Dot.setEnabled(false);
                        break;


                }
            }
        });
        return view;
    }



    }

