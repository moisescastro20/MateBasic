package com.principal.mathebasic.Entidades;

public class Usuarios {

    // Creando variables
    private int ID_USUARIO;
    private String NOMBRE_USUARIO;
    private String APELLIDO_USUARIO;
    private String USUARIO;
    private String CONTRASEÑA;
    private String TELF_EMAIL;
    private int EDAD;
    private String ROL_USUARIO;

    public Usuarios(){}

    // Constructor de la clase Usuarios
    public Usuarios(int ID_USUARIO, String NOMBRE_USUARIO, String APELLIDO_USUARIO, String USUARIO, String CONTRASEÑA, String TELF_EMAIL, int EDAD, String ROL_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
        this.NOMBRE_USUARIO = NOMBRE_USUARIO;
        this.APELLIDO_USUARIO = APELLIDO_USUARIO;
        this.USUARIO = USUARIO;
        this.CONTRASEÑA = CONTRASEÑA;
        this.TELF_EMAIL = TELF_EMAIL;
        this.EDAD = EDAD;
        this.ROL_USUARIO = ROL_USUARIO;
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getNOMBRE_USUARIO() {
        return NOMBRE_USUARIO;
    }

    public void setNOMBRE_USUARIO(String NOMBRE_USUARIO) {
        this.NOMBRE_USUARIO = NOMBRE_USUARIO;
    }

    public String getAPELLIDO_USUARIO() {
        return APELLIDO_USUARIO;
    }

    public void setAPELLIDO_USUARIO(String APELLIDO_USUARIO) {
        this.APELLIDO_USUARIO = APELLIDO_USUARIO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getCONTRASEÑA() {
        return CONTRASEÑA;
    }

    public void setCONTRASEÑA(String CONTRASEÑA) {
        this.CONTRASEÑA = CONTRASEÑA;
    }

    public String getTELF_EMAIL() {
        return TELF_EMAIL;
    }

    public void setTELF_EMAIL(String TELF_EMAIL) {
        this.TELF_EMAIL = TELF_EMAIL;
    }

    public int getEDAD() {
        return EDAD;
    }

    public void setEDAD(int EDAD) {
        this.EDAD = EDAD;
    }

    public String getROL_USUARIO() {
        return ROL_USUARIO;
    }

    public void setROL_USUARIO(String ROL_USUARIO) {
        this.ROL_USUARIO = ROL_USUARIO;
    }

}
