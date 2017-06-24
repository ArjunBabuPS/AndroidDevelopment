package com.example.newnaveen.tceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by NewNaveen on 5/31/2016.
 */
public class Register extends Activity {
    EditText eact,eplace,edate;
    String act,place,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        eact=(EditText)findViewById(R.id.editText6);
        eplace=(EditText)findViewById(R.id.editText7);
        edate=(EditText)findViewById(R.id.editText8);
    }
    public void updateActivity(View view){
        act=eact.getText().toString();
        place=eplace.getText().toString();
        date=edate.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,act,place,date);
        Intent intent = new Intent(this,Display.class);
        startActivity(intent);
    }
}
