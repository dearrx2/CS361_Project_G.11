package com.example.cs361_project_g11;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FocusSessionDao {
    @Insert
    void insert(FocusSession focusSession);

    @Query("SELECT * FROM FocusSession")
    List<FocusSession> getAllFocusSessions();
}

