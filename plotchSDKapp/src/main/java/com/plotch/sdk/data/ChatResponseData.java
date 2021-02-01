package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatResponseData implements Serializable {

    @SerializedName("statements")
    private ArrayList<Statements> statements;

    @SerializedName("options")
    private ArrayList<OptionList> options;

    @SerializedName("data")
    private ChatData chat_data;

    @SerializedName("sessionId")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public ArrayList<Statements> getStatements() {
        return statements;
    }

    public ArrayList<OptionList> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionList> options) {
        this.options = options;
    }

    public ChatData getChat_data() {
        return chat_data;
    }


}
