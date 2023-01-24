package com.example.mvvm_arslan.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvm_arslan.ModelEmployees;


@Database(entities = {ModelEmployees.class}, version = 1)
public abstract class CartDatabase extends RoomDatabase {

    public abstract CartDAO cartDAO();

    private static CartDatabase instance;

    public static synchronized CartDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                            , CartDatabase.class, "EmployeeDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
