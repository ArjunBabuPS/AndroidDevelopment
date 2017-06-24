package com.example.newnaveen.tceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by NewNaveen on 6/8/2016.
 */
public class Display extends Activity {
    String year,dept;
	int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Intent intent = getIntent();
		n=intent.getIntExtra("num", 0);
    }
    public void updateAct(View view){
		if(n==0){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
		}
		else{
			Toast.makeText(Display.this, "You logged out of your account.You need to login again", Toast.LENGTH_LONG).show();
        
		}
	}

    public void updateAtt(View view){
        Intent intent = new Intent(this,AttendanceReg.class);
        startActivity(intent);
    }
    public void logout(View view){
		n=n+1;
        Intent intent = new Intent(this,StaffLogin.class);
        startActivity(intent);
    }

}
