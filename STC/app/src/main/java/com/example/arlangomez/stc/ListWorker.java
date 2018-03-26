package com.example.arlangomez.stc;

import android.os.AsyncTask;

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

/**
 * Created by Rap on 11/02/2018.
 */


public class ListWorker extends AsyncTask<String, Void, String>{


    public interface AsyncResponse {
        void processFinish(String output);
    }

    public ListWorker.AsyncResponse delegate = null;
    public ListWorker(ListWorker.AsyncResponse delegate){
        this.delegate=delegate;
    }
    public String result = "";


    @Override
    protected String doInBackground(String... strings) {
        String status = strings[0];
        String locate_url = "http://172.16.4.199/locate.php";
        result = "";
        if(status.equals("list")){
            try {
                String schedid = strings[1];
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
        return null;
    }
    @Override
    protected void onPreExecute() {


    }

    @Override
    protected void onPostExecute(String result) {

        delegate.processFinish(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}


