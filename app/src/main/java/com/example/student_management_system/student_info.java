package com.example.student_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class student_info extends AppCompatActivity {
    private TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        infoTextView = findViewById(R.id.infoId);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String value = bundle.getString("key");
            infoTextView.setText(value);
        }
    }
}