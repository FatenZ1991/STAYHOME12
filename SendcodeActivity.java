package com.example.STAYHOME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SendcodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendcode);
    }

    public void sendbtn(View view) {

        Intent MainIntent = new Intent(SendcodeActivity.this, PagehomeActivity.class);
        startActivity(MainIntent);
        Toast.makeText(SendcodeActivity.this, "Sent, go to home page", Toast.LENGTH_LONG).show();

    }
}
