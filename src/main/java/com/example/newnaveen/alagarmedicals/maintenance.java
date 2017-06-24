package com.example.newnaveen.alagarmedicals;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NewNaveen on 2/5/2017.
 */
public class maintenance extends Fragment implements View.OnClickListener{
    EditText editText2;
    TextView textView3;
    AutoCompleteTextView editText1;
    List<String> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.maintenance, container, false);
        Typeface wor = Typeface.createFromAsset(getActivity().getAssets(),"fonts/neat.TTF");
        textView3 = (TextView)v.findViewById(R.id.textView3);
        textView3.setTypeface(wor);
        Button button = (Button)v.findViewById(R.id.button4);
        button.setTypeface(wor);
        editText1 = (AutoCompleteTextView) v.findViewById(R.id.medicine);
        editText2 = (EditText)v.findViewById(R.id.rackname);
        try {
            File file =  new File("/sdcard/medicines.txt");
            if(file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                String limit = "";
                list = new ArrayList<String>();
                while ((limit = bufferedReader.readLine()) != null) {
                    int index = limit.indexOf('-');
                    String word = limit.substring(0, index);
                    if (!list.contains(word))
                        list.add(word);
                }
                dataInputStream.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,list);
        editText1.setThreshold(1);
        editText1.setAdapter(arrayAdapter);
        editText1.setTextColor(Color.BLUE);
        button.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        try {
            //inga thaan file open panni write panrom
            String med=  editText1.getText().toString().toLowerCase();
            String loc = editText2.getText().toString().toLowerCase();
            if(med.equals("")||loc.equals("")){
                Toast.makeText(getActivity().getBaseContext(),"Please Enter All Text Fields!",Toast.LENGTH_LONG).show();
                editText2.setText("");
                editText1.setText("");
            }else {
                File file = new File("/sdcard/medicines.txt");
                if(!file.exists()){
                    file.createNewFile();
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                String limit = "";
                String old = "";
                String extra="";
                int flag=0;
                while ((limit = bufferedReader.readLine()) != null) {
                    if(limit.startsWith(med)){
                        extra = limit.substring(med.length(),limit.length());
                        flag=1;
                    }
                    old=old+limit+'\n';
                }
                dataInputStream.close();
                    if(flag==0){
                        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                        String detail = med+"-" +loc;
                        outputStreamWriter.write(detail.toLowerCase());
                        outputStreamWriter.write("\r\n");
                        outputStreamWriter.close();

                    }else{
                        old = old.replace(med+extra,med+"-"+loc);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                        outputStreamWriter.write(old.toLowerCase());
                        outputStreamWriter.close();

                    }
                Toast.makeText(getActivity().getBaseContext(), "Medicine Location Saved Successfully!", Toast.LENGTH_LONG).show();
                editText2.setText("");
                editText1.setText("");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
