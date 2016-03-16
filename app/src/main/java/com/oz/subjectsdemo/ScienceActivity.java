package com.oz.subjectsdemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ojesh on 3/14/2016.
 */
public class ScienceActivity extends AppCompatActivity {
    String url = "https://www.kullabs.com/api/v1/lessons/20";
    RecyclerView recyclerView;
    TextView txtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.science_recycler_layout);

        recyclerView = (RecyclerView) findViewById(R.id.scienceRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        txtTest = (TextView) findViewById(R.id.txtPhysics);

        if (isNetworkAvailable()) {
            fetchContact(url);
        } else {
            Toast.makeText(ScienceActivity.this, "Network not available", Toast.LENGTH_SHORT).show();
        }


    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void fetchContact(String url) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new JSONObject(), OnComplete, OnError);
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }

    Response.Listener<JSONObject> OnComplete = new Response.Listener<JSONObject>() {

        @Override
        public void onResponse(JSONObject response) {
            Log.v("test api", response.toString());

            ScienceWrapper scienceWrapper = null;
            try {
                scienceWrapper = new Gson().fromJson(response.getJSONObject("data").toString(), ScienceWrapper.class);
                //txtTest.setText("Test:"+scienceWrapper.unit);

            } catch (JSONException e) {
                e.printStackTrace();

            }

            ScienceRecyclerAdapter scienceRecylerAdapter = new ScienceRecyclerAdapter(ScienceActivity.this, scienceWrapper.cList);
            recyclerView.setAdapter(scienceRecylerAdapter);

        }
    };
    Response.ErrorListener OnError = new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };
}
