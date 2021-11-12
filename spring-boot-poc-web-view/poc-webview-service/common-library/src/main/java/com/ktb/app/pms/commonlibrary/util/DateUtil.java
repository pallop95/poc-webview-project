package com.ktb.app.pms.commonlibrary.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {
    public static final Locale APPLICATION_LOCALE_TH = new Locale("th", "TH");
    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
    public static final String DEFAULT_DATE_FORMAT2 = "yyyyMMdd";
    public static final String DEFAULT_DATE_FORMAT3 = "yyyyMM";
    public static final String DEFAULT_DATETIME_FORMAT2 = "dd/MM/yyyy HH:mm:ss";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final long ONE_HOUR = 60 * 60 * 1000L;

    public static String covertDateToThaiFormat(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT, APPLICATION_LOCALE_TH);
        if(date != null){
            return formatter.format(date);
        }
        return null;
    }
    public static String covertDateToThaiDatetimeFormat(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT2, APPLICATION_LOCALE_TH);
        if(date != null){
            return formatter.format(date);
        }
        return null;
    }

    public static String covertTimestampToUSYYYYMMDD(Timestamp ts) throws ParseException {
    	Date date = new Date();
    	date.setTime(ts.getTime());
    	return new SimpleDateFormat(DEFAULT_DATE_FORMAT2).format(date);
    }

    public static String covertTimestampToUSHHMMSS(Timestamp ts) throws ParseException {
    	Date date = new Date();
    	date.setTime(ts.getTime());
    	return new SimpleDateFormat(DEFAULT_TIME_FORMAT).format(date);
    }

    public static Date covertDateStringToDateUS(String date) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT2,  Locale.US);
        if(date != null && !date.isEmpty()){
            return formatter.parse(date);
        }
        return null;
    }

    public static String covertDateStringToThaiFormat(String date){
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT2, APPLICATION_LOCALE_TH);
        if(date != null && !date.isEmpty()){
            return formatter.format(date);
        }
        return null;
    }

    public static Timestamp getCurrent() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String convertDateToThaiYYYYMM(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM", APPLICATION_LOCALE_TH);
        if(date != null){
            return formatter.format(date);
        }
        return null;
    }

    public static String covertDateToThaiFormatYYYYMM(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT3, APPLICATION_LOCALE_TH);
        if(date != null){
            return formatter.format(date);
        }
        return null;
    }

    public static String covertDateToDateString(Date date, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format, APPLICATION_LOCALE_TH);
        if(date != null){
            return formatter.format(date);
        }
        return null;
    }

    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date covertDateStringToDateUS(String date, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format,  Locale.US);
        if(date != null && !date.isEmpty()){
            return formatter.parse(date);
        }
        return null;
    }

    public static Date convertDateStringThaiToDateUS(String date, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format,  APPLICATION_LOCALE_TH);
        if(date != null && !date.isEmpty()){
            return formatter.parse(date);
        }
        return null;
    }

    public static Date convertDateStringThaiToDateTime(String dateStr, Integer hr, Integer mn) throws ParseException {

        if(!Validate.empty(dateStr)){
            Date date = DateUtil.convertDateStringThaiToDateUS(dateStr, DEFAULT_DATE_FORMAT);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.HOUR_OF_DAY, hr);
            c.add(Calendar.MINUTE, mn);

            return c.getTime();
        }
        return null;
    }

    public static Timestamp convertDateToTimestamp(Date date) {
    	if(!Validate.empty(date)) {
    		return new Timestamp(date.getTime());
    	}
    	return null;
    }

    public static Timestamp getTimestampWithoutTime(Timestamp dateTime) {
        if(!Validate.empty(dateTime)) {
            return new Timestamp(removeTime(dateTime).getTime());
        }
        return null;
    }
    
    public static String convertDateToStringThai(Date date) {
    	return !Validate.empty(date) ? covertDateToThaiFormat(date) : "-";
    }

    public static long daysBetween(Date d1, Date d2){
        long diff = clearTime(d2).getTime() - clearTime(d1).getTime();
        return (int)((diff/(ONE_HOUR * 24))+1);
    }

    public static Date clearTime(Date date) {
        if(date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.setTimeInMillis(date.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static String covertDateTimeToThaiFormat(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT, APPLICATION_LOCALE_TH);
        if(date != null){
            return formatter.format(date);
        }
        return null;
    }
    public static String covertTimeStampToThaiFormat(Timestamp date){
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT, APPLICATION_LOCALE_TH);
        if(date != null){
            return formatter.format(date);
        }
        return null;
    }

    public static String formatThaiDate(Date date) {
        SimpleDateFormat dfThai = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
        return dfThai.format(date);
    }

    public static String formatThaiDate(Date date, String format) {
        SimpleDateFormat dfThai = new SimpleDateFormat(format, new Locale("th", "TH"));
        return dfThai.format(date);
    }

    public static Date stringToDate(String dateString, String format) throws ParseException {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        return new SimpleDateFormat(format, Locale.US).parse(dateString);
    }

    public static String getYearTH() {
    	Date date = new Date();
    	Calendar calendar = new GregorianCalendar();
    	calendar.setTime(date);
    	return Integer.toString(calendar.get(Calendar.YEAR) + 543);
    }
}

