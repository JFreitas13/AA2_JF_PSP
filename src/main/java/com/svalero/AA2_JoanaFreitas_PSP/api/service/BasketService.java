package com.svalero.AA2_JoanaFreitas_PSP.api.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.svalero.AA2_JoanaFreitas_PSP.api.model.Team;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BasketService {

    private String BASE_URL = "https://www.balldontlie.io";

    private  BasketAPI basketAPI;

    public BasketService(){
        // Configuramos el log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC); //definimos un nivel de debugeo
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gsonParser = new GsonBuilder()
                .setLenient() //Lo configuramos
                .create(); //Se crea

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) //Le pasamos la URL base de la API
                .client(client) //pasamos el cliente del log
                .addConverterFactory(GsonConverterFactory.create(gsonParser)) //Le añadimos el parseados Gson creado
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  // Usamos el adaptador de RxJava para crear el observable
                .build(); //Lo creamos

        this.basketAPI = retrofit.create(BasketAPI.class); //Lo conectamos a la API que hemos definido
    }

    //convertir el observable de lista en un observable Team
    public Observable<Team> getTeams() {
        return  this.basketAPI.getAllTeams().flatMapIterable(team ->team);
    }
}
