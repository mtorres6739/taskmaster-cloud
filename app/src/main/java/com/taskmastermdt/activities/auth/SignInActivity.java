package com.taskmastermdt.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.taskmastermdt.R;
import com.taskmastermdt.activities.MainActivity;

public class SignInActivity extends AppCompatActivity {
    public static final String TAG = "signInActivity";
    Intent callingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        callingIntent = getIntent();
        setupSignInForm();
    }

    public void setupSignInForm(){
        findViewById(R.id.SignInActivityBtnSignIn).setOnClickListener(view -> {
            String userEmail = ((EditText) findViewById(R.id.SignInActivityTextEditEmail)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.SignInActivityTextEditPassword)).getText().toString();

            Amplify.Auth.signIn(
                    userEmail,
                    userPassword,
                    success -> {
                        Log.i(TAG, "Login succeeded: " + success);
                        Intent goToMainActivityIntent = new Intent(this, MainActivity.class);
                        startActivity(goToMainActivityIntent);
                    },
                    failure -> {
                        Log.i(TAG, "Login failed: " + failure);
                        runOnUiThread(() -> Toast.makeText(this, "Sign In Failed!", Toast.LENGTH_SHORT).show());
                    }
            );
        });

    }
}