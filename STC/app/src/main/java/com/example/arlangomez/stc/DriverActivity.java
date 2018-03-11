package com.example.arlangomez.stc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ArlanGomez on 28/02/2018.
 */

public class DriverActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> Stops = new ArrayList<>();
    ArrayList<String> Stopss = new ArrayList<>();
    ArrayList<String> Arrive = new ArrayList<>();
    ArrayList<String> Depart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        Stops.add("DLSU-Laguna");
        Stops.add("Nuvali");
        Stops.add("Laguna Central");

        listView = findViewById(R.id.sched);

        Stopss.add("Laguna Central");
        Arrive.add("6:15");
        Depart.add("6:30");


        final CustomListView customListView= new CustomListView(this,Stopss,Arrive,Depart);
        listView.setAdapter(customListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(DriverActivity.this, DriverShuttleResv.class);
                intent.putExtra("Arrive", Arrive.get(0) );
                intent.putExtra("Depart", Depart.get(0) );
                intent.putExtra("Destination", Stopss.get(0) );
                intent.putExtra("CurLocation", Stops.get(0));
                startActivity(intent);


            }
        });

    }


}
