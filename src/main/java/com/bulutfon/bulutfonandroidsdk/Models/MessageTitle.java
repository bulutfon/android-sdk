package com.bulutfon.bulutfonandroidsdk.Models;

import com.bulutfon.bulutfonandroidsdk.Enums.MessageTitleState;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by htkaya.
 */
public class MessageTitle {
    private int id;
    private String name;
    private MessageTitleState state;

    public MessageTitle(JSONObject result) {
        try {
            this.id = result.getInt("id");
            this.name = result.getString("name");
            String state = result.getString("state");
            switch (state){
                case "DRAFT":
                    this.state = MessageTitleState.DRAFT;
                    break;
                case "REJECTED":
                    this.state = MessageTitleState.REJECTED;
                    break;
                case "CONFIRMED":
                    this.state = MessageTitleState.CONFIRMED;
                    break;
                default:
                    this.state = MessageTitleState.UNKNOWN;
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MessageTitleState getState() {
        return state;
    }


    public static ArrayList<MessageTitle> getMessageTitlesList(JSONObject result) {
        ArrayList<MessageTitle> list = new ArrayList<>();
        try {
            JSONArray messages = result.getJSONArray("message_titles");
            for(int i=0; i < messages.length(); i++){
                try {
                    JSONObject obj = messages.getJSONObject(i);
                    list.add(new MessageTitle(obj));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }
}
