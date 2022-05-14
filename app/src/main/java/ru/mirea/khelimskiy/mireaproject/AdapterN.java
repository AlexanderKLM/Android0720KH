package ru.mirea.khelimskiy.mireaproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterN extends RecyclerView.Adapter<AdapterN.MyViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    private static final String TAG = MainActivity.class.getSimpleName();
    public AdapterN() {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textdate;
        public TextView textdesc;
        public TextView textres;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textdate = itemView.findViewById(R.id.textDate);
            textdesc = itemView.findViewById(R.id.textDesc);
            textres = itemView.findViewById(R.id.textRes);

        }
    }


    public AdapterN(ArrayList<ExampleItem> exampleList) {
        mExampleList = exampleList;

    }
    public void addItem(ArrayList<ExampleItem> a,String text, String text2, String text3,Integer f) {
int b = a.size();
        a.add(new ExampleItem(text,text2,text3));
        Log.d(TAG, "Размер массива " + b);
        notifyDataSetChanged();
    }
    public void addItem2(int indexOf, ArrayList<ExampleItem> a,String text, String text2, String text3,Integer f) {
        int b = a.size();
        Log.d(TAG, "Размер массиваaaaa " + indexOf);
        a.add(indexOf, new ExampleItem(text,text2,text3));
        Log.d(TAG, "Размер массива " + b);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowsettings, parent, false);
        return new MyViewHolder(view2);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        holder.textdate.setText(currentItem.textdate());
        holder.textdesc.setText(currentItem.textdesc());
        holder.textres.setText(currentItem.textres());

    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    }
