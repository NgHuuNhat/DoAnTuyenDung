package com.tuyendungvieclam.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
	
	public static final String MY_TIME_ZONE = "Asia/Bangkok";
	public static final String PARTTERN_YYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public final static String FORMAT_YYMMDD = "ddMMyy";
	
	public static final String PARTTERN_YYMMDD = "yyyy-MM-dd";

	public static String convertDateToString(LocalDateTime time, String parttern) {
		if (time == null) {
			return null;
		}
		if (parttern.equals(PARTTERN_YYMMDD_HHMMSS)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PARTTERN_YYMMDD_HHMMSS);
			String result = time.format(formatter);
			return result;
		} else if (parttern.equals(PARTTERN_YYMMDD)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PARTTERN_YYMMDD);
			String result = time.format(formatter);
			return result;
		} else if (parttern.equals(FORMAT_YYMMDD)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_YYMMDD);
			String result = time.format(formatter);
			return result;
		}
		return null;
	}
	
	public static LocalDateTime convertStringToLocalDateTime(String strDate){
		try {
			if (strDate == null) {
				return null;
			}
			//convert String to date
			DateFormat sourceFormat = new SimpleDateFormat(PARTTERN_YYMMDD);
			Date date = sourceFormat.parse(strDate);
			
			//convert date to localdatetime
			LocalDateTime result = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
			return result;
		} catch (ParseException e) {
			return null;
		}
	}
}
