package com.example.newnaveen.tceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by NewNaveen on 7/28/2016.
 */
public class seeattendance extends AppCompatActivity {
    TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seeattendance);
        Intent intent = getIntent();
        String total = intent.getExtras().getString("t");
        String actual= intent.getExtras().getString("a");
        String percent= intent.getExtras().getString("p");


        textView1=(TextView)findViewById(R.id.textView38);
        textView1.setText("No.of classes conducted  "+total);

        textView2=(TextView)findViewById(R.id.textView39);
        textView2.setText("No.of classes attended  "+actual);

        textView3=(TextView)findViewById(R.id.textView40);
        textView3.setText("Attendance Percentage  " + percent + "%");
    }

}
