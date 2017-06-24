package com.example.newnaveen.alagarmedicals;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by NewNaveen on 2/5/2017.
 */
public class Mainpage extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        working wg = new working();
        ft.setCustomAnimations(R.animator.rightrotatein,R.animator.rightrotateout);
        ft.replace(android.R.id.content,wg);
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        working wg = new working();
        ft.setCustomAnimations(R.animator.rightrotatein,R.animator.rightrotateout);
        ft.replace(android.R.id.content,wg);
        ft.commit();
    }
}
