package com.bulutfon.bulutfonandroidsdk.Rest;

import com.bulutfon.bulutfonandroidsdk.Auth.AccessToken;
import com.bulutfon.bulutfonandroidsdk.Utils.BulutfonHttpResponseHandler;
import com.loopj.android.http.*;
import org.json.*;

import cz.msebera.android.httpclient.Header;

/**
 * Created by htkaya.
 */
public class BaseRequest {
    private JSONObject result;
    private AccessToken accessToken;
    public BaseRequest(AccessToken accessToken) {
        this.accessToken = accessToken;
        this.result = null;
    }

    protected void getAsyncResources(String url, RequestParams params, BulutfonHttpResponseHandler handler) throws JSONException {
        params = addTokenToParams(params);
        BulutfonAsyncRestClient.get(url, params, handler);
    }

    protected void postAsyncResources(String url, RequestParams params, BulutfonHttpResponseHandler handler) throws JSONException {
        params = addTokenToParams(params);
        BulutfonAsyncRestClient.post(url, params, handler);
    }


    protected JSONObject getSynchedResources(String url, RequestParams params) throws JSONException {
        final JSONObject[] requestResult = {null};
        params = addTokenToParams(params);

        BulutfonSyncRestClient.get(url, params, new BulutfonHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                requestResult[0] = null;
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                requestResult[0] = errorResponse;
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                requestResult[0] = response;
            }
        });

        return requestResult[0];
    }

    protected JSONObject postSynchedResources(String url, RequestParams params) throws JSONException {
        final JSONObject[] requestResult = {null};
        params = addTokenToParams(params);

        BulutfonSyncRestClient.post(url, params, new BulutfonHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                requestResult[0] = errorResponse;
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                requestResult[0] = response;
            }
        });

        return requestResult[0];
    }

    private RequestParams addTokenToParams(RequestParams params) {
        if(params == null) {
            params = new RequestParams();
        }
        if(accessToken.getAccessToken() != null) {
            params.add("access_token", accessToken.getAccessToken());
        } else {
            params.add("email", accessToken.getCredentials().getEmail());
            params.add("password", accessToken.getCredentials().getPassword());
        }

        return params;
    }
}
