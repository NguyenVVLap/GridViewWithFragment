package com.example.gridviewwithfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    GridView gridview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            FragmentA fragmentA = new FragmentA();

            fragmentTransaction.replace(R.id.frameContain, fragmentA);


            fragmentTransaction.commit();

            ImageButton ib_BackToList =findViewById(R.id.imageButton_BackToList);
            ib_BackToList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFragmentManager().popBackStack();
                }
            });
        } else {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            FragmentA fragmentA = new FragmentA();
            FragmentB fragmentB = new FragmentB();

            fragmentTransaction.replace(R.id.frameContainA, fragmentA);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    }
}