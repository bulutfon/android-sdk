package com.bulutfon.bulutfonandroidsdk.Auth;

import com.bulutfon.bulutfonandroidsdk.Enums.AuthType;
import com.bulutfon.bulutfonandroidsdk.Utils.BulutfonAuthException;

public class BulutfonConfig {
    private AuthType authType;
    private String clientId;
    private String clientSecret;
    private String email;
    private String password;
    private String masterToken;

    public BulutfonConfig(AuthType authType, String clientIdOrEmail, String clientSecretOrPassword) throws BulutfonAuthException {
        if(authType == AuthType.OAUTH2) {
            this.clientId = clientIdOrEmail;
            this.clientSecret = clientSecretOrPassword;
        } else if(authType == AuthType.CREDENTIALS) {
            this.email = clientIdOrEmail;
            this.password = clientSecretOrPassword;
        } else {
            throw new BulutfonAuthException("Auth type and credentials doesn't match");
        }

        this.authType = authType;
    }

    public BulutfonConfig(String masterToken) throws BulutfonAuthException {
        if(masterToken != null && !masterToken.trim().isEmpty()) {
            this.masterToken = masterToken;
            this.authType = AuthType.MASTER_TOKEN;
        } else {
            throw new BulutfonAuthException("Master Token Can't Be Blank");
        }
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public AuthType getAuthType() {
        return authType;
    }

    public void setAuthType(AuthType authType) {
        this.authType = authType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMasterToken() {
        return masterToken;
    }

    public void setMasterToken(String masterToken) {
        this.masterToken = masterToken;
    }
}
