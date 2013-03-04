package de.constantin.lehenmeier;

public class Test {
	public static void main(String [] args){
		URLParser parser = 
				new URLParser("http://en.wikipedia.org/w/index.php?title=Main_Page&action=edit");
		parser.isURLValid();
		URLParser parser2 = 
				new URLParser("http://en.wikipedia.org/w/index.php?title= hello world!&action=é");
		parser2.isURLValid();
	}
}
