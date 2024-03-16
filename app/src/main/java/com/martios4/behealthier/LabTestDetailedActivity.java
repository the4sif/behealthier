package com.martios4.behealthier;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.martios4.behealthier.databinding.ActivityLabTestDetailedBinding;

public class LabTestDetailedActivity extends Activity {

    ActivityLabTestDetailedBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLabTestDetailedBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.editTextLDTextMultiLine.setKeyListener(null);

        Intent intent = getIntent();
        binding.textViewLDPackageName.setText("text1");
        binding.editTextLDTextMultiLine.setText(intent.getStringExtra("text2"));
        binding.textViewLDTotalCost.setText("Total Cost : " + intent.getStringExtra("text3") + "/-");

        binding.btnCartBack.setOnClickListener(v -> {
            startActivity(new Intent(LabTestDetailedActivity.this, LabTestActivity.class));
        });

        binding.btnCartCheckout.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "").toString();
            String product = binding.textViewLDPackageName.getText().toString();
            float price = Float.parseFloat(intent.getStringExtra("text3").toString());

            Database db = new Database(getApplicationContext(), "healthcare", null, 1);


            if (db.checkCart(username, product) == 1) {
                Toast.makeText(this, "Product Already Added!", Toast.LENGTH_SHORT).show();
            } else {
                db.addCart(username, product, price, "lab");
                Toast.makeText(this, "Record inserted to cart!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestDetailedActivity.this, LabTestBookActivity.class));
            }
        });
    }

}
