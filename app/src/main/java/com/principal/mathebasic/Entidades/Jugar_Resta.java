package com.principal.mathebasic.Entidades;

public class Jugar_Resta {

    // Creando variables
    private int ID_JRESTA;
    private String ID_USUARIO_JR;
    private int TOTAL_JRESTA;

    public Jugar_Resta(){
    }

    // Constructor de la clase JugarResta
    public Jugar_Resta(int ID_JRESTA, String ID_USUARIO_JR, int TOTAL_JRESTA) {
        this.ID_JRESTA = ID_JRESTA;
        this.ID_USUARIO_JR = ID_USUARIO_JR;
        this.TOTAL_JRESTA = TOTAL_JRESTA;
    }

    public int getID_JRESTA() {
        return ID_JRESTA;
    }

    public void setID_JRESTA(int ID_JRESTA) {
        this.ID_JRESTA = ID_JRESTA;
    }

    public String getID_USUARIO_JR() {
        return ID_USUARIO_JR;
    }

    public void setID_USUARIO_JR(String ID_USUARIO_JR) {
        this.ID_USUARIO_JR = ID_USUARIO_JR;
    }

    public int getTOTAL_JRESTA() {
        return TOTAL_JRESTA;
    }

    public void setTOTAL_JRESTA(int TOTAL_JRESTA) {
        this.TOTAL_JRESTA = TOTAL_JRESTA;
    }

}
