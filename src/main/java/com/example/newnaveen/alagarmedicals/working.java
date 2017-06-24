package com.example.newnaveen.alagarmedicals;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by NewNaveen on 2/5/2017.
 */
public class working extends Fragment implements View.OnClickListener{
    Button b1,b2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.mainpage, container,false);
        Typeface h = Typeface.createFromAsset(getActivity().getAssets(),"fonts/OLDENGL.TTF");
        TextView head = (TextView)v.findViewById(R.id.textView);
        Typeface word = Typeface.createFromAsset(getActivity().getAssets(),"fonts/neat.TTF");
         b1=(Button)v.findViewById(R.id.button1);
         b2=(Button)v.findViewById(R.id.button2);
        Button b3=(Button)v.findViewById(R.id.button3);
        Button b4=(Button)v.findViewById(R.id.disc);
        b1.setOnClickListener(this);
        b1.setTypeface(word);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b3.setTypeface(word);
        b2.setOnClickListener(this);
        b2.setTypeface(word);
        head.setTypeface(h);
        return  v;
    }

    @Override
    public void onClick(View view) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch(view.getId()){
            case R.id.button1:
                search s=new search();
                fragmentTransaction.setCustomAnimations(R.animator.rightrotatein, R.animator.rightrotateout);
                fragmentTransaction.replace(android.R.id.content, s);
                fragmentTransaction.commit();
                break;
            case R.id.button2:
                maintenance m=new maintenance();
                fragmentTransaction.setCustomAnimations(R.animator.rightrotatein, R.animator.rightrotateout);
                fragmentTransaction.replace(android.R.id.content,m);
                fragmentTransaction.commit();
                break;
            case R.id.button3:
                getActivity().moveTaskToBack(true);
                getActivity().finish();
                break;
            case R.id.disc:
                disclaimer dis = new disclaimer();
                fragmentTransaction.setCustomAnimations(R.animator.rightrotatein, R.animator.rightrotateout);
                fragmentTransaction.replace(android.R.id.content,dis);
                fragmentTransaction.commit();
                break;
        }
    }


}
