package com.example.student_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup_page extends AppCompatActivity {

    private EditText userNameEditText,fullNameEditText,mobileNumberEditText,passwordEditText;
    private TextView updateTextView;
    private CheckBox conditionCheck;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        updateTextView = findViewById(R.id.updateId);

        userNameEditText = findViewById(R.id.userNameSignUpId);
        fullNameEditText = findViewById(R.id.fullNameSignUpId);
        mobileNumberEditText = findViewById(R.id.mobileNumberSignUpId);
        passwordEditText = findViewById(R.id.passwordSignUpId);
        conditionCheck = findViewById(R.id.checkboxSignUpId);
        signUpButton = findViewById(R.id.buttonSignUpId);

        DataBase dataBase = new DataBase(getApplicationContext());
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String oldUserName = bundle.getString("update").toString();
            updateTextView.setText("Update");
            signUpButton.setText("Update");
            signUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(conditionCheck.isChecked())
                    {
                        DataBase dataBage = new DataBase(getApplicationContext());
                        int rowId = 0;
                        rowId = dataBage.update(oldUserName,userNameEditText.getText().toString(),fullNameEditText.getText().toString(),
                                mobileNumberEditText.getText().toString(),passwordEditText.getText().toString());
                        if(rowId == 0)
                        {
                            Toast.makeText(getApplicationContext(),"Unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                        else {

                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "make sure you agreed with all terms and conditions", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
        else {
            signUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(conditionCheck.isChecked())
                    {
                        String name = userNameEditText.getText().toString();
                        String fullName = fullNameEditText.getText().toString();
                        String mobile = mobileNumberEditText.getText().toString();
                        String password = passwordEditText.getText().toString();
                        long rowId = dataBase.insert(name, fullName, mobile, password);
                        if(rowId == -1)
                        {
                            Toast.makeText(getApplicationContext(),"Unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "make sure you agreed with all terms and conditions", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}


