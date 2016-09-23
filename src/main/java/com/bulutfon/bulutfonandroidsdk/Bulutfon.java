package com.bulutfon.bulutfonandroidsdk;

import com.bulutfon.bulutfonandroidsdk.Auth.AccessToken;
import com.bulutfon.bulutfonandroidsdk.Enums.AuthType;
import com.bulutfon.bulutfonandroidsdk.Auth.BulutfonConfig;
import com.bulutfon.bulutfonandroidsdk.Rest.CdrRequest;
import com.bulutfon.bulutfonandroidsdk.Rest.DetailRequest;
import com.bulutfon.bulutfonandroidsdk.Rest.MessageRequest;
import com.bulutfon.bulutfonandroidsdk.Rest.MessageTitleRequest;

/**
 * Created by htkaya.
 */
public class Bulutfon {
    private BulutfonConfig config;
    private AccessToken accessToken;
    public Bulutfon(BulutfonConfig config){
        this.config = config;
        this.accessToken = generateAccessToken(config);
    }

    public AccessToken getAccessToken() {
        return this.accessToken;
    }

    private AccessToken generateAccessToken(BulutfonConfig config) {
        if(config.getAuthType() == AuthType.MASTER_TOKEN) {
            return new AccessToken(config.getMasterToken());
        } else if(config.getAuthType() == AuthType.CREDENTIALS) {
            AccessToken accessToken = new AccessToken();
            accessToken.setCredentials(config.getEmail(), config.getPassword());
            return accessToken;
        } else {
            //TODO: FIX IT
            return null;
        }
    }

    public DetailRequest userDetail() {
        return new DetailRequest(getAccessToken());
    }

    public MessageTitleRequest messageTitles() {
        return new MessageTitleRequest(getAccessToken());
    }

    public MessageRequest messages() {
        return new MessageRequest(getAccessToken());
    }

    public CdrRequest cdrs() { return new CdrRequest(getAccessToken()); }
}
