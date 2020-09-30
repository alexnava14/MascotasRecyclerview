package com.example.mascotasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mascotasrecyclerview.adapter.MascotaAdaptador;
import com.example.mascotasrecyclerview.pojo.Mascota;
import com.example.mascotasrecyclerview.presentador.IMascotasFavoritasPresenter;
import com.example.mascotasrecyclerview.presentador.MascotasFavoritasPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity  implements View.OnClickListener,IMascotasFavoritas {


   // ArrayList<Mascota> MascotasFav;
    private RecyclerView ListaMascotas;
    private IMascotasFavoritasPresenter presenter;
    ImageView arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mascotas_favoritas);

        arrow=(ImageView) findViewById(R.id.ivarrowback);

        arrow.setOnClickListener(this);
        ListaMascotas=(RecyclerView) findViewById(R.id.rvMascotas2);
        presenter=new MascotasFavoritasPresenter(this,this);

        //Recepcion de ArrayList
        //Bundle bundle=getIntent().getExtras();
        //MascotasFav=(ArrayList<Mascota>) bundle.getSerializable("MaFav");




       // InicializarAdaptador();
    }

   /* public void InicializarAdaptador(){

        final MascotaAdaptador Adapter= new MascotaAdaptador(MascotasFav, new MascotaAdaptador.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

            }
        });


        ListaMascotas.setAdapter(Adapter);

    }
*/
    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void generarLinearLayoutVertical() {
        //RecyclerView

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaMascotas.setLayoutManager(llm);
        ListaMascotas.setHasFixedSize(true);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> Mascotas) {

        final MascotaAdaptador Adapter= new MascotaAdaptador(Mascotas, new MascotaAdaptador.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

            }
        });
        return Adapter;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador Adaptador) {
        ListaMascotas.setAdapter(Adaptador);
    }
}