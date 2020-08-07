package com.example.mascotas.fragments;

import com.example.mascotas.adapter.MascotaAdaptador;
import com.example.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IRvListamascotasFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
