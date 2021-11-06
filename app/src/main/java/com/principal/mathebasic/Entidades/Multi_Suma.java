package com.principal.mathebasic.Entidades;

public class Multi_Suma {

    // Creando variables
    private int ID_MSUMA;
    private String ID_USUARIO_MS;
    private int GANES_MS;
    private int EMPATES_MS;
    private int PERDIDAS_MS;

    public Multi_Suma(){
    }

    // Constructor de la clase MultiSuma
    public Multi_Suma(int ID_JSUMA, String ID_USUARIO_JS, int GANES_MS, int EMPATES_MS, int PERDIDAS_MS) {
        this.ID_MSUMA = ID_MSUMA;
        this.ID_USUARIO_MS = ID_USUARIO_MS;
        this.GANES_MS = GANES_MS;
        this.EMPATES_MS = EMPATES_MS;
        this.PERDIDAS_MS = PERDIDAS_MS;
    }

    public int getID_MSUMA() {
        return ID_MSUMA;
    }

    public void setID_MSUMA(int ID_MSUMA) {
        this.ID_MSUMA = ID_MSUMA;
    }

    public String getID_USUARIO_MS() {
        return ID_USUARIO_MS;
    }

    public void setID_USUARIO_MS(String ID_USUARIO_MS) {
        this.ID_USUARIO_MS = ID_USUARIO_MS;
    }

    public int getGANES_MS() {
        return GANES_MS;
    }

    public void setGANES_MS(int GANES_MS) {
        this.GANES_MS = GANES_MS;
    }

    public int getEMPATES_MS() {
        return EMPATES_MS;
    }

    public void setEMPATES_MS(int EMPATES_MS) {
        this.EMPATES_MS = EMPATES_MS;
    }

    public int getPERDIDAS_MS() {
        return PERDIDAS_MS;
    }

    public void setPERDIDAS_MS(int PERDIDAS_MS) {
        this.PERDIDAS_MS = PERDIDAS_MS;
    }

}
