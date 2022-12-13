package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.SuperTeam;
import com.amplifyframework.datastore.generated.model.TaskList;
import com.amplifyframework.datastore.generated.model.TaskListStatusTypeEnum;
import com.taskmastermdt.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AddTask extends AppCompatActivity {
    public final static String TAG = "AddTaskActivity";
    public final static String TEAM_NAME_TAG = "";
    Spinner superTeamSpinner;
    Spinner taskListStatusTypeSpinner;
    CompletableFuture<List<SuperTeam>> superTeamsFuture = new CompletableFuture<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

//        SuperTeam newSuperTeam1 = SuperTeam.builder()
//                .name("Team Mat")
//                .email("torres.mathew@gmail.com")
//                .build();
//        SuperTeam newSuperTeam2 = SuperTeam.builder()
//                .name("Team Carrie")
//                .email("carrie.j.torres@gmail.com")
//                .build();
//        SuperTeam newSuperTeam3 = SuperTeam.builder()
//                .name("Team James")
//                .email("torres.mathew+james@gmail.com")
//                .build();
//        SuperTeam newSuperTeam4 = SuperTeam.builder()
//                .name("Team Cadence")
//                .email("torres.mathew+cadence@gmail.com")
//                .build();
//        Amplify.API.mutate(
//                ModelMutation.create(newSuperTeam1),
//                success -> {},
//                failure -> {}
//        );
//        Amplify.API.mutate(
//                ModelMutation.create(newSuperTeam2),
//                success -> {},
//                failure -> {}
//        );
//        Amplify.API.mutate(
//                ModelMutation.create(newSuperTeam3),
//                success -> {},
//                failure -> {}
//        );
//        Amplify.API.mutate(
//                ModelMutation.create(newSuperTeam4),
//                success -> {},
//                failure -> {}
//        );



        superTeamSpinner = findViewById(R.id.AddTaskSpinnerSuperTeam);
        taskListStatusTypeSpinner = findViewById(R.id.AddTaskSpinnerStatus);

        Amplify.API.query(
                ModelQuery.list(SuperTeam.class),
                success -> {
                    Log.i(TAG, "Read Super Teams Successfully");
                    ArrayList<String> teamNames = new ArrayList<>();
                    ArrayList<SuperTeam> superTeams = new ArrayList<>();
                    for (SuperTeam superTeam: success.getData()) {
                        teamNames.add(superTeam.getName());
                        superTeams.add(superTeam);
                    }
                    superTeamsFuture.complete(superTeams);
                    runOnUiThread(() -> {
                        setupSuperTeamSpinner(teamNames);
                    });
                },
                failure -> {
                    superTeamsFuture.complete(null);
                    Log.w(TAG, "Failed to read SuperTeams from Database");
                }
        );

        setupTaskListStatusTypeSpinner();
        backBtn();
        setupAddTaskBtn();

    }

    public void setupSuperTeamSpinner(ArrayList<String> teamNames) {
        superTeamSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                teamNames
        ));
    }



    public void setupTaskListStatusTypeSpinner() {
        taskListStatusTypeSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                TaskListStatusTypeEnum.values()
        ));
    }

    public void backBtn() {
        Button goToMainActivityPageFromAddTaskPage = AddTask.this.findViewById(R.id.AddTaskBtnBack);
        goToMainActivityPageFromAddTaskPage.setOnClickListener(view -> {
            Intent goToMainActivityPageActivity = new Intent(AddTask.this, MainActivity.class);
            startActivity(goToMainActivityPageActivity);
        });
    }

    public void setupAddTaskBtn() {
        Button addTaskBtn = findViewById(R.id.AddTaskBtnAddTask);
        addTaskBtn.setOnClickListener(view -> {

            String selectedSuperTeamString = superTeamSpinner.getSelectedItem().toString();
            List<SuperTeam> superTeams = null;
            try {
                superTeams = superTeamsFuture.get();
            }
            catch (InterruptedException ie) {
                Log.e(TAG, "InterruptedException while getting Super Teams");
                Thread.currentThread().interrupt();
            } catch (ExecutionException ee) {
                Log.e(TAG, "ExecutionException while getting Super Teams");
            }
            SuperTeam selectedTeam = superTeams.stream().filter(team -> team.getName().equals(selectedSuperTeamString)).findAny().orElseThrow(RuntimeException::new);


            TaskList newTaskListItem = TaskList.builder()
                    .name(((EditText) findViewById(R.id.AddTaskPlanTextEditMyTaskTitle)).getText().toString())
                    .description(((EditText) findViewById(R.id.AddTaskTextEditTaskDescription)).getText().toString())
                    .type((TaskListStatusTypeEnum)taskListStatusTypeSpinner.getSelectedItem())
                    .dateCreated(new Temporal.DateTime(new Date(), 0))
                    .difficulty(Integer.parseInt(((EditText) findViewById(R.id.AddTaskTextEditDifficulty)).getText().toString()))
                    .superTeam(selectedTeam)
                    .build();

            Amplify.API.mutate(
                    ModelMutation.create(newTaskListItem),
                    successResponse -> Log.i(TAG, "AddTaskActivity.onCreate(): made a task item successfully!"),
                    failureResponse -> Log.w(TAG, "Failed to make a task item.", failureResponse)
            );


            Toast.makeText(this, "Task Added to the List!", Toast.LENGTH_SHORT).show();
        });
    }

}