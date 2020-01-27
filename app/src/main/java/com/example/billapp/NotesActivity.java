package com.example.billapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {

    //variables
    private Button Submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        //find id method for the submit button
        Submit = (Button) findViewById(R.id.NoteBtn);



        //on click method for the submit button to redirect the user back to the options page
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenOptions();
            }
        });
    }

    //redirects user to options page
    public void OpenOptions(){
        Intent intent = new Intent(this, OptionsActivity.class);
        Toast.makeText(getApplicationContext(),"Note added to reminder",Toast.LENGTH_SHORT).show();//toast message saying your note is saved
    }
}
