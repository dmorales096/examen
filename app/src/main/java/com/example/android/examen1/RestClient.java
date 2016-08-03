package com.example.android.examen1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by diegomorales on 02/08/2016.
 */


public class RestClient {

    private ApiRest api;
    private final String URL_BASE = "http://jsonplaceholder.typicode.com/";
    public RestClient(){
        GsonConverterFactory converter = GsonConverterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(converter)
                .baseUrl(URL_BASE)
                .build();
        api = retrofit.create(ApiRest.class);
    }

    public ApiRest getApi(){
        return api;
    }

    interface ApiRest{
        @GET("users")
        Call<List<UsuarioQuery>> getUsers();


    }
}
