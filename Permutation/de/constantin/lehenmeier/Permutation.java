package de.constantin.lehenmeier;

public class Permutation {
	
	protected static void permute(String word){
		permute("", word);
	}
	
	private static void permute(String prefix, String word){
		if(word.length() == 1){
			System.out.println(prefix + word);
		}else{
			for(int i = 0; i < word.length(); i++){
				String newWord = word.substring(0, i) + 
						word.substring(i + 1);
				permute(prefix + word.charAt(i), newWord);
			}
		}
	}
}
