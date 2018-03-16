package com.example.arlangomez.stc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ArlanGomez on 02/03/2018.
 */

public class DriverShuttleResv extends AppCompatActivity {
    private TextView trip, time, empty;
    ListView listView;
    ArrayList<String > id = new ArrayList<>();
    ArrayList<String > num = new ArrayList<>();
    ImageView backButton;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivsched);
        listView = findViewById(R.id.reserved);
        empty = findViewById(R.id.empty);


        final String location = getIntent().getStringExtra("CurLocation");
        final String arrive = getIntent().getStringExtra("Arrive");
        final String depart = getIntent().getStringExtra("Depart");
        final String destination = getIntent().getStringExtra("Destination");


        for(int i = 1; i<4; i++)
            num.add(String.valueOf(i));

        id.add("11502363");
        id.add("11502346");
        id.add("11402395");

        final passengerlist Passenger= new passengerlist(this, num, id);
        listView.setAdapter(Passenger);

        trip = findViewById(R.id.LocationName);
        trip.setText(location + " -> "+ destination);
        time = findViewById(R.id.time);
        time.setText(arrive);

        if (listView.getCount()==0){
            empty.setText("No one is currently reserved for this trip");
        }

        backButton = findViewById(R.id.backbton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
