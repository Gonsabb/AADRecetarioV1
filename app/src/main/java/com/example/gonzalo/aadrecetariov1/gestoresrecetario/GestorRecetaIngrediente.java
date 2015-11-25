package com.example.gonzalo.aadrecetariov1.gestoresrecetario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gonzalo.aadrecetariov1.bdrecetario.Ayudante;
import com.example.gonzalo.aadrecetariov1.bdrecetario.Contrato;
import com.example.gonzalo.aadrecetariov1.clasesrecetario.Receta;
import com.example.gonzalo.aadrecetariov1.clasesrecetario.RecetaIngrediente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class GestorRecetaIngrediente {

    private Ayudante abd;
    private SQLiteDatabase db;

    public GestorRecetaIngrediente(Context context) {
        abd = new Ayudante(context);
    }

    public void open() {
        db= abd.getWritableDatabase();
    }

    public void close(){
        abd.close();
    }

    public long insert(RecetaIngrediente ri){
        ContentValues val= new ContentValues();
        val.put(Contrato.TablaRecetaIngrediente.ID_RECETA, ri.getIdReceta());
        val.put(Contrato.TablaRecetaIngrediente.ID_INGREDIENTE, ri.getIdIngrediente());
        val.put(Contrato.TablaRecetaIngrediente.CANTIDAD, ri.getCantidad());

        long id = db.insert(Contrato.TablaRecetaIngrediente.TABLARECETAINGREDIENTE, null, val);
        return id;
    }

    /************************* select, update y delete ************************************************/
    public int delete(RecetaIngrediente ri){
        return delete(ri.getIdReceta());
    }
    public int delete(long id){
        String condicion = Contrato.TablaRecetaIngrediente.ID_RECETAINGREDIENTE+"= ?";
        String[] argumentos = {id +"" };
        int cuenta = db.delete(Contrato.TablaRecetaIngrediente.TABLARECETAINGREDIENTE, condicion, argumentos);
        return cuenta;
    }

    public int update(RecetaIngrediente r) {
        ContentValues val = new ContentValues();
        val.put(Contrato.TablaRecetaIngrediente.ID_RECETA, r.getIdReceta());
        val.put(Contrato.TablaRecetaIngrediente.ID_INGREDIENTE, r.getIdIngrediente());
        val.put(Contrato.TablaRecetaIngrediente.CANTIDAD, r.getCantidad());

        String condicion = Contrato.TablaRecetaIngrediente.ID_INGREDIENTE + "= ?, "
                + Contrato.TablaRecetaIngrediente.ID_RECETA+ "= ?";
        String[] argumentos = { r.getIdRecetaIngrediente() + "" };

        int cuenta = db.update(Contrato.TablaRecetaIngrediente.TABLARECETAINGREDIENTE, val, condicion, argumentos);
        return cuenta;
    }

    public List<RecetaIngrediente> select(){
        return select(null,null);
    }

    public List<RecetaIngrediente> select(String condicion, String[] params) {
        List<RecetaIngrediente> la = new ArrayList<>();
        Cursor cursor = getCursor(condicion, params);
        RecetaIngrediente r;
        while (!cursor.isAfterLast()) {
            r = getRow(cursor);
            la.add(r);
        }
        cursor.close();
        return la;
    }


    /******************************************* getRow ***********************************************/
    public RecetaIngrediente getRow(long id) {
        Cursor c = getCursor("id = ?", new String[]{id + ""});
        return getRow(c);
    }

    public RecetaIngrediente getRow(Cursor c) {
        RecetaIngrediente r = new RecetaIngrediente();
        Log.v("aadsql", "" + c.getColumnCount());
        r.setIdRecetaIngrediente(c.getLong(c.getColumnIndex(Contrato.TablaRecetaIngrediente.ID_RECETAINGREDIENTE)));
        r.setIdReceta(c.getLong(c.getColumnIndex(Contrato.TablaRecetaIngrediente.ID_RECETA)));
        r.setIdIngrediente(c.getLong(c.getColumnIndex(Contrato.TablaRecetaIngrediente.ID_INGREDIENTE)));
        r.setCantidad(c.getLong(c.getColumnIndex(Contrato.TablaRecetaIngrediente.CANTIDAD)));
        return r;
    }

    /****************************************** getCursor **********************************************/
    public Cursor getCursor(){
        return getCursor(null, null);
    }

    public Cursor getCursor(String condicion, String[] parametros) {
        Cursor cursor = db.query(Contrato.TablaRecetaIngrediente.TABLARECETAINGREDIENTE, null,
                condicion, parametros, null, null,
                Contrato.TablaRecetaIngrediente.ID_INGREDIENTE + ", " + Contrato.TablaRecetaIngrediente.ID_RECETA);
        return cursor;
    }
}
