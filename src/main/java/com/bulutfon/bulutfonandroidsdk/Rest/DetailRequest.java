package com.bulutfon.bulutfonandroidsdk.Rest;

import com.bulutfon.bulutfonandroidsdk.Auth.AccessToken;
import com.bulutfon.bulutfonandroidsdk.Models.Detail;
import com.bulutfon.bulutfonandroidsdk.Utils.BulutfonHttpResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by htkaya.
 */
public class DetailRequest extends BaseRequest{

    public DetailRequest(AccessToken accessToken) {
        super(accessToken);
    }

    public void getDetail(BulutfonHttpResponseHandler handler) throws JSONException {
        getAsyncResources("me", null, handler);
    }

    public Detail getDetailSynched() throws JSONException {
        JSONObject detailJSON = getSynchedResources("me", null);
        return new Detail(detailJSON);
    }
}
