package com.example.partymakersapp2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GuestHouse extends AppCompatActivity {

    WebView webView;
    private  String webUrl = "https://www.weddingsutra.com/blog/";
    ProgressDialog progressDialog;
    ProgressBar progressBar;
    RelativeLayout relativeLayout;
    Button btnNoInternetConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_house);

//        progressBar = (ProgressBar)findViewById(R.id.progressbar);
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Loading Please Wait...");
//
//        btnNoInternetConnection = (Button)findViewById(R.id.btnN0Connection);
//
//        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);


//        checkConnection();
//
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.dashboard:
                        return  true;

                    case R.id.portfolio:
                        startActivity(new Intent(getApplicationContext(),Gallery.class));

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.aboutus:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));

                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
//
//    }
//
//    @Override
//    public void onBackPressed() {
//
//        if (webView.canGoBack()){
//
//            webView.goBack();
//        }
//        else {
//            //super.onBackPressed();
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setMessage("Are you sure you want to exit")
//                    .setNegativeButton("No",null)
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                            finishAffinity();
//                        }
//                    }).show();
//        }
//
//    }
//
//    public void checkConnection(){
//
//        ConnectivityManager connectivityManager = (ConnectivityManager)
//                this.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        NetworkInfo mobilenetwork = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//        if (wifi.isConnected())
//        {
//            webView.loadUrl(webUrl);
//            webView.setVisibility(View.VISIBLE);
//            relativeLayout.setVisibility(View.GONE);
//        }
//        else if (mobilenetwork.isConnected())
//        {
//            webView.loadUrl(webUrl);
//            webView.setVisibility(View.VISIBLE);
//            relativeLayout.setVisibility(View.GONE);
//        }
//        else {
//            webView.setVisibility(View.GONE);
//            relativeLayout.setVisibility(View.VISIBLE);
//        }
    }

    public void photo(View view) {
        Intent intent = new Intent(GuestHouse.this,photo.class);
        startActivity(intent);
    }
}
