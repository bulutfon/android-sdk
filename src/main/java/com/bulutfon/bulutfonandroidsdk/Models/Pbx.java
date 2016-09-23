package com.bulutfon.bulutfonandroidsdk.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by htkaya.
 */
public class Pbx {
    private String name;
    private String url;
    private String state;
    private String pbxPackage;
    private String customerType;

    public Pbx() {}

    public Pbx(String name, String url, String state, String pbxPackage, String customerType) {
        this.name = name;
        this.url = url;
        this.state = state;
        this.pbxPackage = pbxPackage;
        this.customerType = customerType;
    }

    public Pbx(JSONObject result) {
        try {
            this.name = result.getString("name");
            this.url = result.getString("url");
            this.state = result.getString("state");
            this.pbxPackage = result.getString("package");
            this.customerType = result.getString("customer_type");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getState() {
        return state;
    }

    public String getPackage() {
        return pbxPackage;
    }

    public String getCustomerType() {
        return customerType;
    }
}
