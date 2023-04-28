package com.svalero.AA2_JoanaFreitas_PSP.api.service;

import com.svalero.AA2_JoanaFreitas_PSP.api.model.Team;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface BasketAPI {

    //obtener una lista de equipos
    @GET("api/v1/teams")
    Observable<List<Team>> getAllTeams();

    //obtener informacion de un equipo por id
    @GET("api/v1/teams/{id}")
    Observable<List<Team>> getByID(@Path("id") String id);

}
