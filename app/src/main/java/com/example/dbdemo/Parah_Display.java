package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class Parah_Display extends AppCompatActivity {

    TextView textView;
    ListView ayahs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parah_display);
        Intent intent=getIntent();
        int Parah_no=intent.getIntExtra("Parah_no",-1);
        // textView=findViewById(R.id.textView);
        //textView.setText(Integer.toString(Surah_no));
        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        ayahs=findViewById(R.id.ayahs);
        List_Adapter_Ayahs listadapter=new List_Adapter_Ayahs(this,databaseAccess.getParahAyahs(Parah_no));
        ayahs.setAdapter(listadapter);


    }
}