package com.example.gonzalo.aadrecetariov1.bdrecetario;

import android.provider.BaseColumns;

/**
 * Created by Gonzalo on 20/11/2015.
 */
public class Contrato {

    public Contrato() {
    }

    public static abstract class TablaRecetario implements BaseColumns{
        public static final String TABLARECETA="Receta";
        public static final String ID_RECETA="Id_receta";
        public static final String ID_CATEGORIA="Id_categoria";
        public static final String NOMBRERECETA="Nombre_receta";
        public static final String FOTORECETA="Foto_receta";
        public static final String INSTRUCCION="Instruccion";
    }

    public static abstract class TablaIngrediente implements BaseColumns{
        public static final String TABLAINGREDIENTE="Ingrediente";
        public static final String ID_INGREDIENTE="Id_ingrediente";
        public static final String NOMBREINGREDIENTE="Nombre";
    }

    public static abstract class TablaRecetaIngrediente implements BaseColumns{
        public static final String TABLARECETAINGREDIENTE="RecetaIngrediente";
        public static final String ID_RECETAINGREDIENTE="Id_recetaingrediente";
        public static final String ID_RECETA="Id_receta";
        public static final String ID_INGREDIENTE="Id_ingrediente";
        public static final String CANTIDAD="Cantidad";

    }

    public static abstract class TablaUtensilio implements BaseColumns{
        public static final String TABLAUTENSILIO="Utensilio";
        public static final String ID_UTENSILIO="Id_utensilio";
        public static final String NOMBREUTENSILIO="Nombre";
    }

    public static abstract class TablaRecetaUtensilio implements BaseColumns{
        public static final String TABLARECETAUTENSILIO="RecetaUtensilio";
        public static final String ID_RECETAUTENSILIO="Id_recetautensilio";
        public static final String ID_RECETA="Id_receta";
        public static final String ID_UTENSILIO="Id_utensilio";
    }

    public static abstract class TablaCategoria implements BaseColumns{
        public static final String TABLACATEGORIA="Categoria";
        public static final String ID_CATEGORIA="Id_categoria";
        public static final String NOMBRECATEGORIA="Nombre";
    }

}
