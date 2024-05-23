package com.ex;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Event;
import com.example.myapplication.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> eventList;

    public EventAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.bind(event);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventNameTextView, sessionsTextView, speakersTextView, timeTextView, placeTextView;

        EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventNameTextView = itemView.findViewById(R.id.eventNameTextView);
            sessionsTextView = itemView.findViewById(R.id.sessionsTextView);
            speakersTextView = itemView.findViewById(R.id.speakersTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            placeTextView = itemView.findViewById(R.id.placeTextView);
        }

        void bind(Event event) {
            eventNameTextView.setText(event.getName());
            sessionsTextView.setText(event.getSessions());
            speakersTextView.setText(event.getSpeakers());
            timeTextView.setText(event.getTime());
            placeTextView.setText(event.getPlace());
        }
    }
}