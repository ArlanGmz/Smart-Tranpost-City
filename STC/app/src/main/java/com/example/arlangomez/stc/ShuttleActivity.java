package com.example.arlangomez.stc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ArlanGomez on 07/02/2018.
 */

public class ShuttleActivity extends AppCompatActivity {
    private TextView curloc, eta, etd, dest, queueNo,waitNo, status;
    private static final String TAG = "MainActivity";
    private RelativeLayout mainsh;
    private ImageView backButton;
    int queueNum, waitlist;
    Button queue;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuttle);
        final String location = getIntent().getStringExtra("CurLocation");
        final String arrive = getIntent().getStringExtra("Arrive");
        final String depart = getIntent().getStringExtra("Depart");
        final String destination = getIntent().getStringExtra("Destination");

        curloc = findViewById(R.id.LocationName);
        curloc.setText(location);
        eta = findViewById(R.id.Arr);
        eta.setText(arrive);
        etd = findViewById(R.id.Dep);
        etd.setText(depart);
        dest = findViewById(R.id.dest);
        dest.setText(destination);
        status= findViewById(R.id.status);

        backButton = findViewById(R.id.backbton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        queueNo= findViewById(R.id.queue);
        queueNum = Integer.parseInt((String) queueNo.getText());
        waitNo=findViewById(R.id.waiting);
        waitlist = Integer.parseInt((String) waitNo.getText());



        queue= findViewById(R.id.quebut);
        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(queueNum<18) {
                    queueNum+=1;
                    queueNo.setText(String.valueOf(queueNum) );
                    status.setText("You are now Queued");

                }
                else
                {
                    waitlist+=1;
                    waitNo.setText(String.valueOf(waitlist));
                    status.setText("You are in the wait list");
                }
                queue.setEnabled(false);

            }
        });




    }
}
