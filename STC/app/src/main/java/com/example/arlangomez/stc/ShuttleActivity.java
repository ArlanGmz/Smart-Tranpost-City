package com.example.arlangomez.stc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ArlanGomez on 07/02/2018.
 */

public class ShuttleActivity extends AppCompatActivity {
    private TextView curloc, eta, etd, dest, queueNo,waitNo, status;
    private static final String TAG = "MainActivity";
    private RelativeLayout mainsh;
    private ImageView backButton, refresh;
    private String iD ;

    public String qcount = "";

    public String string = "";
    QueueWorker queueWorker = new QueueWorker(new QueueWorker.AsyncResponse() {
        @Override
        public void processFinish(String output) {
            string = output;
        }

    });

    ShowWorker showWorker = new ShowWorker(new ShowWorker.AsyncResponse() {
        @Override
        public void processFinish(String output) {
            string = output;
        }

    });


    private RelativeLayout rel;

    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    int queueNum, waitlist;
    Button queue, no, yes;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuttle);
        final String location = getIntent().getStringExtra("CurLocation");
        //final String arrive = getIntent().getStringExtra("Arrive");
        final String depart = getIntent().getStringExtra("Depart");
        final String destination = getIntent().getStringExtra("Destination");
        final String id = getIntent().getStringExtra("ID");
        iD= getIntent().getStringExtra("UserID");

        curloc = findViewById(R.id.LocationName);
        curloc.setText(location);
        //eta = findViewById(R.id.Arr);
        //eta.setText(arrive);
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

        rel= findViewById(R.id.shuttlelayout);

        refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Status = "show";

                showWorker = new ShowWorker(new ShowWorker.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        qcount = output;
                    }
                });
                showWorker.execute(Status, id);
                Toast.makeText(ShuttleActivity.this, "result:"+id+" count:"+qcount+"::", Toast.LENGTH_SHORT).show();
                // qcount = number of reserved.



            }
        });



        queue= findViewById(R.id.quebut);
        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(queue.getText().equals("Queue")){
                    if(queueNum<10) {
                        queueNum+=1;

                        String Status = "queue";
                        queueWorker = new QueueWorker(new QueueWorker.AsyncResponse() {
                            @Override
                            public void processFinish(String output) {
                                string = (String)output;
                            }
                        });
                        queueWorker.execute(Status, iD, id);
                        Toast.makeText(ShuttleActivity.this, "result:"+ string.length()+" "+string, Toast.LENGTH_SHORT).show();


                        queueNo.setText(String.valueOf(queueNum) );
                        status.setText("You are now Queued");

                    }
                    else
                    {
                        waitlist+=1;
                        waitNo.setText(String.valueOf(waitlist));
                        status.setText("You are in the wait list");
                    }
                    queue.setText("Cancel");}


                else if(queue.getText().equals("Cancel")){
                    layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup, null);
                    popupWindow= new PopupWindow(container, 700, 700, true);
                    popupWindow.showAtLocation(rel, Gravity.NO_GRAVITY, 100,100);
                    popupWindow.setOutsideTouchable(true);

                    no = container.findViewById(R.id.no);
                    no.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View view) {
                            popupWindow.dismiss();

                        }
                    });
                    yes =container.findViewById(R.id.yes);
                    yes.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View view) {
                            popupWindow.dismiss();
                            if(status.getText().equals("You are now Queued")) {
                                Toast.makeText(ShuttleActivity.this, "You received 5 demerits for cancelling reservation.", Toast.LENGTH_SHORT).show();
                                queueNum-=1;
                                queueNo.setText(String.valueOf(queueNum) );
                            }
                            else {
                                Toast.makeText(ShuttleActivity.this, "You have withdrawn from the waitlist. ", Toast.LENGTH_SHORT).show();
                                waitlist-=1;
                                waitNo.setText(String.valueOf(waitlist));
                            }
                            status.setText("");
                            queue.setText("Queue");

                        }
                    });


                }


            }
        });




    }
}