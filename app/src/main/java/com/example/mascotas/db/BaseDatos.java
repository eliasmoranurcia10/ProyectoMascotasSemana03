package com.example.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mascotas.pojo.Mascota;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Se crea la estructura de la base de datos
        String queryCrearTablaMascota = "CREATE TABLE "+ ConstantesBaseDatos.TABLE_MASCOTA+ " ( "+
                ConstantesBaseDatos.TABLE_MASCOTA_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO         + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE       + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FECHA_LIKE   + " TEXT " +
                "); ";

        db.execSQL(queryCrearTablaMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(" DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() throws ParseException {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " ;";

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        //Recorrer los registros
        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();

            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNombreMascota(registros.getString(2));
            mascotaActual.setNumeroLikes(registros.getInt(3));

            DateFormat fechahora = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aaa");
            Date fechalike = fechahora.parse(registros.getString(4));
            mascotaActual.setFechaUltimoLike(fechalike);

            mascotas.add(mascotaActual);
        }

        sqLiteDatabase.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public void eliminarTodasLasMascotas(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " ;");
        db.close();
    }
}
