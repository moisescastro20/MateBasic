package com.principal.mathebasic.Entidades;

public class Multi_Multip {

    // Creando variables
    private int ID_MMULTIP;
    private String ID_USUARIO_MM;
    private int GANES_MM;
    private int EMPATES_MM;
    private int PERDIDAS_MM;

    public Multi_Multip(){
    }

    // Constructor de la clase MultiMltip
    public Multi_Multip(int ID_MMULTIP, String ID_USUARIO_MM, int GANES_MM, int EMPATES_MM, int PERDIDAS_MM) {
        this.ID_MMULTIP = ID_MMULTIP;
        this.ID_USUARIO_MM = ID_USUARIO_MM;
        this.GANES_MM = GANES_MM;
        this.EMPATES_MM = EMPATES_MM;
        this.PERDIDAS_MM = PERDIDAS_MM;
    }

    public int getID_MMULTIP() {
        return ID_MMULTIP;
    }

    public void setID_MMULTIP(int ID_MMULTIP) {
        this.ID_MMULTIP = ID_MMULTIP;
    }

    public String getID_USUARIO_MM() {
        return ID_USUARIO_MM;
    }

    public void setID_USUARIO_MM(String ID_USUARIO_MM) {
        this.ID_USUARIO_MM = ID_USUARIO_MM;
    }

    public int getGANES_MM() {
        return GANES_MM;
    }

    public void setGANES_MM(int GANES_MM) {
        this.GANES_MM = GANES_MM;
    }

    public int getEMPATES_MM() {
        return EMPATES_MM;
    }

    public void setEMPATES_MM(int EMPATES_MM) {
        this.EMPATES_MM = EMPATES_MM;
    }

    public int getPERDIDAS_MM() {
        return PERDIDAS_MM;
    }

    public void setPERDIDAS_MM(int PERDIDAS_MM) {
        this.PERDIDAS_MM = PERDIDAS_MM;
    }

}
