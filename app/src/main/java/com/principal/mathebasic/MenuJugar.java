package com.principal.mathebasic;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuJugar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jugar);
    }

    public void JugarSuma(View v){
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, JugarSuma.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_play_in, R.transition.zoom_play_out);
    }

    public void JugarResta(View v){
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, JugarResta.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_play_in, R.transition.zoom_play_out);
    }

    public void JugarMultiplicacion(View v){
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, JugarMultiplicacion.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_play_in, R.transition.zoom_play_out);
    }

    public void JugarPotencia(View v){
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, JugarDivision.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_play_in, R.transition.zoom_play_out);
    }

    // Accion del botón regresar
    public void Back(View v){
        finish();
        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
    }

}
