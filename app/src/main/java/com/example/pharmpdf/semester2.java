package com.example.pharmpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class semester2 extends AppCompatActivity {
    WebView webview;
    String url = "https://cosmeticsadda.in/2022/03/b-pharmacy-2nd-semester-notes-books-download/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester2);
        webview = findViewById(R.id.webvie);
        webview.loadUrl(url);
    }
}
