package com.example.login.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;

public class cycling extends AppCompatActivity {

    private int counterMin = 20;
    private int counterSec = 0;
    private long num = 1200000;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cycling);

        final Button minusb = findViewById(R.id.cycling_minus);
        final Button plusb = findViewById(R.id.cycling_plus);
        final Button resetb = findViewById(R.id.cycling_reset);
        Button cyclingTimer = findViewById(R.id.cycling_timer);

        resetb.setOnClickListener(v -> {

            num = 1200000;
            counterMin = 20;
            counterSec = 0;
            cyclingTimer.setText(counterMin + " : " + counterSec);
        });

        minusb.setOnClickListener(v -> {

            if (counterMin > 0) {
                num = num - 60000;
                counterMin--;
            }
            cyclingTimer.setText(counterMin + " : " + counterSec);
        });

        plusb.setOnClickListener(v -> {
            if (counterMin < 30) {
                num = num + 60000;
                counterMin = counterMin + 1;
            }
            cyclingTimer.setText(counterMin + " : " + counterSec);
        });

        cyclingTimer.setOnClickListener(v -> {
            new CountDownTimer(num, 1000) {
                public void onTick(long millisUntilFinished) {

                    if (counterSec == 0) {
                        counterMin--;
                        counterSec = 60;
                    }
                    if (counterMin < 0) {
                        cyclingTimer.setText("FINISH!!");
                    } else {
                        counterSec--;
                        cyclingTimer.setText(counterMin + " : " + counterSec);
                    }
                }

                @Override
                public void onFinish() {
                }
            }.start();
        });
    }
}
