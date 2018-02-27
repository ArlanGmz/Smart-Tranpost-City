package com.example.arlangomez.stc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ArlanGomez on 26/02/2018.
 */

public class LocFragment extends Fragment {
    private static final String TAG = "Tab2Fragment";
    ListView list;

    ArrayList<String> Stoplist= new ArrayList<>();




    //String[] ={"DLSU-Laguna", "Nuvali", "Laguna Central"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
                    startActivity(intent);


            }
        });


        return view;
    }
}