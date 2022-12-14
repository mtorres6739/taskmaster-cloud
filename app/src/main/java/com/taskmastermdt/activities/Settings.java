package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.SuperTeam;
import com.taskmastermdt.R;
import com.taskmastermdt.activities.auth.SignInActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Settings extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String USERNAME_TAG = "username";
    public static final String TEAM_TAG = "team";
    public static final String TAG = "settings_activity";
    Spinner superTeamSpinner;
    CompletableFuture<List<SuperTeam>> superTeamsFuture = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        saveValuesToSharedPrefs();
        backBtn();
    }

    public void backBtn(){
        Button goToMainActivityPageFromSettingsPage = Settings.this.findViewById(R.id.SettingsBtnBack);
        goToMainActivityPageFromSettingsPage.setOnClickListener(view -> {
            Intent goToMainActivityPageActivity = new Intent(Settings.this, MainActivity.class);
            startActivity(goToMainActivityPageActivity);
        });
    }

    public void saveValuesToSharedPrefs(){

        String usernameString = preferences.getString(USERNAME_TAG, "");
        String teamString = preferences.getString(TEAM_TAG, "");
        superTeamsFuture = new CompletableFuture<>();
        List<SuperTeam> teamList = new ArrayList<>();
        List<String> teamListAsString = new ArrayList<>();
        superTeamSpinner = findViewById(R.id.SettingSpinnerSelectTeam);
        Amplify.API.query(
                ModelQuery.list(SuperTeam.class),
                success -> {
                    Log.i(TAG, "Read teams successfully");
                    for (SuperTeam superTeam : success.getData()) {
                        teamList.add(superTeam);
                    }
                    superTeamsFuture.complete(teamList);
                    runOnUiThread(() -> {
                        teamListAsString.add("ALL");
                        for (SuperTeam superTeam : teamList)
                        teamListAsString.add(superTeam.getName());
                        superTeamSpinner.setAdapter(new ArrayAdapter<>(
                                this,
                                android.R.layout.simple_spinner_item,
                                teamListAsString
                        ));
                        if (!teamString.isEmpty()) {
                            superTeamSpinner.setSelection(teamListAsString.indexOf(teamString));
                        }
                    });
                },
                failure -> Log.i(TAG, "Failed to read teams")
        );
        if (!usernameString.isEmpty()) {
            EditText usernameEditText = Settings.this.findViewById(R.id.SettingsTextEditUsername);
            usernameEditText.setText(usernameString);
        }
        Button saveButton = Settings.this.findViewById(R.id.SettingsBtnSave);
        saveButton.setOnClickListener(view -> {
        SharedPreferences.Editor preferenceEditor = preferences.edit();
            String teamStringPut = superTeamSpinner.getSelectedItem().toString();
            String usernameText = ((EditText) findViewById(R.id.SettingsTextEditUsername)).getText().toString();
            preferenceEditor.putString(USERNAME_TAG, usernameText);
            preferenceEditor.putString(TEAM_TAG, teamStringPut);
            preferenceEditor.apply();
            Toast.makeText(Settings.this, "Settings Saved!", Toast.LENGTH_SHORT).show();
        });
    }

 

}