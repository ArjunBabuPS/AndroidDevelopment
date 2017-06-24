package com.example.newnaveen.tceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by NewNaveen on 6/29/2016.
 */
public class AttendanceReg extends AppCompatActivity {
    String year,dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendancereg);
    }
	
	public void staffside(View view){
		Intent intent = new Intent(this,Display.class);
		startActivity(intent);
	}
    public void radiobut(View view){
        RadioGroup radioGroup,radioGroup1;
        RadioButton radioButton,radioButton1;

        radioGroup = (RadioGroup)findViewById(R.id.radio);
        int selectid = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectid);
        year=radioButton.getText().toString();

        radioGroup1=(RadioGroup)findViewById(R.id.radio10);
        int selectid1 = radioGroup1.getCheckedRadioButtonId();
        radioButton1=(RadioButton)findViewById(selectid1);
        dept = radioButton1.getText().toString();

        Intent intent = new Intent(this,Updateattendance.class);
        intent.putExtra("y",year);
        intent.putExtra("d",dept);
        startActivity(intent);
    }
}
