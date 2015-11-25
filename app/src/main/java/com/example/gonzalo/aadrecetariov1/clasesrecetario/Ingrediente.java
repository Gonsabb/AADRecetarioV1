package com.example.gonzalo.aadrecetariov1.clasesrecetario;

import android.database.Cursor;

import com.example.gonzalo.aadrecetariov1.bdrecetario.Contrato;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class Ingrediente {

    private long idIngrediente;
    private String nombreIngrediente;

    public Ingrediente(long idIngrediente, String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
        this.idIngrediente = idIngrediente;
    }

    public Ingrediente() {
        this(0,"");
    }

    public void set(Cursor c){
        setIdIngrediente(c.getLong(c.getColumnIndex(Contrato.TablaIngrediente._ID)));
        setNombreIngrediente(c.getString(c.getColumnIndex(Contrato.TablaIngrediente.NOMBREINGREDIENTE)));
    }

    public long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingrediente that = (Ingrediente) o;

        if (idIngrediente != that.idIngrediente) return false;
        return !(nombreIngrediente != null ? !nombreIngrediente.equals(that.nombreIngrediente) : that.nombreIngrediente != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idIngrediente ^ (idIngrediente >>> 32));
        result = 31 * result + (nombreIngrediente != null ? nombreIngrediente.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "idIngrediente=" + idIngrediente +
                ", nombreIngrediente='" + nombreIngrediente + '\'' +
                '}';
    }
}
