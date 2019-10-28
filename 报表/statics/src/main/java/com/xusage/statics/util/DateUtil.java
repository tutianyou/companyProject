package com.xusage.statics.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static final SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final Calendar cal = Calendar.getInstance();
	
	/**获取指定日期年份
	 * @throws ParseException */
	public static int  getYear(String date) throws ParseException { 
		
		Date parse = sim.parse(date);
        cal.setTime(parse);
        return cal.get(Calendar.YEAR);
    }
	
	
	public static Integer getMonth(String date) throws ParseException { 
	        
			Date dt = sim.parse(date);
			cal.setTime(dt);
	 
			return (cal.get(Calendar.MONTH)+1);
		
	    }
}
