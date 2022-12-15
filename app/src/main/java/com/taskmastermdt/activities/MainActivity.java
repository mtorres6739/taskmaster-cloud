package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.cognito.result.GlobalSignOutError;
import com.amplifyframework.auth.cognito.result.HostedUIError;
import com.amplifyframework.auth.cognito.result.RevokeTokenError;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.TaskList;
import com.amplifyframework.datastore.generated.model.TaskListStatusTypeEnum;
import com.taskmastermdt.R;
import com.taskmastermdt.activities.auth.SignInActivity;
import com.taskmastermdt.activities.auth.SignUpActivity;
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
    public static final String TASKMASTER_TASK_IMAGE_TAG = "taskmasterTaskImage";
    public AuthUser authUser = null;

    SharedPreferences preferences;
    String usernameString = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Amplify.Auth.getCurrentUser(
                success -> {
                    Log.i(TAG, "Success, there is a user");
                    authUser = success;
                },
                failure -> {
                    Log.w(TAG, "There is no authenticated user");
                    authUser = null;
                }
        );



        preferences = PreferenceManager.getDefaultSharedPreferences(this);


        setupRecyclerView();
        addTaskBtn();
        allTasksBtn();
        settingsScreen();
        setupAuthBtns();


    }

    @Override
    protected void onResume() {
        super.onResume();
        setupGreeting();
        setupTaskListFromDatabase();
        adapter.updateListData(taskListList);
        setupHideBtns();
    }

    public void setupGreeting() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString(Settings.USERNAME_TAG, "No Username");
        ((TextView) findViewById(R.id.MainActivityTextViewUsernameTasks)).setText(username + "'s Tasks");

    }

    public void setupRecyclerView() {
        taskListList = new ArrayList<>();
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

    private void setupTaskListFromDatabase() {
        String currentTeam = preferences.getString(Settings.TEAM_TAG, "ALL");
        taskListList.clear();
        Amplify.API.query(
                ModelQuery.list(TaskList.class),
                success -> {
                    Log.i(TAG, "Read task list successfully");
                    for (TaskList databaseTaskList : success.getData()) {
                        if (currentTeam.equals("ALL") || databaseTaskList.getSuperTeam().getName().equals(currentTeam))
                            taskListList.add(databaseTaskList);
                    }
                    runOnUiThread(() -> adapter.notifyDataSetChanged());
                },
                failure -> Log.i(TAG, "Failed to read task list")
        );
    }

    public void setupAuthBtns() {
        Button signIn = MainActivity.this.findViewById(R.id.MainActivityBtnSignIn);
        signIn.setOnClickListener(view -> {
            Intent goToSignInActivityIntent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(goToSignInActivityIntent);
        });
        Button signUp = MainActivity.this.findViewById(R.id.MainActivityBtnSignUp);
        signUp.setOnClickListener(view -> {
            Intent goToSignUpActivityIntent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(goToSignUpActivityIntent);
        });


    }

    public void setupHideBtns(){
        Button signIn = this.findViewById(R.id.MainActivityBtnSignIn);
        Button signUp = this.findViewById(R.id.MainActivityBtnSignUp);


        Amplify.Auth.getCurrentUser(
                success -> {
                    String username = success.getUsername();
                    Log.i(TAG, "Success!" + success);
                    signIn.setVisibility(View.GONE);
                    signUp.setVisibility(View.GONE);
                },
                failure -> {
                    Log.w(TAG, "Failed to get current user");

                }

        );
    }



}