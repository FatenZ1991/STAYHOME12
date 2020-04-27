package com.example.STAYHOME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void funRegisterClick(View view) {

        Intent MainIntent = new Intent(RegisterActivity.this, MapsActivity.class);
        startActivity(MainIntent);
        Toast.makeText(RegisterActivity.this,"To Map",Toast.LENGTH_LONG).show();

    }
}
**/


import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText phonenum;
    EditText email;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = findViewById(R.id.FirstName);
        lastName = findViewById(R.id.LastName);
        phonenum = findViewById(R.id.PhoneNum);
        email = findViewById(R.id.Email);
        register = findViewById(R.id.RegButton);
    }
    //Button click
    public void LoadCurrentMap(View view) {
        Intent MainIntent = new Intent(RegisterActivity.this, MapsActivity.class);
        startActivity(MainIntent);
        Toast.makeText(RegisterActivity.this,"To Map",Toast.LENGTH_LONG).show();

    }
    //button click
    public void RegisterNewUser(View view) {
       // checkDataEntered();

        Intent MainIntent = new Intent(RegisterActivity.this, IdChooseActivity.class);
        startActivity(MainIntent);
        Toast.makeText(RegisterActivity.this,"To ID choose",Toast.LENGTH_LONG).show();

    }
    //check data
    private void checkDataEntered() {
//first name
        if (isEmpty(firstName)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }
//ln
        if (isEmpty(lastName)) {
            lastName.setError("Last name is required!");
        }
//email
        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }
//phone
        if (isEmpty(phonenum)) {
            lastName.setError("Phone numer is required!");
        }

    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


}
