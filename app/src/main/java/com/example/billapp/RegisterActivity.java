package com.example.billapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    //varibles
    private Button Register;
    private EditText Email1;
    private EditText Password1;
    private Boolean ValidateEmail1= false;
    private Boolean ValidatePassword1 = false;
    String email1;
    String password1;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //find id method for variables and items
        Register = (Button) findViewById(R.id.RegisterBtn);
        Email1 = (EditText) findViewById(R.id.EmailAddressTF);
        Password1 = (EditText) findViewById(R.id.PasswordTF);

        //on click function which is triggered by the press of the register button
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmInput1(view);
            }
        });
    }

    //redirects the user to the options activity
    public void OptionsActivity(){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    //boolean method used to validate the email conditions so the user can move on to the next page
    private boolean ValidateEmail1(){
        email1 = Email1.getText().toString().trim();

        if (email1.isEmpty()){
            Email1.setError("Field Cant be Empty");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            Email1.setError("Please Enter a Valid Email Address");
            return false;

        } else {
            Email1.setError(null);
            return true;
        }
    }

    //boolean method used to validate the password conditions so the user can move on to the next page
    private boolean ValidatePassword1(){
        password1 = Password1.getText().toString().trim();

        if (password1.isEmpty()){
            Password1.setError("Field Cant be Empty");
            return false;

        } else if (password1.length() < 7){
            Password1.setError("Invalid Password");
            return false;

        } else {
            Password1.setError(null);
            return true;
        }
    }

    //after the on click function for the register is clicked, it triggers call to this method below where it will validate the password and email address conditions
    //if both conditions have been fulfilled it opens the options activity and the user is logged in.
    public void confirmInput1(View view) {
        if (ValidateEmail1() && ValidatePassword1()) {
            OptionsActivity();

            if (mp!=null){//this plays a beep noise when the users clicks the login button
                mp.reset();
                mp.release();
            }
            mp = MediaPlayer.create(getApplicationContext(),R.raw.ring1);
            mp.start();
        }

            Toast.makeText(getApplicationContext(),"You are registered",Toast.LENGTH_LONG).show();//toast message saying you are registered
        }
    }






