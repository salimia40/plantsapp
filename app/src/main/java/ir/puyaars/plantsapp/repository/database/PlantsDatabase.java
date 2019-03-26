package ir.puyaars.plantsapp.repository.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import ir.puyaars.plantsapp.repository.entities.PlantEntity;


@Database(entities = {PlantEntity.class}, version = 1,exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class PlantsDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "plants.db";
    public static volatile PlantsDatabase instance;

    public static final Object LOCK = new Object();

    public abstract PlantDao plantDao();

    public static PlantsDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK){
                if (instance == null) {
                     instance = Room.databaseBuilder(context.getApplicationContext(),PlantsDatabase.class,DATABASE_NAME)
                             // TODO make migration class but im lazy and its not necessary in case of this app
                             .fallbackToDestructiveMigration()
                             .build();
                }
            }
        }
        return instance;
    }
}
