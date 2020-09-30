package com.example.mascotasrecyclerview.pojo;


import java.io.Serializable;

public class Mascota implements Serializable {
    int Id;
    private String Nombre;
    private int Foto;
    private int Rank;

    public Mascota(int id,String nombre, int foto, int rank) {
        this.Id=id;
        this.Nombre = nombre;
        this.Foto = foto;
        this.Rank = rank;
    }

    public Mascota() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
