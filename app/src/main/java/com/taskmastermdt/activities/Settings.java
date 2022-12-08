package com.taskmastermdt.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.taskmastermdt.R;

public class Settings extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String USERNAME_TAG = "username";

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
        SharedPreferences.Editor preferenceEditor = preferences.edit();
        Button saveButton = Settings.this.findViewById(R.id.SettingsBtnSave);
        saveButton.setOnClickListener(view -> {
            String usernameText = ((EditText) findViewById(R.id.SettingsTextEditUsername)).getText().toString();
            preferenceEditor.putString(USERNAME_TAG, usernameText);
            preferenceEditor.apply();
            Toast.makeText(Settings.this, "Settings Saved!", Toast.LENGTH_SHORT).show();
        });
    }

}