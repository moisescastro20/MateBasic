package com.principal.mathebasic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AprendMultiplicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprend_multiplicacion);
    }

    // Accion del botón regresar
    public void Back(View v) {
        finish();
        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
    }

}
