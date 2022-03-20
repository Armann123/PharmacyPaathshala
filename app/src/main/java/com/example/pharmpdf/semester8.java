package com.example.pharmpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class semester8 extends AppCompatActivity {
    WebView webview;
    String url = "https://cosmeticsadda.in/2022/03/b-pharm-8th-semester-notes-books-download/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester8);
        webview = findViewById(R.id.webbiew);
        webview.loadUrl(url);
    }
}