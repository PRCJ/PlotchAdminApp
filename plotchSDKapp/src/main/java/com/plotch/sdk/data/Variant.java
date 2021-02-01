package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Variant implements Serializable {

    @SerializedName("color")
    private ArrayList<String> color;
    @SerializedName("size")
    private ArrayList<String> size;

    public ArrayList<String> getColor() {
        return this.color;
    }

    public void setColor(ArrayList<String> color) {
        this.color = color;
    }

    public ArrayList<String> getSize() {
        return this.size;
    }

    public void setSize(ArrayList<String> size) {
        this.size = size;
    }
}
