package com.example.signup_login_realtime;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewEventsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EventAdapter eventAdapter;
    ArrayList<Event> eventList; // Change the type to ArrayList<Event>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);

        recyclerView = findViewById(R.id.recyclerViewEvents);

        if (getIntent().hasExtra("eventList")) {
            eventList = getIntent().getParcelableArrayListExtra("eventList");
            eventAdapter = new EventAdapter(eventList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(eventAdapter);
        }
    }

}