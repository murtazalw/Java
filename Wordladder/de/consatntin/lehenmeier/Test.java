package de.consatntin.lehenmeier;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordLatter wordLatter = new WordLatter("res/words.txt");
		
		/*
		 * Task 1:
		 * 
		 * wordLatter.getWordLadderOf("best");
		 * 
		 */
		
		/*
		 * Task 2:
		 * 
		 * wordLatter.getWordWithThirdyThreeWords();
		 * 
		 */
		
		for(String word: wordLatter.getWordLadderOf("best", 3)){
			System.out.println(word);
		}
	}

}
