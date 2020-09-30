package com.example.mascotasrecyclerview.db;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mascotasrecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotasFavoritas extends AppCompatActivity {

    private Context context;

    public ConstructorMascotasFavoritas(Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> ObtenerDatos(){
        BaseDatos db=new BaseDatos(context);
        return db.obtenerTodasLasMascotasFavoritas();
    }

    public void InsertarcincoMascotaFavorita( ArrayList<Mascota> MascotasFavoritas){
        BaseDatos db=new BaseDatos(context);
        db.onUpgrade(db.getWritableDatabase(),1,1);

        ContentValues contentValues=new ContentValues();
        for(int i=0;i<MascotasFavoritas.size();i++){
            //contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ID,MascotasFavoritas.get(i).getId());
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,MascotasFavoritas.get(i).getNombre());
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,MascotasFavoritas.get(i).getFoto());
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RANK,MascotasFavoritas.get(i).getRank());

            db.insertarMascota(contentValues);
        }

    }
}
