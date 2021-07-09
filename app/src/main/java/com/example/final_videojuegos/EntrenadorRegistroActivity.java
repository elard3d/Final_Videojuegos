package com.example.final_videojuegos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.final_videojuegos.entities.Entrenador;
import com.example.final_videojuegos.services.EntrenadorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EntrenadorRegistroActivity extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_PERMISION = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenador_registro);

        Button btnCancelar = findViewById(R.id.btnCanelarRegistro);

        final EditText nombres = findViewById(R.id.txtNombreRegistro);
        final EditText pueblo = findViewById(R.id.txtPuebloRegistro);
        //final EditText imagen = findViewById(R.id.);

        findViewById(R.id.btnRegistrarRegistro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Entrenador entrenador = new Entrenador();
                entrenador.setNombres(nombres.getText().toString());
                entrenador.setPueblo(pueblo.getText().toString());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://upn.lumenes.tk/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                EntrenadorService entrenadorService = retrofit.create(EntrenadorService.class);

                entrenadorService.postEntrenadorCall(entrenador).enqueue(new Callback<Entrenador>() {
                    @Override
                    public void onResponse(Call<Entrenador> call, Response<Entrenador> response) {

                    }

                    @Override
                    public void onFailure(Call<Entrenador> call, Throwable t) {
                        Log.e("ERROR3",t.getMessage());
                    }
                });

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntrenadorRegistroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}