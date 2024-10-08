package com.example.dishdash.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.dishdash.model.response.Food;
import com.example.dishdash.model.response.FoodPlan;

@Database(entities = {Food.class, FoodPlan.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance = null;
    public abstract FoodDAO getProductDAO();

    public static synchronized  AppDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"Fooddb")
                    .build();
        }
        return instance;
    }

}
