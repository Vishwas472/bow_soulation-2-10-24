package com.example.athorview.WebView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.athorview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        WebView webView = findViewById(R.id.web);
        Button btn = findViewById(R.id.wetnbb);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webView.loadUrl("https://www.youtube.com/watch?v=RWCgMtzJMJY");


                webView.getSettings().setJavaScriptEnabled(true);


                webView.setWebViewClient(new WebViewClient());


            }
        });
    }
}