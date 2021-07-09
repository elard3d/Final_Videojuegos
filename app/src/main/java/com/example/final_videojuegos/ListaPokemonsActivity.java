package com.example.final_videojuegos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.final_videojuegos.adapters.PokemonAdapter;
import com.example.final_videojuegos.entities.Pokemon;
import com.example.final_videojuegos.services.PokemonService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaPokemonsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Pokemon> listPokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pokemons);

        recyclerView=(RecyclerView)findViewById(R.id.rvPokemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService pokemonService = retrofit.create(PokemonService.class);

        pokemonService.getPokemonAllCall().enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if (response.code()==200){
                    PokemonAdapter pokemonAdapter = new PokemonAdapter(response.body());
                    recyclerView.setAdapter(pokemonAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });
    }
}