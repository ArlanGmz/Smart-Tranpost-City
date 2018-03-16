package com.example.arlangomez.stc;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ArlanGomez on 16/03/2018.
 */

public class passengerlist extends ArrayAdapter<String> {

    private ArrayList<String> num = new ArrayList<>();
    private ArrayList<String> ID = new ArrayList<>();
    int position;

    private Activity context;

    public passengerlist(Activity context, ArrayList<String> num, ArrayList<String> id){
        super(context, R.layout.passenger_parts);

        this.context=context;
        this.num=num;
        //Arrive=arrive;
        ID = id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        passengerlist.ViewHolder viewHolder= null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r= layoutInflater.inflate(R.layout.passenger_parts,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder= (passengerlist.ViewHolder) r.getTag();
        }

        viewHolder.posi.setText(num.get(position));
        viewHolder.id.setText(ID.get(position));
        //viewHolder.chek.setOnClickListener();
        // viewHolder.eta.setText(Arrive.get(position));
        this.position=position;



        return r;
    }

    class ViewHolder{
        TextView posi, eta, id;
        CheckBox chek;
        ViewHolder(View v){
            posi=v.findViewById(R.id.passno);
            // eta=v.findViewById(R.id.Arr);
            chek = v.findViewById(R.id.checkB);
            id=v.findViewById(R.id.Dep);
        }
    }
    public String getID(){
        return ID.get(position);
    }
}
