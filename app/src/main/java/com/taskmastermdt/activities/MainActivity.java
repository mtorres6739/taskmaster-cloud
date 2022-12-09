package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.TaskList;
import com.amplifyframework.datastore.generated.model.TaskListStatusTypeEnum;
import com.taskmastermdt.R;
import com.taskmastermdt.adapter.TaskListRecyclerViewAdapter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<TaskList> taskListList;
    TaskListRecyclerViewAdapter adapter;

    public final static String TAG = "MainActivity";
    public static final String TASKMASTER_TASK_NAME_TAG = "taskmasterTask";
    public static final String TASKMASTER_TASK_BODY_TAG = "taskmasterTaskBody";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setupRecyclerView();
        addTaskBtn();
        allTasksBtn();
        settingsScreen();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setupGreeting();
        Amplify.API.query(
                ModelQuery.list(TaskList.class),
                successResponse -> {
                    Log.i(TAG, "Read Task List successfully!");
                    for (TaskList databaseTaskList : successResponse.getData()) {
                        taskListList.add(databaseTaskList);
                    }
                    runOnUiThread(() -> adapter.notifyDataSetChanged());

                },
                failureResponse -> Log.e(TAG, "Failed to read task list from database.")
        );

    }

    public void setupGreeting() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString(Settings.USERNAME_TAG, "No Username");
        ((TextView) findViewById(R.id.MainActivityTextViewUsernameTasks)).setText(username + "'s Tasks");
    }

    public void setupRecyclerView() {
        taskListList = new ArrayList<>();
//        taskListList.add(new TaskList("Take Medication", "Take medication in the following order. Med 1, Med 2, Med 3, Med 4 with food.", TaskListStatusTypeEnum.New, new Date(), 1));
//        taskListList.add(new TaskList("Take Out Trash", "Take trash and recycling out first thing in the morning.", TaskListStatusTypeEnum.New, new Date(), 1));
//        taskListList.add(new TaskList("Feed Cat", "Ensure cat had adequate supply of Friskies cat food. Only fill with 3/4 cup of food.", TaskListStatusTypeEnum.New, new Date(), 1));
//        taskListList.add(new TaskList("Update Calendar", "Check the calendar to make sure all the assignments are scheduled.", TaskListStatusTypeEnum.New, new Date(), 1));

        RecyclerView taskListRV = findViewById(R.id.MainActivityRecyclerViewTaskList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        taskListRV.setLayoutManager(layoutManager);
        adapter = new TaskListRecyclerViewAdapter(taskListList, this);
        taskListRV.setAdapter(adapter);

    }


    public void addTaskBtn() {
        Button goToAddTaskPageBtn = MainActivity.this.findViewById(R.id.MainActivityBtnAddTask);
        goToAddTaskPageBtn.setOnClickListener(view -> {
            Intent goToAddTaskPageActivity = new Intent(MainActivity.this, AddTask.class);
            startActivity(goToAddTaskPageActivity);
        });
    }

    public void allTasksBtn() {
        Button goToAllTasksPageBtn = MainActivity.this.findViewById(R.id.MainActivityBtnAllTasks);
        goToAllTasksPageBtn.setOnClickListener(view -> {
            Intent goToAllTasksPageActivity = new Intent(MainActivity.this, AllTasks.class);
            startActivity(goToAllTasksPageActivity);
        });
    }

    public void settingsScreen() {
        ImageView settingsScreenLink = MainActivity.this.findViewById(R.id.MainActivityImgBtnSettings);
        settingsScreenLink.setOnClickListener(view -> {
            Intent goToSettingsScreen = new Intent(MainActivity.this, Settings.class);
            startActivity(goToSettingsScreen);
        });
    }




}