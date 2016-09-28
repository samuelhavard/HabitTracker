package com.example.android.habittracker.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.Data.HabitContract.HabitEntry;

/**
 * Created by samue_000 on 9/28/2016.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habit.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_WAKE_TIME + " INTEGER "
                + HabitEntry.COLUMN_SLEEP_TIME + " INTEGER "
                + HabitEntry.COLUMN_ATE_BREAKFAST + " INTEGER "
                + HabitEntry.COLUMN_ATE_LUNCH + " INTEGER "
                + HabitEntry.COLUMN_ATE_DINNER + " INTEGER);";
        sqLiteDatabase.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
