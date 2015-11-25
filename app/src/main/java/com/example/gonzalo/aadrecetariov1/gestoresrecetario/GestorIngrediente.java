package com.example.gonzalo.aadrecetariov1.gestoresrecetario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gonzalo.aadrecetariov1.bdrecetario.Ayudante;
import com.example.gonzalo.aadrecetariov1.bdrecetario.Contrato;
import com.example.gonzalo.aadrecetariov1.clasesrecetario.Ingrediente;
import com.example.gonzalo.aadrecetariov1.clasesrecetario.RecetaIngrediente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class GestorIngrediente {

    private Ayudante abd;
    private SQLiteDatabase db;

    public GestorIngrediente(Context context) {
        abd = new Ayudante(context);
    }

    public void open() {
        db= abd.getWritableDatabase();
    }

    public void close(){
        abd.close();
    }

    public long insert(Ingrediente i){
        ContentValues val= new ContentValues();
        val.put(Contrato.TablaIngrediente.NOMBREINGREDIENTE, i.getNombreIngrediente());

        long id = db.insert(Contrato.TablaIngrediente.TABLAINGREDIENTE, null, val);
        return id;
    }

    /************************* select, update y delete ************************************************/
    public int delete(Ingrediente i){
        return delete(i.getIdIngrediente());
    }
    public int delete(long id){
        String condicion = Contrato.TablaIngrediente.ID_INGREDIENTE+"= ?";
        String[] argumentos = {id +"" };
        int cuenta = db.delete(Contrato.TablaRecetaIngrediente.TABLARECETAINGREDIENTE, condicion, argumentos);
        return cuenta;
    }

    public int update(Ingrediente i) {
        ContentValues val = new ContentValues();
        val.put(Contrato.TablaIngrediente.NOMBREINGREDIENTE, i.getNombreIngrediente());

        String condicion = Contrato.TablaIngrediente.ID_INGREDIENTE + "= ?, ";
        String[] argumentos = { i.getIdIngrediente() + "" };

        int cuenta = db.update(Contrato.TablaIngrediente.TABLAINGREDIENTE, val, condicion, argumentos);
        return cuenta;
    }

    public List<Ingrediente> select(){
        return select(null,null);
    }

    public List<Ingrediente> select(String condicion, String[] params) {
        List<Ingrediente> la = new ArrayList<>();
        Cursor cursor = getCursor(condicion, params);
        Ingrediente i;
        while (!cursor.isAfterLast()) {
            i = getRow(cursor);
            la.add(i);
        }
        cursor.close();
        return la;
    }


    /******************************************* getRow ***********************************************/
    public Ingrediente getRow(long id) {
        Cursor c = getCursor("id = ?", new String[]{id + ""});
        return getRow(c);
    }

    public Ingrediente getRow(Cursor c) {
        Ingrediente r = new Ingrediente();
        Log.v("aadsql", "" + c.getColumnCount());
        r.setIdIngrediente(c.getLong(c.getColumnIndex(Contrato.TablaIngrediente.ID_INGREDIENTE)));
        r.setNombreIngrediente(c.getString(c.getColumnIndex(Contrato.TablaIngrediente.NOMBREINGREDIENTE)));
        return r;
    }

    /****************************************** getCursor **********************************************/
    public Cursor getCursor(){
        return getCursor(null, null);
    }

    public Cursor getCursor(String condicion, String[] parametros) {
        Cursor cursor = db.query(Contrato.TablaIngrediente.TABLAINGREDIENTE, null,
                condicion, parametros, null, null,
                Contrato.TablaIngrediente.ID_INGREDIENTE);
        return cursor;
    }

}
