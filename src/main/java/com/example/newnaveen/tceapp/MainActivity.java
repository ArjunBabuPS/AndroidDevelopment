package com.example.newnaveen.tceapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View.OnClickListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Activity{
    Button button,btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        button=(Button)findViewById(R.id.button4);
        btn=(Button)findViewById(R.id.button11);
        btn.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });  
    }
    public void login(View view){
            Intent intent = new Intent(this,StaffLogin.class);
            startActivity(intent);
    }
    public void actinfo(View view){
		    Intent intent = new Intent(this,Studentsite.class);
			startActivity(intent);
    }

    public void nssawards(View view){
        Intent intent = new Intent(this,Nssawards.class);
        startActivity(intent);
    }
}
