package com.cipsa.appparquimetro;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

/**
 * Created by ycardenas on 30/03/2017.
 */

public class ParquimetroApp extends Application {

    public RequestQueue requestQueue;
    public Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        gson = new Gson();
    }
}
