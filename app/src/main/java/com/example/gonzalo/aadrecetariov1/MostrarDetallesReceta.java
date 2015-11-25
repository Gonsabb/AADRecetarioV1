package com.example.gonzalo.aadrecetariov1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.gonzalo.aadrecetariov1.gestoresrecetario.GestorIngrediente;
import com.example.gonzalo.aadrecetariov1.gestoresrecetario.GestorReceta;
import com.example.gonzalo.aadrecetariov1.gestoresrecetario.GestorRecetaIngrediente;

public class MostrarDetallesReceta extends AppCompatActivity {

    private android.widget.TextView tvNombreDetalles;
    private android.widget.TextView tvCategoriaDetalles;
    private android.widget.TextView tvInstruccionDetalles;
    private android.widget.TextView tvIngredientesDetalles;
    private String id, nombre, categoria, instrucciones;
    private GestorReceta gestorReceta;
    private GestorIngrediente gestorIngrediente;
    private GestorRecetaIngrediente gestorRecetaIngrediente;
    private Cursor r, i, ri;
    private TextView tvIdRecetaDetalles;
    private android.widget.ScrollView scrollView2;
    private android.widget.ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallesreceta);
        this.scrollView = (ScrollView) findViewById(R.id.scrollView);
        this.scrollView2 = (ScrollView) findViewById(R.id.scrollView2);
        this.tvIdRecetaDetalles = (TextView) findViewById(R.id.tvIdRecetaDetalles);
        this.tvIngredientesDetalles = (TextView) findViewById(R.id.tvIngredientesDetalles);
        this.tvInstruccionDetalles = (TextView) findViewById(R.id.tvInstruccionDetalles);
        this.tvCategoriaDetalles = (TextView) findViewById(R.id.tvCategoriaDetalles);
        this.tvNombreDetalles = (TextView) findViewById(R.id.tvNombreDetalles);
        init();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        gestorReceta.open();
//        r=gestorReceta.getCursor();
//
//        gestorIngrediente.open();
//        i=gestorIngrediente.getCursor();
//
//        gestorRecetaIngrediente.open();
//        ri=gestorRecetaIngrediente.getCursor();
//    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        gestorReceta.close();
//        gestorIngrediente.close();
//        gestorRecetaIngrediente.close();
//    }

    public void init(){
        id= getIntent().getExtras().getString("id");
        nombre= getIntent().getExtras().getString("nombre");
        categoria= getIntent().getExtras().getString("categoria");
        instrucciones= getIntent().getExtras().getString("instrucciones");

        tvIdRecetaDetalles.setText(id);
        tvCategoriaDetalles.setText(categoria);
//        if (categoria.equals("")){
//            tvCategoriaDetalles.setText("Sin categoría");
//        }else if (categoria.equals("1")){
//            tvCategoriaDetalles.setText("Aperitivo");
//        }else if (categoria.equals("2")){
//            tvCategoriaDetalles.setText("Carne");
//        }else if (categoria.equals("3")){
//            tvCategoriaDetalles.setText("Pescado");
//        }else{
//            tvCategoriaDetalles.setText("Postre");
//        }
        tvInstruccionDetalles.setText(instrucciones);
    }

}
