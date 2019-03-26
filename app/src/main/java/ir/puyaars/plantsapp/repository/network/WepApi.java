package ir.puyaars.plantsapp.repository.network;

import java.util.List;

import ir.puyaars.plantsapp.repository.entities.PlantEntity;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WepApi {

    @GET("/api/all")
    Call<List<PlantEntity>> getAllPlants();

}
