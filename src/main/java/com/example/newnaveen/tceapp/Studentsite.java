package com.example.newnaveen.tceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by NewNaveen on 6/26/2016.
 */
public class Studentsite extends AppCompatActivity {
	String name="";
    String place="";
    String date="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studsite1);
        
        }
    public void gotoseeact(View view){
		downloadtask2 d = new downloadtask2();
        d.execute();
    }
    public void attendanceinfo(View view){
        Intent intent = new Intent(this,AttendanceRetrieve.class);
        startActivity(intent);
    }
	
        class downloadtask2 extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            @Override
           protected void onPreExecute() {
                super.onPreExecute();
                  }
            @Override
            protected String doInBackground(String... params) {
                		String refresh_url="http://192.168.43.44/content.php";
                try {
                    URL url = new URL(refresh_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    
                    InputStream Is = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Is, "iso-8859-1"));

                   
					String str =bufferedReader.readLine();
					String[] A=str.split(",");

					bufferedReader.close();
                    Is.close();
                    httpURLConnection.disconnect();
                    passchar(name,place,date);
                    return name;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
				loading.dismiss();

            }

        }
        public void passchar(String name,String place,String date){
            Intent intent = new Intent(this,Mainstudent.class);
            intent.putExtra("n", name);
                intent.putExtra("p", place);
                intent.putExtra("d", date);
				startActivity(intent);
		}


    public void goback(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}




