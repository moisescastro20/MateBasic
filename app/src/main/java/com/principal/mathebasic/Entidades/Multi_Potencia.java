package com.principal.mathebasic.Entidades;

public class Multi_Potencia {

    // Creando variables
    private int ID_MPOTE;
    private String ID_USUARIO_MP;
    private int GANES_MP;
    private int EMPATES_MP;
    private int PERDIDAS_MP;

    public Multi_Potencia(){
    }

    // Constructor de la clase MultiSuma
    public Multi_Potencia(int ID_MPOTE, String ID_USUARIO_MP, int GANES_MP, int EMPATES_MP, int PERDIDAS_MP) {
        this.ID_MPOTE = ID_MPOTE;
        this.ID_USUARIO_MP = ID_USUARIO_MP;
        this.GANES_MP = GANES_MP;
        this.EMPATES_MP = EMPATES_MP;
        this.PERDIDAS_MP = PERDIDAS_MP;
    }

    public int getID_MPOTE() {
        return ID_MPOTE;
    }

    public void setID_MPOTE(int ID_MPOTE) {
        this.ID_MPOTE = ID_MPOTE;
    }

    public String getID_USUARIO_MP() {
        return ID_USUARIO_MP;
    }

    public void setID_USUARIO_MP(String ID_USUARIO_MP) {
        this.ID_USUARIO_MP = ID_USUARIO_MP;
    }

    public int getGANES_MP() {
        return GANES_MP;
    }

    public void setGANES_MP(int GANES_MP) {
        this.GANES_MP = GANES_MP;
    }

    public int getEMPATES_MP() {
        return EMPATES_MP;
    }

    public void setEMPATES_MP(int EMPATES_MP) {
        this.EMPATES_MP = EMPATES_MP;
    }

    public int getPERDIDAS_MP() {
        return PERDIDAS_MP;
    }

    public void setPERDIDAS_MP(int PERDIDAS_MP) {
        this.PERDIDAS_MP = PERDIDAS_MP;
    }

}
