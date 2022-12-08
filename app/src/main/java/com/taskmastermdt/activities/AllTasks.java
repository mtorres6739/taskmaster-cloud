package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.taskmastermdt.R;

public class AllTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);

        backBtn();
    }

    public void backBtn(){
        Button goToMainActivityFromAllTasksPageBtn = AllTasks.this.findViewById(R.id.AllTasksBtnBack);
        goToMainActivityFromAllTasksPageBtn.setOnClickListener(view -> {
            Intent goToMainActivityPageActivity = new Intent(AllTasks.this, MainActivity.class);
            startActivity(goToMainActivityPageActivity);
        });
    }
}