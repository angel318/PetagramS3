package com.example.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList mascotas;
    private RecyclerView listaMascotas;
    private ImageView tbStarAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarM);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        tbStarAction = (ImageView) findViewById(R.id.tbStarActionTBM);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        cargarMascotas();
        inicializarAdaptador();

        tbStarAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(MainActivity.this, MascotaFavoritaActivity.class);
                startActivity(intent);
            }
        });

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void cargarMascotas()
    {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro1,"Odin","2"));
        mascotas.add(new Mascota(R.drawable.perro2,"Tony Stark","4"));
        mascotas.add(new Mascota(R.drawable.perro3,"Fido","6"));
        mascotas.add(new Mascota(R.drawable.perro4,"Loki","8"));
        mascotas.add(new Mascota(R.drawable.perro5,"Firulais","10"));
    }
}
