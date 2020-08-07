package com.example.mascotas.fragments;

import com.example.mascotas.adapter.PerfilMascotaAdaptador;
import com.example.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IRvPerfilmascotaFragmentView {

    public void generarGridLayoutManager();

    public PerfilMascotaAdaptador crearAdaptadorPerfil(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRVPerfil(PerfilMascotaAdaptador perfilMascotaAdaptador);
}
