/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.plotch.sdk.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Mahesh Nayak on 14-03-2016.
 */
public class StringUtil {
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";

    public static String formatRsString(String totalRs) {
        String formatString = "";
        try {
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter.applyPattern("#,##,##,##,###");
            formatString = String.format("₹ " + formatter.format(Double.parseDouble(totalRs)));
        } catch (Exception e) {
        }

        return formatString;
    }

}
