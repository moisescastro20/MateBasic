package com.principal.mathebasic.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.principal.mathebasic.Entidades.Jugar_Multip;
import com.principal.mathebasic.Entidades.Jugar_Potencia;
import com.principal.mathebasic.Entidades.Jugar_Resta;
import com.principal.mathebasic.Entidades.Jugar_Suma;
import com.principal.mathebasic.Entidades.Multi_Multip;
import com.principal.mathebasic.Entidades.Multi_Potencia;
import com.principal.mathebasic.Entidades.Multi_Resta;
import com.principal.mathebasic.Entidades.Multi_Suma;
import com.principal.mathebasic.Entidades.Usuarios;
import com.principal.mathebasic.Utilidades.Utilidades;

public class SQLite {

    SQLiteHelper sqliteHelper;
    Context context;
    Usuarios usuario;
    Jugar_Suma jugarSuma;
    Jugar_Resta jugarResta;
    Jugar_Multip jugarMultip;
    Jugar_Potencia jugarPotencia;
    Multi_Suma multiSuma;
    Multi_Resta multiResta;
    Multi_Multip multiMultip;
    Multi_Potencia multiPotencia;

    Utilidades ut = new Utilidades();

    // Constructor de la clase
    public SQLite(Context context) {
        this.context = context;
        sqliteHelper = new SQLiteHelper(context);
    }

    public Usuarios login(String user, String pass) {
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {ut.ID_USUARIO, ut.USUARIO, ut.CONTRASEÑA, ut.NOMBRE, ut.APELLIDO};
            String whereClause = "USUARIO = ? AND PASSWORD = ?";
            String[] whereArgs = new String[]{
                    user,
                    pass
            };
            Cursor cursor = db.query(ut.TABLE_USUARIOS, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                usuario = new Usuarios();
                usuario.setID_USUARIO(cursor.getInt(cursor.getColumnIndex(ut.ID_USUARIO)));
                usuario.setUSUARIO(cursor.getString(cursor.getColumnIndex(ut.USUARIO)));
                usuario.setNOMBRE_USUARIO(cursor.getString(cursor.getColumnIndex(ut.NOMBRE)));
                usuario.setCONTRASEÑA(cursor.getString(cursor.getColumnIndex(ut.CONTRASEÑA)));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return usuario;
    }

    public long insertUsuario(String USUARIO, String PASSWORD, String NAME, String APELLIDO, String CEL_EMAIL, String EDAD, String ROL) {
        long id;
        try {
            SQLiteDatabase dbb = sqliteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ut.USUARIO, USUARIO);
            contentValues.put(ut.CONTRASEÑA, PASSWORD);
            contentValues.put(ut.NOMBRE, NAME);
            contentValues.put(ut.APELLIDO, APELLIDO);
            contentValues.put(ut.CEL_EMAIL, CEL_EMAIL);
            contentValues.put(ut.EDAD, EDAD);
            contentValues.put(ut.ROL, ROL);
            id = dbb.insert(ut.TABLE_USUARIOS, null, contentValues);
            Toast.makeText(context, "Usuario creado exitosamente!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            id = 0;
        }
        return id;
    }

    public long insertJugarSuma(String usuario, int total) {
        long id;
        try {
            SQLiteDatabase dbb = sqliteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ut.ID_USUARIO_JS, usuario);
            contentValues.put(ut.TOTAL_JSUMA, total);
            id = dbb.insert(ut.TABLE_JSUMA, null, contentValues);
        } catch (Exception e) {
            id = 0;
        }
        return id;
    }

    public long insertJugarResta(String usuario, int total) {
        long id;
        try {
            SQLiteDatabase dbb = sqliteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ut.ID_USUARIO_JR, usuario);
            contentValues.put(ut.TOTAL_JRESTA, total);
            id = dbb.insert(ut.TABLE_JRESTA, null, contentValues);
        } catch (Exception e) {
            id = 0;
        }
        return id;
    }

    public long insertJugarMultip(String usuario, int total) {
        long id;
        try {
            SQLiteDatabase dbb = sqliteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ut.ID_USUARIO_JM, usuario);
            contentValues.put(ut.TOTAL_JMULTIP, total);
            id = dbb.insert(ut.TABLE_JMULTIP, null, contentValues);
        } catch (Exception e) {
            id = 0;
        }
        return id;
    }

    public long insertJugarPotencia(String usuario, int total) {
        long id;
        try {
            SQLiteDatabase dbb = sqliteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ut.ID_USUARIO_JP, usuario);
            contentValues.put(ut.TOTAL_JPOTE, total);
            id = dbb.insert(ut.TABLE_JPOTE, null, contentValues);
        } catch (Exception e) {
            id = 0;
        }
        return id;
    }

    public long insertMultiSuma(String usuario, int gane, int empate, int perdida) {
        long id;
        try {
            SQLiteDatabase dbb = sqliteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ut.ID_USUARIO_MS, usuario);
            contentValues.put(ut.GANES_MS, gane);
            contentValues.put(ut.EMPATES_MS, empate);
            contentValues.put(ut.PERDIDAS_MS, perdida);
            id = dbb.insert(ut.TABLE_MSUMA, null, contentValues);
        } catch (Exception e) {
            id = 0;
        }
        return id;
    }

    public long insertMultiResta(String usuario, int gane, int empate, int perdida) {
        long id;
        try {
            SQLiteDatabase dbb = sqliteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ut.ID_USUARIO_MR, usuario);
            contentValues.put(ut.GANES_MR, gane);
            contentValues.put(ut.EMPATES_MR, empate);
            contentValues.put(ut.PERDIDAS_MR, perdida);
            id = dbb.insert(ut.TABLE_MRESTA, null, contentValues);
        } catch (Exception e) {
            id = 0;
        }
        return id;
    }

    public long insertMultiMultip(String usuario, int gane, int empate, int perdida) {
        long id;
        try {
            SQLiteDatabase dbb = sqliteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ut.ID_USUARIO_MM, usuario);
            contentValues.put(ut.GANES_MM, gane);
            contentValues.put(ut.EMPATES_MM, empate);
            contentValues.put(ut.PERDIDAS_MM, perdida);
            id = dbb.insert(ut.TABLE_MMULTIP, null, contentValues);
        } catch (Exception e) {
            id = 0;
        }
        return id;
    }

    public long insertMultiPotencia(String usuario, int gane, int empate, int perdida) {
        long id;
        try {
            SQLiteDatabase dbb = sqliteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ut.ID_USUARIO_MP, usuario);
            contentValues.put(ut.GANES_MP, gane);
            contentValues.put(ut.EMPATES_MP, empate);
            contentValues.put(ut.PERDIDAS_MP, perdida);
            id = dbb.insert(ut.TABLE_MPOTE, null, contentValues);
        } catch (Exception e) {
            id = 0;
        }
        return id;
    }

    public Jugar_Suma mostrarResultadoJS(String user) {
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {"COUNT(" + ut.ID_JSUMA + ") AS PARTIDAS", ut.ID_USUARIO_JS, "SUM(" + ut.TOTAL_JSUMA + ") AS TOTAL_PUNTOS"};
            String whereClause = "USUARIO = ?";
            String[] whereArgs = new String[]{
                    user
            };
            Cursor cursor = db.query(ut.TABLE_JSUMA, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                jugarSuma = new Jugar_Suma();
                jugarSuma.setID_JSUMA(cursor.getInt(cursor.getColumnIndex("PARTIDAS")));
                jugarSuma.setID_USUARIO_JS(cursor.getString(cursor.getColumnIndex(ut.ID_USUARIO_JS)));
                jugarSuma.setTOTAL_JSUMA(cursor.getInt(cursor.getColumnIndex("TOTAL_PUNTOS")));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return jugarSuma;
    }

    public Jugar_Resta mostrarResultadoJR(String user) {
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {"COUNT(" + ut.ID_JRESTA + ") AS PARTIDAS", ut.ID_USUARIO_JR, "SUM(" + ut.TOTAL_JRESTA + ") AS TOTAL_PUNTOS"};
            String whereClause = "USUARIO = ?";
            String[] whereArgs = new String[]{
                    user
            };
            Cursor cursor = db.query(ut.TABLE_JRESTA, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                jugarResta = new Jugar_Resta();
                jugarResta.setID_JRESTA(cursor.getInt(cursor.getColumnIndex("PARTIDAS")));
                jugarResta.setID_USUARIO_JR(cursor.getString(cursor.getColumnIndex(ut.ID_USUARIO_JR)));
                jugarResta.setTOTAL_JRESTA(cursor.getInt(cursor.getColumnIndex("TOTAL_PUNTOS")));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return jugarResta;
    }

    public Jugar_Multip mostrarResultadoJM(String user) {
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {"COUNT(" + ut.ID_JMULTIP + ") AS PARTIDAS", ut.ID_USUARIO_JM, "SUM(" + ut.TOTAL_JMULTIP + ") AS TOTAL_PUNTOS"};
            String whereClause = "USUARIO = ?";
            String[] whereArgs = new String[]{
                    user
            };
            Cursor cursor = db.query(ut.TABLE_JMULTIP, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                jugarMultip = new Jugar_Multip();
                jugarMultip.setID_JMULTIP(cursor.getInt(cursor.getColumnIndex("PARTIDAS")));
                jugarMultip.setID_USUARIO_JM(cursor.getString(cursor.getColumnIndex(ut.ID_USUARIO_JM)));
                jugarMultip.setTOTAL_JMULTIP(cursor.getInt(cursor.getColumnIndex("TOTAL_PUNTOS")));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return jugarMultip;
    }

    public Jugar_Potencia mostrarResultadoJP(String user) {
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {"COUNT(" + ut.ID_JPOTE + ") AS PARTIDAS", ut.ID_USUARIO_JP, "SUM(" + ut.TOTAL_JPOTE + ") AS TOTAL_PUNTOS"};
            String whereClause = "USUARIO = ?";
            String[] whereArgs = new String[]{
                    user
            };
            Cursor cursor = db.query(ut.TABLE_JPOTE, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                jugarPotencia = new Jugar_Potencia();
                jugarPotencia.setID_JPOTE(cursor.getInt(cursor.getColumnIndex("PARTIDAS")));
                jugarPotencia.setID_USUARIO_JP(cursor.getString(cursor.getColumnIndex(ut.ID_USUARIO_JP)));
                jugarPotencia.setTOTAL_JPOTE(cursor.getInt(cursor.getColumnIndex("TOTAL_PUNTOS")));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return jugarPotencia;
    }

    public Multi_Suma mostrarResultadoMS(String user) {
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {ut.ID_MSUMA, ut.ID_USUARIO_MS, "SUM(" + ut.GANES_MS + ") AS GANES", "SUM(" + ut.EMPATES_MS + ") AS EMPATES", "SUM(" + ut.PERDIDAS_MS + ") AS PERDIDAS"};
            String whereClause = "USUARIO = ?";
            String[] whereArgs = new String[]{
                    user
            };
            Cursor cursor = db.query(ut.TABLE_MSUMA, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                multiSuma = new Multi_Suma();
                multiSuma.setID_MSUMA(cursor.getInt(cursor.getColumnIndex(ut.ID_MSUMA)));
                multiSuma.setID_USUARIO_MS(cursor.getString(cursor.getColumnIndex(ut.ID_USUARIO_MS)));
                multiSuma.setGANES_MS(cursor.getInt(cursor.getColumnIndex("GANES")));
                multiSuma.setEMPATES_MS(cursor.getInt(cursor.getColumnIndex("EMPATES")));
                multiSuma.setPERDIDAS_MS(cursor.getInt(cursor.getColumnIndex("PERDIDAS")));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return multiSuma;
    }

    public Multi_Resta mostrarResultadoMR(String user) {
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {ut.ID_MRESTA, ut.ID_USUARIO_MR, "SUM(" + ut.GANES_MR + ") AS GANES", "SUM(" + ut.EMPATES_MR + ") AS EMPATES", "SUM(" + ut.PERDIDAS_MR + ") AS PERDIDAS"};
            String whereClause = "USUARIO = ?";
            String[] whereArgs = new String[]{
                    user
            };
            Cursor cursor = db.query(ut.TABLE_MRESTA, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                multiResta = new Multi_Resta();
                multiResta.setID_MRESTA(cursor.getInt(cursor.getColumnIndex(ut.ID_MRESTA)));
                multiResta.setID_USUARIO_MR(cursor.getString(cursor.getColumnIndex(ut.ID_USUARIO_MR)));
                multiResta.setGANES_MR(cursor.getInt(cursor.getColumnIndex("GANES")));
                multiResta.setEMPATES_MR(cursor.getInt(cursor.getColumnIndex("EMPATES")));
                multiResta.setPERDIDAS_MR(cursor.getInt(cursor.getColumnIndex("PERDIDAS")));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return multiResta;
    }

    public Multi_Multip mostrarResultadoMM(String user) {
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {ut.ID_MMULTIP, ut.ID_USUARIO_MM, "SUM(" + ut.GANES_MM + ") AS GANES", "SUM(" + ut.EMPATES_MM + ") AS EMPATES", "SUM(" + ut.PERDIDAS_MM + ") AS PERDIDAS"};
            String whereClause = "USUARIO = ?";
            String[] whereArgs = new String[]{
                    user
            };
            Cursor cursor = db.query(ut.TABLE_MMULTIP, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                multiMultip = new Multi_Multip();
                multiMultip.setID_MMULTIP(cursor.getInt(cursor.getColumnIndex(ut.ID_MMULTIP)));
                multiMultip.setID_USUARIO_MM(cursor.getString(cursor.getColumnIndex(ut.ID_USUARIO_MM)));
                multiMultip.setGANES_MM(cursor.getInt(cursor.getColumnIndex("GANES")));
                multiMultip.setEMPATES_MM(cursor.getInt(cursor.getColumnIndex("EMPATES")));
                multiMultip.setPERDIDAS_MM(cursor.getInt(cursor.getColumnIndex("PERDIDAS")));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return multiMultip;
    }

    public Multi_Potencia mostrarResultadoMP(String user) {
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {ut.ID_MPOTE, ut.ID_USUARIO_MP, "SUM(" + ut.GANES_MP + ") AS GANES", "SUM(" + ut.EMPATES_MP + ") AS EMPATES", "SUM(" + ut.PERDIDAS_MP + ") AS PERDIDAS"};
            String whereClause = "USUARIO = ?";
            String[] whereArgs = new String[]{
                    user
            };
            Cursor cursor = db.query(ut.TABLE_MPOTE, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                multiPotencia = new Multi_Potencia();
                multiPotencia.setID_MPOTE(cursor.getInt(cursor.getColumnIndex(ut.ID_MPOTE)));
                multiPotencia.setID_USUARIO_MP(cursor.getString(cursor.getColumnIndex(ut.ID_USUARIO_MP)));
                multiPotencia.setGANES_MP(cursor.getInt(cursor.getColumnIndex("GANES")));
                multiPotencia.setEMPATES_MP(cursor.getInt(cursor.getColumnIndex("EMPATES")));
                multiPotencia.setPERDIDAS_MP(cursor.getInt(cursor.getColumnIndex("PERDIDAS")));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return multiPotencia;
    }

    public String getUsuario() {
        String data = "";
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {ut.ID_USUARIO, ut.NOMBRE, ut.CONTRASEÑA};
            Cursor cursor = db.query(ut.TABLE_USUARIOS, columns, null, null, null, null, null);
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()) {
                int cid = cursor.getInt(cursor.getColumnIndex(ut.ID_USUARIO));
                String name = cursor.getString(cursor.getColumnIndex(ut.NOMBRE));
                String password = cursor.getString(cursor.getColumnIndex(ut.CONTRASEÑA));
                buffer.append(cid + "   " + name + "   " + password + " \n");
            }
            data = buffer.toString();
        } catch (Exception e) {
            data = e.getMessage();
        }
        return data;
    }

    public int existenciaUsuario(String user) {
        int exis = 1;
        try {
            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            String[] columns = {ut.ID_USUARIO, ut.USUARIO};
            String whereClause = "USUARIO = ?";
            String[] whereArgs = new String[]{
                    user
            };
            Cursor cursor = db.query(ut.TABLE_USUARIOS, columns, whereClause, whereArgs, null, null, null);
            while (cursor.moveToNext()) {
                exis = 0;
                return exis;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return exis;
    }

    public int delete(String uname) {
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        String[] whereArgs = {uname};

        int count = db.delete(ut.TABLE_USUARIOS, ut.NOMBRE + " = ?", whereArgs);
        return count;
    }

    public int updateName(String oldName, String newName) {
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ut.NOMBRE, newName);
        String[] whereArgs = {oldName};
        int count = db.update(ut.TABLE_USUARIOS, contentValues, ut.NOMBRE + " = ?", whereArgs);
        return count;
    }

}
