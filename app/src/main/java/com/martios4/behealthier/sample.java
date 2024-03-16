package com.martios4.behealthier;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class sample extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthartical);

        webView = findViewById(R.id.webView);

        // Enable JavaScript (optional)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Get the URL from the intent
        String url = getIntent().getStringExtra("articleUrl");

        // Load the URL in the WebView
        webView.loadUrl(url);
    }
}
