package com.martios4.behealthier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.martios4.behealthier.databinding.ActivityFindDoctorBinding;

public class FindDoctorActivity extends Activity {

    ActivityFindDoctorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFindDoctorBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.cardFDBack.setOnClickListener(v -> startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class)));

        binding.cardFDFamilyPhysicians.setOnClickListener(v -> {
            Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
            intent.putExtra("title", "Family Physician");
            startActivity(intent);
        });

        binding.cardFDDietitians.setOnClickListener(v -> {
            Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
            intent.putExtra("title", "Dietitians");
            startActivity(intent);
        });

        binding.cardFDDentists.setOnClickListener(v -> {
            Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
            intent.putExtra("title", "Dentists");
            startActivity(intent);
        });

        binding.cardFDSurgeon.setOnClickListener(v -> {
            Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
            intent.putExtra("title", "Surgeon");
            startActivity(intent);
        });

        binding.cardFDCardiologists.setOnClickListener(v -> {
            Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
            intent.putExtra("title", "Cardiologists");
            startActivity(intent);
        });

    }
}
