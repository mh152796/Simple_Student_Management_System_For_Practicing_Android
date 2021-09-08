package com.example.student_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userName, password;
    private CheckBox checkBox;
    private TextView signUp;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        userName = findViewById(R.id.userNameId);
        password = findViewById(R.id.passId);
        checkBox = findViewById(R.id.showPassword);
        login = findViewById(R.id.login_btn);
        signUp = findViewById(R.id.signUpId);
        signUp.setOnClickListener(this);
        login.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!checkBox.isChecked()) {
                    // show password
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.signUpId)
        {
            Intent intent = new Intent(getApplicationContext(),signup_page.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.login_btn)
        {
            String user =  userName.getText().toString();
            String pass =  password.getText().toString();
            DataBase dataBage = new DataBase(this);
            Cursor cursor = dataBage.display();

            if(user.isEmpty())
            {
                Toast.makeText(this, "Please Enter User Name", Toast.LENGTH_SHORT).show();
            }
            else if(pass.isEmpty()){
                Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            }
            else
            {

                if (cursor.getCount() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Not Found!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (cursor.moveToNext())
                    {

                        if(user.equals(cursor.getString(0)) && pass.equals(cursor.getString(3)))
                        {
                            stringBuffer.append("User Name: "+cursor.getString(0)+"\n\n");
                            stringBuffer.append("Full NAME: "+cursor.getString(1)+"\n\n");
                            stringBuffer.append("Mobile Number: "+cursor.getString(2)+"\n");
                        }

                    }
                    showData(stringBuffer);
                }
            }
        }
    }

    private void showData(StringBuffer message) {
        if(message.length() == 0)
        {
            Toast.makeText(this, "Wrong username or password!", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(getApplicationContext(),student_info.class);
            intent.putExtra("key",message.toString());
            startActivity(intent);
        }

    }

}