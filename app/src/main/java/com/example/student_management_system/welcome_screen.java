package com.example.student_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class welcome_screen extends AppCompatActivity {
    private ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        progressBar = findViewById(R.id.progrssId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                do_work();
                startApp();
            }
        });

        thread.start();
    }

    public void do_work() {

        for(progress = 20; progress<=100; progress += 20)
        {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startApp()
    {
        Intent intent = new Intent(getApplicationContext(),user_admin_page.class);
        startActivity(intent);
        finish();
    }
}