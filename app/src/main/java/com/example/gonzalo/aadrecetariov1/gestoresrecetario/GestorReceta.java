package com.example.gonzalo.aadrecetariov1.gestoresrecetario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gonzalo.aadrecetariov1.bdrecetario.Ayudante;
import com.example.gonzalo.aadrecetariov1.bdrecetario.Contrato;
import com.example.gonzalo.aadrecetariov1.clasesrecetario.Receta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class GestorReceta {

    private Ayudante abd;
    private SQLiteDatabase db;

    public GestorReceta(Context c) {
        abd = new Ayudante(c);
    }

    public void open() {
        db= abd.getWritableDatabase();
    }

    public void close(){
        abd.close();
    }

    public long insert(Receta r){
        ContentValues val= new ContentValues();
        val.put(Contrato.TablaRecetario.ID_CATEGORIA, r.getIdCategoria());
        val.put(Contrato.TablaRecetario.NOMBRERECETA, r.getNombre());
        val.put(Contrato.TablaRecetario.FOTORECETA, r.getFoto());
        val.put(Contrato.TablaRecetario.INSTRUCCION, r.getInstruccion());

        long id = db.insert(Contrato.TablaRecetario.TABLARECETA, null, val);
        return id;
    }

    /************************* select, update y delete ************************************************/
    public int delete(Receta r){
        return delete(r.getIdReceta());
    }
    public int delete(long id){
        String condicion = Contrato.TablaRecetario._ID+ " = ?";
        String[] argumentos = {id +"" };
        int cuenta = db.delete(Contrato.TablaRecetario.TABLARECETA, condicion, argumentos);
        return cuenta;
    }

    public int update(Receta r) {
        ContentValues val = new ContentValues();
        val.put(Contrato.TablaRecetario.ID_CATEGORIA, r.getIdCategoria());
        val.put(Contrato.TablaRecetario.NOMBRERECETA, r.getNombre());
        val.put(Contrato.TablaRecetario.FOTORECETA, r.getFoto());
        val.put(Contrato.TablaRecetario.INSTRUCCION, r.getInstruccion());

        String condicion = Contrato.TablaRecetario._ID + " = ?";
        String[] argumentos = { r.getIdReceta() + "" };

        int cuenta = db.update(Contrato.TablaRecetario.TABLARECETA, val, condicion, argumentos);
        return cuenta;
    }

    public List<Receta> select(){
        return select(null,null);
    }

    public List<Receta> select(String condicion, String[] params) {
        List<Receta> la = new ArrayList<>();
        Cursor cursor = getCursor(condicion, params);
        Receta r;
        while (!cursor.isAfterLast()) {
            r = getRow(cursor);
            la.add(r);
        }
        cursor.close();
        return la;
    }


    /******************************************* getRow ***********************************************/
    public Receta getRow(long id) {
        Cursor c = getCursor("id = ?", new String[]{id + ""});
        return getRow(c);
    }

    public Receta getRow(Cursor c) {
        Receta r = new Receta();
//        Log.v("aadsql", "" + c.getColumnCount());
        r.setIdReceta(c.getLong(c.getColumnIndex(Contrato.TablaRecetario._ID)));
        r.setIdCategoria(c.getInt(c.getColumnIndex(Contrato.TablaRecetario.ID_CATEGORIA)));
        r.setNombre(c.getString(c.getColumnIndex(Contrato.TablaRecetario.NOMBRERECETA)));
        r.setFoto(c.getString(c.getColumnIndex(Contrato.TablaRecetario.FOTORECETA)));
        r.setInstruccion(c.getString(c.getColumnIndex(Contrato.TablaRecetario.INSTRUCCION)));
        return r;
    }

    /****************************************** getCursor **********************************************/
    public Cursor getCursor(){
        return getCursor(null, null);
    }

    public Cursor getCursor(String condicion, String[] parametros) {
        Cursor cursor = db.query(Contrato.TablaRecetario.TABLARECETA, null,
                condicion, parametros, null, null,
                Contrato.TablaRecetario.NOMBRERECETA + ", " + Contrato.TablaRecetario.ID_CATEGORIA);
        return cursor;
    }
}
