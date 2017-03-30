package com.cipsa.appparquimetro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        final int totalProgressTime = 50;
        final Thread timerThread = new Thread() {
            public void run() {
                try {
                    int jumpTime = 0;

                    while (jumpTime < totalProgressTime) {
                        sleep(1000);
                        jumpTime += 10;
//                        pbSplachCargando.setProgress(jumpTime);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(ScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();

    }
}
