package com.example.cs361_project_g11;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FocusSession.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FocusSessionDao focusSessionDao();
}

