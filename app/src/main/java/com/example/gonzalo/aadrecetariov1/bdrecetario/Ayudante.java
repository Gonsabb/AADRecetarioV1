package com.example.gonzalo.aadrecetariov1.bdrecetario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Gonzalo on 20/11/2015.
 */
public class Ayudante extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "recetario.sqlite";
    public static final int DATABASE_VERSION = 3;

    public Ayudante(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.v("SQLAAD", "Ayudante del Gestor recetario");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String sqlB1= "DROP TABLE IF EXISTS "+Contrato.TablaCategoria.TABLACATEGORIA;
//        String sqlB2= "DROP TABLE IF EXISTS "+Contrato.TablaRecetario.TABLARECETA;
//        String sqlB3= "DROP TABLE IF EXISTS "+Contrato.TablaIngrediente.TABLAINGREDIENTE;
//        String sqlB4= "DROP TABLE IF EXISTS "+Contrato.TablaUtensilio.TABLAUTENSILIO;
//        String sqlB5= "DROP TABLE IF EXISTS "+Contrato.TablaRecetaIngrediente.TABLARECETAINGREDIENTE;
//        String sqlB6= "DROP TABLE IF EXISTS "+Contrato.TablaRecetaUtensilio.TABLARECETAUTENSILIO;
//        db.execSQL(sqlB1);
//        db.execSQL(sqlB2);
//        db.execSQL(sqlB3);
//        db.execSQL(sqlB4);
//        db.execSQL(sqlB5);
//        db.execSQL(sqlB6);

        Log.v("SQLAAD", "onCreate Ayudante");
        String sql1, sql2, sql3, sql4, sql5, sql6;

        sql1="CREATE TABLE "+Contrato.TablaCategoria.TABLACATEGORIA
                +" ("+Contrato.TablaCategoria._ID+" integer primary key autoincrement, "
                + Contrato.TablaCategoria.NOMBRECATEGORIA+" text)";
        Log.v("SQLAAD", sql1);

        sql2="CREATE TABLE "+Contrato.TablaRecetario.TABLARECETA
                +" ("+Contrato.TablaRecetario._ID+" integer primary key autoincrement, "
                + Contrato.TablaRecetario.ID_CATEGORIA+" integer, "
                + Contrato.TablaRecetario.NOMBRERECETA+" text, "
                + Contrato.TablaRecetario.FOTORECETA+" text, "
                + Contrato.TablaRecetario.INSTRUCCION+" text)";
        Log.v("SQLAAD", sql2);

        sql3="CREATE TABLE "+Contrato.TablaIngrediente.TABLAINGREDIENTE
                +" ("+Contrato.TablaIngrediente._ID+" integer primary key autoincrement, "
                + Contrato.TablaIngrediente.NOMBREINGREDIENTE+" text)";
        Log.v("SQLAAD", sql3);

        sql4="CREATE TABLE "+Contrato.TablaUtensilio.TABLAUTENSILIO
                +" ("+Contrato.TablaUtensilio._ID+" integer primary key autoincrement, "
                + Contrato.TablaUtensilio.NOMBREUTENSILIO+" text)";
        Log.v("SQLAAD", sql4);

        sql5="CREATE TABLE "+Contrato.TablaRecetaIngrediente.TABLARECETAINGREDIENTE
                +" ("+Contrato.TablaRecetaIngrediente._ID+" integer primary key autoincrement, "
                + Contrato.TablaRecetaIngrediente.ID_RECETA+" integer, "
                + Contrato.TablaRecetaIngrediente.ID_INGREDIENTE+" integer, "
                + Contrato.TablaRecetaIngrediente.CANTIDAD+" text)";
        Log.v("SQLAAD", sql5);

        sql6="CREATE TABLE "+Contrato.TablaRecetaUtensilio.TABLARECETAUTENSILIO
                +" ("+Contrato.TablaRecetaUtensilio._ID+" integer primary key autoincrement, "
                + Contrato.TablaRecetaUtensilio.ID_RECETA+" integer, "
                + Contrato.TablaRecetaUtensilio.ID_UTENSILIO+" integer)";
        Log.v("SQLAAD", sql6);

        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("SQLAAD", "Upgrade de la database");
        String sqlB1= "DROP TABLE IF EXISTS "+Contrato.TablaCategoria.TABLACATEGORIA;
        String sqlB2= "DROP TABLE IF EXISTS "+Contrato.TablaRecetario.TABLARECETA;
        String sqlB3= "DROP TABLE IF EXISTS "+Contrato.TablaIngrediente.TABLAINGREDIENTE;
        String sqlB4= "DROP TABLE IF EXISTS "+Contrato.TablaUtensilio.TABLAUTENSILIO;
        String sqlB5= "DROP TABLE IF EXISTS "+Contrato.TablaRecetaIngrediente.TABLARECETAINGREDIENTE;
        String sqlB6= "DROP TABLE IF EXISTS "+Contrato.TablaRecetaUtensilio.TABLARECETAUTENSILIO;
        db.execSQL(sqlB1);
        db.execSQL(sqlB2);
        db.execSQL(sqlB3);
        db.execSQL(sqlB4);
        db.execSQL(sqlB5);
        db.execSQL(sqlB6);
        onCreate(db);
    }
}
