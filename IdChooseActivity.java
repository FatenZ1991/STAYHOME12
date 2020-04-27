package com.example.STAYHOME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class IdChooseActivity extends AppCompatActivity {

    private RadioGroup radioIdchooseGroup;
    private RadioButton radioIdchooseButton;
    private Button btncomplete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_choose);
        radioIdchooseGroup = (RadioGroup) findViewById(R.id.radioIdchoose);
        btncomplete = (Button) findViewById(R.id.btncomplete);
            }


    public void btncompleteclick(View view) {

        // get selected radio button from radioGroup
        int selectedId = radioIdchooseGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioIdchooseButton = (RadioButton) findViewById(selectedId);

        if (radioIdchooseButton.getText().equals("FingerprintID")) {
            //go to home page

            Intent MainIntent = new Intent(IdChooseActivity.this, PagehomeActivity.class);
            startActivity(MainIntent);
            Toast.makeText(IdChooseActivity.this, "Your registration are completed, go to home page", Toast.LENGTH_LONG).show();

        } else {

            //go to face id page  Face_insertActivity
            Intent MainIntent = new Intent(IdChooseActivity.this, Face_insertActivity.class);
            startActivity(MainIntent);
            Toast.makeText(IdChooseActivity.this, "go to face id", Toast.LENGTH_LONG).show();

        }
    }


}

