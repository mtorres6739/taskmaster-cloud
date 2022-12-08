package com.taskmastermdt.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.taskmastermdt.R;
import com.taskmastermdt.adapter.TaskListRecyclerViewAdapter;
import com.taskmastermdt.database.TaskmasterMDTDatabase;
import com.taskmastermdt.models.TaskList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TaskmasterMDTDatabase taskmasterMDTDatabase;
    public static final String DATABASE_NAME = "task_master_db";

    public static final String TASKMASTER_TASK_NAME_TAG = "taskmasterTask";
    public static final String TASKMASTER_TASK_BODY_TAG = "taskmasterTaskBody";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        taskmasterMDTDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        TaskmasterMDTDatabase.class,
                        DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        setupRecyclerView();
        addTaskBtn();
        allTasksBtn();
        settingsScreen();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setupGreeting();

    }

    public void setupGreeting() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString(Settings.USERNAME_TAG, "No Username");
        ((TextView) findViewById(R.id.MainActivityTextViewUsernameTasks)).setText(username + "'s Tasks");
    }

    public void setupRecyclerView() {
        List<TaskList> taskListList = taskmasterMDTDatabase.taskListDao().findAll();

//        List<TaskList> taskListList = new ArrayList<>();
//        taskListList.add(new TaskList("Take Medication", "Take medication in the following order. Med 1, Med 2, Med 3, Med 4 with food.", "New"));
//        taskListList.add(new TaskList("Take Out Trash", "Take trash and recycling out first thing in the morning.", "New"));
//        taskListList.add(new TaskList("Feed Cat", "Ensure cat had adequate supply of Friskies cat food. Only fill with 3/4 cup of food.", "Complete"));
//        taskListList.add(new TaskList("Update Calendar", "Check the calendar to make sure all the assignments are scheduled.", "In Progress"));

        RecyclerView taskListRV = findViewById(R.id.MainActivityRecyclerViewTaskList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        taskListRV.setLayoutManager(layoutManager);
        TaskListRecyclerViewAdapter adapter = new TaskListRecyclerViewAdapter(taskListList, this);
        taskListRV.setAdapter(adapter);

    }


    public void addTaskBtn() {
//      1. Get UI element by id
        Button goToAddTaskPageBtn = MainActivity.this.findViewById(R.id.MainActivityBtnAddTask);
//      setting up routing logic with intents. Intents are the highway between activities
//      2. Add an event listener
        goToAddTaskPageBtn.setOnClickListener(view -> {
//      3. Set up the intent (Current context.this, class to go to Class.class)
            Intent goToAddTaskPageActivity = new Intent(MainActivity.this, AddTask.class);
//      4. Launch the Intent
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