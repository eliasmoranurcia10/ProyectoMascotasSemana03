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
import com.example.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.example.mascotas.presentador.RecyclerViewFragmentPresent;

import java.util.ArrayList;
import java.util.Date;

public class PerfilmascotaFragment extends Fragment implements IRvPerfilmascotaFragmentView{

    private RecyclerView rvPerfilmascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_perfilmascota, container, false);

        rvPerfilmascotas = (RecyclerView) vista.findViewById(R.id.rvPerfilmascotas);

        presenter = new RecyclerViewFragmentPresent(this,getContext());

        return vista;
    }

    @Override
    public void generarGridLayoutManager() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        rvPerfilmascotas.setLayoutManager(glm);
    }

    @Override
    public PerfilMascotaAdaptador crearAdaptadorPerfil(ArrayList<Mascota> mascotas) {
        PerfilMascotaAdaptador perfilAdaptador = new PerfilMascotaAdaptador(mascotas,getActivity());
        return perfilAdaptador;
    }

    @Override
    public void inicializarAdaptadorRVPerfil(PerfilMascotaAdaptador perfilMascotaAdaptador) {
        rvPerfilmascotas.setAdapter(perfilMascotaAdaptador);
    }
}