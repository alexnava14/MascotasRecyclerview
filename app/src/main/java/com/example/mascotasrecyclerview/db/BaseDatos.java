package com.example.mascotasrecyclerview.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mascotasrecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null,ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateTableMascota="CREATE TABLE "+ConstantesBaseDatos.TABLE_MASCOTA+"("+
                                        ConstantesBaseDatos.TABLE_MASCOTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                        ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+" TEXT,"+
                                        ConstantesBaseDatos.TABLE_MASCOTA_FOTO+" INTEGER,"+
                                        ConstantesBaseDatos.TABLE_MASCOTA_RANK+" INTEGER"+
                                        ")";
        db.execSQL(queryCreateTableMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+ConstantesBaseDatos.TABLE_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotasFavoritas(){
        ArrayList<Mascota> MascotasFav=new ArrayList<>();

        String queryObtenerMascotas="SELECT * FROM "+ConstantesBaseDatos.TABLE_MASCOTA;

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor Registros=db.rawQuery(queryObtenerMascotas,null);

        while (Registros.moveToNext()){
            Mascota Mascotaactual=new Mascota();
            //Mascotaactual.setId(Registros.getInt(0));
            Mascotaactual.setNombre(Registros.getString(1));

            Mascotaactual.setFoto(Registros.getInt(2));
            Mascotaactual.setRank(Registros.getInt(3));

            MascotasFav.add(Mascotaactual);

        }


        db.close();
        return MascotasFav;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();


        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);

        db.close();

    }
}
