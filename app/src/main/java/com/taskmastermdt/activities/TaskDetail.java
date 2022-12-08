package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.taskmastermdt.R;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        receiveSetupTaskButtonValues();
        receiveSetupTaskBodyValue();
        backBtn();
    }

    public void receiveSetupTaskButtonValues(){
        Intent callingIntent = getIntent();
        String taskName = null;
        if (callingIntent != null){
            taskName = callingIntent.getStringExtra(MainActivity.TASKMASTER_TASK_NAME_TAG);
        }
        TextView textViewTaskName = findViewById(R.id.TaskDetailTextViewTaskName);
        if (taskName != null) {
            textViewTaskName.setText(taskName);
        } else {
            textViewTaskName.setText("No Task Listed");
        }

    }

    public void receiveSetupTaskBodyValue(){
        Intent callingIntent = getIntent();
        String taskBody = null;
        if (callingIntent != null){
            taskBody = callingIntent.getStringExtra(MainActivity.TASKMASTER_TASK_BODY_TAG);
        }
        TextView textViewTaskBody = findViewById(R.id.TaskDetailsTextViewLorem);
        if (taskBody != null){
            textViewTaskBody.setText(taskBody);
        } else {
            textViewTaskBody.setText("No Task Body");
        }
    }



    public void backBtn(){
        Button goToMainActivityPageFromTaskDetailPage = TaskDetail.this.findViewById(R.id.TaskDetailBtnBack);
        goToMainActivityPageFromTaskDetailPage.setOnClickListener(view -> {
            Intent goToMainActivityPageActivity = new Intent(TaskDetail.this, MainActivity.class);
            startActivity(goToMainActivityPageActivity);
        });
    }
}