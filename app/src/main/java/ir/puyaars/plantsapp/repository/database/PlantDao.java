package ir.puyaars.plantsapp.repository.database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import ir.puyaars.plantsapp.repository.entities.PlantEntity;

@Dao
public interface PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlant(PlantEntity plantEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPlants(List<PlantEntity> plantEntity);

    @Delete
    void deletePlant(PlantEntity plantEntity);

    @Query("SELECT * FROM plants WHERE  id = :id")
    PlantEntity getPlantById(int id);

    @Query("SELECT * FROM plants WHERE  favourite = :b ORDER BY id ASC")
    LiveData<List<PlantEntity>> getPlantByFavourite(boolean b);

    @Query("SELECT * FROM plants ORDER BY id ASC")
    LiveData<List<PlantEntity>> getAllPlants();

    @Query("DELETE FROM plants")
    int deleteAllplants();

    @Query("SELECT COUNT(*) FROM plants")
    int countPlants();

}
