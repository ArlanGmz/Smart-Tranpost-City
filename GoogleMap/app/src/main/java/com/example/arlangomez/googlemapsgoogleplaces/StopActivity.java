package com.example.arlangomez.googlemapsgoogleplaces;

/**
 * Created by ArlanGomez on 05/02/2018.
 */

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.gcm.Task;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StopActivity extends AppCompatActivity{
    private TextView textView;
    private TextView T12, T11, T21,T22,T31,T32,T41,T42;
    private TextView DeLo1,DeLo2;
    private ImageView backButton;
    private RelativeLayout shut1, shut2, shut3, shut4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        textView = findViewById(R.id.LocationName);
        final String location = getIntent().getStringExtra("Location");
        textView.setText(location);

        backButton = findViewById(R.id.backbtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });










        shut1 = findViewById(R.id.shtl1);
        shut1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                T11 = findViewById(R.id.A1);
                T12 = findViewById(R.id.D1);
                DeLo1 = findViewById(R.id.dest1);
                String S1=T11.toString();
                String S2=T12.toString();
                String S3=DeLo1.toString();

                Intent intent = new Intent(StopActivity.this, ShuttleActivity.class);
                intent.putExtra("Arrive", S1 );
                intent.putExtra("Depart", S2 );
                intent.putExtra("Destination", S3 );
                intent.putExtra("CurLocation", location);
                startActivity(intent);
            }
        });

        shut2 = findViewById(R.id.shtl2);
        shut2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                T21 = findViewById(R.id.A2);
                T22 = findViewById(R.id.D2);
                DeLo1 = findViewById(R.id.dest2);
                String S4=T21.toString();
                String S5=T22.toString();
                String S6=DeLo1.toString();

                Intent intent = new Intent(StopActivity.this, ShuttleActivity.class);
                intent.putExtra("Arrive", S4 );
                intent.putExtra("Depart", S5 );
                intent.putExtra("Destination", S6 );
                intent.putExtra("CurLocation", location);
                startActivity(intent);
            }
        });

        shut3 = findViewById(R.id.shtl3);
        shut3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                T31 = findViewById(R.id.A3);
                T32 = findViewById(R.id.D3);
                DeLo2 = findViewById(R.id.dest3);
                String S7=T31.toString();
                String S8=T32.toString();
                String S9=DeLo2.toString();
                Intent intent = new Intent(StopActivity.this, ShuttleActivity.class);
                intent.putExtra("Arrive", S7 );
                intent.putExtra("Depart", S8 );
                intent.putExtra("Destinatio", S9 );
                intent.putExtra("CurLocation", location);
                startActivity(intent);
            }
        });

        shut4 = findViewById(R.id.shtl4);
        shut4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                T41 = findViewById(R.id.A4);
                T42 = findViewById(R.id.D4);
                DeLo2 = findViewById(R.id.dest4);
                String S10=T41.toString();
                String S11=T42.toString();
                String S12=DeLo2.toString();
                Intent intent = new Intent(StopActivity.this, ShuttleActivity.class);
                intent.putExtra("Arrive", S10 );
                intent.putExtra("Depart", S11 );
                intent.putExtra("Destination", S12 );
                intent.putExtra("CurLocation", location);
                startActivity(intent);
            }
        });


    }


}
