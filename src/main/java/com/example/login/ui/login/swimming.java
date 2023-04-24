package com.example.login.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;

public class swimming extends AppCompatActivity {

    private int counterMin = 20;
    private int counterSec = 0;
    private long num = 1200000;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swimming);

        Button swimTimer = findViewById(R.id.swim_timer);
        Button minusb = findViewById(R.id.swim_minus);
        Button plusb = findViewById(R.id.swim_plus);
        Button resetb = findViewById(R.id.swim_reset);

        resetb.setOnClickListener(v -> {
            num = 1200000;
            counterMin = 20;
            counterSec = 0;
            swimTimer.setText(String.valueOf(counterMin) + " : " + String.valueOf(counterSec));
        });

        minusb.setOnClickListener(v -> {
            if (counterMin > 0) {
                num = num - 60000;
                counterMin--;
            }
            swimTimer.setText(String.valueOf(counterMin) + " : " + String.valueOf(counterSec));
        });

        plusb.setOnClickListener(v -> {
            if (counterMin < 30) {
                num = num + 60000;
                counterMin = counterMin + 1;
            }
            swimTimer.setText(counterMin + " : " + counterSec);
        });


        swimTimer.setOnClickListener(v -> {
            new CountDownTimer(num, 1000) {
                public void onTick(long millisUntilFinished) {

                    if (counterSec == 0) {
                        counterMin--;
                        counterSec = 60;
                    }
                    if (counterMin < 0) {
                        swimTimer.setText("FINISH!!");
                    } else {
                        counterSec--;
                        swimTimer.setText(String.valueOf(counterMin) + " : " + String.valueOf(counterSec));
                    }
                }

                @Override
                public void onFinish() {
                }
            }.start();
        });
    }
}
