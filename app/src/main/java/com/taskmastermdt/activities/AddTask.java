package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.taskmastermdt.R;
import com.taskmastermdt.database.TaskmasterMDTDatabase;
import com.taskmastermdt.models.TaskList;

import java.util.Date;

public class AddTask extends AppCompatActivity {

    TaskmasterMDTDatabase taskmasterMDTDatabase;
    Spinner taskListStatusTypeSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        taskListStatusTypeSpinner = findViewById(R.id.AddTaskSpinnerStatus);

        taskmasterMDTDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        TaskmasterMDTDatabase.class,
                        MainActivity.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        setupTaskListStatusTypeSpinner();
        backBtn();
        setupAddTaskBtn();
    }


    public void setupTaskListStatusTypeSpinner() {
        taskListStatusTypeSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                TaskList.TaskListStatusTypeEnum.values()
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
            TaskList newTaskListItem = new TaskList(
                    ((EditText) findViewById(R.id.AddTaskPlanTextEditMyTaskTitle)).getText().toString(),
                    ((EditText) findViewById(R.id.AddTaskTextEditTaskDescription)).getText().toString(),
                    TaskList.TaskListStatusTypeEnum.fromString(taskListStatusTypeSpinner.getSelectedItem().toString()),
                    new Date(),
                    Integer.parseInt(((EditText) findViewById(R.id.AddTaskTextEditDifficulty)).getText().toString())
            );
            taskmasterMDTDatabase.taskListDao().insertTask(newTaskListItem);
            Toast.makeText(this, "Task Added to the List!", Toast.LENGTH_SHORT).show();
        });
    }

}