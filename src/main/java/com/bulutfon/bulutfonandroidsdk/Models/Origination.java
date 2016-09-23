
package com.bulutfon.bulutfonandroidsdk.Models;

import com.bulutfon.bulutfonandroidsdk.Utils.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class Origination {

    private String destination;
    private String startTime;
    private String answerTime;
    private String hangupTime;
    private String result;

    public Origination(JSONObject result){
        try {
            this.destination = Utilities.getStringFromJson(result.getString("destination"));
            this.startTime = Utilities.getStringFromJson(result.getString("start_time"));
            this.answerTime = Utilities.getStringFromJson(result.getString("answer_time"));
            this.hangupTime = Utilities.getStringFromJson(result.getString("hangup_time"));
            this.result = Utilities.getStringFromJson(result.getString("result"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return
     *     The destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * 
     * @return
     *     The startTime
     */
    public Date getStartTime() {
        return Utilities.getDateFromJson(startTime);
    }

    /**
     * 
     * @return
     *     The answerTime
     */
    public Date getAnswerTime() {
        return Utilities.getDateFromJson(answerTime);
    }

    /**
     * 
     * @return
     *     The hangupTime
     */
    public Date getHangupTime() {
        return Utilities.getDateFromJson(hangupTime);
    }

    /**
     * 
     * @return
     *     The result
     */
    public String getResult() {
        return result;
    }

    public static ArrayList<Origination> getOriginations(JSONObject result) {
        ArrayList<Origination> list = new ArrayList<>();
        try {
            JSONArray originations = result.getJSONArray("origination");
            for(int i=0; i < originations.length(); i++){
                try {
                    JSONObject obj = originations.getJSONObject(i);
                    list.add(new Origination(obj));
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
