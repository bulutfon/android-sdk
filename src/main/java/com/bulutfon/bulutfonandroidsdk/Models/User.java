package com.bulutfon.bulutfonandroidsdk.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by htkaya.
 */
public class User {
    private String email;
    private String name;
    private String gsm;

    public User(){}

    public User(String email, String name, String gsm){
        this.email = email;
        this.gsm = gsm;
        this.name = name;
    }

    public User(JSONObject result) {
        try {
            this.email = result.getString("email");
            this.name = result.getString("name");
            this.gsm = result.getString("gsm");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getGsm() {
        return gsm;
    }
}
