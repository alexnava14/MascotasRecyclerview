package com.example.mascotasrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasrecyclerview.pojo.Mascota;
import com.example.mascotasrecyclerview.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>  {


   private static ArrayList<Mascota> Mascotas;
 private static OnItemClickListener listener;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, OnItemClickListener listener){
        this.Mascotas=mascotas;
        this.listener=listener;
    }

    //inflar el layout y lo pasara al viewholder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);

        return new MascotaViewHolder(v);
    }
    //asocia cada elemento de la lista con su view
    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {

        final Mascota mascota=Mascotas.get(position);
        holder.ivFoto.setImageResource(mascota.getFoto());
        holder.hueso.setImageResource(R.drawable.hueso);
        holder.huesocolor.setImageResource(R.drawable.huesocolor);
        holder.NombrePerro.setText(String.valueOf(mascota.getNombre()));
        holder.Rank.setText(String.valueOf(mascota.getRank()));



      //  holder.hueso.setOnClickListener(this);

     /*  holder.hueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int valorRank=mascota.getRank()+1;
                System.out.println(valorRank);
                //mascota.setRank(valorRank);

                holder.Rank.setText(String.valueOf(mascota.getRank()));


            }
        });*/
    }

    @Override
    public int getItemCount() {
        return Mascotas.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        private ImageView ivFoto;
        private ImageView hueso;
        private ImageView huesocolor;
        private TextView NombrePerro;
        private TextView Rank;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            ivFoto=(ImageView) itemView.findViewById(R.id.imvFoto);
            hueso=(ImageView) itemView.findViewById(R.id.ivHueso);
            huesocolor=(ImageView) itemView.findViewById(R.id.ivHuesocolor);
            NombrePerro=(TextView) itemView.findViewById(R.id.tvNombrep);
            Rank=(TextView) itemView.findViewById(R.id.tvRanked);

            hueso.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onItemClickListener(view,getAdapterPosition());
            Rank.setText(String.valueOf(Mascotas.get(getAdapterPosition()).getRank()));


        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(View view, int position);
    }


}
