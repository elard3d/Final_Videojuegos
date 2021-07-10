package com.example.final_videojuegos.services;

import com.example.final_videojuegos.entities.Entrenador;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EntrenadorService {
    @GET("entrenador/720013")
    Call<Entrenador> getEntrenadorCall();
    @POST("entrenador/720013")
    Call<Entrenador> postEntrenadorCall(@Body Entrenador entrenador);
}
