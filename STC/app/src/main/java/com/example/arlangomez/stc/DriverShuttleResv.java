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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
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
    public String string = "hi hello how";
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

        final String Status = "list";


        //String[] split = splt.split("\\s+");

        /*for(int i = 0; i<split.length; i++) {
            num.add(String.valueOf(i+1));
            id.add(split[i]);
        }
/*
        id.add("11502363");
        id.add("11502346");
        id.add("11402395");*/

        passengerlist Passenger= new passengerlist( this, num, id);
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

                /*Intent intent = getIntent();
                finish();
                startActivity(intent);*/

                listWorker = new ListWorker(new ListWorker.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        string = output;
                    }
                });
                listWorker.execute(Status, schedID);
                Toast.makeText(DriverShuttleResv.this, "result:"+ schedID+"::"+string+"::", Toast.LENGTH_SHORT).show();
                String[] split = string.split("\\s+");
                num.clear();
                id.clear();

                for(int i = 0; i < split.length; i++) {
                    Toast.makeText(DriverShuttleResv.this, "result:" + split[i], Toast.LENGTH_SHORT).show();
                    num.add(String.valueOf(num.size()+1));
                    id.add(split[i]);
                }

                passengerlist Passenger= new passengerlist( DriverShuttleResv.this, num, id);
                listView.setAdapter(Passenger);


                if (listView.getCount()==0){
                    empty.setText("No one is currently reserved for this trip");
                }
                else
                    empty.setText("");


            }
        });

    }

    /*public String GetList(String Status, String schedID){
        String result = "";

        String status = Status;
        String locate_url = "http://172.16.2.52/locate.php";
        result = "";
        if(status.equals("list")){
            try {
                String schedid = schedID;
                URL url = new URL(locate_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
                String post_data = URLEncoder.encode("status","UTF-8")+"="+URLEncoder.encode(status,"UTF-8")+"&"+URLEncoder.encode("schedid","UTF-8")+"="+URLEncoder.encode(schedid,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line;
                while((line=bufferedReader.readLine())!=null){
                    result = line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }*/
}
