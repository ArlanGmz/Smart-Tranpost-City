package com.example.arlangomez.stc;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ArlanGomez on 26/02/2018.
 */

public class CustomListView extends ArrayAdapter<String> {

    private ArrayList<String> Stops = new ArrayList<>();
    private ArrayList<String> ID = new ArrayList<>();
    private ArrayList<String> Arrive = new ArrayList<>();
    private ArrayList<String> Depart = new ArrayList<>();
    int position;

    private Activity context;

    public CustomListView(Activity context, ArrayList<String> stops, ArrayList<String> depart, ArrayList<String> id){
        super(context, R.layout.stop_parts, stops);

        this.context=context;
        Stops=stops;
        //Arrive=arrive;
        Depart=depart;
        ID = id;
    }
    public CustomListView(Activity context, ArrayList<String> stops,ArrayList<String> arrive, ArrayList<String> depart, ArrayList<String> id){
        super(context, R.layout.stop_parts, stops);

        this.context=context;
        Stops=stops;
        Arrive=arrive;
        Depart=depart;
        ID = id;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder= null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r= layoutInflater.inflate(R.layout.stop_parts,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) r.getTag();
        }

        if(Arrive.isEmpty()==false){
            viewHolder.eta.setText(Arrive.get(position));
        }

        viewHolder.Loc.setText(Stops.get(position));

        viewHolder.etd.setText(Depart.get(position));
        this.position=position;



        return r;
    }

    class ViewHolder{
        TextView Loc, eta, etd;
        ViewHolder(View v){
            Loc=v.findViewById(R.id.Dest);
            eta=v.findViewById(R.id.from);
            etd=v.findViewById(R.id.Dep);
        }
    }
    public String getID(){
        return ID.get(position);
    }
}
