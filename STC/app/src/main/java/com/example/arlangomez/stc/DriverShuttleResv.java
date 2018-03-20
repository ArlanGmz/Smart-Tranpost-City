package com.example.arlangomez.stc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ArlanGomez on 02/03/2018.
 */

public class DriverShuttleResv extends AppCompatActivity {
    private TextView trip, time, empty;
    ListView listView;
    ArrayList<String > id = new ArrayList<>();
    ArrayList<String > num = new ArrayList<>();
    ImageView backButton, refresh;
    public String string = "hi";
    ListWorker listWorker = new ListWorker(new ListWorker.AsyncResponse() {
        @Override
        public void processFinish(String output) {
            string = output;
        }

    });



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
        final String schedID = getIntent().getStringExtra("SchedID");

        String Status = "list";
        listWorker = new ListWorker(new ListWorker.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                string = "hell";
            }
        });
        listWorker.execute(Status, schedID);
        Toast.makeText(DriverShuttleResv.this, "result:"+ schedID+"::"+string+"::", Toast.LENGTH_SHORT).show();
        String[] split = string.split("\\s+");

        for(int i = 0; i < split.length; i++)
            Toast.makeText(DriverShuttleResv.this, "result:"+ split[i], Toast.LENGTH_SHORT).show();


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

        refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

    }
}
