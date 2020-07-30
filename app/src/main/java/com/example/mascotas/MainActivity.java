package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity{


    //creo variables de toolbar, tablayout y viewpager
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Haciendo Casting de las variables
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        setUpViewPager();


    }

    private void setUpViewPager(){
        //el viewPager se adapta al PagerAdapter
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);


    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListamascotasFragment());
        fragments.add(new PerfilmascotaFragment());

        return fragments;
    }

    private ArrayList<Mascota> listaMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

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

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,this);

        return mascotaAdaptador.getMascotas();


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

            Intent intent = new Intent(this, MascotasFavoritas.class);

            ArrayList<Mascota> mascotasfavoritas = listaMascotasFavoritas();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mascotafav",mascotasfavoritas);
            intent.putExtras(bundle);
            startActivity(intent);


            //IngresarMascotasFavoritas(null);
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

}