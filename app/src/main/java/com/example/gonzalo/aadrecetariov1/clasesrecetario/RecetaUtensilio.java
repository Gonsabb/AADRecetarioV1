package com.example.gonzalo.aadrecetariov1.clasesrecetario;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class RecetaUtensilio {

    private long idRecetautensilio, idUtensilio, idReceta;

    public RecetaUtensilio(long idRecetautensilio, long idUtensilio, long idReceta) {
        this.idRecetautensilio = idRecetautensilio;
        this.idUtensilio = idUtensilio;
        this.idReceta = idReceta;
    }

    public RecetaUtensilio() {
    }

    public long getIdRecetautensilio() {
        return idRecetautensilio;
    }

    public void setIdRecetautensilio(long idRecetautensilio) {
        this.idRecetautensilio = idRecetautensilio;
    }

    public long getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(long idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    public long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(long idReceta) {
        this.idReceta = idReceta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecetaUtensilio that = (RecetaUtensilio) o;

        if (idRecetautensilio != that.idRecetautensilio) return false;
        if (idUtensilio != that.idUtensilio) return false;
        return idReceta == that.idReceta;

    }

    @Override
    public int hashCode() {
        int result = (int) (idRecetautensilio ^ (idRecetautensilio >>> 32));
        result = 31 * result + (int) (idUtensilio ^ (idUtensilio >>> 32));
        result = 31 * result + (int) (idReceta ^ (idReceta >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "RecetaUtensilio{" +
                "idRecetautensilio=" + idRecetautensilio +
                ", idUtensilio=" + idUtensilio +
                ", idReceta=" + idReceta +
                '}';
    }
}
