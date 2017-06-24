package com.example.newnaveen.alagarmedicals;

import android.app.Fragment;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by NewNaveen on 2/5/2017.
 */
public class search extends Fragment implements View.OnClickListener{
    AutoCompleteTextView autoCompleteText;
    TextView result,textView2,textView4;
    List<String> list;
    Button b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search,container,false);
        Typeface wor = Typeface.createFromAsset(getActivity().getAssets(),"fonts/neat.TTF");
        textView2=(TextView)v.findViewById(R.id.textView2);
        textView4=(TextView)v.findViewById(R.id.textView4);
        textView2.setTypeface(wor);
        textView4.setTypeface(wor);
        b = (Button)v.findViewById(R.id.button);
        b.setTypeface(wor);
        result = (TextView)v.findViewById(R.id.textView5);
        result.setTypeface(wor);
        b.setOnClickListener(this);

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
        autoCompleteText = (AutoCompleteTextView) v.findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,list);
        autoCompleteText.setThreshold(1);
        autoCompleteText.setAdapter(arrayAdapter);
        autoCompleteText.setTextColor(Color.BLUE);
        return v;
    }

    @Override
    public void onClick(View view) {
        try{
            String s= "";
            int flag=0;
            String med = autoCompleteText.getText().toString().toLowerCase();
            if(!med.equals("")) {
                File file =  new File("/sdcard/medicines.txt");
                if(file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    String limit = "";
                    String res = "";
                    while ((limit = bufferedReader.readLine()) != null) {
                        if (limit.startsWith(med) && (limit.charAt(med.length()) == '-')) {
                            flag = 1;
                            res = limit;
                        }
                    }
                    dataInputStream.close();
                    if (flag == 1) {
                        result.setText("           "+res);
                        autoCompleteText.setText("");
                    } else {
                        Toast.makeText(getActivity().getBaseContext(), "Medicine Not Available", Toast.LENGTH_LONG).show();
                        result.setText("");
                        autoCompleteText.setText("");
                    }
                }else{
                    Toast.makeText(getActivity().getBaseContext(), "Medicine Not Available", Toast.LENGTH_LONG).show();
                    autoCompleteText.setText("");
                    result.setText("");
                }
            }else{
                Toast.makeText(getActivity().getBaseContext(), "Enter Some Medicine Name", Toast.LENGTH_LONG).show();
                autoCompleteText.setText("");
                result.setText("");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
