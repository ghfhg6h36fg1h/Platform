package com.liangxin.platform.common.tools;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 *
 * @since 1.0.0
 */
public final class DateTool {

    private final static Logger log = LoggerFactory.getLogger(DateTool.class);

    public static final long millisInDay = 86400000;

    // some static date formats
    private static SimpleDateFormat[] mDateFormats = loadDateFormats();

    private static final SimpleDateFormat mFormat4chars = new SimpleDateFormat(
            "yyyyMM");

    private static final SimpleDateFormat mFormat8chars = new SimpleDateFormat(
            "yyyyMMdd");

    private static final SimpleDateFormat mFormatMMDDchars = new SimpleDateFormat(
            "MM/dd");

    private static final SimpleDateFormat mFormat14chars = new SimpleDateFormat(
            "yyyyMMddHHmmss");

    public static final SimpleDateFormat mFormatIso8601Day = new SimpleDateFormat(
            "yyyy-MM-dd");

    public static final SimpleDateFormat mFormatChineseDay = new SimpleDateFormat(
            "yyyy-MM-dd");

    private static final SimpleDateFormat mFormatIso8601 = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ssZ");

    private static final SimpleDateFormat mFormatSimple = new SimpleDateFormat(
            "MM.dd");

    private static final SimpleDateFormat standFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    public static final SimpleDateFormat todayFormat = new SimpleDateFormat(
            "MM月dd日HH点mm分");

    private static final SimpleDateFormat hourMinuteFormat = new SimpleDateFormat(
            "HH:mm");

    private static final SimpleDateFormat dayhourMinuteFormat = new SimpleDateFormat(
            "yyyy/MM/dd HH:mm");
    // http://www.w3.org/Protocols/rfc822/Overview.html#z28
    // Using Locale.US to fix ROL-725 and ROL-628
    private static final SimpleDateFormat mFormatRfc822 = new SimpleDateFormat(
            "EEE, d MMM yyyy HH:mm:ss Z", Locale.US);

    private static SimpleDateFormat[] loadDateFormats() {
        SimpleDateFormat[] temp = {
                // new SimpleDateFormat("MM/dd/yyyy hh:mm:ss.SSS a"),
                new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy"), // standard
                // Date.toString()
                // results
                new SimpleDateFormat("M/d/yy hh:mm:ss"),
                new SimpleDateFormat("M/d/yyyy hh:mm:ss"),
                new SimpleDateFormat("M/d/yy hh:mm a"),
                new SimpleDateFormat("M/d/yyyy hh:mm a"),
                new SimpleDateFormat("M/d/yy HH:mm"),
                new SimpleDateFormat("M/d/yyyy HH:mm"),
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"),
                new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"), // standard
                // Timestamp.toString()
                // results
                new SimpleDateFormat("M-d-yy HH:mm"),
                new SimpleDateFormat("M-d-yyyy HH:mm"),
                new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS"),
                new SimpleDateFormat("M/d/yy"),
                new SimpleDateFormat("M/d/yyyy"),
                new SimpleDateFormat("M-d-yy"),
                new SimpleDateFormat("M-d-yyyy"),
                new SimpleDateFormat("MMMM d, yyyyy"),
                new SimpleDateFormat("MMM d, yyyyy")};

        return temp;
    }

    // -----------------------------------------------------------------------

    /**
     * Gets the array of SimpleDateFormats that DateTool knows about.
     */
    private static SimpleDateFormat[] getFormats() {
        return mDateFormats;
    }

    // -----------------------------------------------------------------------

    /**
     * Returns a Date set to the last possible millisecond of the day, just
     * before midnight. If a null day is passed in, a new Date is created.
     * midnight (00m 00h 00s)
     */


    public static int minusDate(Date firstDate, Date secondDate) {
        return (int) ((firstDate.getTime() - secondDate.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static int minusMinutesDate(Date firstDate, Date secondDate) {
        return (int) ((firstDate.getTime() - secondDate.getTime()) / (1000 * 60));
    }

    public static int minusHoursDate(Date firstDate, Date secondDate) {
        return (int) ((firstDate.getTime() - secondDate.getTime()) / (1000 * 60 * 60));
    }

    public static int minusSecondDate(Date firstDate, Date secondDate) {
        return (int) ((firstDate.getTime() - secondDate.getTime()) / (1000));
    }

    public static Date plusDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date plusMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static Date caculateMinutes(Date time, int minutes) {
        long times = time.getTime();
        times = times + 60000 * minutes;
        Date newDate = new Date(times);
        return newDate;
    }

    public static long getSecondsTime() {
        Date date = new Date();
        long time = date.getTime();
        return time / 1000;
    }

    public static Date parseSecondsTime(String time) {
        long millseconds = Long.parseLong(time) * 1000;
        Date date = new Date(millseconds);
        return date;
    }

    public static long getSecondsTime(Date date) {
        if (date == null) {
            return 0;
        }
        long time = date.getTime();
        return time / 1000;
    }

    public static Date getSecondesDate(Date date) {
        long secondsTime = getSecondsTime(date);
        return parseSecondsTime(secondsTime + "");
    }


    /**
     * Returns a Date set just to Noon, to the closest possible millisecond of
     * the day. If a null day is passed in, a new Date is created. nnoon (00m
     * 12h 00s)
     */
    public static Date getNoonOfDay(Date day) {
        Calendar cal = Calendar.getInstance();
        if (day == null) {
            day = new Date();
        }
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static java.sql.Date toSqlDate(Date utilDate) {
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }


    // -----------------------------------------------------------------------
    public static Date parseFromFormats(String aValue) {
        if (StringUtils.isEmpty(aValue))
            return null;

        // get DateTool's formats
        SimpleDateFormat formats[] = DateTool.getFormats();
        if (formats == null)
            return null;

        // iterate over the array and parse
        Date myDate = null;
        for (int i = 0; i < formats.length; i++) {
            try {
                myDate = DateTool.parse(aValue, formats[i]);
                // if (myDate instanceof Date)
                return myDate;
            } catch (Exception e) {
                // do nothing because we want to try the next
                // format if current one fails
            }
        }
        // haven't returned so couldn't parse
        return null;
    }

    public static Date getOrdinaryDate(String pStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition mPos = new ParsePosition(0);
        Date mRvalue = formatter.parse(pStr, mPos);
        return mRvalue;
    }

    // -----------------------------------------------------------------------
    public static java.sql.Timestamp parseTimestampFromFormats(String aValue) {
        if (StringUtils.isEmpty(aValue))
            return null;

        // call the regular Date formatter
        Date myDate = DateTool.parseFromFormats(aValue);
        if (myDate != null)
            return new java.sql.Timestamp(myDate.getTime());
        return null;
    }

    // -----------------------------------------------------------------------

    /**
     * Returns a java.sql.Timestamp equal to the current time
     */
    public static java.sql.Timestamp now() {
        return new java.sql.Timestamp(new Date().getTime());
    }

    // -----------------------------------------------------------------------

    /**
     * Returns a string the represents the passed-in date parsed according to
     * the passed-in format. Returns an empty string if the date or the format
     * is null.
     */
    public static String format(Date aDate, SimpleDateFormat aFormat) {
        if (aDate == null || aFormat == null) {
            return "";
        }
        synchronized (aFormat) {
            return aFormat.format(aDate);
        }
    }

    // -----------------------------------------------------------------------

    /**
     * Tries to take the passed-in String and format it as a date string in the
     * the passed-in format.
     */
    public static String formatDateString(String aString,
                                          SimpleDateFormat aFormat) {
        if (StringUtils.isEmpty(aString) || aFormat == null)
            return "";
        try {
            java.sql.Timestamp aDate = parseTimestampFromFormats(aString);
            if (aDate != null) {
                return DateTool.format(aDate, aFormat);
            }
        } catch (Exception e) {
            // Could not parse aString.
        }
        return "";
    }

    public static String formatSecondTimes(String secondTime) {
        String result = "";
        if (StringUtils.isNotEmpty(secondTime)) {
            Date date = parseSecondsTime(secondTime);
            result = formatChinese(date);
        }
        return result;
    }

    // -----------------------------------------------------------------------

    /**
     * Returns a Date using the passed-in string and format. Returns null if the
     * string is null or empty or if the format is null. The string must match
     * the format.
     */
    public static Date parse(String aValue, SimpleDateFormat aFormat)
            throws ParseException {
        if (StringUtils.isEmpty(aValue) || aFormat == null) {
            return null;
        }

        return aFormat.parse(aValue);
    }

    public static Date parseStandardDatetime(String aValue) {
        if (StringUtils.isEmpty(aValue)) {
            return null;
        }

        Date date = null;
        try {
            date = standFormat.parse(aValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 解析成时分秒以冒号分隔格式
     *
     * @param aValue
     * @return
     */
    public static String getHourAndMinuteFormateData(Date date) {
        String time = "";
        try {
            time = hourMinuteFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }


    /**
     * 解析成日期时分以/分隔格式
     *
     * @param aValue
     * @return
     */
    public static String getDayhourMinuteFormat(Date date) {
        String time = "";
        try {
            time = dayhourMinuteFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }


    // -----------------------------------------------------------------------

    /**
     * Returns true if endDate is after startDate or if startDate equals endDate
     * or if they are the same date. Returns false if either value is null.
     */
    public static boolean isValidDateRange(Date startDate, Date endDate) {
        return isValidDateRange(startDate, endDate, true);
    }

    // -----------------------------------------------------------------------

    /**
     * Returns true if endDate is after startDate or if startDate equals
     * endDate. Returns false if either value is null. If equalOK, returns true
     * if the dates are equal.
     */
    public static boolean isValidDateRange(Date startDate, Date endDate,
                                           boolean equalOK) {
        // false if either value is null
        if (startDate == null || endDate == null) {
            return false;
        }

        if (equalOK) {
            // true if they are equal
            if (startDate.equals(endDate)) {
                return true;
            }
        }

        // true if endDate after startDate
        if (endDate.after(startDate)) {
            return true;
        }

        return false;
    }

    // -----------------------------------------------------------------------
    // returns full timestamp format
    public static SimpleDateFormat defaultTimestampFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }

    // -----------------------------------------------------------------------
    // convenience method returns minimal date format
    public static SimpleDateFormat get8charDateFormat() {
        return DateTool.mFormat8chars;
    }

    public static SimpleDateFormat getMMDDFormat() {
        return DateTool.mFormatMMDDchars;
    }

    // -----------------------------------------------------------------------
    // convenience method returns minimal date format
    public static SimpleDateFormat defaultDateFormat() {
        return DateTool.friendlyDateFormat(true);
    }

    // -----------------------------------------------------------------------
    // convenience method
    public static String defaultTimestamp(Date date) {
        return DateTool.format(date, DateTool.defaultTimestampFormat());
    }

    // -----------------------------------------------------------------------
    // convenience method
    public static String defaultDate(Date date) {
        return DateTool.format(date, DateTool.defaultDateFormat());
    }

    // -----------------------------------------------------------------------
    // convenience method returns long friendly timestamp format
    public static SimpleDateFormat friendlyTimestampFormat() {
        return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    }

    // -----------------------------------------------------------------------
    // convenience method returns long friendly formatted timestamp
    public static String friendlyTimestamp(Date date) {
        return DateTool.format(date, DateTool.friendlyTimestampFormat());
    }

    // -----------------------------------------------------------------------
    // convenience method returns long friendly formatted timestamp
    public static String format4chars(Date date) {
        return DateTool.format(date, mFormat4chars);
    }

    public static String format8chars(Date date) {
        return DateTool.format(date, mFormat8chars);
    }

    public static String format14chars(Date date) {
        return DateTool.format(date, mFormat14chars);
    }

    public static String formatSimple(Date date) {
        return DateTool.format(date, mFormatSimple);
    }

    public static String formatChinese(Date date) {
        return DateTool.format(date, mFormatChineseDay);
    }

    // -----------------------------------------------------------------------
    // convenience method returns long friendly formatted timestamp
    public static String formatIso8601Day(Date date) {
        return DateTool.format(date, mFormatIso8601Day);
    }

    // -----------------------------------------------------------------------
    public static String formatRfc822(Date date) {
        return DateTool.format(date, mFormatRfc822);
    }

    // -----------------------------------------------------------------------
    // This is a hack, but it seems to work
    public static String formatIso8601(Date date) {
        if (date == null)
            return "";

        // Add a colon 2 chars before the end of the string
        // to make it a valid ISO-8601 date.

        String str = DateTool.format(date, mFormatIso8601);
        StringBuffer sb = new StringBuffer();
        sb.append(str.substring(0, str.length() - 2));
        sb.append(":");
        sb.append(str.substring(str.length() - 2));
        return sb.toString();
    }

    // -----------------------------------------------------------------------
    // convenience method returns minimal date format
    public static SimpleDateFormat minimalDateFormat() {
        return DateTool.friendlyDateFormat(true);
    }

    // -----------------------------------------------------------------------
    // convenience method using minimal date format
    public static String minimalDate(Date date) {
        return DateTool.format(date, DateTool.minimalDateFormat());
    }

    // -----------------------------------------------------------------------
    // convenience method that returns friendly data format
    // using full month, day, year digits.
    public static SimpleDateFormat fullDateFormat() {
        return DateTool.friendlyDateFormat(false);
    }

    // -----------------------------------------------------------------------
    public static String fullDate(Date date) {
        return DateTool.format(date, DateTool.fullDateFormat());
    }

    // -----------------------------------------------------------------------

    /**
     * Returns a "friendly" date format.
     *
     * @param mimimalFormat Should the date format allow single digits.
     */
    public static SimpleDateFormat friendlyDateFormat(
            boolean minimalFormat) {
        if (minimalFormat) {
            return new SimpleDateFormat("d.M.yy");
        }

        return new SimpleDateFormat("dd.MM.yyyy");
    }

    // -----------------------------------------------------------------------

    /**
     * Format the date using the "friendly" date format.
     */
    public static String friendlyDate(Date date, boolean minimalFormat) {
        return DateTool
                .format(date, DateTool.friendlyDateFormat(minimalFormat));
    }

    // -----------------------------------------------------------------------
    // convenience method
    public static String friendlyDate(Date date) {
        return DateTool.format(date, DateTool.friendlyDateFormat(true));
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year % 4 == 0 && year % 100 != 0) {
            switch (month) {
                case 2:
                    if (day > 29)
                        return false;
                case 4:
                    if (day > 30)
                        return false;
                case 6:
                    if (day > 30)
                        return false;
                case 9:
                    if (day > 30)
                        return false;
                case 11:
                    if (day > 30)
                        return false;
                default:
                    return true;
            }
        } else if (year % 400 == 0) {
            switch (month) {
                case 2:
                    if (day > 29)
                        return false;
                case 4:
                    if (day > 30)
                        return false;
                case 6:
                    if (day > 30)
                        return false;
                case 9:
                    if (day > 30)
                        return false;
                case 11:
                    if (day > 30)
                        return false;
                default:
                    return true;
            }
        } else {
            switch (month) {
                case 2:
                    if (day > 28)
                        return false;
                case 4:
                    if (day > 30)
                        return false;
                case 6:
                    if (day > 30)
                        return false;
                case 9:
                    if (day > 30)
                        return false;
                case 11:
                    if (day > 30)
                        return false;
                default:
                    return true;
            }
        }
    }

    // 日期相减返回值为秒
    public static long dateSubtraction(Date d1, Date d2) {
        long result = 0;
        if (d1 != null && d2 != null) {
            result = (d1.getTime() - d2.getTime()) / 1000;
        }
        return result;
    }

    public static String formatStandardDateTime(Date date) {
        return standFormat.format(date);
    }


    public static Date getNextDay(Date date) {
        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.DATE, 1);
        return cal1.getTime();
    }

    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static Date plusMinute(Date date, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, value);
        return cal.getTime();
    }

    public static Date plusHour(Date date, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, value);
        return cal.getTime();
    }

    public static String getDateLongByMinutes(Integer minutesLong) {
        String time = "";
        if (minutesLong != null && minutesLong.intValue() > 0) {
            int minutesInt = minutesLong.intValue();
            int hours = minutesInt / 60;
            int minutes = minutesInt % 60;
            if (hours > 0) {
                if (hours >= 24) {
                    time += (hours / 24 + "天");
                    hours = hours % 24;
                }
                time += (hours + "小时");
            }
            if (minutes > 0) {
                time += (minutes + "分钟");
            }
        }
        return time;
    }


    public static Date parse(String str, String pattern, Locale locale) {
        if (str == null || pattern == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(pattern, locale).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //
    public static String format(Date date, String pattern, Locale locale) {
        if (date == null || pattern == null) {
            return null;
        }
        return new SimpleDateFormat(pattern, locale).format(date);
    }
}
