package com.example.e_recycling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ElectronicsAdapter extends ArrayAdapter<Electronics> {
    private int resourceId;
    public ElectronicsAdapter(Context context, int textViewResourceId, List<Electronics> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Electronics electronics=getItem(position);//获取当前Electronics实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView textView=(TextView) view.findViewById(R.id.electronics_type);
        textView.setText(electronics.getType());
        return view;
    }
}
