package com.example.gonzalo.aadrecetariov1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.gonzalo.aadrecetariov1.adaptador.Adaptador;
import com.example.gonzalo.aadrecetariov1.clasesrecetario.Receta;
import com.example.gonzalo.aadrecetariov1.gestoresrecetario.GestorReceta;
import com.example.gonzalo.aadrecetariov1.util.Dialogo;
import com.example.gonzalo.aadrecetariov1.util.OnDialogoListener;

import java.util.regex.Pattern;

public class Principal extends AppCompatActivity {


    private GestorReceta gestorReceta;
    private Adaptador adp;
    private ListView lv;
    private Cursor c;
    private ImageView iv;
    private static final int ALTARECETA=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        gestorReceta=new GestorReceta(this);
        this.lv = (ListView) findViewById(R.id.lv);
        iv=(ImageView)findViewById(R.id.imageView);
        iniciar();
    }

    private void iniciar() {

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Receta receta = new Receta();
                receta.set(c);//
                final OnDialogoListener odl = new OnDialogoListener() {
                    @Override
                    public void onPreShow(View vista) {

                        EditText etNombre = (EditText) vista.findViewById(R.id.etNombre);
                        etNombre.setText(receta.getNombre());
                        
                        RadioButton rbApertitivo= (RadioButton)vista.findViewById(R.id.rbAperitivo);
                        RadioButton rbCarne= (RadioButton)vista.findViewById(R.id.rbCarne);
                        RadioButton rbPescado= (RadioButton)vista.findViewById(R.id.rbPescado);
                        RadioButton rbPostre= (RadioButton)vista.findViewById(R.id.rbPostre);
                        int idCat= Integer.parseInt(receta.getIdCategoria() + "");
                        switch(idCat){
                            case 1:
                                rbApertitivo.setChecked(true);
                                break;
                            case 2:
                                rbCarne.setChecked(true);
                                break;
                            case 3:
                                rbPescado.setChecked(true);
                                break;
                            case 4:
                                rbPostre.setChecked(true);
                                break;
                            default:
                                tostada("Seleccione una categoria");
                                break;
                        }

                        String ins=receta.getInstruccion();
                            Log.v("vector instruccion", ins);
                        EditText etPaso1 = (EditText)vista.findViewById(R.id.etPaso1);
                        etPaso1.setText(ins);
                    }

                    @Override
                    public void onOkSelecter(View vista) {
                        tostada("Receta modificada");

                        EditText etNombre = (EditText) vista.findViewById(R.id.etNombre);
                        RadioGroup radioGroup = (RadioGroup) vista.findViewById(R.id.rg);
                        RadioButton rbApertitivo = (RadioButton) vista.findViewById(R.id.rbAperitivo);
                        RadioButton rbCarne = (RadioButton) vista.findViewById(R.id.rbCarne);
                        RadioButton rbPescado = (RadioButton) vista.findViewById(R.id.rbPescado);
                        RadioButton rbPostre = (RadioButton) vista.findViewById(R.id.rbPostre);
                        EditText etPaso1 = (EditText) vista.findViewById(R.id.etPaso1);

                        receta.setNombre(etNombre.getText().toString());

                        int op = radioGroup.getCheckedRadioButtonId();
                        switch (op) {
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
                                tostada("La categoría no fue seleccionada, receta sin categoría(0)");
                            }

                        String paso1;
                        if (etPaso1.getText().toString().equals("")) {
                            paso1 = "";
                            Log.v("PACOIF", paso1);
                        } else {
                            paso1 = etPaso1.getText().toString().trim();
                            Log.v("PACOELSE", paso1);
                        }
                        receta.setInstruccion(paso1);

                        int result = gestorReceta.update(receta);
                        tostada("Resultado es " + result);
                        //Actualizar cursor
                        c = gestorReceta.getCursor();
                        adp.changeCursor(c);
                    }

                    @Override
                    public void onCancelSelecter(View v) {
                        tostada("Cancelado");
                    }
                };
//                tostada(receta.toString());
                Dialogo d = new Dialogo(Principal.this, R.layout.editarreceta, odl);
                d.show();
            }
        });

    }

    private void tostada(String i){
        Toast.makeText(this, i, Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        gestorReceta.open();
        c=gestorReceta.getCursor();
        adp=new Adaptador(this, c, gestorReceta);
        lv.setAdapter(adp);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gestorReceta.close();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            switch (requestCode){
                case ALTARECETA:
                    break;
                default:
                    break;
            }
        }
    }

    public void insertar(View v){
        Intent i = new Intent(this, AltaReceta.class);
        startActivityForResult(i, ALTARECETA);
    }


}
