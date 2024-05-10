import android.os.Bundle;

import com.example.signup_login_realtime.R;



public class FirstPAge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_account_type_layout);

        Button buttonUser = findViewById(R.id.buttonUser);
        Button buttonOrganizer = findViewById(R.id.buttonOrganizer);

        buttonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the result as "user" and finish the activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("accountType", "user");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        buttonOrganizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the result as "organizer" and finish the activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("accountType", "organizer");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
