package com.example.gonzalo.aadrecetariov1.clasesrecetario;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class Categoria {

    private long idCategoria;
    private String nombreCategoria;

    public Categoria(long idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria() {
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;

        if (idCategoria != categoria.idCategoria) return false;
        return !(nombreCategoria != null ? !nombreCategoria.equals(categoria.nombreCategoria) : categoria.nombreCategoria != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idCategoria ^ (idCategoria >>> 32));
        result = 31 * result + (nombreCategoria != null ? nombreCategoria.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                '}';
    }
}
