package com.example.student_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class admin extends AppCompatActivity implements View.OnClickListener {
    private Button listOfStudentButton,removeStudentButton,updateStudentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        listOfStudentButton = findViewById(R.id.show_studentId);
        removeStudentButton = findViewById(R.id.removeStudentId);
        updateStudentButton = findViewById(R.id.updateStudentId);

        listOfStudentButton.setOnClickListener(this);
        removeStudentButton.setOnClickListener(this);
        updateStudentButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.show_studentId){
            Intent intent = new Intent(getApplicationContext(),student_details.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.removeStudentId){
            Intent intent = new Intent(getApplicationContext(),delete_student.class);
            intent.putExtra("update/delete","Delete");
            startActivity(intent);
        }
        else if(view.getId() == R.id.updateStudentId){
            Intent intent = new Intent(getApplicationContext(),delete_student.class);
            intent.putExtra("update/delete","Update");
            startActivity(intent);
        }
    }
}