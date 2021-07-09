package com.example.final_videojuegos.services;

import com.example.final_videojuegos.entities.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonService {
    @GET("pokemons/111/")
    Call <List<Pokemon>> getPokemonAllCall();
    @GET("pokemons/111/")
    Call<Pokemon> getPokemonCall();
    @POST("pokemons/111/crear")
    Call<Pokemon> postPokemonCall(@Body Pokemon pokemon);
}
