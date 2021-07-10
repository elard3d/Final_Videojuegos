package com.example.final_videojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.final_videojuegos.entities.Pokemon;
import com.example.final_videojuegos.services.PokemonService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pokemon);

        Button btnCancelar = findViewById(R.id.btnCancelarCrear);

        final EditText nombre = findViewById(R.id.txtNombreCrear);
        final EditText tipo = findViewById(R.id.txtTipoCrear);
        final EditText latitude = findViewById(R.id.txtLatitudCrear);
        final EditText longitude = findViewById(R.id.txtLongitudCrear);

        findViewById(R.id.btnCrearPokemon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lat =latitude.getText().toString();
                String lon = longitude.getText().toString();
                Pokemon pokemon = new Pokemon();
                pokemon.setNombre(nombre.getText().toString());
                pokemon.setTipo(tipo.getText().toString());
                pokemon.setLatitude(Integer.valueOf(lat));
                pokemon.setLongitude(Integer.valueOf(lon));


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://upn.lumenes.tk/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                PokemonService pokemonService = retrofit.create(PokemonService.class);

                pokemonService.postPokemonCall(pokemon).enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        Toast.makeText(view.getContext(),pokemon.getLongitude().toString(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Toast.makeText(view.getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearPokemonActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}