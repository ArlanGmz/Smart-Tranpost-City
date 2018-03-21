package com.example.arlangomez.stc;

/**
 * Created by ArlanGomez on 05/02/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class StopActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView backButton;

    ListView listView;
    ArrayList<String> Stops = new ArrayList<>();
    ArrayList<String> Stopss = new ArrayList<>();
    ArrayList<String> Arrive = new ArrayList<>();
    ArrayList<String> Depart = new ArrayList<>();
    ArrayList<String> ID = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Stops.add("DLSU-Laguna");
        Stops.add("Nuvali");
        Stops.add("Laguna Central");

        int dlsuid = 100;
        int Lcenid = 200;
        int nuvid = 300;
        final String UserID = getIntent().getStringExtra("Username");
        textView = findViewById(R.id.LocationName);
        final String location = getIntent().getStringExtra("Location");
        textView.setText(location);
        listView = findViewById(R.id.shuttle);


        for (int i = 0; i < Stops.size(); i++) {
            if (Stops.get(i).matches(location))
                Stops.remove(i);
        }
        if (!location.equals("DLSU-Laguna")) {

            int m = 30;
            int hour;
            for (hour = 6; hour < 9; ) {
                if (m >= 60) {
                    m -= 60;
                    hour += 1;
                }
                if (m == 0 && hour != 9) {
                    Depart.add(String.valueOf(hour) + ":00 am");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                } else if (hour != 9) {
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " am");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                }
                m += 15;
            }
            m = 20;
            for (hour = 9; hour < 11; ) {

                if (m >= 60) {
                    m -= 60;
                    hour += 1;
                }
                if (m == 0 && hour != 11) {
                    Depart.add(String.valueOf(hour) + ":00" + " am");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                } else if (hour != 11) {
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " am");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                }
                m += 40;

            }
            m = 0;
            for (hour = 11; hour < 13; ) {
                if (m >= 60) {
                    m -= 60;
                    hour += 1;
                }
                if (m == 0 && hour != 13) {
                    Depart.add(String.valueOf(hour) + ":00" + " am");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid+=1;
                        ID.add(String.valueOf(nuvid));
                    }
                } else if (hour == 12) {
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " am");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                } else if (hour != 13) {
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " am");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                }
                m += 45;
            }
            m = 30;
            for (hour = 13; hour < 15; ) {
                if (m >= 60) {
                    m -= 60;
                    hour += 1;
                }
                if (m == 0 && hour != 15) {
                    Depart.add(String.valueOf(hour - 12) + ":00" + " pm");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                } else if (hour != 15) {
                    Depart.add(String.valueOf(hour - 12) + ":" + String.valueOf(m) + " pm");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                }
                m += 50;
            }
            m = 30;
            for (hour = 15; hour < 20; ) {
                if (m >= 60) {
                    m -= 60;
                    hour += 1;
                }
                if (m == 0 && hour != 20) {
                    Depart.add(String.valueOf(hour - 12) + ":00" + " pm");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                } else if (hour != 20) {
                    Depart.add(String.valueOf(hour - 12) + ":" + String.valueOf(m) + " pm");
                    Stopss.add("DLSU-Laguna");
                    if (location.matches("Laguna Central")) {
                        Lcenid += 1;
                        ID.add(String.valueOf(Lcenid));
                    } else if (location.matches("Nuvali")) {
                        nuvid +=1;
                        ID.add(String.valueOf(nuvid));
                    }
                }
                m += 30;
            }



        }
        else if(location.matches("DLSU-Laguna")){
            int m = 20;
            int hour;
            for (hour = 9; hour < 11; ) {
                if (m >= 60) {
                    m -= 60;
                    hour += 1;
                }
                if (m == 0 && hour != 11) {
                    Depart.add(String.valueOf(hour) + ":00 am");
                    Stopss.add("Laguna Central");
                    Depart.add(String.valueOf(hour) + ":00 am");
                    Stopss.add("Nuvali");
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                } else if (hour != 11) {
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " am");
                    Stopss.add("Laguna Central");
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " am");
                    Stopss.add("Nuvali");
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                }
                m += 40;
            }
            m = 30;
            for (hour = 11; hour < 13; ) {
                if (m >= 60) {
                    m -= 60;
                    hour += 1;
                }
                if (m == 0 && hour != 13) {
                    Depart.add(String.valueOf(hour) + ":00 am");
                    Stopss.add("Laguna Central");
                    Depart.add(String.valueOf(hour) + ":00 am");
                    Stopss.add("Nuvali");
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                } else if (hour == 12) {
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " pm");
                    Stopss.add("Laguna Central");
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " pm");
                    Stopss.add("Nuvali");
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                } else if (hour != 13) {
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " am");
                    Stopss.add("Laguna Central");
                    Depart.add(String.valueOf(hour) + ":" + String.valueOf(m) + " am");
                    Stopss.add("Nuvali");
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                }
                m += 45;
            }
            m = 0;
            for (hour = 13; hour < 15; ) {
                if (m >= 60) {
                    m -= 60;
                    hour += 1;
                }
                if (m == 0 && hour != 15) {
                    Depart.add(String.valueOf(hour - 12) + ":00 pm");
                    Stopss.add("Laguna Central");
                    Depart.add(String.valueOf(hour-12) + ":00 pm");
                    Stopss.add("Nuvali");
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                } else if (hour != 15) {
                    Depart.add(String.valueOf(hour - 12) + ":" + String.valueOf(m) + " pm");
                    Stopss.add("Laguna Central");
                    Depart.add(String.valueOf(hour-12) + ":" + String.valueOf(m) + " pm");
                    Stopss.add("Nuvali");
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                }
                if (hour < 14)
                    m += 60;
                else {
                    m += 40;
                }
            }
            m = 0;
            for (hour = 15; hour < 20; ) {
                if (m >= 60) {
                    m -= 60;
                    hour += 1;
                }
                if (m == 0 && hour != 20) {
                    Depart.add(String.valueOf(hour - 12) + ":00 pm");
                    Stopss.add("Laguna Central");
                    Depart.add(String.valueOf(hour-12) + ":00 pm");
                    Stopss.add("Nuvali");
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                } else if (hour != 20) {
                    Depart.add(String.valueOf(hour - 12) + ":" + String.valueOf(m) + " pm");
                    Stopss.add("Laguna Central");
                    Depart.add(String.valueOf(hour-12) + ":" + String.valueOf(m) + " pm");
                    Stopss.add("Nuvali");
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                    dlsuid += 1;
                    ID.add(String.valueOf(dlsuid));
                }
                m += 30;
            }
            if (hour == 20 && m == 0) {
                Depart.add(String.valueOf(hour - 12) + ":00" + " pm");
                Stopss.add("Laguna Central");
                Depart.add(String.valueOf(hour - 12) + ":00"  + " pm");
                Stopss.add("Nuvali");
                dlsuid += 1;
                ID.add(String.valueOf(dlsuid));
                dlsuid += 1;
                ID.add(String.valueOf(dlsuid));
            }

        }

            final CustomListView customListView = new CustomListView(this, Stopss, Depart, ID);
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
                    //intent.putExtra("Arrive", Arrive.get(i) );
                    intent.putExtra("Depart", Depart.get(i));
                    intent.putExtra("Destination", Stopss.get(i));
                    intent.putExtra("CurLocation", location);
                    intent.putExtra("ID",ID.get(i).toString());
                    intent.putExtra("UserID",UserID);
                    startActivity(intent);


                }
            });


        }



}
