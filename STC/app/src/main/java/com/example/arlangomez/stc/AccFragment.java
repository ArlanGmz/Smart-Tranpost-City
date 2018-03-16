package com.example.arlangomez.stc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ArlanGomez on 26/02/2018.
 */

public class AccFragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    TextView textView, emp;
    ListView lstview;
    private String UserID;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle B = this.getArguments();
        String userID = B.getString("UserID");
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);


        textView = view.findViewById(R.id.merit);
        emp =view.findViewById(R.id.empty);
        lstview = view.findViewById(R.id.Schedlist);

        if(lstview.getCount()==0){
            emp.setText("You are currently not reserved for any trips");
        }



        return view;
    }
}
