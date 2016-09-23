package com.bulutfon.bulutfonandroidsdk.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by htkaya on 16/09/16.
 */
public class RequestResult {
    private boolean success;
    private String message;
    private JSONObject data;

    public RequestResult(JSONObject result) {
        try {
            this.success = result.getBoolean("success");
            this.message = result.getString("messages");
            if(result.has("data")) {
                this.data = result.getJSONObject("data");
            } else {
                this.data = null;
            }
        } catch (JSONException e) {
            this.success = false;
            this.message = null;
            this.data = null;
        }
    }
}
