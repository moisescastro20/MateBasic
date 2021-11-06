package com.principal.mathebasic.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.principal.mathebasic.Utilidades.Utilidades;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "matheBasic"; // Database Name
    public static final int DATABASE_Version = 1;    // Database Version

    Utilidades ut = new Utilidades();
    private Context context;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(ut.CREATE_TABLE_USUARIOS);
            db.execSQL(ut.CREATE_TABLE_JSUMA);
            db.execSQL(ut.CREATE_TABLE_JRESTA);
            db.execSQL(ut.CREATE_TABLE_JMULTIP);
            db.execSQL(ut.CREATE_TABLE_JPOTE);
            db.execSQL(ut.CREATE_TABLE_MSUMA);
            db.execSQL(ut.CREATE_TABLE_MRESTA);
            db.execSQL(ut.CREATE_TABLE_MMULTIP);
            db.execSQL(ut.CREATE_TABLE_MPOTE);
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(ut.DROP_TABLE);
            db.execSQL(ut.DROP_TABLE_JS);
            db.execSQL(ut.DROP_TABLE_JR);
            db.execSQL(ut.DROP_TABLE_JM);
            db.execSQL(ut.DROP_TABLE_JP);
            db.execSQL(ut.DROP_TABLE_MS);
            db.execSQL(ut.DROP_TABLE_MR);
            db.execSQL(ut.DROP_TABLE_MM);
            db.execSQL(ut.DROP_TABLE_MP);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}
