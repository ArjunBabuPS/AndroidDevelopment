package com.example.newnaveen.tceapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

/**
 * Created by NewNaveen on 7/27/2016.
 */
public class AttendanceRetrieve extends Activity {

    EditText editText;
  //  TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieveattendance);

        editText=(EditText)findViewById(R.id.editText9);
       /* textView1=(TextView)findViewById(R.id.textView35);
        textView2=(TextView)findViewById(R.id.textView36);
        textView3=(TextView)findViewById(R.id.textView37);*/

    }
    public void get(View view){

       String reg=editText.getText().toString();
        downloadtask1 d = new downloadtask1();
        d.execute(reg);

    /*    textView1.setText("No.of classes conducted  "+total);

        textView2.setText("No.of classes attended  "+actual);

         textView3.setText("Attendance Percentage  " + percent + "%");*/


    }
    class downloadtask1 extends AsyncTask<String, Void, String> {
        ProgressDialog loading;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading = ProgressDialog.show(AttendanceRetrieve.this, "System is fetching your data", "Please wait ...", true, true);
        }
        @Override
        protected String doInBackground(String... params) {
            String names=params[0];
            String refresh_url="http://192.168.43.44/retrivatten.php";
            try {
                URL url = new URL(refresh_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("names", "UTF-8")+"="+URLEncoder.encode(names, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream Is = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Is,"iso-8859-1"));
                String str =bufferedReader.readLine();
                String[] A=str.split(",");
                String total,actual,percent;
                total=A[0];
                actual=A[1];
                percent=A[2];
                passchar(total, actual, percent);
                bufferedReader.close();
                Is.close();
                httpURLConnection.disconnect();
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
  public  void passchar(String total1,String actual1,String percent1){
        Intent intent = new Intent(this,seeattendance.class);
        intent.putExtra("t",total1);
        intent.putExtra("a",actual1);
        intent.putExtra("p",percent1);
        startActivity(intent);
    }
    public void goback(View view){
        Intent intent = new Intent(this,Studentsite.class);
        startActivity(intent);
    }
}
