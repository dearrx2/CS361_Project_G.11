package com.example.cs361_project_g11;

// FocusSessionAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FocusSessionAdapter extends RecyclerView.Adapter<FocusSessionAdapter.ViewHolder> {
    private List<FocusSession> focusSessions;

    public FocusSessionAdapter(List<FocusSession> focusSessions) {
        this.focusSessions = focusSessions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_focus_session, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FocusSession focusSession = focusSessions.get(position);
        holder.selectedTimeTextView.setText(focusSession.selectedTime);
        holder.workFocusTextView.setText(focusSession.workFocus);
    }

    @Override
    public int getItemCount() {
        return focusSessions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView selectedTimeTextView;
        private TextView workFocusTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            selectedTimeTextView = itemView.findViewById(R.id.selectedTimeTextView);
            workFocusTextView = itemView.findViewById(R.id.workFocusTextView);
        }
    }
}

