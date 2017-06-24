package com.example.newnaveen.tceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by NewNaveen on 6/27/2016.
 */
public class Mainstudent extends AppCompatActivity {
    private TextView t1;
    private TextView t2;
    private TextView t3;
    String name,place,date;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
        t1=(TextView)findViewById(R.id.textView14);
        t2=(TextView)findViewById(R.id.textView15);
        t3=(TextView)findViewById(R.id.textView16);
        Intent intent = getIntent();
        name=intent.getExtras().getString("n");
        place=intent.getExtras().getString("p");
        date=intent.getExtras().getString("d");
        t1.setText(name);
        t2.setText(place);
        t3.setText(date);
    }
}
