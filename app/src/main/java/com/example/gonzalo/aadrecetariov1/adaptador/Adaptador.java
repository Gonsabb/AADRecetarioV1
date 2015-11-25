package com.example.gonzalo.aadrecetariov1.adaptador;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gonzalo.aadrecetariov1.MostrarDetallesReceta;
import com.example.gonzalo.aadrecetariov1.Principal;
import com.example.gonzalo.aadrecetariov1.R;
import com.example.gonzalo.aadrecetariov1.clasesrecetario.Receta;
import com.example.gonzalo.aadrecetariov1.gestoresrecetario.GestorIngrediente;
import com.example.gonzalo.aadrecetariov1.gestoresrecetario.GestorReceta;
import com.example.gonzalo.aadrecetariov1.util.Dialogo;
import com.example.gonzalo.aadrecetariov1.util.OnDialogoListener;

/**
 * Created by Gonzalo on 22/11/2015.
 */
public class Adaptador extends CursorAdapter{

    private GestorReceta gestorReceta;
    private GestorIngrediente gestorIngrediente;
    private ImageButton ibmas, ibmenos;
    private RelativeLayout rl;
    static ImageView iv;
    private Button bt;
    private Cursor c;
    private Context context;

    private Receta receta;

    public Adaptador(Context context, Cursor c, GestorReceta gr) {
        super(context, c ,true);
        this.context=context;
        this.c=c;
        this.gestorReceta=gr;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater i = LayoutInflater.from(parent.getContext());
        View v = i.inflate(R.layout.item, parent, false);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView tvNombre=(TextView)view.findViewById(R.id.tvNombreReceta);
        TextView tvInstruccion=(TextView)view.findViewById(R.id.textView);
        iv=(ImageView)view.findViewById(R.id.imageView);
        ibmas=(ImageButton)view.findViewById(R.id.ibMas);
        ibmenos=(ImageButton)view.findViewById(R.id.ibMenos);
        rl=(RelativeLayout)view.findViewById(R.id.desplegable);
        bt=(Button)view.findViewById(R.id.btDetalles);

        rl.setVisibility(View.GONE);
        ibmenos.setVisibility(View.INVISIBLE);

        receta= gestorReceta.getRow(cursor);
        receta.set(cursor);

        tvNombre.setText(receta.getNombre());
        tvInstruccion.setText(receta.getInstruccion());

        addListener(ibmas, ibmenos, rl);
        addListener2(ibmenos, ibmas, rl);
        addListener3(bt, context ,receta);
    }

    private void addListener(final ImageButton ibma, final ImageButton ibme, final RelativeLayout rl) {
        ibma.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rl.setVisibility(View.VISIBLE);
                ibma.setVisibility(View.INVISIBLE);
                ibme.setVisibility(View.VISIBLE);
            }
        });
    }

    private void addListener2(final ImageButton ibme, final ImageButton ibma, final RelativeLayout rl) {
        ibme.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rl.setVisibility(View.GONE);
                ibme.setVisibility(View.INVISIBLE);
                ibma.setVisibility(View.VISIBLE);
            }
        });
    }

    private void addListener3(final Button btn, final Context context, final Receta receta) {
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, MostrarDetallesReceta.class);
                i.putExtra("id", receta.getIdReceta());
                i.putExtra("nombre", receta.getNombre());
                i.putExtra("categoria", receta.getIdCategoria());
                i.putExtra("instrucciones", receta.getInstruccion());
                context.startActivity(i);

                //para recoger los datos:
                //String nombre= getIntent().getExtras().getString("nombre");
            }
        });
    }

}
