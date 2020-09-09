package com.example.mascotasrecyclerview;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Mascota implements Serializable {
    private String Nombre;
    private int Foto;
    private int Rank;

    public Mascota(String nombre, int foto, int rank) {
        this.Nombre = nombre;
        this.Foto = foto;
        this.Rank = rank;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }


}
