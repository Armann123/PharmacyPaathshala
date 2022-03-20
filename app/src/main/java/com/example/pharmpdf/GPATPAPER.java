package com.example.pharmpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class GPATPAPER extends AppCompatActivity {
    WebView webview;
    String url = "https://cosmeticsadda.in/2022/03/practice-question-papers/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_p_a_t_p_a_p_e_r);

        webview = findViewById(R.id.webgiew);
        webview.loadUrl(url);
    }
}
