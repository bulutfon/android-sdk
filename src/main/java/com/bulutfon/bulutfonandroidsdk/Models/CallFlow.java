
package com.bulutfon.bulutfonandroidsdk.Models;

import com.bulutfon.bulutfonandroidsdk.Utils.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CallFlow {

    private String callee;
    private String startTime;
    private String answerTime;
    private String hangupTime;
    private String redirection;
    private String redirectionTarget;
    private List<Origination> origination;

    public CallFlow(JSONObject result){
        try {
            this.callee = Utilities.getStringFromJson(result.getString("callee"));
            this.startTime = Utilities.getStringFromJson(result.getString("start_time"));
            this.answerTime = Utilities.getStringFromJson(result.getString("answer_time"));
            this.hangupTime = Utilities.getStringFromJson(result.getString("hangup_time"));
            this.redirection = Utilities.getStringFromJson(result.getString("redirection"));
            if(result.has("redirection_target"))
                this.redirectionTarget = Utilities.getStringFromJson(result.getString("redirection_target"));
            if(result.has("origination")){
                this.origination = Origination.getOriginations(result);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return
     *     The callee
     */
    public String getCallee() {
        return callee;
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
     *     The redirection
     */
    public String getRedirection() {
        return redirection;
    }

    /**
     * 
     * @return
     *     The redirectionTarget
     */
    public String getRedirectionTarget() {
        return redirectionTarget;
    }

    /**
     * 
     * @return
     *     The origination
     */
    public List<Origination> getOrigination() {
        return origination;
    }

    public static ArrayList<CallFlow> getCallFlow(JSONObject result){
        ArrayList<CallFlow> list = new ArrayList<>();
        try {
            JSONArray originations = result.getJSONArray("call_flow");
            for(int i=0; i < originations.length(); i++){
                try {
                    JSONObject obj = originations.getJSONObject(i);
                    list.add(new CallFlow(obj));
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
