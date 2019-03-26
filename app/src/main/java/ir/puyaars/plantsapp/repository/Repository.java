package ir.puyaars.plantsapp.repository;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;
import ir.puyaars.plantsapp.repository.entities.PlantEntity;
import ir.puyaars.plantsapp.repository.database.PlantsDatabase;
import ir.puyaars.plantsapp.repository.network.Network;
import ir.puyaars.plantsapp.repository.network.WepApi;
import ir.puyaars.plantsapp.repository.utils.SampleData;
import retrofit2.Call;

public class Repository {
    private static Repository ourInstance;

    public LiveData<List<PlantEntity>> mPlants;
    private PlantsDatabase database;
    private Executor executor = Executors.newSingleThreadExecutor();
    private WepApi network;

    public static Repository getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new Repository(context);
        }
        return ourInstance;
    }

    private Repository(Context context) {
        database = PlantsDatabase.getInstance(context);
        mPlants = getLocalPlants();
    }

    private LiveData<List<PlantEntity>> getLocalPlants() {
        return database.plantDao().getAllPlants();
    }


    /**
     * checks if database is empty
     * if so adds a bunch of predefined data
     */
    public Repository initDatabase() {
        executor.execute(() -> {
            if(database.plantDao().countPlants() == 0){
                Log.i("database", "init: "+ "table was empty");
                database.plantDao().insertAllPlants(SampleData.getSampleData());
            }
            Log.i("database", "init: "+ database.plantDao().countPlants());
        });

        return this;
    }

    /**
     * checks if database is empty
     * if so adds a bunch of predefined data from assets
     *  @param context to get asset
     * @param fileName name of asset file
     * */
    public Repository initDatabase(Context context, String fileName) {
        executor.execute(() -> {
            if(database.plantDao().countPlants() == 0){
                Log.i("database", "init: "+ "table was empty");
                database.plantDao().insertAllPlants(SampleData.loadAssetPlants(context,fileName));
            }
            Log.i("database", "init: "+ database.plantDao().countPlants());
        });
        return this;
    }

    public void initNetwork(String baseURL) {
        network = Network.BuildApi(baseURL);
        executor.execute(() -> {
            Call<List<PlantEntity>> call = network.getAllPlants();
            List<PlantEntity> plantEntities;
            try {
                plantEntities = call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            database.plantDao().insertAllPlants(plantEntities);
        });
    }

    public PlantEntity getPlantById(int plantId) {
        return database.plantDao().getPlantById(plantId);
    }

    public void savePlant(PlantEntity mPlant) {
        executor.execute(() -> database.plantDao().insertPlant(mPlant));
    }
}
