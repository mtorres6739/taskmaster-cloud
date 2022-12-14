package com.taskmastermdt.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.taskmastermdt.R;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "signUpActivity";
    public static final String SIGNUP_EMAIL_TAG = "signup_email_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupSignUpForm();
    }

    public void setupSignUpForm(){
        findViewById(R.id.SignUpActivityBtnSignUp).setOnClickListener(view -> {
            String userEmail = ((EditText) findViewById(R.id.SignUpActivityTextEditEmail)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.SignUpActivityTextEditPassword)).getText().toString();

            Amplify.Auth.signUp(
                    userEmail,
                    userPassword,
                    AuthSignUpOptions.builder()
                            .userAttribute(AuthUserAttributeKey.email(), userEmail)
                            .build(),
                    success -> {
                        Log.i(TAG, "SignUp success! " + success);
                        Intent goToVerifyActivity = new Intent(this, VerifySignUpActivity.class);
                        goToVerifyActivity.putExtra(SIGNUP_EMAIL_TAG, userEmail);
                        startActivity(goToVerifyActivity);
                    },
                    failure -> {
                        Log.w(TAG, "Sign up failed with username: " + userEmail + "with message " + failure);
                        runOnUiThread(() -> Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show());
                    }
            );
        });
    }
}