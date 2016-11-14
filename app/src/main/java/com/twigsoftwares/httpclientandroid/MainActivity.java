package com.twigsoftwares.httpclientandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import HttpClient.HttpRestClient;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doLogin("Account/Login");

    }

    public void doLogin(String LoginUrl) {

        final RequestParams params = new RequestParams();
        params.put("Username", "abcd@gmail.com");
        params.put("Password", "123456a");

        // requires authentication is false because this is simply login method which doesn't require any token
        HttpRestClient.post(LoginUrl,false,"", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                System.out.println(response);
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                // Do something with the response
                System.out.println(timeline);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                System.out.println(statusCode);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                System.out.println(statusCode);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(statusCode);
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                System.out.println(statusCode);
            }
        });
    }
}
