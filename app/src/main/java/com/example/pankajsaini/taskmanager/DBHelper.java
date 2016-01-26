package com.example.pankajsaini.taskmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by pankaj.saini on 25/01/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    /*@Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table tasks(_id integer primary key, " +
                "title text not null, " +
                "description text not null, " +
                "flag integer)";
        db.execSQL(query);

    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                        FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                        FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " TEXT ," +
                        FeedReaderContract.FeedEntry.COLUMN_NAME_DESCRIPTION + " TEXT," +
                        FeedReaderContract.FeedEntry.COLUMN_NAME_FLAG + " TEXT" + ")";
        Log.i("TaskManagerDBHelper", "Query : " + SQL_CREATE_ENTRIES);

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public DBHelper(Context context) {
        super(context, "tasks.db", null, 1);
    }
}
