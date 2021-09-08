package com.example.student_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete_student extends AppCompatActivity {
    private EditText deleteEditText;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        deleteEditText = findViewById(R.id.deleteEditText);
        deleteButton = findViewById(R.id.deleteButtonId);
        DataBase dataBage = new DataBase(getApplicationContext());
        Cursor cursor = dataBage.display();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            String value = bundle.getString("update/delete");
            if(value.equals("Delete"))
            {
                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String user =  deleteEditText.getText().toString();
                        if(user.isEmpty())
                        {
                            Toast.makeText(getApplicationContext(), "Please Enter User Name", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int i = 0;
                        while (cursor.moveToNext())
                        {

                            if(user.equals(cursor.getString(0)))
                            {
                                i = 1;
                            }

                        }
                        if(i==1)
                        {
                            dataBage.delete(user,getApplicationContext());
                        }
                        else if(i==0)
                        {
                            Toast.makeText(getApplicationContext(), "incorrect username!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }


            else if(value.equals("Update"))
            {
                deleteButton.setText("Enter");
                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String user =  deleteEditText.getText().toString();


                        if(user.isEmpty())
                        {
                            Toast.makeText(getApplicationContext(), "Please Enter User Name", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            int i = 0;
                            while (cursor.moveToNext())
                            {

                                if(user.equals(cursor.getString(0)))
                                {
                                    i = 1;
                                }

                            }
                            if(i == 0)
                            {
                                Toast.makeText(getApplicationContext(), "incorrect username!", Toast.LENGTH_SHORT).show();
                            }
                            else if(i == 1){
                                Intent intent = new Intent(getApplicationContext(),signup_page.class);
                                intent.putExtra("update",user);
                                startActivity(intent);
                            }
                        }

                    }
                });
            }


        }


    }
}