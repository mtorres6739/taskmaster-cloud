package com.taskmastermdt.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.taskmastermdt.R;

public class VerifySignUpActivity extends AppCompatActivity {
    public static final String TAG = "verifyAccountActivity";
    Intent callingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_sign_up);
        callingIntent = getIntent();
        setupVerifyForm();
    }

    public void setupVerifyForm(){
        String userEmail = callingIntent.getStringExtra(SignUpActivity.SIGNUP_EMAIL_TAG);
        findViewById(R.id.VerifySignUpBtnVerify).setOnClickListener(view -> {
            String verificationCode = ((EditText) findViewById(R.id.VerifySignUpActivityTextEditVerificationCode)).getText().toString();

            Amplify.Auth.confirmSignUp(
                    userEmail,
                    verificationCode,
                    success -> {
                        Log.i(TAG, "Verification succeeded: " + success.toString());
                        Intent goToSignInActivity = new Intent(this, SignInActivity.class);
                        goToSignInActivity.putExtra(SignUpActivity.SIGNUP_EMAIL_TAG, userEmail);
                        startActivity(goToSignInActivity);
                    },
                    failure -> {
                        Log.i(TAG, "Verification failed with username: " + userEmail + "Verify account failed!", failure);
                        runOnUiThread(() -> Toast.makeText(VerifySignUpActivity.this, "Verify account failed!", Toast.LENGTH_SHORT).show());
                    }
            );
        });
    }
}