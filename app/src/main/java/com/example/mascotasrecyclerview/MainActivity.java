package com.example.mascotasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Mascota> MaFav=new ArrayList<Mascota>();
    int mascoliked=0;
    ArrayList<Mascota> Mascotas;
    ImageView huella,estrella;
    TextView liked;
    private RecyclerView ListaMascotas;
    String Nombre;
    int foto;
    int rank;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        huella=(ImageView) findViewById(R.id.ivhuella);
        estrella=(ImageView) findViewById(R.id.ivestrella);
        liked=(TextView) findViewById(R.id.tvmascotasliked);

        liked.setText(String.valueOf(mascoliked));

        agregarFAB();




        //RecyclerView

        ListaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaMascotas.setLayoutManager(llm);
        InicializarListaMascotas();
        InicializarAdaptador();

    }


    public void InicializarAdaptador(){



        final MascotaAdaptador Adapter= new MascotaAdaptador(Mascotas, new MascotaAdaptador.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                if(view.getId()==R.id.ivHueso){

                    Mascotas.get(position).setRank(Mascotas.get(position).getRank()+1);

                    if (mascoliked<5){
                        Nombre=Mascotas.get(position).getNombre();
                        foto=Mascotas.get(position).getFoto();
                        rank=Mascotas.get(position).getRank();
                        agregarfav(Nombre,foto,rank,position);
                        liked.setText(String.valueOf(mascoliked+=1));
                    }
                    else{
                        MaFav.remove(0);
                        Nombre=Mascotas.get(position).getNombre();
                        foto=Mascotas.get(position).getFoto();
                        rank=Mascotas.get(position).getRank();
                        agregarfav(Nombre,foto,rank,position);
                    }
                    //System.out.println(Mascotas.get(position).getNombre());
                    //System.out.println(Mascotas.get(position).getRank());
                }
            }
        });


        ListaMascotas.setAdapter(Adapter);

    }
    public void InicializarListaMascotas(){
        Mascotas =new ArrayList<Mascota>();

        Mascotas.add(new Mascota("Firulais",R.drawable.imgmascota1,0));
        Mascotas.add(new Mascota("Sombra",R.drawable.perro2,0));
        Mascotas.add(new Mascota("Firulais",R.drawable.perro3,0));
        Mascotas.add(new Mascota("Scobby",R.drawable.perro4,0));
        Mascotas.add(new Mascota("Dolly",R.drawable.perro5,0));
        Mascotas.add(new Mascota("Dino",R.drawable.perro6,0));
    }

    public void agregarfav(String nombre,int foto,int rank,int position){

        if(!MaFav.contains(Mascotas.get(position)))
             MaFav.add(Mascotas.get(position));

    }

    public void agregarFAB(){
        FloatingActionButton FAB= (FloatingActionButton) findViewById(R.id.fabagregar);
        //programar el evento cuando se pulsa
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, getResources().getText(R.string.MensajeSnack),Snackbar.LENGTH_SHORT)
                        .setAction(getResources().getText(R.string.text_actionSnack), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR","Click en sanckBar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }




    @Override
    public void onClick(View view) {
        if (view==estrella){
            Intent intent=new Intent(this,MascotasFavoritas.class);
            Bundle bun=new Bundle();
            bun.putSerializable("MaFav",MaFav);
            intent.putExtras(bun);
            startActivity(intent);

        }


    }
}