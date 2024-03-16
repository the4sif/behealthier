package com.martios4.behealthier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.martios4.behealthier.databinding.ActivityLabTestBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends Activity {

    private final String[][] packages =
            {
                    {"Package 1 : Full Body Checkup", "", "", "", "999"},
                    {"Package 2 : Blood Glucose Fasting", "", "", "", "299"},
                    {"Package 3 : COVID-19 Antibody - IgG", "", "", "", "899"},
                    {"Package 4 : Full Body Checkup", "", "", "", "499"},
                    {"Package 5 : Full Body Checkup", "", "", "", "899"}

            };
    private final String[] package_details = {
            "Blood Glucose Fasting\n" + "Complete Hemogram\n" + "HbA1c\n" + "Iron Studies\n" + "Kidney Function Test\n"
                    + "LDH Lactate Dehydrogenase, Serum\n" + "Liquid Profile\n" + "Liver Function Test\n",
            "Blood Glucose Fasting\n", "COVID-19 Antibody - IgG",
            "Thyroid Profile-Total (T3, T4, & TSH Ultra-Sensitive)",
            "Complete Hemogram\n" +
                    "CRP (C Reactive Protein) Quantitative Serum\n" + "Iron Studies\n" + "Kidney Function Test\n" + "Vitamin D Total-25 Hydroxy\n" +
                    "Liquid Profile"
    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    //    ListView listView;
    ActivityLabTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLabTestBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnLTBack.setOnClickListener(v -> {
            startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost " + packages[i][4] + "/-");
            list.add(item);
        }

        binding.listViewLT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LabTestActivity.this, LabTestDetailedActivity.class);
                intent.putExtra("text1", packages[position][0]);
                intent.putExtra("text2", package_details[position]);
                intent.putExtra("text3", packages[position][4]);
                startActivity(intent);
            }
        });

        sa = new SimpleAdapter(this, list,
                R.layout.multi_line,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        binding.listViewLT.setAdapter(sa);

        binding.listViewLT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailedActivity.class);
                it.putExtra("text1", packages[position][0]);
                it.putExtra("text2", package_details[position]);
                it.putExtra("text3", packages[position][4]);
                startActivity(it);
            }
        });

        binding.btnGoToCart.setOnClickListener(v -> {
                    startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
                }
        );
    }


}
