package com.bulutfon.bulutfonandroidsdk.Models;

import com.bulutfon.bulutfonandroidsdk.Enums.MessageState;

/**
 * Created by htkaya.
 */
public class MessageRecipient {
    private String number;
    private MessageState state;
    public MessageRecipient(String number) {
        this.number = number;
    }

    public MessageRecipient(String number, String state) {
        this.number = number;
        switch (state){
            case "SENT":
                this.state = MessageState.SENT;
                break;
            case "FAILED":
                this.state = MessageState.FAILED;
                break;
            case "WAITING":
                this.state = MessageState.WAITING;
                break;
            default:
                this.state = MessageState.UNKNOWN;
                break;
        }
    }

    public String getNumber() {
        return number;
    }

    public MessageState getState() {
        return state;
    }
}
