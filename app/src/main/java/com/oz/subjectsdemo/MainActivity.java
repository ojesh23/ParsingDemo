package com.oz.subjectsdemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
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

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView txtClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://www.kullabs.com/api/v1/subjects/8";
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,null) );

        if (isNetworkAvailable()) {
            fetchContact(url);
        } else {
            Toast.makeText(this, "No Internet Available", Toast.LENGTH_SHORT).show();
        }
        txtClass=(TextView)findViewById(R.id.className);

    }
    public Boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();

    }

    public void fetchContact(String url) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new JSONObject(), onComplete, onError);
        Volley.newRequestQueue(this).add(jsonObjectRequest);

    }
    Response.Listener<JSONObject> onComplete = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            Log.v("test api", response.toString());

            SubjectWrapper subjectWrapper = null;
            try {
                subjectWrapper = new Gson().fromJson(response.getJSONObject("data").toString(), SubjectWrapper.class);
                txtClass.setText("Class "+subjectWrapper.id );
            } catch (JSONException e) {
                e.printStackTrace();
            }



            RecyclerAdapter adapter = new RecyclerAdapter(MainActivity.this, subjectWrapper.list);
            recyclerView.setAdapter(adapter);


        }
    };
    Response.ErrorListener onError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };
}
