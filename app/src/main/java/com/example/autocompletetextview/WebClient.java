package com.example.autocompletetextview;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

interface WebClientController {
    void onStarted();

    void onFinished();
}

public class WebClient extends WebViewClient {
    protected WebClientController webClientController;

    public WebClient(WebClientController webClientController) {
        this.webClientController = webClientController;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        webClientController.onStarted();
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        webClientController.onFinished();
    }
}
