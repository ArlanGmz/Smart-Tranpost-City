package com.example.arlangomez.stc;

/**
 * Created by ArlanGomez on 26/03/2018.
 */
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ArlanGomez on 26/02/2018.
 */

public class WaitLstFragment extends Fragment {
    private static final String TAG = "Tab2Fragment";
    ListView list;
    private String UserID;
    ArrayList<String > id = new ArrayList<>();
    ArrayList<String > num = new ArrayList<>();





    //String[] ={"DLSU-Laguna", "Nuvali", "Laguna Central"};

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle B = this.getArguments();
        final String userID = B.getString("UserID");
        id.add("11502363");
        id.add("11502346");
        id.add("11402395");
        for(int i = 0; i<id.size(); i++) {
            num.add(String.valueOf(i+1));
        }


        View view = inflater.inflate(R.layout.reserved_list,container,false);
        list = (ListView)view.findViewById(R.id.reserved);



        //ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Stoplist);
        //list.setAdapter(arrayAdapter);

        passengerlist Passenger= new passengerlist( getActivity(), num, id);
        list.setAdapter(Passenger);




        return view;
    }
}