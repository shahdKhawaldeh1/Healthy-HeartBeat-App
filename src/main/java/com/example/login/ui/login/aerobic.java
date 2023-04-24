package com.example.login.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;

public class aerobic extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aerobic);

        Button walkb = findViewById(R.id.walk);
        Button swimb = findViewById(R.id.swim);
        Button cycleb = findViewById(R.id.cycle);
        Button yogab = findViewById(R.id.yoga);
        Button danceb = findViewById(R.id.dance);

        walkb.setOnClickListener(v -> {

            // TODO Auto-generated method stub
            Intent walkI = new Intent(aerobic.this, walking.class);
            startActivity(walkI);

        });

        swimb.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            Intent swimI = new Intent(aerobic.this, swimming.class);
            startActivity(swimI);

        });

        cycleb.setOnClickListener(v -> {

            // TODO Auto-generated method stub
            Intent cycleI = new Intent(aerobic.this, cycling.class);
            startActivity(cycleI);

        });

        yogab.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            Intent yogaI = new Intent(aerobic.this, yoga.class);
            startActivity(yogaI);

        });

        danceb.setOnClickListener(v -> {

            // TODO Auto-generated method stub
            Intent danceI = new Intent(aerobic.this, dancing.class);
            startActivity(danceI);

        });
    }
}
