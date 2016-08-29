package harvsftw.spambot.fb2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import harvsftw.spambot.fb2.R;

public class MainActivity extends Activity {
    private SharedPreferences mSharedPreferences;


    int ctr;
    int ctrl;
    int ctrl2;
    private WebView mWebView;

    public MainActivity() {
        this.ctrl = 0;
        this.ctr = 0;
        this.mSharedPreferences = null;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivity.this, "WARNING: Test Version ONLY (0.99 built 07/28/16)", Toast.LENGTH_LONG).show();
        if (this.mSharedPreferences == null) {
            this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        }
        setContentView(R.layout.activity_main);
        this.mWebView = (WebView) findViewById(R.id.activity_main_webview);
        this.mWebView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                if (MainActivity.this.ctrl == 999) {
                    MainActivity.this.spam();
                }
            }
        });
        WebSettings webSettings = this.mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        this.mWebView.loadUrl("https://mbasic.facebook.com/messages/");
        webSettings.setUserAgentString("full");

    }


    public void pwn(View view) {

        this.ctrl = 999;
        this.ctrl2 = 1;
        spam();
    }

    public void onBackPressed() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    private void spam() {
        try {
            final int amt = Integer.valueOf(MainActivity.this.mSharedPreferences.getString(SettingsActivity.config2, null)).intValue();
            if (this.ctrl == 999) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        if (MainActivity.this.ctrl == 999) {
                            if (ctrl2 == 1){
                                ln1();
                            } else if (ctrl2 == 2){
                                ln2();
                            } else if (ctrl2 == 3){
                                ln3();
                            } else if (ctrl2 == 4){
                                ln4();
                            } else if (ctrl2 == 5){
                                ln5();
                            }
                            if (MainActivity.this.ctr >= amt) {
                                MainActivity.this.ctrl = 0;
                                MainActivity.this.ctr = 0;
                                ctrl2 = 0;
                                Toast.makeText(MainActivity.this, "Spamming Finished", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }, (Integer.valueOf(this.mSharedPreferences.getString(SettingsActivity.config3, null)).intValue() * 1000));
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Error: Please Change Settings", Toast.LENGTH_LONG).show();
        }
    }
    public void ln1() {
        try {
            String config1 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config1, null);
            String config4 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config4, null);
            String config5 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config5, null);
            String config6 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config6, null);
            String config7 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config7, null);
            MainActivity.this.mWebView.loadUrl("javascript:(function() {var elUsername = document.getElementById('composerInput'), elForm = document.getElementById('composer_form');elUsername.textContent = '" + config1 + "';" + "elForm.submit();" + "})()");
            if (!config4.isEmpty()) {
                ctrl2 = 2;
            } else if (!config5.isEmpty()) {
                ctrl2 = 3;
            } else if (!config6.isEmpty()) {
                ctrl2 = 4;
            } else if (!config7.isEmpty()) {
                ctrl2 = 5;
            } else {
                ctr++;
                ctrl2 = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ln2(){
        try {
            String config4 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config4, null);
            String config5 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config5, null);
            String config6 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config6, null);
            String config7 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config7, null);
            MainActivity.this.mWebView.loadUrl("javascript:(function() {var elUsername = document.getElementById('composerInput'), elForm = document.getElementById('composer_form');elUsername.textContent = '" + config4 + "';" + "elForm.submit();" + "})()");
            if (!config5.isEmpty()) {
                ctrl2 = 3;
            } else if (!config6.isEmpty()) {
                ctrl2 = 4;
            } else if (!config7.isEmpty()) {
                ctrl2 = 5;
            } else {
                ctr++;
                ctrl2 = 1;
            }
        } catch (Exception e) {
            // IGNORE
        }
    }
    public void ln3() {
        try {
            String config5 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config5, null);
            String config6 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config6, null);
            String config7 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config7, null);
            MainActivity.this.mWebView.loadUrl("javascript:(function() {var elUsername = document.getElementById('composerInput'), elForm = document.getElementById('composer_form');elUsername.textContent = '" + config5 + "';" + "elForm.submit();" + "})()");
            if (!config6.isEmpty()) {
                ctrl2 = 4;
            } else if (!config7.isEmpty()) {
                ctrl2 = 5;
            } else {
                ctr++;
                ctrl2 = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ln4(){
        try {
            String config6 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config6, null);
            String config7 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config7, null);
            MainActivity.this.mWebView.loadUrl("javascript:(function() {var elUsername = document.getElementById('composerInput'), elForm = document.getElementById('composer_form');elUsername.textContent = '" + config6 + "';" + "elForm.submit();" + "})()");
            if (!config7.isEmpty()) {
                ctrl2 = 5;
            } else {
                ctr++;
                ctrl2 = 1;
            }
        } catch (Exception e) {
            // IGNORE
        }
    }
    public void ln5() {
        try {
            String config7 = MainActivity.this.mSharedPreferences.getString(SettingsActivity.config7, null);
            MainActivity.this.mWebView.loadUrl("javascript:(function() {var elUsername = document.getElementById('composerInput'), elForm = document.getElementById('composer_form');elUsername.textContent = '" + config7 + "';" + "elForm.submit();" + "})()");
            MainActivity mainActivity = MainActivity.this;
            mainActivity.ctr++;
            ctrl2 = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void settings(MenuItem menuItem) {
        startActivity(new Intent(this, SettingsActivity.class));
    }
    public void refresh(MenuItem menuItem) {
        mWebView.reload();
    }
    public void exit(MenuItem menuItem) {
        System.exit(0);
    }
}