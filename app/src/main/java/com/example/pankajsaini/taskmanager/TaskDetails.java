package com.example.pankajsaini.taskmanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskDetails extends Fragment {

    Task tasks;
    TextView taskTitle;
    TextView taskDetails;

    public TaskDetails() {
        // Required empty public constructor
    }

    public static Fragment newFragment() {
        return new TaskDetails();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View mainView = inflater.inflate(R.layout.fragment_task_details, container, false);
        taskTitle = (TextView) mainView.findViewById(R.id.titleView);
        taskDetails = (TextView) mainView.findViewById(R.id.detailView);


        Bundle bundle = getArguments();
        tasks = bundle.getParcelable("DETAIL");
        taskTitle.setText(tasks.title);
        taskDetails.setText(tasks.description);
        return mainView;
    }


}
