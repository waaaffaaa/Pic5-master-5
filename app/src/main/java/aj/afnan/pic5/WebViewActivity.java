package aj.afnan.pic5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

        private WebView WebSite;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            Intent intent = getIntent();

            Bundle bundle = intent.getExtras();
            String name= bundle.getString("name");

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_web_view);
            setTitle("موقع الويب");

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //home icon
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Home = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(Home);
                }
            });


            WebSite = (WebView) findViewById(R.id.webView);
            WebSettings WebSettingsForWebSite= WebSite.getSettings();
            WebSettingsForWebSite.setJavaScriptEnabled(true);
            WebSite.loadUrl(name);
            WebSite.setWebViewClient(new WebViewClient());

            WebSettingsForWebSite.setLoadWithOverviewMode(true);
            WebSettingsForWebSite.setUseWideViewPort(true);
            WebSettingsForWebSite.setBuiltInZoomControls(true);
            WebSettingsForWebSite.setDisplayZoomControls(false);
            WebSite.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        WebView webView = (WebView) v;

                        switch (keyCode) {
                            case KeyEvent.KEYCODE_BACK:
                                if (webView.canGoBack()) {
                                    webView.goBack();
                                    return true;
                                }
                                break;
                        }
                    }

                    return false;
                }
            });


        }

    }