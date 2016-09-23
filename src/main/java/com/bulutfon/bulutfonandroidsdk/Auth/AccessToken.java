package com.bulutfon.bulutfonandroidsdk.Auth;

/**
 * Created by htkaya.
 */
public class AccessToken {

    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private String scope;
    private int expireIN;
    private long createdAt;

    private Credentials credentials;

    public AccessToken() {}

    public AccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AccessToken(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getExpireIN() {
        return expireIN;
    }

    public void setExpireIN(int expireIN) {
        this.expireIN = expireIN;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setCredentials(String email, String password) {
        this.credentials = new Credentials(email, password);
    }

    public Credentials getCredentials() {
        return this.credentials;
    }
}
