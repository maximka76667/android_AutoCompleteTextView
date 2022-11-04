package com.example.autocompletetextview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    WebLink[] links = {new WebLink("Google", "google.com"), new WebLink("Amazon", "amazon.com"), new WebLink("SpaceX", "spacex.com")};
    String selectedLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCompleteTextView = this.findViewById(R.id.autoCompleteTextView);
        Button button = this.findViewById(R.id.button);
        WebView webView = this.findViewById(R.id.webView);
        ProgressBar progressBar = this.findViewById(R.id.progressBar);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.setWebViewClient(new WebClient(new WebClientController() {
            @Override
            public void onStarted() {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinished() {
                progressBar.setVisibility(View.GONE);
            }
        }));

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, links);

        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedLink = (String) ((WebLink) (adapterView.getItemAtPosition(i))).getLink();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("https://" + selectedLink);
            }
        });
    }
}