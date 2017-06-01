package com.whjbsoft.www.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormateDate {
	
	public static String formate(String prefix){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String str =prefix + sdf.format(new Date());
		return str;
	}
	
	public static String formate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str =sdf.format(new Date());
		return str;
	}
	
	public static String formateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str =sdf.format(new Date());
		return str;
	}
	
	public static String appointFormat(String type,Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		return sdf.format(date);
	}

	public static int contrastDate(String date1 , String date2){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int num = 0;
		try {
			Date d1 = sdf.parse(date1);
			Date d2 = sdf.parse(date2);
			Long dispersion = d2.getTime()-d1.getTime();
			num=(int)(dispersion/24/60/60/1000);
			return num;
		} catch (ParseException e) {
			e.printStackTrace();
			return num;
		}
	}
}
