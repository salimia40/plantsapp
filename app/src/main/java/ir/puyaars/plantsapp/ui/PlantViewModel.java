package ir.puyaars.plantsapp.ui;

import android.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import ir.puyaars.plantsapp.repository.Repository;
import ir.puyaars.plantsapp.repository.entities.PlantEntity;

public class PlantViewModel extends AndroidViewModel {

    public MutableLiveData<PlantEntity> mPlant = new MutableLiveData<>();
    public Repository repository;
    private Executor executor = Executors.newSingleThreadExecutor();

    public PlantViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application.getApplicationContext());
    }

    public void loadData(int plantId) {
        executor.execute(() -> {
            PlantEntity plant = repository.getPlantById(plantId);
            mPlant.postValue(plant);
        });
    }

    public void savePlant(PlantEntity plant) {
        executor.execute(() -> {
            repository.savePlant(plant);
            this.mPlant.postValue(plant);
        });
    }
}
