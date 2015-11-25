package com.example.gonzalo.aadrecetariov1.clasesrecetario;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class RecetaIngrediente {

    private long idReceta, idIngrediente, idRecetaIngrediente;
    private float cantidad;

    public RecetaIngrediente(long idReceta, long idIngrediente, long idRecetaIngrediente, float cantidad) {
        this.idReceta = idReceta;
        this.idIngrediente = idIngrediente;
        this.idRecetaIngrediente = idRecetaIngrediente;
        this.cantidad = cantidad;
    }

    public RecetaIngrediente() {
    }

    public long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(long idReceta) {
        this.idReceta = idReceta;
    }

    public long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public long getIdRecetaIngrediente() {
        return idRecetaIngrediente;
    }

    public void setIdRecetaIngrediente(long idRecetaIngrediente) {
        this.idRecetaIngrediente = idRecetaIngrediente;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecetaIngrediente that = (RecetaIngrediente) o;

        if (idReceta != that.idReceta) return false;
        if (idIngrediente != that.idIngrediente) return false;
        if (idRecetaIngrediente != that.idRecetaIngrediente) return false;
        return Float.compare(that.cantidad, cantidad) == 0;

    }

    @Override
    public int hashCode() {
        int result = (int) (idReceta ^ (idReceta >>> 32));
        result = 31 * result + (int) (idIngrediente ^ (idIngrediente >>> 32));
        result = 31 * result + (int) (idRecetaIngrediente ^ (idRecetaIngrediente >>> 32));
        result = 31 * result + (cantidad != +0.0f ? Float.floatToIntBits(cantidad) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecetaIngrediente{" +
                "idReceta=" + idReceta +
                ", idIngrediente=" + idIngrediente +
                ", idRecetaIngrediente=" + idRecetaIngrediente +
                ", cantidad=" + cantidad +
                '}';
    }
}
