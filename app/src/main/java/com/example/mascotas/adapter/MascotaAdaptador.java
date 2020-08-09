package com.example.mascotas.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.R;
import com.example.mascotas.db.ConstructorMascotas;
import com.example.mascotas.pojo.Mascota;

import java.util.ArrayList;
import java.util.Date;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    //Inflar el Layout y lo pasará al viewholder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombreMascota());
        mascotaViewHolder.tvNumeroLikes.setText(" " +Integer.toString(mascota.getNumeroLikes()) );

        mascotaViewHolder.btnhuesolike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mascota.setNumeroLikes(mascota.getNumeroLikes()+1);

                Date nuevafecha = new Date();
                mascota.setFechaUltimoLike(nuevafecha);

                mascotaViewHolder.tvNumeroLikes.setText(" " +Integer.toString(mascota.getNumeroLikes()) );

                //Toast.makeText(activity, ""+mascota.getNumeroLikes(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    //Crear nuestros views a un objeto
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoMascota;
        private ImageView btnhuesolike;
        private TextView tvNombreMascota;
        private TextView tvNumeroLikes;
        private ImageView imgNumLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            btnhuesolike = (ImageView) itemView.findViewById(R.id.btnhuesolike);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvNumeroLikes = (TextView) itemView.findViewById(R.id.tvNumeroLikes);
            imgNumLikes = (ImageView) itemView.findViewById(R.id.imgNumLikes);
        }
    }


}
