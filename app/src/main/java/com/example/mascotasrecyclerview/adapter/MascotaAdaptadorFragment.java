package com.example.mascotasrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasrecyclerview.R;
import com.example.mascotasrecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptadorFragment extends RecyclerView.Adapter<MascotaAdaptadorFragment.MascotaFragmentViewHolder> {

    ArrayList<Mascota> MascotaFragment;

    public MascotaAdaptadorFragment (ArrayList<Mascota> MascotaFragment){
        this.MascotaFragment=MascotaFragment;
    }

    @NonNull
    @Override
    public MascotaFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewmascota_fragment,parent,false);
        return new MascotaFragmentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaFragmentViewHolder holder, int position) {
        Mascota Mascotas=MascotaFragment.get(position);
        holder.imgfotofragment.setImageResource(Mascotas.getFoto());
        holder.tvRankedfragment.setText(String.valueOf(Mascotas.getRank()));
        holder.huesocolor.setImageResource(R.drawable.huesocolor);
    }

    @Override
    public int getItemCount() {
        return MascotaFragment.size();
    }

    public static class MascotaFragmentViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgfotofragment;
        private TextView tvRankedfragment;
        private ImageView huesocolor;

        public MascotaFragmentViewHolder(@NonNull View itemView) {
            super(itemView);

            imgfotofragment=(ImageView) itemView.findViewById(R.id.imvFotoMascotafragment);
            tvRankedfragment=(TextView) itemView.findViewById(R.id.tvRankedMascotafragment);
            huesocolor=(ImageView) itemView.findViewById(R.id.ivHuesocolorMascotaFragment);

        }
    }
}
