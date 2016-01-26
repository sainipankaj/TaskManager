package com.example.pankajsaini.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pankaj.saini on 20/01/16.
 */
public class TaskAdapter extends BaseAdapter {
    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    Context context;
    ArrayList<Task> tasks;


    public static class ViewHolder {
        TextView textView;

        public ViewHolder(TextView textView) {
            this.textView = textView;
        }
    }
    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View mainView = null;

        if(convertView == null){
            mainView = LayoutInflater.from(this.context).inflate(R.layout.row, null);

            TextView tv = (TextView) mainView.findViewById(R.id.titleTextView);
            ViewHolder vh = new ViewHolder(tv);

            mainView.setTag(vh);
        } else {
            mainView = convertView;
        }

        String titleName = tasks.get(position).title;

        ViewHolder vh = (ViewHolder) mainView.getTag();
        TextView tv = vh.textView;

        tv.setText(titleName);
        return mainView;
    }

}
