package de.constantin.lehenmeier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLParser {
	private String ex;
	
	public URLParser(String ex){
		System.out.println("URL: " + ex);
		this.ex = ex;
	}
	
	protected boolean isURLValid(){
		if(ex == null){
			System.out.println("String is empty");
			return false;
		}
		
		if(hasInvalidCharacters()){
			return false;
		}
		
		if(isNotWellFormed()){
			return false;
		}
		
		return true;
	}

	private boolean hasInvalidCharacters() {
		Pattern ws = Pattern.compile("\\s");
		Pattern unic = Pattern.compile("[^\\x00-\\x7F]");
		Matcher matchWs = ws.matcher(ex);
		Matcher matchUnic = unic.matcher(ex);
		
		if(matchWs.find()){
			System.out.println("Whitespace found");
			return true;
		}else if(matchUnic.find()){
			System.out.println("Unicode found");
			return true;
		}else{
			System.out.println("No invalid characters found");
			return false;
		}
	}
	
	private boolean isNotWellFormed() {
		Pattern quest = Pattern.compile("[\\?]+");
		Pattern and = Pattern.compile("[&]");
		Pattern equal = Pattern.compile("[=]");
		Matcher matchQuest = quest.matcher(ex);
		String exMod;
		if(matchQuest.find()){
			int index = matchQuest.start();
			exMod = ex.substring(index + 1);
			extractKeyValuePairs(exMod, and, equal, "Key-Value Pairs: \n");
			return false;
		}
		System.out.println("Not well formed");
		return true;
	}
	
	private void extractKeyValuePairs(String substring, Pattern and, Pattern equal, 
			String pairs){
		Matcher matchAnd = and.matcher(substring);
		if(matchAnd.find()){
			int index = matchAnd.start();
			String firstPair = substring.substring(0, index);
			pairs += firstPair + "\n";
			
			String leftOver = substring.substring(index + 1);
			extractKeyValuePairs(leftOver, and, equal, pairs);
		}else{
			pairs += substring;
			System.out.println(pairs);
		}
		
	}
}
