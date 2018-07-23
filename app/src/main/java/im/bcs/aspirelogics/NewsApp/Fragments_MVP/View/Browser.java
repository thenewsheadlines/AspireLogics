package im.bcs.aspirelogics.NewsApp.Fragments_MVP.View;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import im.bcs.aspirelogics.R;

public class Browser extends AppCompatActivity {
    WebView webView;
    String getUrl;
    String validUrl;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        getUrl = getIntent().getStringExtra("url");
        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setAppCacheEnabled(true);

        webSettings.setAppCachePath(getApplicationContext().getCacheDir().getPath());
        webSettings.setAppCacheMaxSize(8*1024*1024);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setEnableSmoothTransition(true);
        //validUrl = "http://www.bbc.co.uk/news/world-us-canada-44686989";
        validUrl = CheckHttp(getUrl);
        webView.loadUrl(validUrl);
        webView.setWebViewClient(new MyClient());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // once the progress hit 100 then will invisible from screen.
                if(newProgress == 100) {
                    progressBar.setProgress(100);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                        }
                    },3000);
                }else {
                    progressBar.setProgress(newProgress);
                }
                System.out.println("Progress:"+newProgress);

            }
        });
    }

    private String CheckHttp(String getUrl) {

        if(getUrl.startsWith("http://")){
            String newUrl = getUrl.replace("http://","https://");
            return newUrl;
        }else {
            return getUrl;
        }
    }

    public class MyClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(validUrl);
            return true;
        }

    }
}
