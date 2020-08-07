package com.example.mascotas.presentador;

import android.content.Context;

import com.example.mascotas.db.ConstructorMascotas;
import com.example.mascotas.fragments.IRvListamascotasFragmentView;
import com.example.mascotas.fragments.IRvPerfilmascotaFragmentView;
import com.example.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresent implements IRecyclerViewFragmentPresenter{

    private IRvListamascotasFragmentView iRvListamascotasFragmentView;
    private IRvPerfilmascotaFragmentView iRvPerfilmascotaFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresent(IRvListamascotasFragmentView iRvListamascotasFragmentView, Context context) {
        this.iRvListamascotasFragmentView = iRvListamascotasFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
        mostrarMascotasRV();
    }
    public RecyclerViewFragmentPresent(IRvPerfilmascotaFragmentView iRvPerfilmascotaFragmentView, Context context) {
        this.iRvPerfilmascotaFragmentView = iRvPerfilmascotaFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
        mostrarMascotasRVPerfil();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
    }

    @Override
    public void mostrarMascotasRV() {

        iRvListamascotasFragmentView.inicializarAdaptadorRV(iRvListamascotasFragmentView.crearAdaptador(mascotas));
        iRvListamascotasFragmentView.generarLinearLayoutVertical();

    }

    @Override
    public void mostrarMascotasRVPerfil() {
        iRvPerfilmascotaFragmentView.inicializarAdaptadorRVPerfil(iRvPerfilmascotaFragmentView.crearAdaptadorPerfil(mascotas));
        iRvPerfilmascotaFragmentView.generarGridLayoutManager();
    }


}
