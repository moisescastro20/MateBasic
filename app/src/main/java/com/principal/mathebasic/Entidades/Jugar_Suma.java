package com.principal.mathebasic.Entidades;

public class Jugar_Suma {

    // Creando variables
    private int ID_JSUMA;
    private String ID_USUARIO_JS;
    private int TOTAL_JSUMA;

    public Jugar_Suma(){
    }

    // Constructor de la clase JugarSuma
    public Jugar_Suma(int ID_JSUMA, String ID_USUARIO_JS, int TOTAL_JSUMA) {
        this.ID_JSUMA = ID_JSUMA;
        this.ID_USUARIO_JS = ID_USUARIO_JS;
        this.TOTAL_JSUMA = TOTAL_JSUMA;
    }

    public int getID_JSUMA() {
        return ID_JSUMA;
    }

    public void setID_JSUMA(int ID_JSUMA) {
        this.ID_JSUMA = ID_JSUMA;
    }

    public String getID_USUARIO_JS() {
        return ID_USUARIO_JS;
    }

    public void setID_USUARIO_JS(String ID_USUARIO_JS) {
        this.ID_USUARIO_JS = ID_USUARIO_JS;
    }

    public int getTOTAL_JSUMA() {
        return TOTAL_JSUMA;
    }

    public void setTOTAL_JSUMA(int TOTAL_JSUMA) {
        this.TOTAL_JSUMA = TOTAL_JSUMA;
    }

}
