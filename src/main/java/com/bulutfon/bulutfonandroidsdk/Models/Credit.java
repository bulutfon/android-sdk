package com.bulutfon.bulutfonandroidsdk.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by htkaya.
 */
public class Credit {
    private double balance;
    private int smsCredit;

    public Credit(){}

    public Credit(double balance, int smsCredit) {
        this.balance = balance;
        this.smsCredit = smsCredit;
    }

    public Credit(JSONObject result) {
        try {
            this.balance = result.getDouble("balance");
            this.smsCredit = result.getInt("sms_credit");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getSmsCredit() {
        return smsCredit;
    }
}
