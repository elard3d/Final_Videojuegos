package com.example.final_videojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.final_videojuegos.entities.Entrenador;
import com.example.final_videojuegos.services.EntrenadorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EntrenadorDetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenador_detalle);

        Button btnRegresar = findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntrenadorDetalleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EntrenadorService entrenadorService = retrofit.create(EntrenadorService.class);

        entrenadorService.getEntrenadorCall().enqueue(new Callback<Entrenador>() {
            @Override
            public void onResponse(Call<Entrenador> call, Response<Entrenador> response) {
                if(response.code()==200){
                    TextView nombres = findViewById(R.id.txtNombreDetalle);
                    TextView pueblo = findViewById(R.id.txtPuebloDetalle);
                    ImageView imagen = findViewById(R.id.ImagenPokemon);

                    nombres.setText(response.body().nombres);
                    pueblo.setText(response.body().pueblo);
                }


            }

            @Override
            public void onFailure(Call<Entrenador> call, Throwable t) {

            }
        });


    }
}