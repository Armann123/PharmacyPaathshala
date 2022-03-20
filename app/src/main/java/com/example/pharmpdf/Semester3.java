package com.example.pharmpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Semester3 extends AppCompatActivity {
    WebView webview;
    String url = "https://cosmeticsadda.in/2022/03/b-pharm-2nd-year-books-notes-download/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester3);
        webview = findViewById(R.id.webvi);
        webview.loadUrl(url);


    }
}