package com.plotch.sdk.data;

import android.app.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class NotificationListObject implements Serializable {

    @SerializedName("notifications")
    @Expose
    public ArrayList<Notification> notifications = new ArrayList<>();
}
