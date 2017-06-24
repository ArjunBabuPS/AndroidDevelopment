package com.example.newnaveen.alagarmedicals;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by NewNaveen on 1/16/2017.
 */
public class disclaimer extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.disclaimer,container,false);
        Typeface head = Typeface.createFromAsset(getActivity().getAssets(),"fonts/super.TTF");
        Typeface content = Typeface.createFromAsset(getActivity().getAssets(),"fonts/neat.TTF");
        TextView text = ((TextView)v.findViewById(R.id.dis0));
        text.setTypeface(head);
        ((TextView)v.findViewById(R.id.dis2)).setTypeface(head);
        ((TextView)v.findViewById(R.id.dis1)).setTypeface(content);
        ((TextView)v.findViewById(R.id.dis3)).setTypeface(content);
        Typeface con = Typeface.createFromAsset(getActivity().getAssets(),"fonts/OLDENGL.TTF");
        ((TextView)v.findViewById(R.id.dis4)).setTypeface(con);
        return v;
    }
}
