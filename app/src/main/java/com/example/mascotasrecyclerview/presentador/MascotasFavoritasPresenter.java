package com.example.mascotasrecyclerview.presentador;

import android.content.Context;

import com.example.mascotasrecyclerview.IMascotasFavoritas;
import com.example.mascotasrecyclerview.db.ConstructorMascotasFavoritas;
import com.example.mascotasrecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritasPresenter implements IMascotasFavoritasPresenter {

    private IMascotasFavoritas iMascotasFavoritas;
    private Context context;
    private ConstructorMascotasFavoritas constructorMascotasFavoritas;
    private ArrayList<Mascota> MascotasFavoritas;

    public MascotasFavoritasPresenter(IMascotasFavoritas iMascotasFavoritas,Context context) {
        this.iMascotasFavoritas=iMascotasFavoritas;
        this.context=context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotasFavoritas=new ConstructorMascotasFavoritas(context);
        MascotasFavoritas=constructorMascotasFavoritas.ObtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotasFavoritas.inicializarAdaptador(iMascotasFavoritas.crearAdaptador(MascotasFavoritas));
        iMascotasFavoritas.generarLinearLayoutVertical();
    }
}
