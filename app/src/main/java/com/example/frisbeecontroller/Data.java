package com.example.frisbeecontroller;

import android.util.Log;

public class Data {
    /*
    Member variables for class Data to store information about a frisbee execution
    */
    public int speed;
    public int angle;
    public int rotation; //0 is left 1 is right

    public Data(int inSpeed, int inAngle, int inRotation){
        speed = inSpeed;
        angle = inAngle;
        rotation = inRotation;
    }

    public void str(){
        String data = new String("Speed: " + speed + " Angle: " + angle + " Rotation: " + rotation);
        Log.i("Input Data: ", data);
        //System.out.print("Speed: " + speed + " Angle: " + angle + " Rotation: " + rotation);
    }
}
