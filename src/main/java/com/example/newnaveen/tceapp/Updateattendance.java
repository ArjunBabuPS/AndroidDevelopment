package com.example.newnaveen.tceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by NewNaveen on 7/23/2016.
 */
public class Updateattendance extends AppCompatActivity {

    LinearLayout linearLayout;
    Button button;
    Integer year;
    String dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateattendance);
        Intent intent = getIntent();
        String y= intent.getExtras().getString("y");
        if(y.equals("Iyear"))
            year= 16;
        else
            year=15;
        String d = intent.getExtras().getString("d");
        if(d.equals("Mech"))
            dept="A";
        else if(d.equals("CIVIL"))
            dept="B";
        else if(d.equals("EEE"))
            dept="EE";
        else if(d.equals("ECE"))
            dept="EC";
        else if(d.equals("CSE"))
            dept="C";
        else if(d.equals("IT"))
            dept="IT";
        else if(d.equals("Mechatronics"))
            dept="MCT";
        LinearLayout lay = (LinearLayout) findViewById(R.id.linearlayout1);
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            CheckBox cb = new CheckBox(this);
            int r =i + 1;
            cb.setText(year + dept + r);
            cb.setId(i);
            lay.addView(cb);
        }
        int j1 = 100;
        Button b = new Button(this);

        b.setText("Update");

        lay.addView(b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout root = (LinearLayout) findViewById(R.id.linearlayout1);
                dis(root);
            }
        });
    }


    public void dis(ViewGroup parent) {
        String checked_checkbox = new String();
        //String checked_one = new String();
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof CheckBox) {
                CheckBox cb = (CheckBox) child;
                if (cb.isChecked()) {
                    checked_checkbox = checked_checkbox + (String) cb.getText()+",1";
					checked_checkbox=checked_checkbox + ",";
                }else{
					  checked_checkbox = checked_checkbox + (String) cb.getText()+",0";
					  checked_checkbox=checked_checkbox + ",";
                
				}
            }
        }
		 
		 Toast.makeText(Updateattendance.this,checked_checkbox,Toast.LENGTH_LONG).show();
         BackgroundTask backgroundTask = new BackgroundTask(this);
		 backgroundTask.execute("attendance",checked_checkbox);
        Intent intent = new Intent(this,AttendanceReg.class);
        startActivity(intent);
    }
}
