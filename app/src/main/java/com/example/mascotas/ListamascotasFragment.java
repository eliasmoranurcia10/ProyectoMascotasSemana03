package com.example.mascotas;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

public class ListamascotasFragment extends Fragment{

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotasfavoritas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_listamascotas, container, false);

        listaMascotas = (RecyclerView) vista.findViewById(R.id.rvMascotas);

        //Crear LinearLayout
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //Darle sentido vertical
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Agregar el diseño a la listaMascotas quien es un RecycleView
        listaMascotas.setLayoutManager(llm);

        //Crear arreglos de Mascotas
        inicializarListaMascotas();

        //Crear Objeto Adaptador y que tome forma de listaMascotas
        inicializarAdaptador();



        return vista;
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        Date fechaActual = new Date();

        mascotas.add(new Mascota(R.drawable.diesel, "Diesel", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.betoben, "Betoben", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.boberman, "Boberman", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.branco, "Branco", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.dalma, "Dalma", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.donki, "Donki", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.kitty, "Kitty", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.michi, "Michi", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.pibe, "Pibe", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.puppy, "Puppy", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.teysi, "Teisi", 0, fechaActual));
        mascotas.add(new Mascota(R.drawable.toby, "Toby", 0, fechaActual));

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);

        mascotasfavoritas = new ArrayList<Mascota>();
        mascotasfavoritas = adaptador.getMascotas();
    }

    public void IngresarMascotasFavoritas(){
        Intent intent = new Intent(getActivity(), MascotasFavoritas.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("mascotafav",mascotasfavoritas);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public ArrayList<Mascota> getMascotasfavoritas() {
        return mascotasfavoritas;
    }

}

