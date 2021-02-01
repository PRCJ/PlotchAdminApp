package com.plotch.sdk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static String getDuration(String startTime) {

        String timeDifference = "";

        //date formatter as per the coder need
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        //parse the string date-ti
        // me to Date object
        Date startDate = null;
        try {
            startDate = sdf.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //end date will be the current system time to calculate the lapse time difference
        //if needed, coder can add end date to whatever date
        Date endDate = new Date();

        System.out.println(startDate);
        System.out.println(endDate);

        //get the time difference in milliseconds
        long duration = endDate.getTime() - startDate.getTime();

        //now we calculate the differences in different time units
        //this long value will be the total time difference in each unit
        //i.e; total difference in seconds, total difference in minutes etc...
        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);

        //now we create the time stamps depending on the value of each unit that we get
        //as we do not have the unit in years,
        //we will see if the days difference is more that 365 days, as 365 days = 1 year
        if (diffInDays > 365) {
            //we get the year in integer not in float
            //ex- 791/365 = 2.167 in float but it will be 2 years in int
            int year = (int) (diffInDays / 365);
            timeDifference = year + " years ";
            System.out.println(year + " years ");
        }
        //if days are not enough to create year then get the days
        else if (diffInDays > 1) {
            timeDifference = diffInDays + " days ";
            System.out.println(diffInDays + " days ");
        }
        //if days value<1 then get the hours
        else if (diffInHours > 1) {
            timeDifference = diffInHours + " hours ";
            System.out.println(diffInHours + " hours ");
        }
        //if hours value<1 then get the minutes
        else if (diffInMinutes > 1) {
            timeDifference = diffInMinutes + " minutes ";
            System.out.println(diffInMinutes + " minutes ");
        }
        //if minutes value<1 then get the seconds
        else if (diffInSeconds > 1) {
            timeDifference = diffInSeconds + " seconds ";
            System.out.println(diffInSeconds + " seconds ");
        }

        return timeDifference;

    }


}
