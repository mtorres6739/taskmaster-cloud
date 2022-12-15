package com.taskmastermdt.activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.documentfile.provider.DocumentFile;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import java.io.FileNotFoundException;
import java.io.InputStream;
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
    ActivityResultLauncher<Intent> activityResultLauncher;
    private String s3ImageKey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        activityResultLauncher = getImagePickingActivityResultLauncher();
        superTeamSpinner = findViewById(R.id.AddTaskSpinnerSuperTeam);
        taskListStatusTypeSpinner = findViewById(R.id.AddTaskSpinnerStatus);

        Amplify.API.query(
                ModelQuery.list(SuperTeam.class),
                success -> {
                    Log.i(TAG, "Read Super Teams Successfully");
                    ArrayList<String> teamNames = new ArrayList<>();
                    ArrayList<SuperTeam> superTeams = new ArrayList<>();
                    for (SuperTeam superTeam : success.getData()) {
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

        setupAddImagebtn();
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
            saveTask();
        });
    }


    private void setupAddImagebtn() {
        findViewById(R.id.AddTaskFloatingActionBtnAddImage).setOnClickListener(view -> {
            launchImageSelectionIntent();
        });
    }

    private void launchImageSelectionIntent() {
        Intent imageFilePickingIntent = new Intent(Intent.ACTION_GET_CONTENT);
        imageFilePickingIntent.setType("*/*");
        imageFilePickingIntent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"image/jpeg", "image/png"});
        activityResultLauncher.launch(imageFilePickingIntent);
    }

    private ActivityResultLauncher<Intent> getImagePickingActivityResultLauncher() {
        ActivityResultLauncher<Intent> imagePickingActivityResultLauncher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            Uri pickedImageFileUri = result.getData().getData();
                            try {
                                InputStream pickedImageInputStream = getContentResolver().openInputStream(pickedImageFileUri);
                                String pickedImageFileName = DocumentFile.fromSingleUri(this, pickedImageFileUri).getName();
                                Log.i(TAG, "Succeeded in getting input stream from file on phone! Filename is: " + pickedImageFileName);
                                uploadInputStreamToS3(pickedImageInputStream, pickedImageFileName, pickedImageFileUri);
                            } catch (FileNotFoundException fnfe) {
                                Log.e(TAG, "Could not get file from file picker" + fnfe.getMessage());
                            }
                        }
                );
        return imagePickingActivityResultLauncher;
    }

    private void uploadInputStreamToS3(InputStream pickedImageInputStream, String pickedImageFileName, Uri pickedImageFileUri) {
        Amplify.Storage.uploadInputStream(
                pickedImageFileName,
                pickedImageInputStream,
                success -> {
                    Log.i(TAG, "Succeeded in getting file uploaded to S3! Key is: " + success.getKey());
                    s3ImageKey = success.getKey();
                    ImageView taskItemImage = findViewById(R.id.AddTaskImageViewTaskItem);
                    InputStream pickedImageInputStreamCopy = null;
                    try {
                        pickedImageInputStreamCopy = getContentResolver().openInputStream(pickedImageFileUri);
                    } catch (FileNotFoundException fnfe) {
                        Log.e(TAG, "Could not get file stream from Uri!" + fnfe.getMessage());
                    }
                    taskItemImage.setImageBitmap(BitmapFactory.decodeStream(pickedImageInputStreamCopy));
                },
                failure -> Log.e(TAG, "Failure in uploading file to s3 with filename: " + pickedImageFileName + "with error: " + failure.getMessage())
        );
    }

    private void saveTask() {
        String selectedSuperTeamString = superTeamSpinner.getSelectedItem().toString();
        List<SuperTeam> superTeams = null;
        try {
            superTeams = superTeamsFuture.get();
        } catch (InterruptedException ie) {
            Log.e(TAG, "InterruptedException while getting Super Teams");
            Thread.currentThread().interrupt();
        } catch (ExecutionException ee) {
            Log.e(TAG, "ExecutionException while getting Super Teams");
        }
        SuperTeam selectedTeam = superTeams.stream().filter(team -> team.getName().equals(selectedSuperTeamString)).findAny().orElseThrow(RuntimeException::new);

        TaskList newTaskListItem = TaskList.builder()
                .name(((EditText) findViewById(R.id.AddTaskPlanTextEditMyTaskTitle)).getText().toString())
                .description(((EditText) findViewById(R.id.AddTaskTextEditTaskDescription)).getText().toString())
                .type((TaskListStatusTypeEnum) taskListStatusTypeSpinner.getSelectedItem())
                .dateCreated(new Temporal.DateTime(new Date(), 0))
                .difficulty(Integer.parseInt(((EditText) findViewById(R.id.AddTaskTextEditDifficulty)).getText().toString()))
                .superTeam(selectedTeam)
                .s3ImageKey(s3ImageKey)
                .build();

        Amplify.API.mutate(
                ModelMutation.create(newTaskListItem),
                successResponse -> Log.i(TAG, "AddTaskActivity.onCreate(): made a task item successfully!"),
                failureResponse -> Log.w(TAG, "Failed to make a task item.", failureResponse)
        );

        Toast.makeText(this, "Task Added to the List!", Toast.LENGTH_SHORT).show();
    }
}