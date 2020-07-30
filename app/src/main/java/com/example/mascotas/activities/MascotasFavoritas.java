package com.example.mascotas.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mascotas.R;
import com.example.mascotas.adapter.MascotaAdaptador;
import com.example.mascotas.pojo.Mascota;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasfav;
    private RecyclerView listamascotasfav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listamascotasfav = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listamascotasfav.setLayoutManager(llm);

        inicializarMascotasFavoritas();

        inicializarAdaptador();

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    public void inicializarMascotasFavoritas(){
        mascotasfav = new ArrayList<Mascota>();
        Date fechaAct = new Date();
        boolean sigueprimero = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aaa");

        ArrayList<Mascota> listafav = (ArrayList<Mascota>) getIntent().getSerializableExtra("mascotafav");
        ArrayList<Mascota> listaordenada = new ArrayList<Mascota>();

        for (int i = 0; i < listafav.size(); i++) {
            for (int j = 0; j < listafav.size(); j++) {
                if(listafav.get(i).getFechaUltimoLike().compareTo(listafav.get(j).getFechaUltimoLike()) >= 0){
                    sigueprimero = true;
                } else {
                    sigueprimero = false;
                    break;
                }
            }
            if (sigueprimero){
                listaordenada.add(listafav.get(i));
                listafav.remove(listafav.get(i));
                i = -1;
            }
        }

        for (int k = 0; k < 5; k++) {
            mascotasfav.add(listaordenada.get(k));
        }

        

        /*
        for (int i = 0; i < listafav.size(); i++) {
            System.out.println(" "+ listafav.get(i).getNombreMascota() + " | " + sdf.format(listafav.get(i).getFechaUltimoLike()));
        }
         */

        /*
        Bundle mascotarecibida = getIntent().getExtras();
        Mascota mascotafav = null;

        if(mascotarecibida != null){
            mascotafav = (Mascota) mascotarecibida.getSerializable("mascotafav");
            System.out.println(" " + mascotafav.getNombreMascota());
        }
         */

        /*
        mascotasfav.add(new Mascota(R.drawable.diesel, "Diesel", 0, fechaAct));
        mascotasfav.add(new Mascota(R.drawable.betoben, "Betoben", 0, fechaAct));
        mascotasfav.add(new Mascota(R.drawable.boberman, "Boberman", 0, fechaAct));
        mascotasfav.add(new Mascota(R.drawable.branco, "Branco", 0, fechaAct));
        mascotasfav.add(new Mascota(R.drawable.dalma, "Dalma", 0, fechaAct));
         */
    }

    public void inicializarAdaptador(){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotasfav,this);
        listamascotasfav.setAdapter(mascotaAdaptador);
    }
}