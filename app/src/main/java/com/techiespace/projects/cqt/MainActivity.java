package com.techiespace.projects.cqt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.techiespace.projects.cqt.mycqt.MyCqt;

import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    MyCqt cQ;

    private static final int SAMPLE_RATE = 16000;
    float[] floatInputBuffer = new float[40000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cQ = new MyCqt(SAMPLE_RATE,27.500f, 4434.92f,12*3);
        int i;
        for(i = 0; i < 40000; i++){
            float random = (float) Math.random() * 49 + 1;
            floatInputBuffer[i] = random;
        }

//        cQ.calculate(floatInputBuffer);
        cQ.calculateMagintudes(floatInputBuffer);
        System.out.println(Arrays.toString(cQ.getMagnitudes()).length());
        System.out.println(Arrays.toString(cQ.getMagnitudes()));
        System.out.println(Arrays.toString(cQ.getCoefficients()).length());
        System.out.println((Arrays.toString(cQ.getCoefficients())));
    }
}
