package ir.puyaars.plantsapp.ui;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import ir.puyaars.plantsapp.repository.Repository;
import ir.puyaars.plantsapp.repository.entities.PlantEntity;

public class MainViewModel extends AndroidViewModel {

    public LiveData<List<PlantEntity>> mPlants;
    public Repository repository;


    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.getInstance(application.getApplicationContext());
        mPlants = repository.mPlants;
    }


}
