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

public class MainActivity extends AppCompatActivity {

    Button bRotation, bThrow;
    EditText etSpeed, etAngle;

    boolean isValidFields = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bRotation = findViewById(R.id.rotationButton);
        bThrow = findViewById(R.id.throwFrisbee);

        etSpeed = findViewById(R.id.speed);
        etAngle = findViewById(R.id.angle);

        Queue<String> qe = new LinkedList<String>();

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

                }
            }
        });
    }

    private boolean checkFields() {
        String speedStr = etSpeed.getText().toString();
        int speedInt = Integer.parseInt(speedStr);
        String angleStr = etAngle.getText().toString();
        int angleInt = Integer.parseInt(angleStr);
        if (etSpeed.length() == 0){
            etSpeed.setError("Speed is required");
            return false;
        }
        if (speedInt > 50){
            etSpeed.setError("Speed is too high");
            return false;
        }
        if (speedInt < 15) {
            etSpeed.setError("Speed is too low");
            return false;
        }
        if (etAngle.length() == 0){
            etAngle.setError("Angle is required");
        }
        if (angleInt > 90){
            etAngle.setError("Angle is too high");
            return false;
        }
        if (angleInt < 0) {
            etAngle.setError("Angle is too low");
            return false;
        }
        return true;
    }
}