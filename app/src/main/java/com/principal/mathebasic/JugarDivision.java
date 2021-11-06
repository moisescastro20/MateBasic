package com.principal.mathebasic;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.principal.mathebasic.SQLite.SQLite;

import java.util.Locale;

public class JugarDivision extends AppCompatActivity {

    // Referencias a los elementos de nuestro Activity
    EditText etValor;
    TextView tvNum1, tvNum2, tvSigno, tvSignoIgual, tvPuntos, tvTime;
    Button btnAceptar;

    // Números al azar y cantidad de puntos por partida
    double numero1, numero2;
    int puntos;

    ProgressBar progressBar;

    // Referencia a la clase SQLite
    SQLite helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar_division);
        // Objeto de la clase SQLite
        helper = new SQLite(this);

        inicializar();
    }

    // Método para inicializar los elementos
    public void inicializar() {
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        etValor = (EditText) findViewById(R.id.etValor);
        tvNum1 = (TextView) findViewById(R.id.tvNum1);
        tvNum2 = (TextView) findViewById(R.id.tvNum2);
        tvSigno = (TextView) findViewById(R.id.tvSigno);
        tvSignoIgual = (TextView) findViewById(R.id.tvSignoIgual);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvPuntos = (TextView) findViewById(R.id.tvPuntos);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        // Campo de texto Valor, deshabilitado
        etValor.setEnabled(false);
        etValor.setInputType(InputType.TYPE_NULL);
        puntos = 0;
        // Cantidad de puntos de la partida
        tvPuntos.setText(puntos + " Puntos");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                tvSigno.setText("/");
                tvSignoIgual.setText("=");
                etValor.setText("");
                etValor.setTextColor(getResources().getColor(R.color.division));
                // Arranque del timer con 60000 milisegundos (1 minuto), al incio de la actividad
                countTimer();
                division();
            }
        }, 6000);
    }

    public void division() {
        // Niveles del juego, según los puntos
        int n = 0;
        if (puntos <= 15)
            n = 20;
        else if (puntos <= 30)
            n = 40;
        else if (puntos <= 45)
            n = 80;
        else
            n = 120;

        // Números al azar (random)
        numero1 = (int) (Math.random() * n) + 1;
        numero2 = (int) (Math.random() * n) + 1;

        double res = numero1 / numero2;

        if (res % 2 == 0) {
            // Almacenando los números al azar, en los respectivos TextView
            tvNum1.setText(String.valueOf((int) numero1));
            tvNum2.setText(String.valueOf((int) numero2));
        } else
            division();
    }

    // Acción de los botones
    //BOTON NUMERO "1"
    public void boton1(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "1";
        etValor.setText(captura);
    }

    //BOTON NUMERO "2"
    public void boton2(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "2";
        etValor.setText(captura);
    }

    //BOTON NUMERO "3"
    public void boton3(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "3";
        etValor.setText(captura);
    }

    //BOTON NUMERO "4"
    public void boton4(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "4";
        etValor.setText(captura);
    }

    //BOTON NUMERO "5"
    public void boton5(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "5";
        etValor.setText(captura);

    }

    //BOTON NUMERO "6"
    public void boton6(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "6";
        etValor.setText(captura);
    }

    //BOTON NUMERO "7"
    public void boton7(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "7";
        etValor.setText(captura);
    }

    //BOTON NUMERO "8"
    public void boton8(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "8";
        etValor.setText(captura);
    }

    //BOTON NUMERO "9"
    public void boton9(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "9";
        etValor.setText(captura);
    }

    //BOTON NUMERO "0"
    public void boton0(View v) {
        String captura = etValor.getText().toString();
        captura = captura + "0";
        etValor.setText(captura);
    }

    // Acción del botón Borrar, que elimina un caracter de la cadena
    public void borrar(View v) {
        try {
            String captura = etValor.getText().toString();
            captura = captura.substring(0, captura.length() - 1);
            etValor.setText(captura);
        } catch (Exception e) {
        }
    }

    // Acción del botón aceptar, que verifica si el
    // valor digitado por el usuario es igual, al resultado de la operación
    public void aceptar(View v) {
        try {
            double resultado = numero1 / numero2;
            int val = Integer.parseInt(etValor.getText().toString());
            if (resultado == val) {
                // LLamando a la Actividad que da por correcto el resultado
                startActivity(new Intent(this, SplashCorrecto.class));
                overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
                nextPoint();
            } else
                Snackbar.make(v, "Incorrecto", Snackbar.LENGTH_SHORT).setDuration(700)
                        .show();
            etValor.setText((int) resultado);
            String valu = etValor.getText().toString();
            etValor.setText(valu);
        } catch (Exception e) { /* vacio*/ }
    }

    // Método que ejecuta las acciones luego de 300 milisegundos
    public void nextPoint() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                division();
                etValor.setText("");
                puntos++;
                tvPuntos.setText(puntos + " Puntos");
            }
        }, 500);
    }

    // Cuenta regresiva
    public void countTimer(){
        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTime.setText(String.format(Locale.getDefault(), "00:%d", millisUntilFinished / 1000));
                String time = String.format(Locale.getDefault(), "%d", millisUntilFinished / 1000);
                String barTime = (String) time;
                progressBar.setProgress(Integer.parseInt(barTime));
                tick();
            }

            public void onFinish() {
                try {
                    dialogFinal();
                    tvTime.setText("00:0");
                    deshabilitar();
                } catch (Exception e) {
                    //vacio
                }
            }
        }.start();
    }

    CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
        public void onTick(long millisUntilFinished) {
            tvNum2.setText(String.format(Locale.getDefault(), "%d", millisUntilFinished / 1000));
        }

        public void onFinish() {
            try {

            } catch (Exception e) {
                //vacio
            }
        }
    }.start();

    public void tick(){
        if(tvTime.getText().equals("00:10"))
            tvTime.setTextSize(21);
        else if(tvTime.getText().equals("00:9"))
            tvTime.setTextSize(18);
        else if(tvTime.getText().equals("00:8"))
            tvTime.setTextSize(21);
        else if(tvTime.getText().equals("00:7"))
            tvTime.setTextSize(18);
        else if(tvTime.getText().equals("00:6"))
            tvTime.setTextSize(21);
        else if(tvTime.getText().equals("00:5"))
            tvTime.setTextSize(18);
        else if(tvTime.getText().equals("00:4"))
            tvTime.setTextSize(23);
        else if(tvTime.getText().equals("00:3"))
            tvTime.setTextSize(18);
        else if(tvTime.getText().equals("00:2"))
            tvTime.setTextSize(23);
        else if(tvTime.getText().equals("00:1"))
            tvTime.setTextSize(18);
        else if(tvTime.getText().equals("00:0"))
            tvTime.setTextSize(23);
    }

    // Deshabilitar botones al finalizar el tiempo
    public void deshabilitar() {
        etValor.setEnabled(false);
        etValor.setTextColor(Color.WHITE);
        btnAceptar.setEnabled(false);
    }

    // Diálogo que se muestra al finalizar el tiempo de la partida
    public void dialogFinal() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Configura el titulo.
        if (puntos <= 5) {
            builder.setTitle("¡Bien!");
        } else if (puntos > 5 && puntos <= 10) {
            builder.setTitle("¡Muy Bien!");
        } else if (puntos > 10) {
            builder.setTitle("¡Excelente!");
        }

        // Configura el mensaje.
        builder
                .setMessage("Has hecho un total de: " + puntos + " puntos")
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Recibiendo la variable usuario del activity anterior
                        Bundle extras = getIntent().getExtras();
                        String user = extras.getString("Usuario");
                        if(user!="Invitado")
                        helper.insertJugarPotencia(user, puntos);
                        finish();
                        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
                    }
                }).create().show();
    }

    // Diálogo que se muestra al intentar regrasar
    public void dialogBack() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Configura el mensaje.
        builder
                .setMessage("¿Deseas salir de la partida?\n")
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        overridePendingTransition(R.transition.fade_back_in, R.transition.fade_back_out);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create().show();
    }

    // Accion del botón regresar
    public void Back(View v) {
        dialogBack();
    }

    @Override
    public void onBackPressed()
    {
        dialogBack();
    }
}
