package com.example.newnaveen.tceapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static android.support.v4.app.ActivityCompat.startActivity;
import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static android.support.v4.content.ContextCompat.startActivities;

/**
 * Created by NewNaveen on 5/31/2016.
 */
public class BackgroundTask extends AsyncTask<String,String,String> {


    ProgressDialog loading;

    Context ctx;
    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }
    @Override
    protected void onPreExecute() {

       super.onPreExecute();


    }


    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        
        if (method.equals("register")) {
            String name = params[1];
            String place = params[2];
            String date = params[3];

            try {
				String reg_url = "http://192.168.43.44/registeract.php";

                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" + URLEncoder.encode("place", "UTF-8") + "=" + URLEncoder.encode(place, "UTF-8")+"&"+URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8") ;
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream Is = httpURLConnection.getInputStream();
                Is.close();
                return "UpdationSuccess";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
			if (method.equals("attendance")) {
            String names = params[1];
           

            try {
				String reg_url = "http://192.168.43.44/attendance.php";
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("names", "UTF-8") + "=" + URLEncoder.encode(names, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream Is = httpURLConnection.getInputStream();
                Is.close();
                return "UpdationSuccess";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
		}
return null;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }




}