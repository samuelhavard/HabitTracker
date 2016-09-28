package com.example.android.habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.habittracker.Data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mHabitDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHabitDbHelper = new HabitDbHelper(this);
    }


}
