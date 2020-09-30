package com.example.mascotasrecyclerview;

import com.example.mascotasrecyclerview.adapter.MascotaAdaptador;
import com.example.mascotasrecyclerview.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasFavoritas {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> Mascotas);
    public void inicializarAdaptador(MascotaAdaptador Adaptador);
}
