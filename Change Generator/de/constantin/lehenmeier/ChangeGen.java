package de.constantin.lehenmeier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeGen {
	private static final int QUARTER = 25;
	private static final int DIME = 10;
	private static final int NICKEL = 5;
	private static final int PENNY = 1;
	private int preDecimal, postDecimal;
	
	public ChangeGen(){
				
	}
	
	protected String getChange(String value){
		roundAmount(value);
		return computeChange();
	}
	
	private void roundAmount(String value){
		Pattern pattern = Pattern.compile("[\\.,]");
		Matcher match = pattern.matcher(value);
		if(match.find()){
			if(match.start() > 0){
				preDecimal = Integer.parseInt(value.substring(0, match.start()));
			}
			postDecimal = Integer.parseInt(value.substring(match.start() + 1, 
					value.length()));
			int numOfPostDecimals = value.substring(match.start() + 1, 
					value.length()).length();
			if(numOfPostDecimals > 2){
				float foo = postDecimal;
				while(numOfPostDecimals > 2){
					foo = foo / 10;
					numOfPostDecimals--;
				}
				postDecimal = Math.round(foo);
				if(postDecimal > 100){
					preDecimal++;
					postDecimal = 0;
				}
			}
		}else{
			preDecimal = Integer.parseInt(value);
			postDecimal = 0;
		}
		System.out.println(preDecimal + " Dollars and " + postDecimal + " Penny(s)");
	}
	
	private String computeChange(){
		int numOfQuartersPreDecimal, numOfQuartersPostDecimal,
			numOfDimes, numOfNickels, numOfPennies; 
		numOfQuartersPreDecimal = numOfQuartersPostDecimal = 
				numOfDimes = numOfNickels = numOfPennies = 0;
		StringBuilder sBuilder = new StringBuilder();
		if(preDecimal > 0){
			preDecimal *= 100;
			numOfQuartersPreDecimal = preDecimal / QUARTER;
		}
		if(postDecimal > 0){
			int leftOver = postDecimal;
			numOfQuartersPostDecimal = leftOver / QUARTER;
			leftOver = leftOver % QUARTER;
			numOfDimes = leftOver / DIME;
			leftOver = leftOver % DIME;
			numOfNickels = leftOver / NICKEL;
			leftOver = leftOver % NICKEL;
			numOfPennies = leftOver / PENNY;
			leftOver = leftOver % PENNY;
		}
		sBuilder.append("Quarters: " + (numOfQuartersPreDecimal + numOfQuartersPostDecimal) + "\n")
				.append("Dimes: " + numOfDimes + "\n")
				.append("Nickels: " + numOfNickels + "\n")
				.append("Pennies: " + numOfPennies + "\n");
		return sBuilder.toString();
	}
}
