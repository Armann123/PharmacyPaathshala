package com.example.pharmpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class semester6 extends AppCompatActivity {
    WebView webview;
    String url = "https://cosmeticsadda.in/2022/03/b-pharm-6th-semester-notes-books-download/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester6);

        webview = findViewById(R.id.we);
        webview.loadUrl(url);

    }
}