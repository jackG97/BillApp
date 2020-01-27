package com.example.billapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionsActivity extends AppCompatActivity {

    private Button Profile;
    private Button Gallery;
    private Button Camera;
    private Button Bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Profile = (Button) findViewById(R.id.ProfileBtn);
        Gallery = (Button) findViewById(R.id.GalleryBtn);
        Camera = (Button) findViewById(R.id.CameraBtn);
        Bills = (Button) findViewById(R.id.BillsBtn);


        //on click function which is triggered by the press of the bills set button
        Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenGallery();
            }
        });

        //on click function which is triggered by the press of the camera button
        Camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenCamera();
            }
        });

        //on click function which is triggered by the press of the notes button
        Bills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenBills();
            }
        });

        //on click function which is triggered by the press of the profile button
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenProfile();
            }
        });
    }

    //redirects the user to the profile activity
        public void OpenProfile(){
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }

    //redirects the user to the camera activity
        public void OpenCamera(){
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        }

    //redirects the user to the set bill activity
        public void OpenGallery(){
            Intent intent = new Intent(this, SetBillActivity.class);
            startActivity(intent);
        }

    //redirects the user to the notes activity
        public void OpenBills(){
            Intent intent = new Intent(this, NotesActivity.class);
            startActivity(intent);
        }

}
