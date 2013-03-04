package de.consatntin.lehenmeier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class WordLatter {
	ArrayList<String> words;
	
	public WordLatter(String path){
		words = new ArrayList<String>();
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(path));
			
			String word = input.readLine();
			
			while(word != null){
				words.add(word);
				word = input.readLine();
			}
			
			System.out.println("File was successfully read");
		} catch (Exception e) {
			System.out.println("Unable to open path " + path);
		}
	}
	
	protected String getWordWithThirdyThreeWords(){
		for(String word: words){
			if(getWordLadderOf(word).size() == 33){
				System.out.println("The word is with 33 words is " + word);
				return word;
			}
		}
		return null;
	}
	
	protected ArrayList<String> getWordLadderOf(String startWord, int steps){
		ArrayList<String> wordLadder = new ArrayList<String>();
		ArrayList<String> help = new ArrayList<String>();
		help.add(startWord);
		
		for(int i = 0; i < steps; i++){
			ArrayList<String> currentWordLadder = new ArrayList<String>();
			for(String word: help){
				currentWordLadder.addAll(getWordLadderOf(word));
			}
			help = currentWordLadder;
			wordLadder.addAll(help);
		}
		return wordLadder;
	}
	
	protected ArrayList<String> getWordLadderOf(String startWord){
		// System.out.println("Wordladder of " + startWord);
		ArrayList<String> wordLadder = new ArrayList<String>();
		if(isInputCorrect(startWord)){
			for(String word: words){
				if(isPossibleWord(word, startWord)){
					wordLadder.add(word);
					System.out.println(word);
				}
			}
		}
		return wordLadder;
	}

	private boolean isInputCorrect(String word) {
		return words.contains(word) ? true: false;
	}
	
	private boolean isPossibleWord(String word, String startWord) {
		int hammingDistance = 4;
		for(int i = 0; i < startWord.length(); i++){
			if(startWord.charAt(i) == word.charAt(i)){
				hammingDistance--;
			}
		}
		return hammingDistance == 1? true: false;
	}
	
}
