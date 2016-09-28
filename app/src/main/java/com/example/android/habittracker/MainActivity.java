package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.habittracker.Data.HabitContract;
import com.example.android.habittracker.Data.HabitContract.HabitEntry;
import com.example.android.habittracker.Data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mHabitDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHabitDbHelper = new HabitDbHelper(this);
    }

    private void insertHabit() {
        SQLiteDatabase db = mHabitDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_WAKE_TIME, 1111);
        values.put(HabitEntry.COLUMN_SLEEP_TIME, 1111);
        values.put(HabitEntry.COLUMN_ATE_BREAKFAST, " ");
        values.put(HabitEntry.COLUMN_ATE_LUNCH, " ");
        values.put(HabitEntry.COLUMN_ATE_DINNER, " ");

        db.insert(HabitEntry.TABLE_NAME, null, values);
    }
}
