package com.principal.mathebasic.Entidades;

public class Multi_Resta {

    // Creando variables
    private int ID_MRESTA;
    private String ID_USUARIO_MR;
    private int GANES_MR;
    private int EMPATES_MR;
    private int PERDIDAS_MR;

    public Multi_Resta(){
    }

    // Constructor de la clase MultiResta
    public Multi_Resta(int ID_MRESTA, String ID_USUARIO_MR, int GANES_MR, int EMPATES_MR, int PERDIDAS_MR) {
        this.ID_MRESTA = ID_MRESTA;
        this.ID_USUARIO_MR = ID_USUARIO_MR;
        this.GANES_MR = GANES_MR;
        this.EMPATES_MR = EMPATES_MR;
        this.PERDIDAS_MR = PERDIDAS_MR;
    }

    public int getID_MRESTA() {
        return ID_MRESTA;
    }

    public void setID_MRESTA(int ID_MRESTA) {
        this.ID_MRESTA = ID_MRESTA;
    }

    public String getID_USUARIO_MR() {
        return ID_USUARIO_MR;
    }

    public void setID_USUARIO_MR(String ID_USUARIO_MR) {
        this.ID_USUARIO_MR = ID_USUARIO_MR;
    }

    public int getGANES_MR() {
        return GANES_MR;
    }

    public void setGANES_MR(int GANES_MR) {
        this.GANES_MR = GANES_MR;
    }

    public int getEMPATES_MR() {
        return EMPATES_MR;
    }

    public void setEMPATES_MR(int EMPATES_MR) {
        this.EMPATES_MR = EMPATES_MR;
    }

    public int getPERDIDAS_MR() {
        return PERDIDAS_MR;
    }

    public void setPERDIDAS_MR(int PERDIDAS_MR) {
        this.PERDIDAS_MR = PERDIDAS_MR;
    }

}
