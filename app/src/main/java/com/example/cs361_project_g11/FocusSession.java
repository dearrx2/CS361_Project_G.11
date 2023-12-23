package com.example.cs361_project_g11;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FocusSession {
    @PrimaryKey(autoGenerate = true)
    public int id;


    public String selectedTime;
    public String workFocus;
}
