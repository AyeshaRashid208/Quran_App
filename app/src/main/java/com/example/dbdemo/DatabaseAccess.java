package com.example.dbdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.content.Context;
import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //private constructor so that object creation from outside of class can be avoided
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

    public String getTranslation(int id) {
        c = db.rawQuery("Select MehmoodulHassan from tayah where SuraID = " + id + "", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String address = c.getString(0);
            buffer.append("" + address);

        }
        return buffer.toString();
    }

    public ArrayList getSurahAyahs(int Surah_no) {
        c = db.rawQuery("Select ArabicText,FatehMuhammadJalandhri,DrMohsinKhan from tayah where SuraID = " + Surah_no + "", new String[]{});
        ArrayList<Ayah> SurahAyahs = new ArrayList<>();
        Ayah ayahs;
        while (c.moveToNext()) {
            String ayah = c.getString(0);
            String urduTranslatiom = c.getString(1);
            String englishTranslation = c.getString(2);
            ayahs = new Ayah(ayah, urduTranslatiom, englishTranslation);
            SurahAyahs.add(ayahs);
        }
        return SurahAyahs;
    }

    public ArrayList getParahAyahs(int Parah_no) {
        c = db.rawQuery("Select ArabicText,FatehMuhammadJalandhri,DrMohsinKhan,ParaID,AyaID,SuraID from tayah where ParaID = " + Parah_no + " ORDER BY ParaID,AyaID,SuraID  ", new String[]{});
        ArrayList<Ayah> ParahAyahs = new ArrayList<>();
        Ayah ayahs;
        while (c.moveToNext()) {
            String ayah = c.getString(0);
            String urduTranslatiom = c.getString(1);
            String englishTranslation = c.getString(2);
            ayahs = new Ayah(ayah, urduTranslatiom, englishTranslation);
            ParahAyahs.add(ayahs);
        }
        return ParahAyahs;
    }
    String getAyah(int an, int sn)
    {
        c = db.rawQuery("select ArabicText from tayah where AyaNo = ? and SuraId =?", new String[]{String.valueOf(an), String.valueOf(sn)});

        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext())
        {
            String arabicText = c.getString(0);
            buffer.append(""+arabicText);
        }
        return buffer.toString();
    }


}


