package ir.puyaars.plantsapp.repository.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    public static WepApi BuildApi(String baseURL) {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WepApi api = retrofit.create(WepApi.class);
        return api;
    }

}
