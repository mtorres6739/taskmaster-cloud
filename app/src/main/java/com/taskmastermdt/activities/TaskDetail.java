package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.TaskList;
import com.taskmastermdt.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TaskDetail extends AppCompatActivity {
    public static final String TAG = "taskDetailActivity";
    Intent callingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
//        receiveSetupTaskButtonValues();
        receiveSetupTaskBodyValue();
//        setupTaskImage();
        backBtn();
    }

    @Override
    protected void onResume() {
        super.onResume();
        callingIntent = getIntent();
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

    private TaskList getTaskListId(String taskListId) {
        TaskList databaseTaskList = null;
        Amplify.API.query(
                ModelQuery.get(TaskList.class, taskListId),
                success -> {
                    Log.i(TAG, "Query Task List Correctly");
                },
                failure -> {}
        );
        return null;
    }

    private void setupTaskImage(){
        String taskImageKeyString = null;
        taskImageKeyString = callingIntent.getStringExtra(MainActivity.TASKMASTER_TASK_IMAGE_TAG);
        if (taskImageKeyString != null && !taskImageKeyString.isEmpty()) {

            Amplify.Storage.downloadFile(
                    taskImageKeyString,
                    new File(getApplication().getFilesDir(), taskImageKeyString),
                    success -> {
                        Log.i(TAG, "Success getting image");
                        ImageView taskImageView = findViewById(R.id.TaskDetailImageViewTaskImage);
                        taskImageView.setImageBitmap(BitmapFactory.decodeFile(success.getFile().getPath()));
                    },
                    failure -> {
                        Log.e(TAG, "Failed to get image with s3 key because " + failure.getMessage());
                    }
            );
        }

    }
}