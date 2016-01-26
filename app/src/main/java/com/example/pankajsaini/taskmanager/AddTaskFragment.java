package com.example.pankajsaini.taskmanager;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTaskFragment extends Fragment {

    Button doneButton;
    Button cancelButton;
    EditText taskTitleEditText;
    EditText taskDescriptionEditText;
    DBHelper dbHelper;
    SQLiteDatabase database;
    SimpleCursorAdapter adapter;
    Cursor cursor;

    public AddTaskFragment() {
        // Required empty public constructor
    }

    public static Fragment newFragment() {
        AddTaskFragment atf = new AddTaskFragment();
        return atf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_add_task, container, false);
        doneButton = (Button) mainView.findViewById(R.id.done);
        taskTitleEditText = (EditText) mainView.findViewById(R.id.taskTitleEditText);
        taskDescriptionEditText = (EditText) mainView.findViewById(R.id.taskDescriptionEditText);

        //TaskManagerApplication app = (TaskManagerApplication) getActivity().getApplication();
        TaskManagerApplication app = (TaskManagerApplication) getActivity().getApplication();
        dbHelper = app.dbHelper;

        //get writable access to database
        database = dbHelper.getWritableDatabase();

        //cursor = database.query("tasks", null, null, null, null, null, null);

        //String[] from = {"title", "description"};
        //int[] to = {android.R.id.text1, android.R.id.text2};

        //adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to);
        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v) {
                String title = taskTitleEditText.getText().toString();
                String description = taskDescriptionEditText.getText().toString();
                ContentValues row = new ContentValues();
                row.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, title);
                row.put(FeedReaderContract.FeedEntry.COLUMN_NAME_DESCRIPTION, description);
                row.put(FeedReaderContract.FeedEntry.COLUMN_NAME_FLAG, false);
                database.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, row);
                Intent intent = new Intent();

                Task task = new Task();
                task.title = title;
                task.description = description;
                intent.putExtra("NEW_TASK", task);
                //getTargetFragment().onActivityResult(101, Activity.RESULT_OK, intent);

                TaskListFragment tlf = (TaskListFragment) getTargetFragment();
                tlf.addTask(task);

                getFragmentManager().popBackStack();
            }
        });

        cancelButton = (Button) mainView.findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        taskTitleEditText = (EditText) mainView.findViewById(R.id.taskTitleEditText);
        taskDescriptionEditText = (EditText) mainView.findViewById(R.id.taskDescriptionEditText);
        return mainView;
    }


}
