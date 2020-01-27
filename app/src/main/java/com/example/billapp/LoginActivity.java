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

public class LoginActivity extends AppCompatActivity {


    //varibles
    private Button Login;
    private EditText Email;
    private EditText Password;
    private Boolean ValidateEmail = false;
    private Boolean ValidatePassword = false;
    String email;
    String password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //find id method for variables and items
        Login = (Button) findViewById(R.id.LoginBtn);
        Email = (EditText) findViewById(R.id.EmailAddressTF2);
        Password = (EditText) findViewById(R.id.PasswordET2);


        //on click function which is triggered by the press of the login button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmInput(view);
            }

        });
    }


    //redirects the user to the options activity
    public void OptionsActivity() {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }


    //boolean method used to validate the email conditions so the user can move on to the next page
    private boolean ValidateEmail() {
        email = Email.getText().toString().trim();

        if (email.isEmpty()) {
            Email.setError("Field Cant be empty");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Please Enter a Valid Email Address");
            return false;

        } else {
            Email.setError(null);
            return true;
        }
    }

    //boolean method used to validate the password conditions so the user can move on to the next page
    private boolean ValidatePassword() {
        password = Password.getText().toString().trim();

        if (password.isEmpty()) {
            Password.setError("Field Cant be empty");
            return false;

        } else if (password.length() < 7) {
            Password.setError("Invalid Password");
            return false;

        } else {
            Password.setError(null);
            return true;
        }
    }

    //after the on click function for the login is clicked, it triggers call to this method below where it will validate the password and email address conditions
    //if both conditions have been fulfilled it opens the options activity and the user is logged in.
    public void confirmInput(View view) {
        if (ValidateEmail() && ValidatePassword()) {
            OptionsActivity();

            if (mp!=null){//this plays a beep noise when the users clicks the login button
                mp.reset();
                mp.release();
            }
            mp = MediaPlayer.create(getApplicationContext(),R.raw.ring1);
            mp.start();
        }

            Toast.makeText(getApplicationContext(),"Signed in",Toast.LENGTH_SHORT).show();//toast message saying you signed in
        }
    }



