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
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.TaskList;
import com.amplifyframework.datastore.generated.model.TaskListStatusTypeEnum;
import com.taskmastermdt.R;

import java.util.Date;

public class AddTask extends AppCompatActivity {
    public final static String TAG = "AddTaskActivity";

    Spinner taskListStatusTypeSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        taskListStatusTypeSpinner = findViewById(R.id.AddTaskSpinnerStatus);


        setupTaskListStatusTypeSpinner();
        backBtn();
        setupAddTaskBtn();
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

            TaskList newTaskListItem = TaskList.builder()
                    .name(((EditText) findViewById(R.id.AddTaskPlanTextEditMyTaskTitle)).getText().toString())
                    .description(((EditText) findViewById(R.id.AddTaskTextEditTaskDescription)).getText().toString())
                    .type((TaskListStatusTypeEnum)taskListStatusTypeSpinner.getSelectedItem())
                    .dateCreated(new Temporal.DateTime(new Date(), 0))
                    .difficulty(Integer.parseInt(((EditText) findViewById(R.id.AddTaskTextEditDifficulty)).getText().toString()))
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