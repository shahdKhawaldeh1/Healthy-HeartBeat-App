package com.example.login.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;

public class yoga extends AppCompatActivity {

    private int counterMin = 20;
    private int counterSec = 0;
    private long num = 1200000;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yoga);

        Button yogaTimer = findViewById(R.id.yoga_timer);
        Button minusb = findViewById(R.id.yoga_minus);
        Button plusb = findViewById(R.id.yoga_plus);
        Button resetb = findViewById(R.id.yoga_reset);

        resetb.setOnClickListener(v -> {
            num = 1200000;
            counterMin = 20;
            counterSec = 0;
            yogaTimer.setText(String.valueOf(counterMin) + " : " + String.valueOf(counterSec));
        });

        minusb.setOnClickListener(v -> {
            if (counterMin > 0) {
                num = num - 60000;
                counterMin--;
            }
            yogaTimer.setText(String.valueOf(counterMin) + " : " + String.valueOf(counterSec));
        });

        plusb.setOnClickListener(v -> {
            if (counterMin < 30) {
                num = num + 60000;
                counterMin = counterMin + 1;
            }
            yogaTimer.setText(counterMin + " : " + counterSec);
        });

        yogaTimer.setOnClickListener(v -> {
            new CountDownTimer(num, 1000) {
                public void onTick(long millisUntilFinished) {

                    if (counterSec == 0) {
                        counterMin--;
                        counterSec = 60;
                    }
                    if (counterMin < 0) {
                        yogaTimer.setText("FINISH!!");
                    } else {
                        counterSec--;
                        yogaTimer.setText(String.valueOf(counterMin) + " : " + String.valueOf(counterSec));
                    }
                }

                @Override
                public void onFinish() {
                }
            }.start();
        });
    }
}
