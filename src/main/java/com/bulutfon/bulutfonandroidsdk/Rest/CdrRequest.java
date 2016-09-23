package com.bulutfon.bulutfonandroidsdk.Rest;

import com.bulutfon.bulutfonandroidsdk.Auth.AccessToken;
import com.bulutfon.bulutfonandroidsdk.Models.Cdr;
import com.bulutfon.bulutfonandroidsdk.Utils.BulutfonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by htkaya.
 */
public class CdrRequest extends BaseRequest{
    public CdrRequest(AccessToken accessToken) { super(accessToken); }

    public void getCdrs(RequestParams params, BulutfonHttpResponseHandler handler) throws JSONException {
        getAsyncResources("cdrs", params, handler);
    }

    public void getCdr(String uuid, BulutfonHttpResponseHandler handler) throws JSONException {
        getAsyncResources("cdrs/" + uuid , null, handler);
    }

    public ArrayList<Cdr> getCdrsSynched(RequestParams params) throws JSONException {
        JSONObject cdrJSON = getSynchedResources("cdrs", params);
        return Cdr.getCdrsList(cdrJSON);
    }

    public Cdr getCdrSynched(String uuid) throws JSONException {
        JSONObject cdrJSON = getSynchedResources("cdrs/" + uuid, null);
        return new Cdr(cdrJSON.getJSONObject("cdr"));
    }
}
