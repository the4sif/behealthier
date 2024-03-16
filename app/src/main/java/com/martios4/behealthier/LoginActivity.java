package com.martios4.behealthier;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.martios4.behealthier.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Inside your AppCompatActivity's onCreate() method




        binding.buttonLogin.setOnClickListener(v -> {
            String username = binding.editTextLoginUsername.getText().toString();
            String password = binding.editTextLoginPassword.getText().toString();
            Database db = new Database(getApplicationContext(), "healthcare", null, 1);
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all details!", Toast.LENGTH_SHORT).show();

            } else {
                if (db.login(username, password) == 1) {
                    Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    // to save our data with key and password
                    editor.apply();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(this, "Invalid username and password!", Toast.LENGTH_SHORT).show();
                }

            }

        });

        binding.textViewNewUser.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}
