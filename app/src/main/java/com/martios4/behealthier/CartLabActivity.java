package com.martios4.behealthier;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.martios4.behealthier.databinding.ActivityCartLabBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class CartLabActivity extends AppCompatActivity {

    ActivityCartLabBinding binding;
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartLabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCartBack.setOnClickListener(v -> {
                    startActivity(new Intent(CartLabActivity.this, LabTestActivity.class));
                }
        );

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();

        Database db = new Database(getApplicationContext(), "heatlhcare", null, 1);

        float totalAmount = 0;
        ArrayList dbData = db.getCartData(username, "lab");
        Toast.makeText(this, "" + dbData, Toast.LENGTH_SHORT).show();

        initDatePickerDialog();
        binding.btnCartDate.setOnClickListener(v -> {
            datePickerDialog.show();
        });

        initTimePicker();
        binding.btnCartTime.setOnClickListener(v -> {
            timePickerDialog.show();
        });


    }

    private void initDatePickerDialog() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                binding.btnCartDate.setText(dayOfMonth + " /" + month + " /" + year);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);

    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                binding.btnCartTime.setText(hourOfDay + ":" + minute);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int hrs = calendar.get(Calendar.HOUR);
        int mins = calendar.get(Calendar.MINUTE);


        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, true);


    }
}