package com.martios4.behealthier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class Splash extends AppCompatActivity {

 Button log ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash);

        log= findViewById (R.id.moverlog);


        log.setOnClickListener(v -> {
            startActivity(new Intent (Splash.this, LoginActivity.class));
        });


    }
}