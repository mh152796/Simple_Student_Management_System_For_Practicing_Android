package com.example.student_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feed_back extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText, messageEditText;
    Button submitButton,clearButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        nameEditText = findViewById(R.id.nameId);
        messageEditText = findViewById(R.id.messageId);
        submitButton = findViewById(R.id.submitButtonId);
        clearButton = findViewById(R.id.clearButtonId);

        submitButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        try {
            String name = nameEditText.getText().toString();
            String message = messageEditText.getText().toString();
            if(v.getId() == R.id.submitButtonId)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"mosarofdiu123@gmail.com"});
                intent.putExtra(Intent.EXTRA_TEXT, "Name : "+name + "\n Message: "+message);
                startActivity(Intent.createChooser(intent,"share with"));
            }
            else if(v.getId() == R.id.clearButtonId)
            {
                nameEditText.setText("");
                messageEditText.setText("");
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Exception "+e, Toast.LENGTH_SHORT).show();
        }

    }

}