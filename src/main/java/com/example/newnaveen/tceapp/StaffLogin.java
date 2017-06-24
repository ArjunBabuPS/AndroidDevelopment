package com.example.newnaveen.tceapp;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newnaveen.tceapp.BackgroundTask;
import com.example.newnaveen.tceapp.R;
import com.example.newnaveen.tceapp.Register;

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
 * Created by NewNaveen on 6/24/2016.
 */
public class StaffLogin extends AppCompatActivity {
	public int counter=0;
    EditText et_us,et_pas;
    String us;
    String tolog;
    String response = "";
    String line = "";
    String pas;
    AsyncTask<String, String, String> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_us=(EditText)findViewById(R.id.editText);
        et_pas=(EditText)findViewById(R.id.editText2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void logfun(View view) {
        us = et_us.getText().toString();
        pas = et_pas.getText().toString();
		 
		//if(hasConnection(StaffLogin.this)) {
		downloadtask d = new downloadtask();
        d.execute(us,pas);
		//}
		/*else{
			Toast.makeText(StaffLogin.this,"you are not connected to internet..Please Try again..",Toast.LENGTH_LONG).show();
		}*/


    }

        class downloadtask extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            @Override
           protected void onPreExecute() {
                super.onPreExecute();

                loading = ProgressDialog.show(StaffLogin.this, "Logged in", "Please wait sir...", true, true);
                loading.setMax(3000);
            }



            @Override
            protected String doInBackground(String... params) {
                String us=params[0];
                String pas=params[1];
        			String login_url="http://192.168.43.44/login.php";
                try {
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream OS = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                    String data = URLEncoder.encode("user","UTF-8")+"="+ URLEncoder.encode(us, "UTF-8")+"&"+URLEncoder.encode("user_pass", "UTF-8")+"="+URLEncoder.encode(pas, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    OS.close();
                    InputStream Is = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Is, "iso-8859-1"));

                    String json="";
                    json=bufferedReader.readLine();
                    bufferedReader.close();
                    Is.close();
                    httpURLConnection.disconnect();
                    return json;

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
				decide(result);
				loading.dismiss();

            }

        }

	public boolean hasConnection(Context context){
   ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo wifiNetwork=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    if (wifiNetwork != null && wifiNetwork.isConnected()){
        return true;
    }          
   NetworkInfo mobileNetwork=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
    if (mobileNetwork != null && mobileNetwork.isConnected()){
        return true;
    }
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    if (activeNetwork != null && activeNetwork.isConnected()){
        return true;
    }
    return false;
}

    public void decide(String res){
        if (res.equals("1")){
			Intent intent = new Intent(this,Display.class);
			intent.putExtra("num",0);
            startActivity(intent);
        }else{
           Toast.makeText(getApplicationContext(),"Loginfailed....Invalid Passowrd",Toast.LENGTH_LONG).show();
        }

    }
public void gotomain(View view){
	Intent intent = new Intent(this,MainActivity.class);
	startActivity(intent);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
			