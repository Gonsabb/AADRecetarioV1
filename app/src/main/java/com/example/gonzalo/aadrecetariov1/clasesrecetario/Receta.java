package com.example.gonzalo.aadrecetariov1.clasesrecetario;

import android.database.Cursor;

import com.example.gonzalo.aadrecetariov1.bdrecetario.Contrato;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class Receta {

    private long idReceta, IdCategoria;
    private String nombre, foto, instruccion;

    public Receta() {
        this(0,0,"","","");
    }

    public Receta(long idReceta, long idCategoria, String nombre, String foto, String instruccion) {
        this.idReceta = idReceta;
        this.IdCategoria = idCategoria;
        this.nombre = nombre;
        this.foto = foto;
        this.instruccion = instruccion;
    }

    public void set(Cursor c){
        setIdReceta(c.getLong(c.getColumnIndex(Contrato.TablaRecetario._ID)));
        setNombre(c.getString(c.getColumnIndex(Contrato.TablaRecetario.NOMBRERECETA)));
        setFoto(c.getString(c.getColumnIndex(Contrato.TablaRecetario.FOTORECETA)));
        setInstruccion(c.getString(c.getColumnIndex(Contrato.TablaRecetario.INSTRUCCION)));
        setIdCategoria(c.getLong(c.getColumnIndex(Contrato.TablaRecetario.ID_CATEGORIA)));
    }

    public long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(long idReceta) {
        this.idReceta = idReceta;
    }

    public long getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        IdCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receta receta = (Receta) o;

        if (idReceta != receta.idReceta) return false;
        if (IdCategoria != receta.IdCategoria) return false;
        if (nombre != null ? !nombre.equals(receta.nombre) : receta.nombre != null) return false;
        if (foto != null ? !foto.equals(receta.foto) : receta.foto != null) return false;
        return !(instruccion != null ? !instruccion.equals(receta.instruccion) : receta.instruccion != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idReceta ^ (idReceta >>> 32));
        result = 31 * result + (int) (IdCategoria ^ (IdCategoria >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (foto != null ? foto.hashCode() : 0);
        result = 31 * result + (instruccion != null ? instruccion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "idReceta=" + idReceta +
                ", IdCategoría=" + IdCategoria +
                ", nombre='" + nombre + '\'' +
                ", foto='" + foto + '\'' +
                ", instruccion='" + instruccion + '\'' +
                '}';
    }
}
