package com.example.mnlgu.challenge1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://api.myjson.com/bins/17alm6" ; //aca se pone el link del json
    private JsonObjectRequest request;
    private RequestQueue requestQueue;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
    }

    private void jsonRequest(){
        request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                try{

                    JSONArray cardsJSON = response.getJSONArray("cards");
                    JSONObject jsonObject = null;

                    for(int i = 0; i < cardsJSON.length(); i++){
                        jsonObject = cardsJSON.getJSONObject(i);

                        //PokeCard pokeCard = new PokeCard();
                        //pokeCard.setId(jsonObject.getString("id"));
                        //pokeCard.setName(jsonObject.getString("name"));
                        //pokeCard.setImageURL(jsonObject.getString("imageUrl"));
                        //pokeCard.setArtist(jsonObject.getString("artist"));

                        //cards.add(pokeCard);
                    }

                }
                catch(JSONException jsonException){
                    jsonException.printStackTrace();
                }

                //setRecyclerView(cards);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error del Server", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    /*
    private void setRecyclerView(List<PokeCard> pokeCards){
        PokeRecycleAdapter pokeRecycleAdapter = new PokeRecycleAdapter(this, pokeCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pokeRecycleAdapter);
    }
    */
}
