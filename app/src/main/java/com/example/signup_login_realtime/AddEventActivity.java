package com.example.signup_login_realtime;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddEventActivity extends AppCompatActivity {

    EditText editTextEventName, editTextSessions, editTextSpeakers, editTextTime, editTextPlace;
    Button buttonAddEvent, buttonViewEvents;
    RecyclerView recyclerView;
    EventAdapter eventAdapter;
    List<Event> eventList;
    DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        databaseReference = FirebaseDatabase.getInstance().getReference("events");

        editTextEventName = findViewById(R.id.editTextEventName);
        editTextSessions = findViewById(R.id.editTextSessions);
        editTextSpeakers = findViewById(R.id.editTextSpeakers);
        editTextTime = findViewById(R.id.editTextTime);
        editTextPlace = findViewById(R.id.editTextPlace);
        buttonAddEvent = findViewById(R.id.buttonAddEvent);
        buttonViewEvents = findViewById(R.id.buttonViewEvents);
        recyclerView = findViewById(R.id.recyclerViewEvents);

        eventList = new ArrayList<>();
        eventAdapter = new EventAdapter(eventList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(eventAdapter);

        buttonAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });

        buttonViewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass eventList to ViewEventsActivity
                Intent intent = new Intent(AddEventActivity.this, ViewEventsActivity.class);
                intent.putParcelableArrayListExtra("eventList", (ArrayList<? extends Parcelable>) new ArrayList<>(eventList));
                startActivity(intent);
            }
        });
    }

    private void addEvent() {
        String eventName = editTextEventName.getText().toString();
        String sessions = editTextSessions.getText().toString();
        String speakers = editTextSpeakers.getText().toString();
        String time = editTextTime.getText().toString();
        String place = editTextPlace.getText().toString();

        // Check if any field is empty
        if (eventName.isEmpty() || sessions.isEmpty() || speakers.isEmpty() || time.isEmpty() || place.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create new event
        Event event = new Event(eventName, sessions, speakers, time, place);

        // Generate a unique key for the event
        String eventId = databaseReference.push().getKey();

        // Add event to Firebase database
        databaseReference.child(eventId).setValue(event);

        // Add event to list
        eventList.add(event);
        eventAdapter.notifyDataSetChanged();

        // Clear input fields
        editTextEventName.getText().clear();
        editTextSessions.getText().clear();
        editTextSpeakers.getText().clear();
        editTextTime.getText().clear();
        editTextPlace.getText().clear();
    }
}