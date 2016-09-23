package com.bulutfon.bulutfonandroidsdk.Models;

import com.bulutfon.bulutfonandroidsdk.Utils.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by htkaya.
 */
public class Message {
    private int id;
    private String title;
    private String content;
    private String createdAt;
    private boolean sentAsSingleSms;
    private boolean isPlannedSms;
    private Date sendDate;
    private String sendDateString;
    private ArrayList<MessageRecipient> recipients;

    public Message(JSONObject result) {
        try {
            this.id = result.getInt("id");
            this.title = result.getString("title");
            this.content = result.getString("content");
            this.createdAt = result.getString("created_at");
            this.sentAsSingleSms = result.getBoolean("sent_as_single_sms");
            if(result.has("is_planned_sms"))
                this.isPlannedSms = result.getBoolean("is_planned_sms");
            if(result.has("send_date"))
                this.sendDateString = result.getString("send_date");
            Object recs = result.get("recipients");
            String name = recs.getClass().getSimpleName();
            if(name.equals("JSONArray")) {
                this.recipients = assignRecipients(result.getJSONArray("recipients"));
            } else {
                this.recipients = assignRecipients(result.getString("recipients"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Message(String title, String content, ArrayList<MessageRecipient> recipients) {
        this.title = title;
        this.content = content;
        this.recipients = recipients;
        this.sentAsSingleSms = false;
        this.isPlannedSms = false;
        this.sendDate = null;
    }

    public Message(String title, String content, boolean sentAsSingleSms,  ArrayList<MessageRecipient> recipients) {
        this.title = title;
        this.content = content;
        this.recipients = recipients;
        this.sentAsSingleSms = sentAsSingleSms;
        this.isPlannedSms = false;
        this.sendDate = null;
    }

    public Message(String title, String content, Date sendDate,  ArrayList<MessageRecipient> recipients) {
        this.title = title;
        this.content = content;
        this.recipients = recipients;
        this.sentAsSingleSms = false;
        this.isPlannedSms = true;
        this.sendDate = sendDate;
    }

    public Message(String title, String content, boolean sentAsSingleSms, Date sendDate,  ArrayList<MessageRecipient> recipients) {
        this.title = title;
        this.content = content;
        this.recipients = recipients;
        this.sentAsSingleSms = sentAsSingleSms;
        this.isPlannedSms = true;
        this.sendDate = sendDate;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        this.sendDateString = format.format(sendDate);
    }

    public static ArrayList<Message> getMessagesList(JSONObject result) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            JSONArray messages = result.getJSONArray("messages");
            for(int i=0; i < messages.length(); i++){
                try {
                    JSONObject obj = messages.getJSONObject(i);
                    list.add(new Message(obj));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }


    private ArrayList<MessageRecipient> assignRecipients(JSONArray result) {
        ArrayList<MessageRecipient> list = new ArrayList<>();
        for(int i=0; i < result.length(); i++){
            try {
                JSONObject obj = result.getJSONObject(i);
                list.add(new MessageRecipient(obj.getString("number"), obj.getString("state")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    private ArrayList<MessageRecipient> assignRecipients(String result) {
        ArrayList<MessageRecipient> list = new ArrayList<>();
        String[] resultList = result.split(",");
        for(String number : resultList) {
            list.add(new MessageRecipient(number));
        }
        return list;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedAt() {
        return Utilities.getDateFromJson(createdAt);
    }

    public boolean isSentAsSingleSms() {
        return sentAsSingleSms;
    }

    public boolean isPlannedSms() {
        return isPlannedSms;
    }

    public Date getSendDate() {
        return Utilities.getDateFromJson(sendDateString);
    }

    public ArrayList<MessageRecipient> getRecipients() {
        return recipients;
    }
}
