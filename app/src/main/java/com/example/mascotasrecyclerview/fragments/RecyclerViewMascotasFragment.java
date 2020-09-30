package com.example.mascotasrecyclerview.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasrecyclerview.MascotasFavoritas;
import com.example.mascotasrecyclerview.R;
import com.example.mascotasrecyclerview.adapter.MascotaAdaptador;
import com.example.mascotasrecyclerview.db.ConstructorMascotasFavoritas;
import com.example.mascotasrecyclerview.pojo.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RecyclerViewMascotasFragment extends Fragment  implements View.OnClickListener{


    ArrayList<Mascota> MaFav=new ArrayList<Mascota>();
    int mascoliked=0;
    ArrayList<Mascota> Mascotas;

    TextView liked;
    private RecyclerView ListaMascotas;
    ImageView huella,estrella;
    String Nombre;
    int foto;
    int rank;
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        v=inflater.inflate(R.layout.fragment_recyclerviewmascotas,container,false);

        huella=(ImageView) v.findViewById(R.id.ivhuella);
        estrella=(ImageView) v.findViewById(R.id.ivestrella);
        liked=(TextView) v.findViewById(R.id.tvmascotasliked);
        liked.setText(String.valueOf(mascoliked));



        estrella.setOnClickListener(this);
        //((AppCompatActivity)getActivity()).setSupportActionBar(tool);

        agregarFAB();

        //RecyclerView

        ListaMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaMascotas.setLayoutManager(llm);
        InicializarListaMascotas();
        InicializarAdaptador();

        return v;
    }


    public void InicializarAdaptador(){
        System.out.println("pruebafinal"+Mascotas.get(0).getNombre());


        final MascotaAdaptador Adapter= new MascotaAdaptador(Mascotas, new MascotaAdaptador.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                if(view.getId()==R.id.ivHueso){

                    Mascotas.get(position).setRank(Mascotas.get(position).getRank()+1);

                    if (mascoliked<5){
                        Nombre=Mascotas.get(position).getNombre();
                        foto=Mascotas.get(position).getFoto();
                        rank=Mascotas.get(position).getRank();
                        System.out.println("Probando"+Nombre);
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

        Mascotas.add(new Mascota(0,"Firulais",R.drawable.imgmascota1,0));
        Mascotas.add(new Mascota(1,"Sombra",R.drawable.perro2,0));
        Mascotas.add(new Mascota(2,"Firulais",R.drawable.perro3,0));
        Mascotas.add(new Mascota(3,"Scobby",R.drawable.perro4,0));
        Mascotas.add(new Mascota(4,"Dolly",R.drawable.perro5,0));
        Mascotas.add(new Mascota(5,"Dino",R.drawable.perro6,0));
    }

    public void agregarfav(String nombre,int foto,int rank,int position){

        final ConstructorMascotasFavoritas MascFav=new ConstructorMascotasFavoritas(getContext());

        if(!MaFav.contains(Mascotas.get(position)))
            MaFav.add(Mascotas.get(position));

        MascFav.InsertarcincoMascotaFavorita(MaFav);

    }

    public void agregarFAB(){
        FloatingActionButton FAB= (FloatingActionButton) v.findViewById(R.id.fabagregar);
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
            Intent intent=new Intent(getActivity(), MascotasFavoritas.class);
            //Bundle bun=new Bundle();
            //bun.putSerializable("MaFav",MaFav);
            //intent.putExtras(bun);
            startActivity(intent);

        }


    }

    @Override
    public void onResume() {
        super.onResume();
        InicializarAdaptador();
    }
}
