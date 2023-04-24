package com.example.login.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;

public class sport extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport);

        Button warmup = findViewById(R.id.warmUp);
        Button aerobic = findViewById(R.id.aerobic);

        warmup.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            Intent intent = new Intent(sport.this, warmup.class);
            startActivity(intent);
        });

        aerobic.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            Intent intent = new Intent(sport.this, aerobic.class);
            startActivity(intent);
        });
    }
}
