package com.principal.mathebasic;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pprincipal extends AppCompatActivity {

    TextView tvUsuario;

    // Mantener la sesion iniciada
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pprincipal);

        preferences = getSharedPreferences("Preferences", MODE_PRIVATE);
        String usuario = preferences.getString("usuario", null);

        Aprenizaje();
        RecibirUsuario();
    }

    // Acción de cada opcion del Spinner
    public void AprendizajeBuscar(AdapterView<?> adapterView, int posicion) {
        if (String.valueOf(adapterView.getItemAtPosition(posicion)).equals("Suma")) {
            Intent i = new Intent(this, AprendSuma.class);
            startActivity(i);
            overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
        } else if (String.valueOf(adapterView.getItemAtPosition(posicion)).equals("Resta")) {
            Intent i = new Intent(this, AprendResta.class);
            startActivity(i);
            overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
        } else if (String.valueOf(adapterView.getItemAtPosition(posicion)).equals("Multiplicación")) {
            Intent i = new Intent(this, AprendMultiplicacion.class);
            startActivity(i);
            overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
        } else if (String.valueOf(adapterView.getItemAtPosition(posicion)).equals("División")) {
            Intent i = new Intent(this, AprendDivision.class);
            startActivity(i);
            overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
        } else { /* Vacio*/ }
    }

    // Selección en opciones del Spinner
    public void Aprenizaje() {
        // Spinner Aprendizaje
        Spinner spinner = (Spinner) findViewById(R.id.spnAprendizaje);
        String[] valores = {"Aprendizaje", "Suma", "Resta", "Multiplicación", "División"};
        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long id) {
                AprendizajeBuscar(adapterView, posicion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // vacio
            }
        });
    }

    //Recibiendo datos de la actividad anterior
    public void RecibirUsuario() {
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        tvUsuario.setText(user);
    }

    // Accion del botón Jugar
    public void Jugar(View v) {
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, MenuJugar.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
    }

    // Accion del botón Multijugador
    public void Multijugador(View v) {
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, MenuMultijugador.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
    }

    // Accion del botón Resultados
    public void Resultados(View v) {
        // Recibiendo la variable enviada desde el formulario anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        if (user.equals("Invitado")) {
            dialogCuenta();
        } else {
            Intent i = new Intent(this, Resultados.class);
            i.putExtra("Usuario", user);
            startActivity(i);
            overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
        }
    }

    // Diálogo que se muestra al querer ingresar a resultados sin tener cuenta
    public void dialogCuenta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Configura el titulo.
        builder.setTitle("Resultados");
        // Configura el mensaje.
        builder
                .setMessage("Es necesario tener una cuenta\n¿Deseas crear una?")
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(Pprincipal.this, Registro.class);
                        startActivity(i);
                        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create().show();
    }

    // Diálogo que se muestra al intentar cerrar sesion
    public void salirAplicacion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Configura el titulo.
        builder.setTitle("MatheBasic");
        // Configura el mensaje.
        builder
                .setMessage("¿Desea cerrar sesión?")
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        preferences.edit().clear().apply();
                        Intent i = new Intent(Pprincipal.this, Login.class);
                        finish();
                        startActivity(i);
                        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create().show();
    }

    // Accion del botón Resultados
    public void acAboutAs(View v) {
        Intent i = new Intent(this, AboutAs.class);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
    }

    // Accion del botón cerrar sesion
    public void CerrarSesion(View v) {
        salirAplicacion();
    }

    private static final int INTERVALO = 2000; //2 segundos para salir
    private long tiempoPrimerClick;

    @Override
    public void onBackPressed() {
        if (tiempoPrimerClick + INTERVALO > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Vuelve a presionar para salir", Toast.LENGTH_SHORT).show();
        }
        tiempoPrimerClick = System.currentTimeMillis();
    }

}
