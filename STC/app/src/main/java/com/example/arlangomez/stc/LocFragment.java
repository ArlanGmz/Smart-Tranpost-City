package com.example.arlangomez.stc;

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

public class LocFragment extends Fragment {
    private static final String TAG = "Tab2Fragment";
    ListView list;
    private String UserID;

    ArrayList<String> Stoplist= new ArrayList<>();

    //@SuppressLint("ValidFragment")

   /* public LocFragment()
    {
        super();
    }

    public LocFragment(String username){
        super();
        UserID=username;
    }*/




    //String[] ={"DLSU-Laguna", "Nuvali", "Laguna Central"};

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle B = this.getArguments();
        String userID = B.getString("UserID");
        Stoplist.add("DLSU-Laguna");
        Stoplist.add("Nuvali");
        Stoplist.add("Laguna Central");
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);
        list = (ListView)view.findViewById(R.id.Stoplist);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Stoplist);

        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(getActivity(), StopActivity.class);
                    String message = Stoplist.get(i);
                    intent.putExtra("Location", message);
                    intent.putExtra("Username",UserID);
                    startActivity(intent);


            }
        });


        return view;
    }
}