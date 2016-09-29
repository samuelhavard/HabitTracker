package com.example.android.habittracker.Data;

import android.provider.BaseColumns;

/**
 * HabitContract class is the contract for the sqlite database used in the habit tracker app
 */

public class HabitContract {
    private HabitContract() {
    }

    public class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_WAKE_TIME = "awake";
        public static final String COLUMN_SLEEP_TIME = "sleep";
        public static final String COLUMN_ATE_BREAKFAST = "breakfast";
        public static final String COLUMN_ATE_LUNCH = "lunch";
        public static final String COLUMN_ATE_DINNER = "dinner";
    }
}
