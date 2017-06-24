package com.example.newnaveen.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText editText,editText1;
Integer[] integers = new Integer[200];
    ArrayList<Integer> arrayList;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void getden(View view){
       editText=(EditText)findViewById(R.id.editText);
       editText1=(EditText)findViewById(R.id.editText2);

       String s = editText.getText().toString();
       String s1=editText1.getText().toString();
       int den=Integer.parseInt(s1);
       String[] a=s.split(",");
       int i=1;
       integers[0]=0;
       for (String str:a){
           integers[i++]=Integer.parseInt(str);
       }
       int n=i;
        Denomination denomination = new Denomination();
        arrayList=denomination.Dencalc(integers,den,n);
       textView=(TextView)findViewById(R.id.textView4);
       textView.setText("");
       textView.append(TextUtils.join("\n", arrayList));

   }


}
