package com.example.class3demo2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlueFragment extends Fragment {
    TextView titleTv;
    String title;

    public static BlueFragment newInstance (String title){
        BlueFragment frag = new BlueFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", title);
        frag.setArguments(bundle);
        return frag;
    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            this.title = bundle.getString("TITLE");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blue, container, false);
        TextView titleTv = view.findViewById(R.id.bluefrag_title_tv);
        if (title!= null){
            titleTv.setText(title);
        }
        return view;
    }

    public void setText(String title){
        this.title = title;
        if (titleTv != null){
            titleTv.setText(title);
        }
    }





}