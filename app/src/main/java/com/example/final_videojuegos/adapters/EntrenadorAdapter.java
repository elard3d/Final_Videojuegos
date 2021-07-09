package com.example.final_videojuegos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_videojuegos.R;
import com.example.final_videojuegos.entities.Entrenador;

import java.util.List;

public class EntrenadorAdapter extends RecyclerView.Adapter<EntrenadorAdapter.EntrenadorViewHolder> {

    Entrenador entrenador;

    public EntrenadorAdapter(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public EntrenadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_entrenador_detalle,parent,false);


        return new EntrenadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EntrenadorAdapter.EntrenadorViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EntrenadorViewHolder extends RecyclerView.ViewHolder{

        public EntrenadorViewHolder(View itemView) {
            super(itemView);
        }
    }
}
