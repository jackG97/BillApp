package com.example.billapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {

    private Button Login;// varibales
    private Button Reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //find id method for variables and items
        Login = (Button) findViewById(R.id.BtnLogin);
        Reg = (Button) findViewById(R.id.BtnReg);

        //on click function for login button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenLogin();
            }
        });

        //on click function for register button
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenReg();
            }
        });
    }

    //open login method which directs you to the login page
    public void OpenLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    //open register method which directs you to the register page
    public void OpenReg(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    }

