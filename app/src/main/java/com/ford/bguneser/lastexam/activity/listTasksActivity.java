package com.ford.bguneser.lastexam.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.ford.bguneser.lastexam.R;
import com.ford.bguneser.lastexam.adapters.TaskListAdapter;
import com.ford.bguneser.lastexam.model.DbContext;
import com.ford.bguneser.lastexam.model.entity.Task;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listTasksActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.tasklist);
        listView = (ListView) findViewById(R.id.listView);

        DbContext.getInstance().taskfindAll(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                List<Task> tasks = response.body();
                TaskListAdapter taskListAdapter = new TaskListAdapter(listTasksActivity.this, tasks);
                listView.setAdapter(taskListAdapter);


            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {

            }
        });

    }

    }

