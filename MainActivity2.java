package com.example.makemyhome;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        WebView webView=findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript (if needed)

        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfEyIoYt6YhT4pDgvcTS8LVPWraJ8ZcLhMB9eFcoU9ZWW0XOg/viewform?usp=sf_link");
    }
}
