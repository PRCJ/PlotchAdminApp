package com.plotch.sdk.utils;

import android.view.Gravity;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class GeneralUtils {

    public static String getAmountString(String amount) {
        String originalAmount = amount;
        String strWithountSign = "";
        String strRupeeConverted = "";
        String finalString = "";

        if (amount != null) {
            boolean isNegative = false;

            if (originalAmount != null && originalAmount.length() > 0 && originalAmount.startsWith("-")) {
                isNegative = true;
                strWithountSign = originalAmount.substring(1);
                strRupeeConverted = "\u20B9 " + NumberFormat.getNumberInstance(Locale.getDefault())
                        .format((int) Float.parseFloat(strWithountSign)) + "";
            } else {
                strRupeeConverted = "\u20B9 " + NumberFormat.getNumberInstance(Locale.getDefault())
                        .format((int) Float.parseFloat(originalAmount)) + "";
            }

            if (isNegative) {
                finalString = " - " + strRupeeConverted;
            } else {
                finalString = " + " + strRupeeConverted;
            }

        }
        return finalString;
    }

    public static void setParamsForOrientation(TextView title, String orien) {
        if (orien != null) {
            if (orien.equalsIgnoreCase("center")) {
                title.setGravity(Gravity.CENTER);
            } else if (orien.equalsIgnoreCase("left")) {
                title.setGravity(Gravity.LEFT);
            } else if (orien.equalsIgnoreCase("right")) {
                title.setGravity(Gravity.RIGHT);
            } else {
                title.setGravity(Gravity.CENTER);
            }
        }
    }


    public static String getAmountStringWithOutSign(String amount) {
        String originalAmount = amount;
        String strWithountSign = "";
        String strRupeeConverted = "";
        String finalString = "";

        if (amount != null) {
            boolean isNegative = false;

            if (originalAmount != null && originalAmount.length() > 0 && originalAmount.startsWith("-")) {
                isNegative = true;
                strWithountSign = originalAmount.substring(1);
                strRupeeConverted = "\u20B9" + NumberFormat.getNumberInstance(Locale.getDefault())
                        .format((int) Float.parseFloat(strWithountSign)) + "";
            } else {
                strRupeeConverted = "\u20B9" + NumberFormat.getNumberInstance(Locale.getDefault())
                        .format((int) Float.parseFloat(originalAmount)) + "";
            }

            if (isNegative) {
                finalString = " - " + strRupeeConverted;
            } else {
                finalString = strRupeeConverted;
            }

        }
        return finalString;
    }


}
