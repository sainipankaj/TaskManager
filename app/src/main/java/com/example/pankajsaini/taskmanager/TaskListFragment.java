package com.example.pankajsaini.taskmanager;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends Fragment {

    ListView taskListTitleView;
    Button addTaskButton;
    //TextView taskTextView;

    TaskAdapter adapter;
    ArrayList<Task> tasks;

    TaskListDelegate delegate;

    public TaskListFragment() {
        // Required empty public constructor
        tasks = new ArrayList<Task>();
    }

    private void updateUI() {
        adapter.notifyDataSetChanged();
    }

    public static Fragment newFragment() {
        TaskListFragment tlf = new TaskListFragment();
        return tlf;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflater.inflate(R.menu.menu_fragment_task, menu);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_task_list, container, false);


        adapter = new TaskAdapter(getContext(), tasks);

        taskListTitleView = (ListView) fragView.findViewById(R.id.taskListView);

        taskListTitleView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = tasks.get(position);

                delegate.switchToTaskDetails(task);

            }
        });

        //attach the adapter to the list view
        taskListTitleView.setAdapter(adapter);

        FloatingActionButton addTask = (FloatingActionButton) fragView.findViewById(R.id.addTask);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {
                    delegate.switchToAddTaskFragment();
                }
            }
        });

        return fragView;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*if(item.getItemId() == R.id.addMenuOption){
            if(delegate != null) {
                delegate.switchToAddTaskFragment();
            }
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101 && resultCode == Activity.RESULT_OK) {
            Task task = data.getParcelableExtra("NEW_TASK");
            tasks.add(task);
        }
    }
}
