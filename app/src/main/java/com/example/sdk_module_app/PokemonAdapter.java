package com.example.sdk_module_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PokemonAdapter extends BaseAdapter {
    private Context context;
    private List<Pokemon> pokemonList;
    private LayoutInflater inflater;

    public PokemonAdapter(Context context,List<Pokemon> pokemonList){
        this.context = context;
        this.pokemonList = pokemonList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pokemonList.size();
    }

    @Override
    public Pokemon getItem(int position) {
        return pokemonList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.activity_adapter_pokemon,null);

        Pokemon currentPokemon = getItem(i);
        String pokemonName = currentPokemon.getName();
        String pokemonUrl = currentPokemon.getUrl();

        TextView pokemonNameView = view.findViewById(R.id.name);
        pokemonNameView.setText(pokemonName);

        TextView pokemonUrlView = view.findViewById(R.id.url);
        pokemonUrlView.setText(pokemonUrl);

        return view;
    }
}
