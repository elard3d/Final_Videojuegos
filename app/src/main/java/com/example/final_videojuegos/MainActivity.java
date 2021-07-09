package com.example.final_videojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDetalle = findViewById(R.id.btnDetalle);
        Button btnRegistro = findViewById(R.id.btnRegistro);
        Button btnCrearPokemon = findViewById(R.id.btnCrearPokemon);
        Button btnPokemons = findViewById(R.id.btnListaPokemons);
        Button btnPokemonsCapturados = findViewById(R.id.btnPokemonsCapturados);

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EntrenadorDetalleActivity.class);
                startActivity(intent);
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EntrenadorRegistroActivity.class);
                startActivity(intent);
            }
        });

        btnCrearPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrearPokemonActivity.class);
                startActivity(intent);
            }
        });



    }
}