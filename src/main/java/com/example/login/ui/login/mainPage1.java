package com.example.login.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;

public class mainPage1 extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs_login";
    SharedPreferences sharedpreferences;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page1);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        final Button sportb = findViewById(R.id.sport);
        final Button notes = findViewById(R.id.note);
        final Button emergencyb = findViewById(R.id.emg);
        final Button symptomsb = findViewById(R.id.symptoms);

        sportb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent1 = new Intent(mainPage1.this, sport.class);
                startActivity(intent1);
            }
        });

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent2 = new Intent(mainPage1.this, medicine.class);
                startActivity(intent2);
            }
        });

        emergencyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });

        symptomsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent4 = new Intent(mainPage1.this, symptoms.class);
                startActivity(intent4);
            }
        });
    }

    public void logout(View view) {


        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putBoolean("isLoginKey", false);
        finish();

    }

}
