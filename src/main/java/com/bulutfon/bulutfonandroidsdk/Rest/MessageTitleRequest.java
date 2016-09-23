package com.bulutfon.bulutfonandroidsdk.Rest;

import com.bulutfon.bulutfonandroidsdk.Auth.AccessToken;
import com.bulutfon.bulutfonandroidsdk.Models.MessageTitle;
import com.bulutfon.bulutfonandroidsdk.Utils.BulutfonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by htkaya.
 */
public class MessageTitleRequest extends BaseRequest {
    public MessageTitleRequest(AccessToken accessToken) {
        super(accessToken);
    }

    public void getMessageTitles(BulutfonHttpResponseHandler handler) throws JSONException {
        getAsyncResources("message-titles", null, handler);
    }

    public ArrayList<MessageTitle> getMessageTitlesSynched() throws JSONException {
        JSONObject titleObject = getSynchedResources("message-titles", null);
        return MessageTitle.getMessageTitlesList(titleObject);
    }
}
