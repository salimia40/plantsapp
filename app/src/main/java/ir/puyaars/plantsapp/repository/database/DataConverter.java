package ir.puyaars.plantsapp.repository.database;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;
import ir.puyaars.plantsapp.repository.entities.Spec;

public class DataConverter {
    @TypeConverter
    public static List<Spec> toSpecs(String json) {
        return json == null ? null : convert(json);
    }

    @TypeConverter
    public static String toString(List<Spec> specs) {
        return specs == null ? null : convert(specs);
    }

    private static String convert(List<Spec> specs) {
        Type specsType = new TypeToken<List<Spec>>() {}.getType();
        Gson gson = new Gson();
        return gson.toJson(specs,specsType);
    }

    private static List<Spec> convert(String json) {
        Type specsType = new TypeToken<List<Spec>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(json,specsType);
    }

}
