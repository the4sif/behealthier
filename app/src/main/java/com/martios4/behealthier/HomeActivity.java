package com.martios4.behealthier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.martios4.behealthier.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        Toast.makeText(this, "Welcome" + username, Toast.LENGTH_SHORT).show();

        binding.cardExit.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        });

        binding.cardFindDoctor.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class));
        });

        binding.cardLabTest.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, LabTestActivity.class));
        });

        binding.cardOrderDetails.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, OrderDetailsActivity.class));
        });


        binding.cardHealthDoctor.setOnClickListener(v -> {
            String articleUrl = "https://www.healthshots.com/hindi/"; // Replace with the actual URL
            Intent intent = new Intent(HomeActivity.this, HealthArticleActivity.class);
            intent.putExtra("articleUrl", articleUrl);
            startActivity(intent);
        });

        binding.cardBuyMedicine.setOnClickListener(v -> {
            String articleUrl = "https://pharmeasy.in/"; // Replace with the actual URL
            Intent intent = new Intent(HomeActivity.this, sample.class);
            intent.putExtra("articleUrl", articleUrl);
            startActivity(intent);
        });


    }
}
