package com.example.mascotasrecyclerview.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotasrecyclerview.R;
import com.example.mascotasrecyclerview.adapter.MascotaAdaptadorFragment;
import com.example.mascotasrecyclerview.pojo.Mascota;

import java.util.ArrayList;


public class MascotaFragment extends Fragment {

    ArrayList<Mascota> Mascotas;
    private RecyclerView ListaMascotas;
    View v;

    public MascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_mascota, container, false);

        ListaMascotas=(RecyclerView) v.findViewById(R.id.rvMascotafragment);

        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        ListaMascotas.setLayoutManager(llm);
        InicializarListaMascotas();
        InicializarAdaptador();


        return v;
    }

    public void InicializarAdaptador(){
        MascotaAdaptadorFragment adapter=new MascotaAdaptadorFragment(Mascotas);
        ListaMascotas.setAdapter(adapter);
    }

    public void InicializarListaMascotas(){
        Mascotas =new ArrayList<Mascota>();

        Mascotas.add(new Mascota("Firulais",R.drawable.perro2,0));
        Mascotas.add(new Mascota("Sombra",R.drawable.perro2,3));
        Mascotas.add(new Mascota("Firulais",R.drawable.perro2,4));
        Mascotas.add(new Mascota("Scobby",R.drawable.perro2,6));
        Mascotas.add(new Mascota("Dolly",R.drawable.perro2,7));
        Mascotas.add(new Mascota("Dino",R.drawable.perro2,8));
    }
}