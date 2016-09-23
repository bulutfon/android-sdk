
package com.bulutfon.bulutfonandroidsdk.Models;

import android.util.Log;

import com.bulutfon.bulutfonandroidsdk.Utils.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cdr {

    private String uuid;
    private String bfCalltype;
    private String direction;
    private String caller;
    private String callee;
    private String extension;
    private String callTime;
    private String answerTime;
    private String hangupTime;
    private Double callPrice;
    private String callRecord;
    private String hangupCause;
    private String hangupState;
    private List<CallFlow> callFlow = new ArrayList<>();

    public Cdr(JSONObject result) {
        try {
            this.uuid = Utilities.getStringFromJson(result.getString("uuid"));
            this.bfCalltype = Utilities.getStringFromJson(result.getString("bf_calltype"));
            this.direction = Utilities.getStringFromJson(result.getString("direction"));
            this.caller = Utilities.getStringFromJson(result.getString("caller"));
            this.callee = Utilities.getStringFromJson(result.getString("callee"));
            if(result.has("extension"))
                this.extension = Utilities.getStringFromJson(result.getString("extension"));
            this.bfCalltype = Utilities.getStringFromJson(result.getString("bf_calltype"));
            this.callTime = Utilities.getStringFromJson(result.getString("call_time"));
            this.answerTime = Utilities.getStringFromJson(result.getString("answer_time"));
            this.hangupTime = Utilities.getStringFromJson(result.getString("hangup_time"));
            this.callRecord = Utilities.getStringFromJson(result.getString("call_record"));
            if(result.has("call_price"))
                if(!result.getString("call_price").equals("null"))
                    this.callPrice = result.getDouble("call_price");
            this.hangupCause = Utilities.getStringFromJson(result.getString("hangup_cause"));
            this.hangupState = Utilities.getStringFromJson(result.getString("hangup_state"));
            if(result.has("call_flow")){
                this.callFlow = CallFlow.getCallFlow(result);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return
     *     The uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 
     * @return
     *     The bfCalltype
     */
    public String getBfCalltype() {
        return bfCalltype;
    }

    /**
     * 
     * @return
     *     The direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * 
     * @return
     *     The caller
     */
    public String getCaller() {
        return caller;
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
     *     The extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * 
     * @return
     *     The callTime
     */
    public Date getCallTime() {
        return Utilities.getDateFromJson(callTime);
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
     *     The callPrice
     */
    public Double getCallPrice() {
        return callPrice;
    }

    /**
     * 
     * @return
     *     The callRecord
     */
    public String getCallRecord() {
        return callRecord;
    }

    /**
     * 
     * @return
     *     The hangupCause
     */
    public String getHangupCause() {
        return hangupCause;
    }

    /**
     * 
     * @return
     *     The hangupState
     */
    public String getHangupState() {
        return hangupState;
    }

    /**
     * 
     * @return
     *     The callFlow
     */
    public List<CallFlow> getCallFlow() {
        return callFlow;
    }

    public static ArrayList<Cdr> getCdrsList(JSONObject result){
        ArrayList<Cdr> list = new ArrayList<>();
        try {
            JSONArray cdrs = result.getJSONArray("cdrs");
            for(int i=0; i < cdrs.length(); i++){
                try {
                    JSONObject obj = cdrs.getJSONObject(i);
                    list.add(new Cdr(obj));
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
