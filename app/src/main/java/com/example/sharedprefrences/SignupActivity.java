package com.example.sharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText etUsername, etPassword, etConPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConPassword = findViewById(R.id.etConPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp(){
        String password = etPassword.getText().toString();
        String conPassword = etConPassword.getText().toString();
        String username = etUsername.getText().toString();



            SharedPreferences sharedPreference = getSharedPreferences("user", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreference.edit();

            editor.putString("username", username);
            editor.putString("password", password);
            editor.commit();

            Toast.makeText(this, "Successfully made User", Toast.LENGTH_LONG).show();

    }
}
