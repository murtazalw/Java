package de.constantin.lehenmeier;

import java.util.Calendar;

public class TimeStamp {
	protected static String getTime(String input){
		Calendar cal = Calendar.getInstance();
		input = input.replaceAll("%y", Integer.toString(cal.get(Calendar.YEAR)));
		input = input.replaceAll("%M", Integer.toString(cal.get(Calendar.MONTH) + 1));
		input = input.replaceAll("%d", Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
		input = input.replaceAll("%h", Integer.toString(cal.get(Calendar.HOUR)));
		input = input.replaceAll("%m", Integer.toString(cal.get(Calendar.MINUTE)));
		input = input.replaceAll("%s", Integer.toString(cal.get(Calendar.SECOND)));
		input = input.replaceAll("%l", Integer.toString(cal.get(Calendar.MILLISECOND)));
		System.out.println(input);
		return input;
	}
	
}
