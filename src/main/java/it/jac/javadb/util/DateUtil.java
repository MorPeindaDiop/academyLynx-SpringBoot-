package it.jac.javadb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	public static String format(Date date) {
		
		return sdf.format(date);
	}
}
