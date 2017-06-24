package com.example.newnaveen.alagarmedicals;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileOutputStream;

public class splashActvty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_actvty);
        TextView tx = (TextView)findViewById(R.id.name);
        Typeface cf = Typeface.createFromAsset(getAssets(),"fonts/super.TTF");
        tx.setTypeface(cf);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent i = new Intent(splashActvty.this,Mainpage.class);
                    startActivity(i);
                }
            }
        };
        timer.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
