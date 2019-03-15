package com.example.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    EditText Nombre,Edad,Fecha;
    TextView Nomb,Ed,Fe;
    Button Aceptar,Cargar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Nombre=  findViewById(R.id.Nombre_id);
        Edad=  findViewById(R.id.Edad_id);
        Fecha=  findViewById(R.id.Fecha_id);
        Aceptar= findViewById(R.id.Aceptar_id);
        Cargar= findViewById(R.id.Cargar_id);

        Nomb=findViewById(R.id.Nb);
        Ed=findViewById(R.id.Edi);
        Fe=findViewById(R.id.Fech);


        Aceptar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                guardarPreferencias();
            }
        });
        Cargar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               cargarPreferencias();
            }
        });

       // cargarPreferencias();

    }

  /*  public void onClick(View view){

        switch (view.getId()){

            case R.id.Aceptar_id:


                break;

            case R.id.Cargar_id:

                cargarPreferencias();
                break;
        }

    }*/

    private void guardarPreferencias(){
        SharedPreferences DatosGuardar= getSharedPreferences("DatosUsiario", Context.MODE_PRIVATE);

        String NombreSP=Nombre.getText().toString();
        String EdadSP= Edad.getText().toString();
        String FechaSP=Fecha.getText().toString();

        SharedPreferences.Editor Editor=DatosGuardar.edit();

        Editor.putString("Nombre",NombreSP);
        Editor.putString("Edad",EdadSP);
        Editor.putString("Fecha",FechaSP);


        Nomb.setText(NombreSP);
        Ed.setText(EdadSP);
        Fe.setText(FechaSP);

        Editor.apply();
    }

    private void cargarPreferencias(){
        SharedPreferences DatosConsultar= getSharedPreferences("DatosUsiario", Context.MODE_PRIVATE);

        String NombreS= DatosConsultar.getString("Nombre","No existe");
        String EdadS = DatosConsultar.getString("Edad","No existe");
        String FechaS= DatosConsultar.getString("Fecha","No existe");

        Nomb.setText(NombreS);
        Ed.setText(EdadS);
        Fe.setText(FechaS);
    }
}
