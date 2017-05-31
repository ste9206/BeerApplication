package com.ste9206.beerapplication.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by stefano on 30/05/17.
 */

public class DateTime {

    public static Date todayDate(){
        Calendar c = Calendar.getInstance();

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        Date today = c.getTime();

        return today;
    }
}
