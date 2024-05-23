package com.example.signup_login_realtime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OrganizerMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_menu);

        Button buttonStudent = findViewById(R.id.buttonStudent);
        Button buttonOrganizer = findViewById(R.id.buttonOrganizer);

        buttonStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Student Activity
                startActivity(new Intent(OrganizerMenuActivity.this, StudentActivity.class));
            }
        });

        buttonOrganizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Add Event Activity
                startActivity(new Intent(OrganizerMenuActivity.this, AddEventActivity.class));
            }
        });
    }
}