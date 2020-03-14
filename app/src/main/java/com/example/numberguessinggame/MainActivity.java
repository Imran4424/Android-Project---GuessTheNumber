package com.example.numberguessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    EditText inputTextField;
    TextView indicatorText;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing UI variables
        inputTextField = (EditText) findViewById(R.id.inputEditText);
        submitButton = (Button) findViewById(R.id.submitButton);

        int  min = 1;
        int max = 100;
        int range = max - min + 1;
        number = (int) (Math.random() * range) + min;
    }

    public void matchTheNumber(View v) {
        int inputNumber = parseInteger(inputTextField.getText().toString());

        if(inputNumber == number) {
            startActivity(new Intent(MainActivity.this, WinnerActivity.class));
        } else if(inputNumber > number) {
            Toast.makeText(getApplicationContext(), "Your Number is Higher", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Your Number is Lower", Toast.LENGTH_SHORT).show();
        }

    }

    int parseInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return  0;
        }
    }
}
