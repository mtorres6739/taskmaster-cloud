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
    public AuthUser authUser = null;

    SharedPreferences preferences;
    String usernameString = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Amplify.Auth.signUp("torres.mathew@gmail.com", "p@$$word",
//                AuthSignUpOptions.builder()
//                        .userAttribute(AuthUserAttributeKey.email(), "torres.mathew@gmail.com")
//                        .userAttribute(AuthUserAttributeKey.nickname(), "Chewie")
//                        .build(),
//                success -> Log.i(TAG, "Signup succeeded" + success.toString()),
//                failure -> Log.w(TAG, "Sigup failed with email" + "torres.mathew@gmail.com" + "with message " + failure)
//                );
//
//        // Verification
//        Amplify.Auth.confirmSignUp(
//                "torres.mathew@gmail.com",
//                "123456",
//                success -> Log.i(TAG, "Signup succeeded" + success.toString()),
//                failure -> Log.w(TAG, "Verification failed: " + failure)
//
//        );
//        // Login
//        Amplify.Auth.signIn(
//                'torres.mathew@gmail.com',
//                "p@$$word",
//                success -> Log.i(TAG, "SignIn success!"),
//                failure -> Log.e(TAG, "SignIn failed")
//        );
//
//        // Signout
//        Amplify.Auth.signOut(
//                success -> {},
//                failure -> {}
//        );

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
//        Amplify.API.query(
//                ModelQuery.list(TaskList.class),
//                successResponse -> {
//                    Log.i(TAG, "Read Task List successfully!");
//                    for (TaskList databaseTaskList : successResponse.getData()) {
//                        taskListList.add(databaseTaskList);
//                    }
//                    runOnUiThread(() -> adapter.notifyDataSetChanged());
//
//                },
//                failureResponse -> Log.e(TAG, "Failed to read task list from database.")
//        );

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



        Amplify.Auth.getCurrentUser(
                success -> {
                    Log.i(TAG, "Success!");
                    if (authUser == null){
                        signIn.setVisibility(View.VISIBLE);
                        signUp.setVisibility(View.VISIBLE);
                    } else {
                        String username = authUser.getUsername();
                        Log.i(TAG, "Username is: " + username);
                        signIn.setVisibility(View.INVISIBLE);
                        signUp.setVisibility(View.INVISIBLE);
                    }
                },
                failure -> Log.w(TAG, "Failed to get current user")

        );




    }


}