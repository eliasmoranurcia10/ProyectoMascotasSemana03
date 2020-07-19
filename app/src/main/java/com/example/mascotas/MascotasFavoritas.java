package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Date;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasfav;
    private RecyclerView listamascotasfav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        listamascotasfav = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listamascotasfav.setLayoutManager(llm);

        inicializarMascotasFavoritas();

        inicializarAdaptador();

    }

    public void inicializarMascotasFavoritas(){
        mascotasfav = new ArrayList<Mascota>();
        Date fechaAct = new Date();

        mascotasfav.add(new Mascota(R.drawable.diesel, "Diesel", 0, fechaAct));
        mascotasfav.add(new Mascota(R.drawable.betoben, "Betoben", 0, fechaAct));
        mascotasfav.add(new Mascota(R.drawable.boberman, "Boberman", 0, fechaAct));
        mascotasfav.add(new Mascota(R.drawable.branco, "Branco", 0, fechaAct));
        mascotasfav.add(new Mascota(R.drawable.dalma, "Dalma", 0, fechaAct));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotasfav,this);
        listamascotasfav.setAdapter(mascotaAdaptador);
    }
}