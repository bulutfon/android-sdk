package com.bulutfon.bulutfonandroidsdk.Auth;

/**
 * Created by htkaya on 16/09/16.
 */
public class Credentials {
    private String email;
    private String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
