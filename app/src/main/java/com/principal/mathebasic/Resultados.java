package com.principal.mathebasic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.principal.mathebasic.Entidades.Jugar_Multip;
import com.principal.mathebasic.Entidades.Jugar_Potencia;
import com.principal.mathebasic.Entidades.Jugar_Resta;
import com.principal.mathebasic.Entidades.Jugar_Suma;
import com.principal.mathebasic.Entidades.Multi_Multip;
import com.principal.mathebasic.Entidades.Multi_Potencia;
import com.principal.mathebasic.Entidades.Multi_Resta;
import com.principal.mathebasic.Entidades.Multi_Suma;
import com.principal.mathebasic.SQLite.SQLite;

public class Resultados extends AppCompatActivity {

    TextView tvPuntosS, tvPartidasS, tvGanesS, tvEmpatesS, tvPerdidasS;
    TextView tvPuntosR, tvPartidasR, tvGanesR, tvEmpatesR, tvPerdidasR;
    TextView tvPuntosM, tvPartidasM, tvGanesM, tvEmpatesM, tvPerdidasM;
    TextView tvPuntosP, tvPartidasP, tvGanesP, tvEmpatesP, tvPerdidasP;

    // Referencia a la clase SQLite
    SQLite helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        // Objeto de la clase SQLite
        helper = new SQLite(this);

        inicializar();
        resultadosSuma();
        resultadosResta();
        resultadosMultiplicacion();
        resultadosPotencia();
    }

    // Método para inicializar los elementos
    public void inicializar() {
        tvPuntosS = (TextView) findViewById(R.id.tvPuntosS);
        tvPartidasS = (TextView) findViewById(R.id.tvPartidasS);
        tvGanesS = (TextView) findViewById(R.id.tvGanesS);
        tvEmpatesS = (TextView) findViewById(R.id.tvEmpatesS);
        tvPerdidasS = (TextView) findViewById(R.id.tvPerdidasS);

        tvPuntosR = (TextView) findViewById(R.id.tvPuntosR);
        tvPartidasR = (TextView) findViewById(R.id.tvPartidasR);
        tvGanesR = (TextView) findViewById(R.id.tvGanesR);
        tvEmpatesR = (TextView) findViewById(R.id.tvEmpatesR);
        tvPerdidasR = (TextView) findViewById(R.id.tvPerdidasR);

        tvPuntosM = (TextView) findViewById(R.id.tvPuntosM);
        tvPartidasM = (TextView) findViewById(R.id.tvPartidasM);
        tvGanesM = (TextView) findViewById(R.id.tvGanesM);
        tvEmpatesM = (TextView) findViewById(R.id.tvEmpatesM);
        tvPerdidasM = (TextView) findViewById(R.id.tvPerdidasM);

        tvPuntosP = (TextView) findViewById(R.id.tvPuntosP);
        tvPartidasP = (TextView) findViewById(R.id.tvPartidasP);
        tvGanesP = (TextView) findViewById(R.id.tvGanesP);
        tvEmpatesP = (TextView) findViewById(R.id.tvEmpatesP);
        tvPerdidasP = (TextView) findViewById(R.id.tvPerdidasP);
    }

    public void resultadosSuma() {
        try {
            Bundle extras = getIntent().getExtras();
            String user = extras.getString("Usuario");
            Jugar_Suma jugarS = helper.mostrarResultadoJS(user);
            Multi_Suma multiS = helper.mostrarResultadoMS(user);
            tvPuntosS.setText(jugarS.getTOTAL_JSUMA() + " puntos");
            tvPartidasS.setText(jugarS.getID_JSUMA() + " partidas");
            tvGanesS.setText(multiS.getGANES_MS() + " ganes");
            tvEmpatesS.setText(multiS.getEMPATES_MS() + " empates");
            tvPerdidasS.setText(multiS.getPERDIDAS_MS() + " perdidas");
        } catch (Exception e) {
        }
    }

    public void resultadosResta() {
        try {
            Bundle extras = getIntent().getExtras();
            String user = extras.getString("Usuario");
            Jugar_Resta jugarR = helper.mostrarResultadoJR(user);
            Multi_Resta multiR = helper.mostrarResultadoMR(user);
            tvPuntosR.setText(jugarR.getTOTAL_JRESTA() + " puntos");
            tvPartidasR.setText(jugarR.getID_JRESTA() + " partidas");
            tvGanesR.setText(multiR.getGANES_MR() + " ganes");
            tvEmpatesR.setText(multiR.getEMPATES_MR() + " empates");
            tvPerdidasR.setText(multiR.getPERDIDAS_MR() + " perdidas");
        } catch (Exception e) {
        }
    }

    public void resultadosMultiplicacion() {
        try {
            Bundle extras = getIntent().getExtras();
            String user = extras.getString("Usuario");
            Jugar_Multip jugarM = helper.mostrarResultadoJM(user);
            Multi_Multip multiM = helper.mostrarResultadoMM(user);
            tvPuntosM.setText(jugarM.getTOTAL_JMULTIP() + " puntos");
            tvPartidasM.setText(jugarM.getID_JMULTIP() + " partidas");
            tvGanesM.setText(multiM.getGANES_MM() + " ganes");
            tvEmpatesM.setText(multiM.getEMPATES_MM() + " empates");
            tvPerdidasM.setText(multiM.getPERDIDAS_MM() + " perdidas");
        } catch (Exception e) {
        }
    }

    public void resultadosPotencia() {
        try {
            Bundle extras = getIntent().getExtras();
            String user = extras.getString("Usuario");
            Jugar_Potencia jugarP = helper.mostrarResultadoJP(user);
            Multi_Potencia multiP = helper.mostrarResultadoMP(user);
            tvPuntosP.setText(jugarP.getTOTAL_JPOTE() + " puntos");
            tvPartidasP.setText(jugarP.getID_JPOTE() + " partidas");
            tvGanesP.setText(multiP.getGANES_MP() + " ganes");
            tvEmpatesP.setText(multiP.getEMPATES_MP() + " empates");
            tvPerdidasP.setText(multiP.getPERDIDAS_MP() + " perdidas");
        } catch (Exception e) {
        }
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
