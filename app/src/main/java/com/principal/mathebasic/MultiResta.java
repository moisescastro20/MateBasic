package com.principal.mathebasic;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import com.principal.mathebasic.SQLite.SQLite;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class MultiResta extends AppCompatActivity {

    // Referencias a los elementos de nuestro Activity
    EditText etValor;
    TextView tvNum1, tvNum2, tvSigno, tvSignoIgual, tvPuntos1, tvPuntos2, tvTime, tvCont, tvTitulo;
    Button btnAceptar;

    // Números al azar y cantidad de puntos por partida
    int numero1, numero2, puntos1, puntos2, cont;

    // Referencia a la clase SQLite
    SQLite helper;

    CountDownTimer Timer;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_resta);
        // Objeto de la clase SQLite
        helper = new SQLite(this);

        inicializar();
    }

    // Método para inicializar los elementos
    public void inicializar() {
        try {
            btnAceptar = (Button) findViewById(R.id.btnAceptar);
            etValor = (EditText) findViewById(R.id.etValor);
            tvNum1 = (TextView) findViewById(R.id.tvNum1);
            tvNum2 = (TextView) findViewById(R.id.tvNum2);
            tvSigno = (TextView) findViewById(R.id.tvSigno);
            tvSignoIgual = (TextView) findViewById(R.id.tvSignoIgual);
            tvTime = (TextView) findViewById(R.id.tvTime);
            tvCont = (TextView) findViewById(R.id.tvCont);
            tvTitulo = (TextView) findViewById(R.id.tvTitulo);
            tvPuntos1 = (TextView) findViewById(R.id.tvPuntos1);
            tvPuntos2 = (TextView) findViewById(R.id.tvPuntos2);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);

            // Campo de texto Valor, deshabilitado
            etValor.setEnabled(false);
            etValor.setInputType(InputType.TYPE_NULL);
            puntos1 = 0;
            puntos2 = 0;
            cont = 0;
            // Cantidad de puntos de la partida
            tvPuntos1.setText(puntos1 + " Puntos");
            tvPuntos2.setText(puntos2 + " Puntos");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    tvSigno.setText("-");
                    tvSignoIgual.setText("=");
                    etValor.setText("");
                    etValor.setTextColor(getResources().getColor(R.color.resta));
                    // Arranque del timer con 60000 milisegundos (1 minuto), al incio de la actividad
                    countTimer();
                    timer();
                    resta();
                }
            }, 6000);
        } catch (Exception e) {
            // vacio
        }
    }

    public void resta() {
        // Niveles del juego, según los puntos
        int n = 0;
        if (puntos1 <= 8)
            n = 10;
        else if (puntos1 <= 16)
            n = 30;
        else if (puntos1 <= 24)
            n = 60;
        else
            n = 90;

        // Números al azar (random)
        numero1 = (int) (Math.random() * n) + 1;
        numero2 = (int) (Math.random() * n) + 1;

        if (numero1 > numero2) {
            // Almacenando los números al azar, en los respectivos TextView
            tvNum1.setText(String.valueOf(numero1));
            tvNum2.setText(String.valueOf(numero2));
        } else
            resta();
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
            int resultado = numero1 - numero2;
            int val = Integer.parseInt(etValor.getText().toString());
            if (resultado == val) {
                // LLamando a la Actividad que da por correcto el resultado
                startActivity(new Intent(this, SplashCorrecto.class));
                overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
                nextPoint(1);
            } else {
                Snackbar.make(v, "Incorrecto", Snackbar.LENGTH_SHORT).setDuration(700)
                        .show();
                etValor.setText("");
                String valu = etValor.getText().toString();
                etValor.setText(valu);
                nextPoint(-1);
            }
        } catch (Exception e) { /* vacio*/ }
    }

    // Método que ejecuta las acciones luego de 300 milisegundos
    public void nextPoint(final int res) {
        if (res == 1) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Timer.cancel();
                    timer();
                }
            }, 550);
        } else {
            Timer.cancel();
            timer();
        }

        if (res == 1) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    nextPlayer();

                    if (cont % 2 == 0) {
                        puntos2++;
                        tvPuntos2.setText(puntos2 + " Puntos");
                    } else {
                        puntos1++;
                        tvPuntos1.setText(puntos1 + " Puntos");
                    }
                }
            }, 400);
        } else {
            nextPlayer();
        }
    }

    public void nextPlayer() {
        resta();
        etValor.setText("");
        cont++;

        if (cont % 2 == 0) {
            tvPuntos2.setBackgroundColor(Color.WHITE);
            tvPuntos1.setBackgroundColor(Color.parseColor("#DEE0E3"));
        } else {
            tvPuntos2.setBackgroundColor(Color.parseColor("#DEE0E3"));
            tvPuntos1.setBackgroundColor(Color.WHITE);
        }
    }

    // Cuenta regresiva
    public void countTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTime.setText(String.format(Locale.getDefault(), "00:%d", millisUntilFinished / 1000));
            }

            public void onFinish() {
                try {
                    int numJugador = 0, puntos = 0, resultado = 0;
                    Timer.cancel();
                    if (puntos1 > puntos2) {
                        numJugador = 1;
                        puntos = puntos1;
                    } else if (puntos2 > puntos1) {
                        numJugador = 2;
                        puntos = puntos2;
                    } else {
                        puntos = puntos1;
                        resultado = 3;
                    }
                    dialogFinal(numJugador, puntos, resultado);
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

    public void tick() {
        if (tvCont.getText().equals("00:2"))
            tvTitulo.setTextSize(16);
        else if (tvCont.getText().equals("00:1"))
            tvTitulo.setTextSize(15);
        else if (tvCont.getText().equals("00:0"))
            tvTitulo.setTextSize(16);
        else
            tvTitulo.setTextSize(15);
    }

    // Cuenta regresiva
    public void timer() {
        Timer = new CountDownTimer(7000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvCont.setText(String.format(Locale.getDefault(), "00:%d", millisUntilFinished / 1000));
                String time = String.format(Locale.getDefault(), "%d", millisUntilFinished / 1000);
                String barTime = (String) time;
                progressBar.setProgress(Integer.parseInt(barTime));
                tick();
            }

            public void onFinish() {
                try {
                    nextPoint(-1);
                } catch (Exception e) {
                    //vacio
                }
            }
        }.start();
    }

    // Deshabilitar botones al finalizar el tiempo
    public void deshabilitar() {
        etValor.setEnabled(false);
        etValor.setTextColor(Color.WHITE);
        btnAceptar.setEnabled(false);
    }

    // Diálogo que se muestra al finalizar el tiempo de la partida
    public void dialogFinal(int numJugador, int puntos, int resultado) {
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Usuario");
        String titulo = "", mensaje = "";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (resultado == 0) {
            titulo = "¡Ganador!";
            mensaje = "Jugador " + numJugador + "\nCon un total de: " + puntos + " puntos";
            if (user != "Invitado") {
                if (numJugador == 1) {
                    helper.insertMultiResta(user, 1, 0, 0);
                } else if (numJugador == 2) {
                    helper.insertMultiResta(user, 0, 0, 1);
                }
            }
        } else {
            titulo = "¡Empate!";
            mensaje = "Con un total de: " + puntos + " puntos";
            if (user != "Invitado")
                helper.insertMultiResta(user, 0, 1, 0);
        }
        // Configura el titulo.
        builder.setTitle(titulo);
        // Configura el mensaje.
        builder
                .setMessage(mensaje)
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
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
    public void onBackPressed() {
        dialogBack();
    }

}
