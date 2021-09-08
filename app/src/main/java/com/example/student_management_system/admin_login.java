package com.example.student_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class admin_login extends AppCompatActivity implements View.OnClickListener {

    private EditText adminUserName, adminPassword;
    private CheckBox adminCheckBox;
    private Button adminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        adminUserName = findViewById(R.id.adminUserNameId);
        adminPassword = findViewById(R.id.adminPassId);
        adminCheckBox = findViewById(R.id.adminShowPassword);
        adminLogin = findViewById(R.id.admin_login_btn);
        adminLogin.setOnClickListener(this);
        adminCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!adminCheckBox.isChecked()) {
                    // show password
                    adminPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    adminPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.admin_login_btn)
        {
            String admin =  "mosaraf";
            String password = "2796";
            String user =  adminUserName.getText().toString();
            String pass =  adminPassword.getText().toString();

                if(admin.isEmpty())
                 {
                Toast.makeText(this, "Please Enter User Name", Toast.LENGTH_SHORT).show();
                 }
                else if(password.isEmpty()){
                    Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
            else
            {

                if (user.equals(admin) && pass.equals(password))
                {
                    Intent intent = new Intent(getApplicationContext(),admin.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "wrong username or password", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

}