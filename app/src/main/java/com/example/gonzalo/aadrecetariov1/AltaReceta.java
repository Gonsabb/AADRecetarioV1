package com.example.gonzalo.aadrecetariov1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gonzalo.aadrecetariov1.clasesrecetario.Receta;
import com.example.gonzalo.aadrecetariov1.gestoresrecetario.GestorReceta;

public class AltaReceta extends AppCompatActivity {

    private android.widget.EditText etNombre;
    private android.widget.TextView tvCategoria;
    private android.widget.RadioButton rbAperitivo;
    private android.widget.RadioButton rbCarne;
    private android.widget.RadioButton rbPescado;
    private android.widget.RadioButton rbPostre;
    private android.widget.RadioGroup rg;
    private android.widget.TextView tvPasos;
    private android.widget.EditText etPaso1;
    private android.widget.EditText etPaso2;
    private android.widget.EditText etPaso3;
    private android.widget.EditText etPaso4;
    private android.widget.EditText etPaso5;

    private GestorReceta gestorReceta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.altareceta);
        this.etPaso5 = (EditText) findViewById(R.id.etPaso5);
        this.etPaso4 = (EditText) findViewById(R.id.etPaso4);
        this.etPaso3 = (EditText) findViewById(R.id.etPaso3);
        this.etPaso2 = (EditText) findViewById(R.id.etPaso2);
        this.etPaso1 = (EditText) findViewById(R.id.etPaso1);
        this.tvPasos = (TextView) findViewById(R.id.tvPasos);
        this.rg = (RadioGroup) findViewById(R.id.rg);
        this.rbPostre = (RadioButton) findViewById(R.id.rbPostre);
        this.rbPescado = (RadioButton) findViewById(R.id.rbPescado);
        this.rbCarne = (RadioButton) findViewById(R.id.rbCarne);
        this.rbAperitivo = (RadioButton) findViewById(R.id.rbAperitivo);
        this.tvCategoria = (TextView) findViewById(R.id.tvCategoria);
        this.etNombre = (EditText) findViewById(R.id.etNombre);
        gestorReceta=new GestorReceta(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gestorReceta.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gestorReceta.close();
    }

    public void añadir(View v){
        Receta receta = new Receta();
        receta.setNombre(etNombre.getText().toString().trim());

        int op = rg.getCheckedRadioButtonId();
        switch (op){
            case R.id.rbAperitivo:
                receta.setIdCategoria(1);
                break;

            case R.id.rbCarne:
                receta.setIdCategoria(2);
                break;

            case R.id.rbPescado:
               receta.setIdCategoria(3);
                break;

            case R.id.rbPostre:
               receta.setIdCategoria(4);
                break;

            default:
                receta.setIdCategoria(0);
                Toast.makeText(this, "La categoría no fue seleccionada, receta sin categoría", Toast.LENGTH_SHORT).show();
        }

        String novacio=".\n";
        String paso1, paso2, paso3, paso4, paso5;
        if(etPaso1.getText().toString().equals("")){
            paso1="";
        }else{
            paso1=etPaso1.getText().toString().trim()+novacio;
        }
        if(etPaso2.getText().toString().equals("")){
            paso2="";
        }else{
            paso2=etPaso2.getText().toString().trim()+novacio;
        }
        if(etPaso3.getText().toString().equals("")){
            paso3="";
        }else{
            paso3=etPaso3.getText().toString().trim()+novacio;
        }
        if(etPaso4.getText().toString().equals("")){
            paso4="";
        }else{
            paso4=etPaso4.getText().toString().trim()+novacio;
        }
        if(etPaso5.getText().toString().equals("")){
            paso5="";
        }else{
            paso5=etPaso5.getText().toString().trim();
        }

        receta.setInstruccion(paso1+paso2+paso3+paso4+paso5);

        if(!receta.getNombre().isEmpty()) {
            long r = gestorReceta.insert(receta);
            if(r>0){
                Intent i = new Intent();
                Bundle bundle = new Bundle();
                bundle.putLong("id", r);
                i.putExtras(bundle);
                setResult(Activity.RESULT_OK, i);
                finish();

            }else{
                Toast.makeText(this, "No se ha podido insertar", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "El nombre de la receta es obligatorio", Toast.LENGTH_SHORT).show();
        }
    }

    public void editar(Receta r){
        Receta receta = new Receta();
        receta.setNombre(etNombre.getText().toString());
        int op = rg.getCheckedRadioButtonId();
        switch (op){
            case R.id.rbAperitivo:
                receta.setIdCategoria(1);
                break;

            case R.id.rbCarne:
                receta.setIdCategoria(2);
                break;

            case R.id.rbPescado:
                receta.setIdCategoria(3);
                break;

            case R.id.rbPostre:
                receta.setIdCategoria(4);
                break;

            default:
                Toast.makeText(this, "Debe seleccionar una categoria", Toast.LENGTH_SHORT).show();
        }
        receta.setInstruccion(etPaso1.getText().toString().trim()
                + etPaso2.getText().toString().trim()
                + etPaso3.getText().toString().trim()
                + etPaso4.getText().toString().trim()
                + etPaso5.getText().toString().trim());

        if(!receta.getNombre().isEmpty()) {
            long res = gestorReceta.insert(receta);
            if(res>0){
                Intent i = new Intent();
                Bundle bundle = new Bundle();
                bundle.putLong("id", res);
                i.putExtras(bundle);
                setResult(Activity.RESULT_OK, i);
                finish();

            }else{
                Toast.makeText(this, "No se ha podido insertar", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "El nombre de la receta es obligatorio", Toast.LENGTH_SHORT).show();
        }

        long id = r.getIdReceta();
        receta.setIdReceta(id);
        gestorReceta.insert(receta);
    }

}
