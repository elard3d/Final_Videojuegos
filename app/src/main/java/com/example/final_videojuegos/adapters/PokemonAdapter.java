package com.example.final_videojuegos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_videojuegos.R;
import com.example.final_videojuegos.entities.Pokemon;
import com.example.final_videojuegos.services.PokemonService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    public List<Pokemon> listaPokemon ;

    public PokemonAdapter(List<Pokemon> listaPokemon) {
        this.listaPokemon = listaPokemon;
    }

    @Override
    public PokemonAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pokemon,parent, false);

        return new PokemonViewHolder(view, parent) ;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.PokemonViewHolder holder, int position) {
        Pokemon lista=listaPokemon.get(position);
        holder.setItem(lista);
    }

    @Override
    public int getItemCount() {
        return listaPokemon.size();
    }


    public class PokemonViewHolder extends RecyclerView.ViewHolder {

        ViewGroup viewGroup;
        Pokemon pokemon;

        public TextView nombre;
        public TextView tipo;
        public TextView imagen;
        public TextView latitude;
        public TextView longitude;

        public PokemonViewHolder(@NonNull View itemView, ViewGroup viewGroup) {
            super(itemView);
            this.viewGroup = viewGroup ;

            nombre = itemView.findViewById(R.id.tvNombre);
            tipo = itemView.findViewById(R.id.tvTipo);
            //imagen = itemView.findViewById(R.id.ImagenPokemon);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    /*Context context = view.getContext();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://upn.lumenes.tk/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    PokemonService pokemonService=retrofit.create(PokemonService.class);
                    pokemonService.getPokemonCall();*/


                }
            });

        }

        public void setItem (Pokemon pokemon) {

            this.pokemon = pokemon;

            nombre.setText(pokemon.getNombre());
            tipo.setText(pokemon.getTipo());


        }
    }
}
