package de.constantin.lehenmeier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
	
	protected static String parseString(String input){
		Pattern digets = Pattern.compile("[\\d]+");
		Pattern floats = Pattern.compile("[\\d]+[\\.]{1}[\\d]+");
		Pattern text = Pattern.compile("[\\w\\s]+");
		Pattern date = Pattern.compile("[\\d]{2}[-]{1}[\\d]{2}[-]{1}[\\d]{4}");
		Matcher match = digets.matcher(input);
		
		if(match.matches()){
			return "int";
		}

		match.usePattern(floats);
		if(match.matches()){
			return "float";
		}
		
		match.usePattern(text);
		if(match.matches()){
			return "text";
		}
		
		match.usePattern(date);
		if(match.matches()){
			return "date";
		}
		return "no classification";
	}
}
