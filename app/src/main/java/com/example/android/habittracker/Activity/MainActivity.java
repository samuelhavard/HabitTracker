package com.example.android.habittracker.Activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.habittracker.Data.HabitContract.HabitEntry;
import com.example.android.habittracker.Data.HabitDbHelper;
import com.example.android.habittracker.R;

/**
 * The Habit Tracker app was created as part of the Udacity curriculum.  It creates a {@link SQLiteDatabase}
 * if one does not exist and inserts information into it.  If one does exist, in inserts information into it.
 * <p>
 * There was no requirement for a UI to display any information for this project, however a simple UI
 * is incorporated for ease of seeing the information present in the database.
 */
public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mHabitDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHabitDbHelper = new HabitDbHelper(this);
        insertHabit();
        updateDisplay();
    }

    /**
     * insertHabit is a helper method that inserts dummy data into the database
     */
    private void insertHabit() {
        SQLiteDatabase db = mHabitDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_WAKE_TIME, 1111);
        values.put(HabitEntry.COLUMN_SLEEP_TIME, 1111);
        values.put(HabitEntry.COLUMN_ATE_BREAKFAST, "eggs");
        values.put(HabitEntry.COLUMN_ATE_LUNCH, "pizza ");
        values.put(HabitEntry.COLUMN_ATE_DINNER, "chicken ");

        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    /**
     * read is a helper method used to read data from a database and return a {@link Cursor}
     * object to be parsed for displa later.
     *
     * @return a {@link Cursor} object from a {@link SQLiteDatabase} to be parsed and displayed.
     */
    private Cursor read() {

        SQLiteDatabase db = mHabitDbHelper.getReadableDatabase();

        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_WAKE_TIME,
                HabitEntry.COLUMN_SLEEP_TIME,
                HabitEntry.COLUMN_ATE_BREAKFAST,
                HabitEntry.COLUMN_ATE_LUNCH,
                HabitEntry.COLUMN_ATE_DINNER
        };

        return db.query(
                true,
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * updateDisplay uses the information in the database to update a {@link TextView} to display
     * the contents of the database to the screen.  This is done via a {@link Cursor} object.
     */
    private void updateDisplay() {

        Cursor cursor = read();

        TextView display = (TextView) findViewById(R.id.display_textview);
        display.setText("Number of rows in the database: " + cursor.getCount() + "\n\n");

        try {
            display.append(
                    HabitEntry._ID + " - " +
                            HabitEntry.COLUMN_WAKE_TIME + " - " +
                            HabitEntry.COLUMN_SLEEP_TIME + " - " +
                            HabitEntry.COLUMN_ATE_BREAKFAST + " - " +
                            HabitEntry.COLUMN_ATE_LUNCH + " - " +
                            HabitEntry.COLUMN_ATE_DINNER + "\n"
            );

            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int wakeColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_WAKE_TIME);
            int sleepColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_SLEEP_TIME);
            int breakfastColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_ATE_BREAKFAST);
            int lunchColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_ATE_LUNCH);
            int dinnerColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_ATE_DINNER);

            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumnIndex);
                long wakeTime = cursor.getLong(wakeColumnIndex);
                long sleepTime = cursor.getLong(sleepColumnIndex);
                String breakfast = cursor.getString(breakfastColumnIndex);
                String lunch = cursor.getString(lunchColumnIndex);
                String dinner = cursor.getString(dinnerColumnIndex);

                display.append("\n" +
                        id + " - " +
                        wakeTime + " - " +
                        sleepTime + " - " +
                        breakfast + " - " +
                        lunch + " - " +
                        dinner);
            }
        } finally {
            cursor.close();
        }
    }
}
