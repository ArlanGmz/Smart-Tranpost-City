package com.example.arlangomez.stc;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity{
    public String string = "heello";
    LoginWorker loginWorker = new LoginWorker(new LoginWorker.AsyncResponse() {
        @Override
        public void processFinish(String output) {
            string = output;
        }
    });


    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;
    //private int UserID;
    private String PassW,UserID;
    private EditText ID, Pword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        /*if(isServiceOK()){
            init();
        }*/
    }

    public void init(){
        Button btnMap =  findViewById(R.id.btnMap);

        btnMap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                ID=findViewById(R.id.UserID);
                Pword=findViewById(R.id.password);
                UserID = ID.getText().toString();
                PassW=Pword.getText().toString();
                if(UserID.matches("") || PassW.matches(""))
                {
                    Toast.makeText(MainActivity.this, "You did not input a username or password ", Toast.LENGTH_SHORT).show();
                }
                else{
                    String status = "login";
                    loginWorker = new LoginWorker(new LoginWorker.AsyncResponse() {
                        @Override
                        public void processFinish(String output) {
                            string = (String)output;
                        }
                    });
                    loginWorker.execute(status, UserID, PassW);
                    Toast.makeText(MainActivity.this, "result:"+ string.length()+" "+string, Toast.LENGTH_SHORT).show();

                    if(string.equals("01")){
                        Intent intent = new Intent(MainActivity.this,  TabActivity.class);
                        startActivity(intent);
                    }
                    else if(string.equals("02")){
                        Intent intent = new Intent(MainActivity.this,  DriverActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


    }



    public boolean isServiceOK(){
        Log.d(TAG, "isServiceOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServiceOK: Google Play services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            Log.d(TAG, "isServiceOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "You cant make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;

    }

}