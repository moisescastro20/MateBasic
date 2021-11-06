package com.principal.mathebasic.Entidades;

public class Jugar_Potencia {

    // Creando variables
    private int ID_JPOTE;
    private String ID_USUARIO_JP;
    private int TOTAL_JPOTE;

    public Jugar_Potencia(){
    }

    // Constructor de la clase JugarPotencia
    public Jugar_Potencia(int ID_JPOTE, String ID_USUARIO_JP, int TOTAL_JPOTE) {
        this.ID_JPOTE = ID_JPOTE;
        this.ID_USUARIO_JP = ID_USUARIO_JP;
        this.TOTAL_JPOTE = TOTAL_JPOTE;
    }

    public int getID_JPOTE() {
        return ID_JPOTE;
    }

    public void setID_JPOTE(int ID_JPOTE) {
        this.ID_JPOTE = ID_JPOTE;
    }

    public String getID_USUARIO_JP() {
        return ID_USUARIO_JP;
    }

    public void setID_USUARIO_JP(String ID_USUARIO_JP) {
        this.ID_USUARIO_JP = ID_USUARIO_JP;
    }

    public int getTOTAL_JPOTE() {
        return TOTAL_JPOTE;
    }

    public void setTOTAL_JPOTE(int TOTAL_JPOTE) {
        this.TOTAL_JPOTE = TOTAL_JPOTE;
    }

}
