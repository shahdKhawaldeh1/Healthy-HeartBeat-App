package com.example.login.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;

public class warmup extends AppCompatActivity {

    private int counterMin = 5;
    private int counterSec = 0;
    private long num = 300000;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warmup);

        Button warmupTimer = findViewById(R.id.warmup_timer);
        Button minusb = findViewById(R.id.warmup_minus);
        Button plusb = findViewById(R.id.warmup_plus);
        Button resetb = findViewById(R.id.warmup_reset);

        resetb.setOnClickListener((v) -> {
            num = 300000;
            counterMin = 5;
            counterSec = 0;
            warmupTimer.setText(String.valueOf(counterMin) + " : " + String.valueOf(counterSec));
        });

        minusb.setOnClickListener((v) -> {

            if (counterMin > 0) {
                num = num - 60000;
                counterMin--;
            }
            warmupTimer.setText(String.valueOf(counterMin) + " : " + String.valueOf(counterSec));

        });

        plusb.setOnClickListener(v -> {
            if (counterMin < 30) {
                num = num + 60000;
                counterMin = counterMin + 1;
            }
            warmupTimer.setText(counterMin + " : " + counterSec);
        });

        warmupTimer.setOnClickListener(v -> {

            new CountDownTimer(num, 1000) {
                public void onTick(long millisUntilFinished) {

                    if (counterSec == 0) {
                        counterMin--;
                        counterSec = 60;
                    }
                    if (counterMin < 0) {
                        warmupTimer.setText("FINISH!!");
                    } else {
                        counterSec--;
                        warmupTimer.setText(String.valueOf(counterMin) + " : " + String.valueOf(counterSec));
                    }
                }

                @Override
                public void onFinish() {
                }
            }.start();

        });
    }
}
