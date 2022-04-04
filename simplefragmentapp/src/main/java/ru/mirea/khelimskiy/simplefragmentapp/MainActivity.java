package ru.mirea.khelimskiy.simplefragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment fragment1, fragment2;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new BlankFragment();
        fragment2 = new BlankFragment2();

    }


    public void NewFrag(View view) {
        fragmentManager = getSupportFragmentManager();
        switch (view.getId()) {
            case R.id.buttonf1:
                fragmentManager.beginTransaction().replace(R.id.Frag1, fragment1).commit();
                break;
            case R.id.buttonf2:
                fragmentManager.beginTransaction().replace(R.id.Frag1, fragment2).commit();
                break;
            default:
                break;
        }
    }
}