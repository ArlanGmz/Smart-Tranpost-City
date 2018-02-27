package com.example.arlangomez.stc;

/**
 * Created by ArlanGomez on 05/02/2018.
 */

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StopActivity extends AppCompatActivity{
    private TextView textView;
    private ImageView backButton;

    ListView listView;
    ArrayList<String> Stops = new ArrayList<>();
    ArrayList<String> Stopss = new ArrayList<>();
    ArrayList<String> Arrive = new ArrayList<>();
    ArrayList<String> Depart = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Stops.add("DLSU-Laguna");
        Stops.add("Nuvali");
        Stops.add("Laguna Central");

        textView = findViewById(R.id.LocationName);
        final String location = getIntent().getStringExtra("Location");
        textView.setText(location);



        for (int i=0;i<Stops.size();i++)
        {
            if (Stops.get(i).matches(location))
                Stops.remove(i);
        }
        if(location!="DLSU-Laguna"){
            int m=30;
            int hour ;
            for( hour=6; hour<9;){
                if(m-15<0)
                    Arrive.add(String.valueOf(hour-1)+":45");
                else if(m-15==0)
                    Arrive.add(String.valueOf(hour)+":00");
                else
                    Arrive.add(String.valueOf(hour)+":"+ String.valueOf(m-15));

                if(m==60){
                    m=0;
                    hour+=1;
                }
                if(m==0)
                    Depart.add(String.valueOf(hour)+":00");
                else
                    Depart.add(String.valueOf(hour)+":"+ String.valueOf(m));
                Stopss.add("DLSU-Laguna");
                m+=15;
            }
            /*m=20;
            for( hour=9; hour<20;){
                if(m==0 && hour<=12)
                    Arrive.add(String.valueOf(hour)+":00");
                else if(hour<=12)
                    Arrive.add(String.valueOf(hour)+":"+ String.valueOf(m));
                else if(m==0 && hour>12)
                    Arrive.add(String.valueOf(hour-12)+":"+ String.valueOf(m));
                if(hour<11)
                    m+=40;
                else if(hour )
                if(m>=60){
                    m-=60;
                    hour+=1;
                }
                Depart.add(String.valueOf(hour)+":"+ String.valueOf(m-5));
                Stopss.add("DLSU-Laguna");
            }*/


        }
        listView= (ListView)findViewById(R.id.shuttle);
        final CustomListView customListView= new CustomListView(this,Stopss,Arrive,Depart);
        listView.setAdapter(customListView);

        backButton = findViewById(R.id.backbtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(StopActivity.this, ShuttleActivity.class);
                intent.putExtra("Arrive", Arrive.get(i) );
                intent.putExtra("Depart", Depart.get(i) );
                intent.putExtra("Destination", Stopss.get(i) );
                intent.putExtra("CurLocation", location);
                startActivity(intent);


            }
        });



    }


}
