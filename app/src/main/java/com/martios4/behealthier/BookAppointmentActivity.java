package com.martios4.behealthier;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.martios4.behealthier.databinding.ActivityBookAppointmentBinding;

import java.util.Calendar;

public class BookAppointmentActivity extends Activity {

    ActivityBookAppointmentBinding binding;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookAppointmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.editTextAppFullName.setKeyListener(null);
        binding.editTextAppAddress.setKeyListener(null);
        binding.editTextAppContactNumber.setKeyListener(null);
        binding.editTextAppFees.setKeyListener(null);

        Intent intent = getIntent();
        String title = intent.getStringExtra("text1");
        String fullname = intent.getStringExtra("text2");
        String address = intent.getStringExtra("text3");
        String contact = intent.getStringExtra("text4");
        String fees = intent.getStringExtra("text5");

        binding.textViewAppTitle.setText(title);
        binding.editTextAppFullName.setText(fullname);
        binding.editTextAppAddress.setText(address);
        binding.editTextAppContactNumber.setText(contact);
        binding.editTextAppFees.setText(fees);

        initDatePickerDialog();
        binding.btnCartDate.setOnClickListener(v -> {
            datePickerDialog.show();
        });

        initTimePicker();
        binding.btnCartTime.setOnClickListener(v -> {
            timePickerDialog.show();
        });

        binding.buttonBookAppointment2.setOnClickListener(v -> {

        });

        binding.buttonBookAppointmentBack.setOnClickListener(v -> {
            startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class));
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
