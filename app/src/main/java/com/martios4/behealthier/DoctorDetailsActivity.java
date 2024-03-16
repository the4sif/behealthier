package com.martios4.behealthier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;

import com.martios4.behealthier.databinding.ActivityDoctorDetailsBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends Activity {

    ActivityDoctorDetailsBinding binding;

    String[][] doctor_details1 =
            {
                    {"Doctor Name = Ajit Saste", "Hospital Address : Moradabd", "Exp. : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name = Prasad Pawar", "Hospital Address : Moradabad", "Exp. : 8yrs", "Mobile No: 8989898989", "700"},
                    {"Doctor Name = Swapil Kavel", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 9989989989", "600"},
                    {"Doctor Name = Deepak Deshmukh", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 8898898898", "600"},
                    {"Doctor Name = Deepak Rawat", "Hospital Address : Moradabad", "Exp. : 4yrs", "Mobile No: 8898802898", "650"},
                    {"Doctor Name = Anjali Pandey", "Hospital Address : Moradabad", "Exp. : 2yrs", "Mobile No: 8058452689", "350"},
                    {"Doctor Name = Leena Roy", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 8058165702", "400"},
                    {"Doctor Name = Asif ", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 8898070540", "460"},
                    {"Doctor Name = Ashok Panda", "Hospital Address : Moradabad", "Exp. : 2yrs", "Mobile No: 9889889889", "300"}

            };
    String[][] doctor_details2 =
            {
                    {"Doctor Name = Rashi Saste", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 9898989897", "500"},
                    {"Doctor Name = Trisha Pawar", "Hospital Address : Moradabad", "Exp. : 4yrs", "Mobile No: 8989898987", "600"},
                    {"Doctor Name = Risha Kavel", "Hospital Address : Moradabad", "Exp. : 10yrs", "Mobile No: 9989989987", "1000"},
                    {"Doctor Name = Deepak Rawat", "Hospital Address : Moradabad", "Exp. : 4yrs", "Mobile No: 8898802898", "650"},
                    {"Doctor Name = Anjali Pandey", "Hospital Address : Moradabad", "Exp. : 2yrs", "Mobile No: 8058452689", "350"},
                    {"Doctor Name = Leena Roy", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 8058165702", "400"},
                    {"Doctor Name = Asif ", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 8898070540", "460"},
                    {"Doctor Name = Disha Deshmukh", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 8898898897", "600"},
                    {"Doctor Name = Aalanki Panda", "Hospital Address : Moradabad", "Exp. : 12yrs", "Mobile No: 9889889889", "800"}

            };

    String[][] doctor_details3 =
            {
                    {"Doctor Name = Ajay Saste", "Hospital Address : Moradabad", "Exp. : 7yrs", "Mobile No: 9898989896", "600"},
                    {"Doctor Name = Prakash Pawar", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 8989898986", "400"},
                    {"Doctor Name = Sapna Kavel", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 9989989986", "500"},
                    {"Doctor Name = Deepak Rawat", "Hospital Address : Moradabad", "Exp. : 4yrs", "Mobile No: 8898802898", "650"},
                    {"Doctor Name = Anjali Pandey", "Hospital Address : Moradabad", "Exp. : 2yrs", "Mobile No: 8058452689", "350"},
                    {"Doctor Name = Leena Roy", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 8058165702", "400"},
                    {"Doctor Name = Asif ", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 8898070540", "460"},
                    {"Doctor Name = Deepsikha Deshmukh", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 8898898896", "500"},
                    {"Doctor Name = Abhishek Panda", "Hospital Address : Moradabad", "Exp. : 2yrs", "Mobile No: 9889889886", "300"}

            };

    String[][] doctor_details4 =
            {
                    {"Doctor Name = Riza Ishmail", "Hospital Address : Moradabad", "Exp. : 7yrs", "Mobile No: 9898989895", "800"},
                    {"Doctor Name = Pramod Pawar", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 8989898985", "400"},
                    {"Doctor Name = Saurabh Kavel", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 9989989985", "500"},
                    {"Doctor Name = Deepak Rawat", "Hospital Address : Moradabad", "Exp. : 4yrs", "Mobile No: 8898802898", "650"},
                    {"Doctor Name = Anjali Pandey", "Hospital Address : Moradabad", "Exp. : 2yrs", "Mobile No: 8058452689", "350"},
                    {"Doctor Name = Leena Roy", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 8058165702", "400"},
                    {"Doctor Name = Asif ", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 8898070540", "460"},
                    {"Doctor Name = Ritesh Deshmukh", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 889889885", "600"},
                    {"Doctor Name = Shekhar Panda", "Hospital Address : Moradabad", "Exp. : 8yrs", "Mobile No: 9889889885", "600"}

            };

    String[][] doctor_details5 =
            {
                    {"Doctor Name = Arvind Saste", "Hospital Address : Moradabad", "Exp. : 2yrs", "Mobile No: 9898989898", "300"},
                    {"Doctor Name = Prashant Pawar", "Hospital Address : Moradabad", "Exp. : 8yrs", "Mobile No: 8989898989", "700"},
                    {"Doctor Name = Shikhar Kavel", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 9989989989", "600"},
                    {"Doctor Name = Deepak Rawat", "Hospital Address : Moradabad", "Exp. : 4yrs", "Mobile No: 8898802898", "650"},
                    {"Doctor Name = Anjali Pandey", "Hospital Address : Moradabad", "Exp. : 2yrs", "Mobile No: 8058452689", "350"},
                    {"Doctor Name = Leena Roy", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 8058165702", "400"},
                    {"Doctor Name = Asif ", "Hospital Address : Moradabad", "Exp. : 3yrs", "Mobile No: 8898070540", "460"},
                    {"Doctor Name = Raju Deshmukh", "Hospital Address : Moradabad", "Exp. : 5yrs", "Mobile No: 8898898898", "600"},
                    {"Doctor Name = Nanda Panda", "Hospital Address : Moradabad", "Exp. : 2yrs", "Mobile No: 9889889889", "300"}

            };

    String[][] doctor_details;

    ArrayList<HashMap<String, String>> list;
    HashMap<String, String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        binding.textViewDDName.setText(title);

        // Use a default case in the if-else block to handle unmatched titles
        assert title != null;
        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietitians") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentists") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeons") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5; // Use doctor_details5 as a default or choose another appropriate array


        binding.buttonDDBack.setOnClickListener(v -> startActivity(new Intent(DoctorDetailsActivity.this, HomeActivity.class)));

        list = new ArrayList<>();
        for (String[] doctorDetail : doctor_details) {
            item = new HashMap<>();
            item.put("line1", doctorDetail[0]);
            item.put("line2", doctorDetail[1]);
            item.put("line3", doctorDetail[2]);
            item.put("line4", doctorDetail[3]);
            item.put("line5", "Cons Fees: " + doctorDetail[4] + "/-");
            list.add(item);
        }


        SimpleAdapter sa = new SimpleAdapter(this, list, R.layout.multi_line,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        binding.listViewDD.setAdapter(sa);

        binding.listViewDD.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent1 = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
            intent1.putExtra("text1", title);
            intent1.putExtra("text2", doctor_details[position][0]);
            intent1.putExtra("text3", doctor_details[position][1]);
            intent1.putExtra("text4", doctor_details[position][2]);
            intent1.putExtra("text5", doctor_details[position][4]);
            startActivity(intent1);
        });


    }
}
