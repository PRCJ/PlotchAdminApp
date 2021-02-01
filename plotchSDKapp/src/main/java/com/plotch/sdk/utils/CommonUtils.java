package com.plotch.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by root on 12/8/16.
 */
public class CommonUtils {
    public static final int UNBOUNDED = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
    private static final String TAG = "CommonUtils";

    public static boolean isInternetAvailable(Context ctx) {
        boolean isConnected = false;
        ConnectivityManager connectivityManager = null;
        if (ctx != null) {
            connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        }
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                isConnected = true;
            }
        }
        return isConnected;
    }


    public static String getSortedJsonObject(JSONObject jsonObject) throws JSONException {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> keys = new ArrayList<>();
        Iterator<String> iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            keys.add(iterator.next());
        }
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        stringBuilder.append("{");

        String sep = "";
        final String COMMA = ",";
        for (int j = 0; j < keys.size(); j++) {
            String s = keys.get(j);
            stringBuilder.append(sep);
            Object object = jsonObject.get(s);
            stringBuilder.append("\"" + s + "\":");
            if (object instanceof JSONArray) {
                stringBuilder.append(getSortedJsonArray((JSONArray) object));
            } else if (object instanceof JSONObject) {
                stringBuilder.append(getSortedJsonObject((JSONObject) object));
            } else if (object instanceof String) {
                stringBuilder.append("\"" + object.toString() + "\"");
            } else {
                stringBuilder.append(object.toString());
            }
            sep = COMMA;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String getSortedJsonArray(JSONArray jsonArray) throws JSONException {

        StringBuilder stringBuilder = new StringBuilder();
        if (jsonArray.length() > 0) {
            Object arrayElement = jsonArray.get(0);
            stringBuilder.append("[");
            if (arrayElement instanceof JSONArray) {

                for (int i = 0; i < jsonArray.length(); i++) {
                    if (i > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(getSortedJsonArray(jsonArray.getJSONArray(i)));
                }

            } else if (arrayElement instanceof JSONObject) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    if (i > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(getSortedJsonObject(jsonArray.getJSONObject(i)));
                }
            } else {
                List<String> elements = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    String childElement = jsonArray.get(i).toString();
                    elements.add(childElement);
                }
                Collections.sort(elements, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.compareToIgnoreCase(s2);
                    }
                });
                boolean isStringArray = jsonArray.get(0) instanceof String;
                for (int i = 0; i < elements.size(); i++) {
                    if (i > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(isStringArray ? "\"" + elements.get(i) + "\"" : elements.get(i));
                }
            }
            stringBuilder.append("]");
        } else {
            stringBuilder.append("[]");
        }

        return stringBuilder.toString();
    }

}