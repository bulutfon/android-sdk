package com.bulutfon.bulutfonandroidsdk.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by htkaya.
 */
public class Detail {
    public User User;
    public Pbx Pbx;
    public Credit Credit;

    public Detail() {
        this.User = new User();
        this.Pbx = new Pbx();
        this.Credit = new Credit();
    }

    public Detail(JSONObject response) {
        if(response != null) {
            try {
                this.User = new User(response.getJSONObject("user"));
                this.Pbx = new Pbx(response.getJSONObject("pbx"));
                this.Credit = new Credit(response.getJSONObject("credit"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            this.User = new User();
            this.Pbx = new Pbx();
            this.Credit = new Credit();
        }
    }
}
