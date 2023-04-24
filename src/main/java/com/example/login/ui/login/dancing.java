package com.example.login.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;

public class dancing extends AppCompatActivity {

    private int counterMin = 20;
    private int counterSec = 0;
    private long num = 1200000;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dancing);

        Button danceTimer = findViewById(R.id.dance_timer);
        final Button minusb = findViewById(R.id.dance_minus);
        final Button plusb = findViewById(R.id.dance_plus);
        final Button resetb = findViewById(R.id.dance_reset);

        resetb.setOnClickListener(v -> {
            num = 1200000;
            counterMin = 20;
            counterSec = 0;
            danceTimer.setText(counterMin + " : " + counterSec);
        });

        minusb.setOnClickListener(v -> {
            if (counterMin > 0) {
                num = num - 60000;
                counterMin--;
            }
            danceTimer.setText(counterMin + " : " + counterSec);
        });

        plusb.setOnClickListener(v -> {
            if (counterMin < 30) {
                num = num + 60000;
                counterMin = counterMin + 1;
            }
            danceTimer.setText(counterMin + " : " + counterSec);
        });

        danceTimer.setOnClickListener(v -> {
            new CountDownTimer(num, 1000) {
                public void onTick(long millisUntilFinished) {

                    if (counterSec == 0) {
                        counterMin--;
                        counterSec = 60;
                    }
                    if (counterMin < 0) {
                        danceTimer.setText("FINISH!!");
                    } else {
                        counterSec--;
                        danceTimer.setText(counterMin + " : " + counterSec);
                    }
                }

                @Override
                public void onFinish() {
                }
            }.start();
        });
    }
}