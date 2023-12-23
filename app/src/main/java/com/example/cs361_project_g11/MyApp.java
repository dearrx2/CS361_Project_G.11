package com.example.cs361_project_g11;

import android.app.Application;

import androidx.room.Room;

import com.example.cs361_project_g11.AppDatabase;

public class MyApp extends Application {

    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "your-database-name")
                .allowMainThreadQueries() // Note: You should not do queries on the main thread. This is just for the example.
                .build();
    }
}
