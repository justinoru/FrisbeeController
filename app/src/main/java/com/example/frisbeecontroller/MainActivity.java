package com.example.frisbeecontroller;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.Queue;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    Button bRotation, bThrow;
    EditText etSpeed, etAngle;

    boolean isValidFields = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton bRotation = (ToggleButton) findViewById(R.id.rotationButton);
        bThrow = findViewById(R.id.throwFrisbee);

        etSpeed = findViewById(R.id.speed);
        etAngle = findViewById(R.id.angle);

        Queue<Data> qe = new LinkedList<Data>();

        bThrow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                isValidFields = checkFields();
                if (isValidFields) {
                    Context context = getApplicationContext();
                    CharSequence text = "Throwing Frisbee!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    String speedStr = etSpeed.getText().toString();
                    int speedInt = Integer.parseInt(speedStr);
                    String angleStr = etAngle.getText().toString();
                    int angleInt = Integer.parseInt(angleStr);
                    int rotationInt = 0;
                    if (bRotation.isChecked()){
                        rotationInt = 1;
                    }
                    Data inData = new Data(speedInt, angleInt, rotationInt);
                    inData.str();
                    qe.add(inData);
                    etSpeed.setText("");
                    etAngle.setText("");
                }
            }
        });
    }

    private boolean checkFields() {
        boolean isValid = true;
        String speedStr = etSpeed.getText().toString();
        int speedInt;
        try {
            speedInt = Integer.parseInt(speedStr);
            if (speedInt > 50){
                etSpeed.setError("Speed is too high");
                isValid = false;
            }
            if (speedInt < 15) {
                etSpeed.setError("Speed is too low");
                isValid = false;
            }
        }
        catch(NumberFormatException ex){
            etSpeed.setError("Speed is required");
            isValid = false;
        }
        String angleStr = etAngle.getText().toString();
        int angleInt;
        try {
            angleInt = Integer.parseInt(angleStr);
            if (angleInt > 90){
                etAngle.setError("Angle is too high");
                isValid = false;
            }
            if (angleInt < 0) {
                etAngle.setError("Angle is too low");
                isValid = false;
            }
        }
        catch(NumberFormatException ex){
            etAngle.setError("Angle is required");
            isValid = false;
        }
        return isValid;
    }
}