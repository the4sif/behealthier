package com.martios4.behealthier;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.martios4.behealthier.databinding.LabTestBookActivityBinding;

public class LabTestBookActivity extends Activity {
    LabTestBookActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LabTestBookActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

}
