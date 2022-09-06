package com.example.sdk_module_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Liste extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_liste);

         ArrayList<Pokemon> pokemonList = new ArrayList<>();

         ListView pokemonListView = findViewById(R.id.pokemon_list_view);

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                "https://pokeapi.co/api/v2/pokemon/",
                response -> {
                    try {
                        JSONArray jsonPokemonList = response.getJSONArray("results");
                        for(int i = 0; i < jsonPokemonList.length(); i++ ) {
                            try {
                                JSONObject json = jsonPokemonList.getJSONObject(i);
                                Pokemon pokemon = new Pokemon(json);
                                pokemonList.add(pokemon);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        pokemonListView.setAdapter(new PokemonAdapter(this,pokemonList));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.e("volley",error.toString())
        );
        RequestManager.getInstance(this).addToRequestQueue(jsonArrayRequest);

    }
}
