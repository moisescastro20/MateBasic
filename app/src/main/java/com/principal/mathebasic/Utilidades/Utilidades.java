package com.principal.mathebasic.Utilidades;

public class Utilidades {

    // ---------- Tabla Usuarios ----------
    // Nombre de la tabla y campos de la tabla
    public static final String TABLE_USUARIOS = "Usuarios";   // Table Name
    public static final String ID_USUARIO = "Id_Usuario";     //  (Primary Key)
    public static final String USUARIO = "Usuario";
    public static final String CONTRASEÑA = "Password";
    public static final String NOMBRE = "Nombre";
    public static final String APELLIDO = "Apellido";
    public static final String CEL_EMAIL = "Cel_Email";
    public static final String EDAD = "Edad";
    public static final String ROL = "Rol";
    // Cadena para crear la tabla Usuarios
    public static final String CREATE_TABLE_USUARIOS = "CREATE TABLE IF NOT EXISTS " + TABLE_USUARIOS +
            " (" + ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            USUARIO + " VARCHAR(100) ," +
            CONTRASEÑA + " VARCHAR(100)," +
            NOMBRE + " VARCHAR(150)," +
            APELLIDO + " VARCHAR(150)," +
            CEL_EMAIL + " VARCHAR(150)," +
            EDAD + " INTEGER," +
            ROL + " VARCHAR(50));";
    // Borrar la tabla, si ya existe
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_USUARIOS;

    // ---------- Tabla JugarSuma ----------
    // Nombre de la tabla y campos de la tabla
    public static final String TABLE_JSUMA = "Jugar_Suma";   // Table Name
    public static final String ID_JSUMA = "Id_Jugar_Sum";     //  (Primary Key)
    public static final String ID_USUARIO_JS = "Usuario";
    public static final String TOTAL_JSUMA = "Total_Jugar_Sum";
    // Cadena para crear la tabla JugarSuma
    public static final String CREATE_TABLE_JSUMA = "CREATE TABLE IF NOT EXISTS " + TABLE_JSUMA +
            " (" + ID_JSUMA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ID_USUARIO_JS + " VARCHAR(100)," +
            TOTAL_JSUMA + " INTEGER );";
    // Borrar la tabla, si ya existe
    public static final String DROP_TABLE_JS = "DROP TABLE IF EXISTS " + TABLE_JSUMA;

    // ---------- Tabla JugarResta ----------
    // Nombre de la tabla y campos de la tabla
    public static final String TABLE_JRESTA = "Jugar_Resta";   // Table Name
    public static final String ID_JRESTA = "Id_Jugar_Rest";     //  (Primary Key)
    public static final String ID_USUARIO_JR = "Usuario";
    public static final String TOTAL_JRESTA = "Total_Jugar_Rest";
    // Cadena para crear la tabla JugarResta
    public static final String CREATE_TABLE_JRESTA = "CREATE TABLE IF NOT EXISTS " + TABLE_JRESTA +
            " (" + ID_JRESTA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ID_USUARIO_JR + " VARCHAR(100)," +
            TOTAL_JRESTA + " INTEGER );";
    // Borrar la tabla, si ya existe
    public static final String DROP_TABLE_JR = "DROP TABLE IF EXISTS " + TABLE_JRESTA;

    // ---------- Tabla JugarMultip ----------
    // Nombre de la tabla y campos de la tabla
    public static final String TABLE_JMULTIP = "Jugar_Multip";   // Table Name
    public static final String ID_JMULTIP = "Id_Jugar_Multip";     //  (Primary Key)
    public static final String ID_USUARIO_JM = "Usuario";
    public static final String TOTAL_JMULTIP = "Total_Jugar_Multip";
    // Cadena para crear la tabla JugarMultip
    public static final String CREATE_TABLE_JMULTIP = "CREATE TABLE IF NOT EXISTS " + TABLE_JMULTIP +
            " (" + ID_JMULTIP + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ID_USUARIO_JM + " VARCHAR(100)," +
            TOTAL_JMULTIP + " INTEGER );";
    // Borrar la tabla, si ya existe
    public static final String DROP_TABLE_JM = "DROP TABLE IF EXISTS " + TABLE_JMULTIP;

    // ---------- Tabla JugarPotencia ----------
    // Nombre de la tabla y campos de la tabla
    public static final String TABLE_JPOTE = "Jugar_Potencia";   // Table Name
    public static final String ID_JPOTE = "Id_Jugar_Pote";     //  (Primary Key)
    public static final String ID_USUARIO_JP = "Usuario";
    public static final String TOTAL_JPOTE = "Total_Jugar_Pote";
    // Cadena para crear la tabla JugarPotencia
    public static final String CREATE_TABLE_JPOTE = "CREATE TABLE IF NOT EXISTS " + TABLE_JPOTE +
            " (" + ID_JPOTE + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ID_USUARIO_JP + " VARCHAR(100)," +
            TOTAL_JPOTE + " INTEGER );";
    // Borrar la tabla, si ya existe
    public static final String DROP_TABLE_JP = "DROP TABLE IF EXISTS " + TABLE_JPOTE;


    // ---------- Tabla MultijugadorSuma ----------
    // Nombre de la tabla y campos de la tabla
    public static final String TABLE_MSUMA = "Multi_Suma";   // Table Name
    public static final String ID_MSUMA = "Id_Multi_Sum";     //  (Primary Key)
    public static final String ID_USUARIO_MS= "Usuario";
    public static final String GANES_MS = "Ganes_Multi_Sum";
    public static final String EMPATES_MS = "Empates_Multi_Sum";
    public static final String PERDIDAS_MS = "Perdidas_Multi_Sum";
    // Cadena para crear la tabla MultiplicarSuma
    public static final String CREATE_TABLE_MSUMA = "CREATE TABLE IF NOT EXISTS " + TABLE_MSUMA +
            " (" + ID_MSUMA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ID_USUARIO_MS + " VARCHAR(100)," +
            GANES_MS + " INTEGER," +
            EMPATES_MS + " INTEGER," +
            PERDIDAS_MS + " INTEGER );";
    // Borrar la tabla, si ya existe
    public static final String DROP_TABLE_MS = "DROP TABLE IF EXISTS " + TABLE_MSUMA;

    // ---------- Tabla MultijugadorResta ----------
    // Nombre de la tabla y campos de la tabla
    public static final String TABLE_MRESTA = "Multi_Resta";   // Table Name
    public static final String ID_MRESTA = "Id_Multi_Rest";     //  (Primary Key)
    public static final String ID_USUARIO_MR= "Usuario";
    public static final String GANES_MR = "Ganes_Multi_Rest";
    public static final String EMPATES_MR = "Empates_Multi_Rest";
    public static final String PERDIDAS_MR = "Perdidas_Multi_Rest";
    // Cadena para crear la tabla MultiplicarResta
    public static final String CREATE_TABLE_MRESTA = "CREATE TABLE IF NOT EXISTS " + TABLE_MRESTA +
            " (" + ID_MRESTA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ID_USUARIO_MR + " VARCHAR(100)," +
            GANES_MR + " INTEGER," +
            EMPATES_MR + " INTEGER," +
            PERDIDAS_MR + " INTEGER );";
    // Borrar la tabla, si ya existe
    public static final String DROP_TABLE_MR = "DROP TABLE IF EXISTS " + TABLE_MRESTA;

    // ---------- Tabla MultijugadorMultip ----------
    // Nombre de la tabla y campos de la tabla
    public static final String TABLE_MMULTIP = "Multi_Multip";   // Table Name
    public static final String ID_MMULTIP = "Id_Multi_Multip";     //  (Primary Key)
    public static final String ID_USUARIO_MM= "Usuario";
    public static final String GANES_MM = "Ganes_Multi_Multip";
    public static final String EMPATES_MM = "Empates_Multi_Multip";
    public static final String PERDIDAS_MM = "Perdidas_Multi_Multip";
    // Cadena para crear la tabla MultiplicarMultip
    public static final String CREATE_TABLE_MMULTIP = "CREATE TABLE IF NOT EXISTS " + TABLE_MMULTIP +
            " (" + ID_MMULTIP + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ID_USUARIO_MM + " VARCHAR(100)," +
            GANES_MM + " INTEGER," +
            EMPATES_MM + " INTEGER," +
            PERDIDAS_MM + " INTEGER );";
    // Borrar la tabla, si ya existe
    public static final String DROP_TABLE_MM = "DROP TABLE IF EXISTS " + TABLE_MMULTIP;

    // ---------- Tabla MultijugadorPotencia ----------
    // Nombre de la tabla y campos de la tabla
    public static final String TABLE_MPOTE = "Multi_Potencia";   // Table Name
    public static final String ID_MPOTE = "Id_Multi_Pote";     //  (Primary Key)
    public static final String ID_USUARIO_MP= "Usuario";
    public static final String GANES_MP = "Ganes_Multi_Pote";
    public static final String EMPATES_MP = "Empates_Multi_Pote";
    public static final String PERDIDAS_MP = "Perdidas_Multi_Pote";
    // Cadena para crear la tabla MultiplicarPotencia
    public static final String CREATE_TABLE_MPOTE = "CREATE TABLE IF NOT EXISTS " + TABLE_MPOTE +
            " (" + ID_MPOTE + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ID_USUARIO_MP + " VARCHAR(100)," +
            GANES_MP + " INTEGER," +
            EMPATES_MP + " INTEGER," +
            PERDIDAS_MP + " INTEGER );";
    // Borrar la tabla, si ya existe
    public static final String DROP_TABLE_MP = "DROP TABLE IF EXISTS " + TABLE_MPOTE;

}
