package de.constantin.lehenmeier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteConverter {
	private FileInputStream fis;
	
	public ByteConverter(){
			File file = new File("res/file.txt");
			int i=10;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
		}
	}
	
	protected void computeFile(){
		int currentByte;
		try {
			currentByte = fis.read();
			int counter = 0;
			while(currentByte != -1){
				if((counter%18) == 0){
					counter = 0;
					System.out.println();
				}
				currentByte = fis.read();
				String output = Integer.toHexString(currentByte);
				if(output.length() == 1){
					output = "0" + output;
				}
				System.out.print(output + " ");
				counter++;
			}
		} catch (IOException e) {
			System.out.println("Unable to read file");
		}
	}
	
}
