package com.principal.mathebasic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.principal.mathebasic.Entidades.Usuarios;
import com.principal.mathebasic.SQLite.SQLite;

public class Login extends AppCompatActivity {

    // Referencias a los elementos de nuestro Activity
    EditText etUsuario, etContraseña;
    ProgressBar progressBar;

    // Mantener la sesion iniciada
    private SharedPreferences preferences;

    // Referencia a la clase SQLite
    SQLite helper;
    Usuarios user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Objeto de la clase SQLite
        helper = new SQLite(this);
        // Llamamos al método de la clase SQLite
        helper.getUsuario();

        inicializar();
        validarSesion();
    }

    // Método para inicializar los elementos
    public void inicializar() {
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContraseña = (EditText) findViewById(R.id.etContraseña);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        preferences = getSharedPreferences("Preferences", MODE_PRIVATE);
    }

    private void validarSesion(){
        preferences = getSharedPreferences("Preferences", MODE_PRIVATE);
        String usuario = preferences.getString("usuario", null);
        if(usuario != null){
            Intent i = new Intent(this, Pprincipal.class);
            i.putExtra("Usuario", usuario);
            finish();
            startActivity(i);
            overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
        }
    }

    // Accion del botón Ingresar
    public void Ingresar(View v) {
        if(etUsuario.getText().equals("") || etContraseña.getText().equals(""))
            Snackbar.make(v, "Campos vacios", Snackbar.LENGTH_SHORT).show();
        else {
            user = helper.login(etUsuario.getText().toString(), etContraseña.getText().toString());
            if (user != null) {
                getWindow().getDecorView().clearFocus();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("usuario", user.getUSUARIO());
                editor.commit();
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(Login.this, Pprincipal.class);
                        i.putExtra("Usuario", user.getUSUARIO());
                        finish();
                        startActivity(i);
                        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
                    }
                }, 2000);
            } else {
                Snackbar.make(v, "Usuario no encontrado", Snackbar.LENGTH_SHORT).setDuration(700)
                        .show();
            }
        }
    }

    // Acción del boton omitir
    public void Omitir (View v) {
        try{
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent i = new Intent(Login.this, Pprincipal.class);
                    i.putExtra("Usuario", "Invitado");
                    finish();
                    startActivity(i);
                    overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
                }
            }, 1000);
        }catch(Exception e){
            // vacio
        }
    }

    // Accion del botón Registrarse
    public void Registrarse(View v) {
        etUsuario.setText("");
        etContraseña.setText("");
        etContraseña.clearFocus();
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
    }

    private static final int INTERVALO = 2000; //2 segundos para salir
    private long tiempoPrimerClick;

    @Override
    public void onBackPressed(){
        if (tiempoPrimerClick + INTERVALO > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(this, "Vuelve a presionar para salir", Toast.LENGTH_SHORT).show();
        }
        tiempoPrimerClick = System.currentTimeMillis();
    }

}
