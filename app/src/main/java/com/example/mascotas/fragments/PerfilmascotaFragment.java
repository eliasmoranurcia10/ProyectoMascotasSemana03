package com.example.mascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotas.R;
import com.example.mascotas.adapter.PerfilMascotaAdaptador;
import com.example.mascotas.pojo.Mascota;

import java.util.ArrayList;
import java.util.Date;

public class PerfilmascotaFragment extends Fragment {

    ArrayList<Mascota> perfilmascotas;
    private RecyclerView rvPerfilmascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_perfilmascota, container, false);

        rvPerfilmascotas = (RecyclerView) vista.findViewById(R.id.rvPerfilmascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        rvPerfilmascotas.setLayoutManager(glm);

        inicializarListaPerfilMascotas();

        inicializarAdaptadorMascotas();

        return vista;
    }

    public void inicializarListaPerfilMascotas(){
        perfilmascotas = new ArrayList<Mascota>();
        Date fechaActual = new Date();

        perfilmascotas.add(new Mascota(R.drawable.diesel, "Diesel", 8, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.betoben, "Betoben", 7, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.boberman, "Boberman", 5, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.branco, "Branco", 4, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.dalma, "Dalma", 3, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.donki, "Donki", 1, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.kitty, "Kitty", 1, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.michi, "Michi", 1, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.pibe, "Pibe", 0, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.puppy, "Puppy", 0, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.teysi, "Teisi", 0, fechaActual));
        perfilmascotas.add(new Mascota(R.drawable.toby, "Toby", 0, fechaActual));
    }

    public void inicializarAdaptadorMascotas(){
        PerfilMascotaAdaptador perfilMascotaAdaptador = new PerfilMascotaAdaptador(perfilmascotas,getActivity());
        rvPerfilmascotas.setAdapter(perfilMascotaAdaptador);
    }

}