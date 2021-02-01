package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OptionList implements Serializable {


    @SerializedName("optionId")
    private int optionId;
    @SerializedName("tag")
    private String target;
    @SerializedName("statementHindi")
    private String statement_hindi;
    @SerializedName("statementEnglish")
    private String statement_english;

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String tag) {
        this.target = tag;
    }

    public String getStatement_hindi() {
        return statement_hindi;
    }

    public void setStatement_hindi(String statement_hindi) {
        this.statement_hindi = statement_hindi;
    }

    public String getStatement_english() {
        return statement_english;
    }

    public void setStatement_english(String statement_english) {
        this.statement_english = statement_english;
    }

}

