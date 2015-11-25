package com.example.gonzalo.aadrecetariov1.clasesrecetario;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class Utensilio {

    private long idUtensilio;
    private String nombreUtensilio;

    public Utensilio(long idUtensilio, String nombreUtensilio) {
        this.idUtensilio = idUtensilio;
        this.nombreUtensilio = nombreUtensilio;
    }

    public Utensilio() {
    }

    public long getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(long idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    public String getNombreUtensilio() {
        return nombreUtensilio;
    }

    public void setNombreUtensilio(String nombreUtensilio) {
        this.nombreUtensilio = nombreUtensilio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utensilio utensilio = (Utensilio) o;

        if (idUtensilio != utensilio.idUtensilio) return false;
        return !(nombreUtensilio != null ? !nombreUtensilio.equals(utensilio.nombreUtensilio) : utensilio.nombreUtensilio != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idUtensilio ^ (idUtensilio >>> 32));
        result = 31 * result + (nombreUtensilio != null ? nombreUtensilio.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Utensilio{" +
                "idUtensilio=" + idUtensilio +
                ", nombreUtensilio='" + nombreUtensilio + '\'' +
                '}';
    }
}
