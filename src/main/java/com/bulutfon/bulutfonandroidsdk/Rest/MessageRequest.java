package com.bulutfon.bulutfonandroidsdk.Rest;

import com.bulutfon.bulutfonandroidsdk.Auth.AccessToken;
import com.bulutfon.bulutfonandroidsdk.Models.Message;
import com.bulutfon.bulutfonandroidsdk.Models.MessageRecipient;
import com.bulutfon.bulutfonandroidsdk.Models.RequestResult;
import com.bulutfon.bulutfonandroidsdk.Utils.BulutfonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by htkaya.
 */
public class MessageRequest extends BaseRequest{

    public MessageRequest(AccessToken accessToken) {
        super(accessToken);
    }

    public void getMessages(RequestParams params, BulutfonHttpResponseHandler handler) throws JSONException {
        getAsyncResources("messages", params, handler);
    }

    public void getMessage(int messageID, BulutfonHttpResponseHandler handler) throws JSONException {
        getAsyncResources("messages/" + messageID , null, handler);
    }

    public void createMessage(Message message, BulutfonHttpResponseHandler handler) throws JSONException {
        postAsyncResources("messages", messageParameters(message), handler);
    }

    public ArrayList<Message> getMessagesSynched(RequestParams params) throws JSONException {
        JSONObject messageJSON = getSynchedResources("messages", params);
        return Message.getMessagesList(messageJSON);
    }

    public Message getMessageSynched(int messageID) throws JSONException {
        JSONObject messageJSON = getSynchedResources("messages/" + messageID , null);
        return new Message(messageJSON.getJSONObject("messages"));
    }

    public RequestResult createMessageSynched(Message message) throws JSONException {
        JSONObject resultJSON = postSynchedResources("messages", messageParameters(message));
        return new RequestResult(resultJSON);
    }

    private RequestParams messageParameters(Message msg) {
        RequestParams params = new RequestParams();
        params.add("title", msg.getTitle());
        params.add("content", msg.getContent());
        params.add("sent_as_single_sms", String.valueOf(msg.isPlannedSms()));
        if(msg.getSendDate() != null) {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            params.add("is_planned_sms", String.valueOf(true));
            params.add("send_date", df.format(msg.getSendDate()));
        }

        StringBuilder stringBuilder = new StringBuilder();
        String delimiter = "";

        ArrayList<MessageRecipient> recipients = msg.getRecipients();
        for (MessageRecipient recipient : recipients) {
            stringBuilder.append(delimiter).append(recipient.getNumber());
            delimiter = ",";
        }
        params.add("receivers", stringBuilder.toString());
        return params;
    }

}
