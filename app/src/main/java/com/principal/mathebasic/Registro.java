package com.principal.mathebasic;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.principal.mathebasic.SQLite.SQLite;

public class Registro extends AppCompatActivity {

    // Referencias a los elementos de nuestro Activity
    EditText etNombre, etApellido, etUsuario, etContraseña, etCelEmail, etEdad;
    Button btnAceptar;
    // Referencia a la clase SQLite
    SQLite helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        // Objeto de la clase SQLite
        helper = new SQLite(this);

        inicializar();
    }

    // Método para inicializar los elementos
    public void inicializar() {
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContraseña = (EditText) findViewById(R.id.etContraseña);
        etCelEmail = (EditText) findViewById(R.id.etCelEmail);
        etEdad = (EditText) findViewById(R.id.etEdad);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
    }

    // Accion del boton Aceptar
    public void Aceptar(View v) {
        // Validando campos vacios
        if (etNombre.getText().toString().equals("") || etApellido.getText().toString().equals("") ||
                etUsuario.getText().toString().equals("") || etContraseña.getText().toString().equals("") ||
                etCelEmail.getText().toString().equals("") || etEdad.getText().toString().equals("")) {
            Snackbar.make(v, "Campos incompletos", Snackbar.LENGTH_SHORT).setDuration(700)
                    .show();
        } else {
                // Existencia del usuario
                int user = helper.existenciaUsuario(etUsuario.getText().toString());
                if(user != 1 || etUsuario.getText().toString().equals("Invitado")) {
                    Snackbar.make(v, "Este usuario ya existe", Snackbar.LENGTH_SHORT).setDuration(700)
                            .show();
                } else {
                    registrarUsuariosSQL();
                    Intent i = new Intent(this, Login.class);
                    finish();
                    startActivity(i);
                    overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
                }
        }
    }

    // Método que inserta los datos a nuestra tabla Usuarios
    private void registrarUsuariosSQL() {
        String rolUsuario = "Cliente";
        helper.insertUsuario(etUsuario.getText().toString(), etContraseña.getText().toString(), etNombre.getText().toString(), etApellido.getText().toString(), etCelEmail.getText().toString(), etEdad.getText().toString(), rolUsuario);
    }

    // Accion del botón regresar
    public void Cancelar(View v) {
        finish();
        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
    }

    @Override
    public void onBackPressed(){
        finish();
        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
    }

}
