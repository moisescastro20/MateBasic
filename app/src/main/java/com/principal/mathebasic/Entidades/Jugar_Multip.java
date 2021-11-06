package com.principal.mathebasic.Entidades;

public class Jugar_Multip {

    // Creando variables
    private int ID_JMULTIP;
    private String ID_USUARIO_JM;
    private int TOTAL_JMULTIP;

    public Jugar_Multip(){
    }

    // Constructor de la clase JugarMultiplicacion
    public Jugar_Multip(int ID_JMULTIP, String ID_USUARIO_JM, int TOTAL_JMULTIP) {
        this.ID_JMULTIP = ID_JMULTIP;
        this.ID_USUARIO_JM = ID_USUARIO_JM;
        this.TOTAL_JMULTIP = TOTAL_JMULTIP;
    }

    public int getID_JMULTIP() {
        return ID_JMULTIP;
    }

    public void setID_JMULTIP(int ID_JMULTIP) {
        this.ID_JMULTIP = ID_JMULTIP;
    }

    public String getID_USUARIO_JM() {
        return ID_USUARIO_JM;
    }

    public void setID_USUARIO_JM(String ID_USUARIO_JM) {
        this.ID_USUARIO_JM = ID_USUARIO_JM;
    }

    public int getTOTAL_JMULTIP() {
        return TOTAL_JMULTIP;
    }

    public void setTOTAL_JMULTIP(int TOTAL_JMULTIP) {
        this.TOTAL_JMULTIP = TOTAL_JMULTIP;
    }

}
