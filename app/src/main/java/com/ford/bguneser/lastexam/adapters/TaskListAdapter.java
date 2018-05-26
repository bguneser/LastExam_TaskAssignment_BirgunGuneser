package com.ford.bguneser.lastexam.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ford.bguneser.lastexam.R;
import com.ford.bguneser.lastexam.model.DbContext;
import com.ford.bguneser.lastexam.model.entity.Employee;
import com.ford.bguneser.lastexam.model.entity.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListAdapter extends BaseAdapter {

    private List<Task> taskList;
    Activity activity2 ;
    LayoutInflater layoutInflater;

    public TaskListAdapter(Activity activity2, List<Task> taskList) {
        layoutInflater= (LayoutInflater) activity2.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        this.taskList=taskList;
        this.activity2=activity2;

    }

    @Override
    public Object getItem(int position) {
        return taskList.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return taskList.size();
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View satirViewTasks;
        satirViewTasks=layoutInflater.inflate( R.layout.custom_tasks_layout,null );
        ImageButton btnImageDeleteTasks=(ImageButton)satirViewTasks.findViewById( R.id.btn_delete_task );
        TextView textViewTasks = (TextView) satirViewTasks.findViewById( R.id.txt_task_name );

//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_tasks_layout, parent, false);
//        }

        final Task task = taskList.get( position );
        btnImageDeleteTasks.setImageResource( R.drawable.ic_action_delete_task );
        textViewTasks.setText( task.getTaskname().toString() );

//        btnImageDeleteTasks.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DbContext.getInstance().deleteTask( taskList.remove( position ), new Callback <Void>() {
//                    @Override
//                    public void onResponse(Call<Void> call, Response<Void> response) {
//                        Toast.makeText( activity2,taskList.remove( position )+": .Task'ı sildiniz",Toast.LENGTH_SHORT ).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call <Void> call, Throwable t) {
//
//                    }
//                } );
//            }
//        } );

        btnImageDeleteTasks.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbContext.getInstance().deleteTask( task.getId(), new Callback <Void>() {
                    @Override
                    public void onResponse(Call <Void> call, Response <Void> response) {
                        Toast.makeText( activity2,task.getId()+": Task'ı sildiniz",Toast.LENGTH_LONG ).show();
                    }

                    @Override
                    public void onFailure(Call <Void> call, Throwable t) {

                    }
                } );
            }
        } );


        // ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        //ImageButton deleteTask = (ImageButton) convertView.findViewById(R.id.delete_task);
       // deleteTask.setImageResource(R.drawable.ic_action_delete_task);

//        TextView textView_name = (TextView) convertView.findViewById(R.id.txt_task_name);
//        Task task = taskList.get(position);
//        textView_name.setText(task.getTaskname().toString());
        return  satirViewTasks;
    }
}
