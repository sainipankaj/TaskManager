package com.example.pankajsaini.taskmanager;

import android.provider.BaseColumns;

/**
 * Created by pankaj.saini on 26/01/16.
 */
public final class FeedReaderContract {

    public FeedReaderContract() {};

    public static abstract class FeedEntry implements BaseColumns {

        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_FLAG = "flag";
    }
}
