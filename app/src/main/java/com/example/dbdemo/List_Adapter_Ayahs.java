package com.example.dbdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class List_Adapter_Ayahs extends ArrayAdapter<Ayah> {

    public List_Adapter_Ayahs(@NonNull Context context, ArrayList<Ayah> ayah) {
        super(context,0,ayah);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Ayah AYAH=getItem(position);
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_list_adapter_ayahs,parent,false);

        TextView ayah= convertView.findViewById(R.id.ayah);
        ayah.setText(AYAH.getAyah());

        TextView urdu= convertView.findViewById(R.id.urdu);
        urdu.setText(AYAH.getUrduTranslation());

        TextView english= convertView.findViewById(R.id.english);
        english.setText(AYAH.getEnglishTranslation());

        return convertView;
    }
}