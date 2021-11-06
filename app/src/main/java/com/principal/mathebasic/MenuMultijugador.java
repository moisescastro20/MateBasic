package com.principal.mathebasic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuMultijugador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_multijugador);
    }

    // Accion del botón regresar
    public void Back(View v){
        finish();
        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
    }

    public void MultiSuma(View v){
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, MultiSuma.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_play_in, R.transition.zoom_play_out);
    }

    public void MultiResta(View v){
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, MultiResta.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_play_in, R.transition.zoom_play_out);
    }

    public void MultiMultip(View v){
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, MultiMultiplicacion.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_play_in, R.transition.zoom_play_out);
    }

    public void MultiPotencia(View v){
        // Recibiendo la variable usuario del activity anterior
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        Intent i = new Intent(this, MultiDivision.class);
        i.putExtra("Usuario", user);
        startActivity(i);
        overridePendingTransition(R.transition.zoom_play_in, R.transition.zoom_play_out);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
    }

}
