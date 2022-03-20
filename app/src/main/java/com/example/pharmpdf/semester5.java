package com.example.pharmpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class semester5 extends AppCompatActivity {
    WebView webview;
    String url = "https://cosmeticsadda.in/2022/03/b-pharm-5th-semester-notes-and-books-download/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester5);
        webview = findViewById(R.id.web);
        webview.loadUrl(url);
    }
}