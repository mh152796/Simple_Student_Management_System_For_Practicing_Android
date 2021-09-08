package com.example.student_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class student_details extends AppCompatActivity {
    private TextView studentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        studentDetails = findViewById(R.id.allStudentInfo);

        DataBase dataBage = new DataBase(this);
        Cursor cursor = dataBage.display();

        if (cursor.getCount() == 0)
            {
                Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_SHORT).show();
                return;
            }
        else
            {
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext())
                {

                        stringBuffer.append("User Name: "+cursor.getString(0)+"\n");
                        stringBuffer.append("Full NAME: "+cursor.getString(1)+"\n");
                        stringBuffer.append("Mobile Number: "+cursor.getString(2)+"\n\n");
                    }
                studentDetails.setText(stringBuffer);

            }

    }

}