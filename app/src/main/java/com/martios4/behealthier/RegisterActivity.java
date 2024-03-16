package com.martios4.behealthier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.martios4.behealthier.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                } else if (Character.isDigit(passwordhere.charAt(p))) { // added condition to check for digits
                    f2 = 1;
                } else if ((passwordhere.charAt(p) >= 33 && passwordhere.charAt(p) <= 46) || passwordhere.charAt(p) == 64) { // modified condition to check for symbols
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1) return true;

        }
        return false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.buttonRegister.setOnClickListener(v -> {
            String email = binding.editTextRegEmail.getText().toString();
            String pass = binding.editTextRegPassword.getText().toString();
            String conPass = binding.editTextRegConfirmPassword.getText().toString();
            String username = binding.editTextRegUserName.getText().toString();

            Database db = new Database(getApplicationContext(), "healthcare", null, 1);

            if (email.isEmpty() || pass.isEmpty() || conPass.isEmpty() || username.isEmpty()) {
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();

            } else {
                if (pass.compareTo(conPass) == 0) {
                    if (isValid(pass)) {
                        db.register(username, email, pass);
                        Toast.makeText(this, "Record Inserted!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                    } else {
                        Toast.makeText(this, "Password must caontain atleast 8 character, having letter, digit and symbols!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Password and Confirm Password is not same!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        binding.textViewExistingUser.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }

}
