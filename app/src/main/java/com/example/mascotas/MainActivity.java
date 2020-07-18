package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        //Crear LinearLayout
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //Darle sentido vertical
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Agregar el diseño a la listaMascotas quien es un RecycleView
        listaMascotas.setLayoutManager(llm);

        //Crear arreglos de Mascotas
        inicializarListaMascotas();

        //Crear Objeto Adaptador y que tome forma de listaMascotas
        inicializarAdaptador();
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
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }
}