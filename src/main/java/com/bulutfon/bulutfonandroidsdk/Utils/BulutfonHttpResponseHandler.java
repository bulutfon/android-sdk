package com.bulutfon.bulutfonandroidsdk.Utils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by htkaya.
 */
public class BulutfonHttpResponseHandler extends JsonHttpResponseHandler {

    private static final String LOG_TAG = "BulutfonHttpRH";

    /**
     * Returns when request succeeds
     *
     * @param statusCode http response status line
     * @param headers    response headers if any
     * @param response   parsed response if any
     */
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    /**
     * Returns when request succeeds
     *
     * @param statusCode http response status line
     * @param headers    response headers if any
     * @param response   parsed response if any
     */
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        AsyncHttpClient.log.w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", throwable);
    }

    /**
     * Returns when request failed
     *
     * @param statusCode    http response status line
     * @param headers       response headers if any
     * @param throwable     throwable describing the way request failed
     * @param errorResponse parsed response if any
     */
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        AsyncHttpClient.log.w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", throwable);
    }
}
