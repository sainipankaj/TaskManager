package com.example.pankajsaini.taskmanager;

import android.app.Application;

/**
 * Created by pankaj.saini on 25/01/16.
 */
public class TaskManagerApplication extends Application {

    DBHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        dbHelper = new DBHelper(this);
    }
}
