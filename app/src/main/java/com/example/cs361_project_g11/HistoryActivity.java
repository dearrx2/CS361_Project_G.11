package com.example.cs361_project_g11;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs361_project_g11.FocusSession;
import com.example.cs361_project_g11.FocusSessionAdapter;
import com.example.cs361_project_g11.MyApp;
import com.example.cs361_project_g11.R;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FocusSessionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<FocusSession> focusSessions = MyApp.database.focusSessionDao().getAllFocusSessions();

        adapter = new FocusSessionAdapter(focusSessions);
        recyclerView.setAdapter(adapter);
    }
}
