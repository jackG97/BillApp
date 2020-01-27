package com.example.billapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetBillActivity extends AppCompatActivity {

    private EditText Bill;
    private EditText Amount;
    private EditText Date;
    private Button Set;
    private boolean Validatebill;
    private boolean Validateamount;
    private boolean Validatedate;
    String bill;
    String amount;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setbill);

        Bill = (EditText) findViewById(R.id.BillTypeTF);
        Amount = (EditText) findViewById(R.id.AmountTF);
        Date = (EditText) findViewById(R.id.DateTF);
        Set = (Button) findViewById(R.id.button);

        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Confirmbill(view);
            }
        });
    }

    public void OptionsActivity() {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    private boolean Validatebill() {
        bill = Bill.getText().toString().trim();

        if (bill.isEmpty()) {
            Bill.setError("Field Cant be Empty");
            return false;

        } else if (bill.length() <= 0) {
            Bill.setError("Field Cant be Empty");
            return false;

        } else {
            Bill.setError(null);
            return true;
        }
    }

    private boolean Validateamount() {
        amount = Amount.getText().toString().trim();

        if (amount.isEmpty()) {
            Amount.setError("Field Cant be Empty");
            return false;

        } else if (amount.length() <= 0) {
            Amount.setError("Field Cant be Empty");
            return false;

        } else {
            Amount.setError(null);
            return true;
        }
    }

    private boolean Validatedate() {
        date = Date.getText().toString().trim();

        if (date.isEmpty()) {
            Date.setError("Field Cant be Empty");
            return false;

        } else if (date.length() <= 0) {
            Date.setError("Field Cant be Empty");
            return false;

        } else {
            Date.setError(null);
            return true;
        }
    }

    public void Confirmbill(View view) {
        if (Validatebill() && Validateamount() && Validatedate()) {
            OptionsActivity();

            Toast.makeText(getApplicationContext(),"Your Bill has been saved!",Toast.LENGTH_LONG).show();
        }
    }

}
