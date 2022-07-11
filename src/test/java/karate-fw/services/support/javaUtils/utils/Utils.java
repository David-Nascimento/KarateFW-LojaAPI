package utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
     /**
     * Generate current date / time
     */
    public static long getCurrentTimestamp() {
        return new Timestamp((System.currentTimeMillis() / 1000)).getTime();
    }

    /**
     * Generates Current Date/Time Plus Minutes
     */
    public static long getCurrentTimestampPlusMinutes(int min) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, min);
        return new Timestamp(c.getTimeInMillis() / 1000).getTime();
    }

    /**
     * Get Date Now Format
     */
    public static String getDateNowFormat(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * Get Add Minutes To Date
     */
    public static String getAddMinutesToDate(String dateTime, String format, int minutes) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, minutes);
        return sdf.format(cal.getTime());
    }

    /**
     * Format Date Time
     */
    public static String formatDateTime(String dateTime, String format) throws ParseException {
        SimpleDateFormat formatt = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat = formatt.parse(dateTime);
        SimpleDateFormat parser = new SimpleDateFormat(format);
        return parser.format(dateFormat);
    }

    /**
     * Get Next Hour Format
     */
    public static String getNextHourFormat(String format, int hours) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR_OF_DAY, hours);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(c.getTime());
    }

    /**
     * Get Date Now Time Zone
     */
    public static String getDateNowTimeZone(String format, String timeZone) {
        Date date = new Date();
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

}
