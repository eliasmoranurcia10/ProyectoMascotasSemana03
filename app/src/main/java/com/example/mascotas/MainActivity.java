package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotasfavoritas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        mascotasfavoritas = new ArrayList<Mascota>();
        mascotasfavoritas = adaptador.getMascotas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.menu_en_activity, mimenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem opcionesmenu) {
        //ALMACENA EL ID DEL BOTON QUE SE PRESIONÓ EN EL MENU
        int id = opcionesmenu.getItemId();

        if(id == R.id.favoritos){
            //AQUI SE CREARÁ UNA ACCIÓN
            IngresarMascotasFavoritas(null);
            return true;
        }

        if(id == R.id.mContacto){
            IngresaraFormularioContacto(null);
            return true;
        }

        if(id == R.id.mAcercade){
            IngresaraAcercaDe(null);
            return true;
        }

        if(id == R.id.salir){
            SalirApp(null);
            return true;
        }

        return super.onOptionsItemSelected(opcionesmenu);
    }

    public void IngresaraAcercaDe(View view){
        Intent intent = new Intent(this, InformacionActivity.class);
        startActivity(intent);
    }

    public void IngresaraFormularioContacto(View view){
        Intent intent = new Intent(this, ActivityContacto.class);
        startActivity(intent);
    }

    public void SalirApp(View view){
        finish();
    }

    public void IngresarMascotasFavoritas(View view){
        Intent intent = new Intent(this, MascotasFavoritas.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("mascotafav",mascotasfavoritas);
        intent.putExtras(bundle);
        startActivity(intent);

        /*
        Mascota mascotaFavorita = mascotasfavoritas.get(1);
        Bundle bundle = new Bundle();
        bundle.putSerializable("mascotafav",mascotaFavorita);
        intent.putExtras(bundle);
        startActivity(intent);
         */


        /*
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aaa");

            for (int i = 0; i < mascotasfavoritas.size(); i++) {
                System.out.println("" + mascotasfavoritas.get(i).getNombreMascota() +" |"+ sdf.format(mascotasfavoritas.get(i).getFechaUltimoLike()));
            }

            startActivity(intent);
        }catch (Exception e){

        }
         */
    }

}