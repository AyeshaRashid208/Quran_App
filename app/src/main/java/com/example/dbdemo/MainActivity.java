package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.core.view.GravityCompat;
public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button surah_names;
    Button parah_names;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*txt=findViewById(R.id.txt);
        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        String translation=databaseAccess.getTranslation(1);
        txt.setText(translation);*/

        surah_names=findViewById(R.id.surah_names);
        parah_names=findViewById(R.id.parah_names);
        surah_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Surah_List.class);
                startActivity(intent);
            }
        });

        parah_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Parah_List.class);
                startActivity(intent);
            }
        });



    }



}