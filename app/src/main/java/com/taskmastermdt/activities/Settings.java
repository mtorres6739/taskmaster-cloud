package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.cognito.result.GlobalSignOutError;
import com.amplifyframework.auth.cognito.result.HostedUIError;
import com.amplifyframework.auth.cognito.result.RevokeTokenError;
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
        setupSignOutBtn();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupHideBtns();
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

    public void setupSignOutBtn(){
        Button signOut = Settings.this.findViewById(R.id.SettingsBtnSignOut);
        signOut.setOnClickListener(view -> {

            Amplify.Auth.signOut( signOutResult -> {
                if (signOutResult instanceof AWSCognitoAuthSignOutResult.CompleteSignOut) {
                    // Sign Out completed fully and without errors.
                    Log.i("AuthQuickStart", "Signed out successfully");
                } else if (signOutResult instanceof AWSCognitoAuthSignOutResult.PartialSignOut) {
                    // Sign Out completed with some errors. User is signed out of the device.
                    AWSCognitoAuthSignOutResult.PartialSignOut partialSignOutResult =
                            (AWSCognitoAuthSignOutResult.PartialSignOut) signOutResult;

                    HostedUIError hostedUIError = partialSignOutResult.getHostedUIError();
                    if (hostedUIError != null) {
                        Log.e("AuthQuickStart", "HostedUI Error", hostedUIError.getException());
                        // Optional: Re-launch hostedUIError.getUrl() in a Custom tab to clear Cognito web session.
                    }

                    GlobalSignOutError globalSignOutError = partialSignOutResult.getGlobalSignOutError();
                    if (globalSignOutError != null) {
                        Log.e("AuthQuickStart", "GlobalSignOut Error", globalSignOutError.getException());
                        // Optional: Use escape hatch to retry revocation of globalSignOutError.getAccessToken().
                    }

                    RevokeTokenError revokeTokenError = partialSignOutResult.getRevokeTokenError();
                    if (revokeTokenError != null) {
                        Log.e("AuthQuickStart", "RevokeToken Error", revokeTokenError.getException());
                        // Optional: Use escape hatch to retry revocation of revokeTokenError.getRefreshToken().
                    }
                } else if (signOutResult instanceof AWSCognitoAuthSignOutResult.FailedSignOut) {
                    AWSCognitoAuthSignOutResult.FailedSignOut failedSignOutResult =
                            (AWSCognitoAuthSignOutResult.FailedSignOut) signOutResult;
                    // Sign Out failed with an exception, leaving the user signed in.
                    Log.e("AuthQuickStart", "Sign out Failed", failedSignOutResult.getException());
                }
            });

            Intent goToMainActivityIntent = new Intent(this, MainActivity.class);
            startActivity(goToMainActivityIntent);
        });
    }
    public void setupHideBtns(){
        Button signOut = this.findViewById(R.id.SettingsBtnSignOut);


        Amplify.Auth.getCurrentUser(
                success -> {
                    String username = success.getUsername();
                    Log.i(TAG, "Success!" + success);
                },
                failure -> {
                    Log.w(TAG, "Failed to get current user");
                    signOut.setVisibility(View.GONE);

                }

        );
    }


}