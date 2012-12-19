package com.yiling.lu.guidetogalaxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

import com.yiling.lu.romannumerals.exception.SymbolAlreadyDefinedException;

/**
 * @author yiling.lu@outlook.com
 *
 */
public class MerchantsGuide {
	private NoteProcessor noteProcessor = new NoteProcessor();
	
	/**
	 * Expecting one argument in args array. This sole argument should be 
	 * the full path to a file to be processed by this application.
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		MerchantsGuide mcguide = new MerchantsGuide();
		
		if(args.length != 1){
			
			mcguide.printUsage();
			
		}else {
			
			// process the argument as file name
			File note = new File(args[0]);
			
			try {
				
				mcguide.processInput(new FileReader(note));
				
			} catch (FileNotFoundException e) {
				mcguide.printFileNotFoundMessage(args[0]);					
			} 
		}
	}
	
	private void processInput(Reader reader) 
			throws SymbolAlreadyDefinedException{
		
		Scanner scanner = new Scanner(reader);	
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			
			if(line.length()>0){
				noteProcessor.processLine(line);
			}
		}
		scanner.close();
	}
	
	public void printFileNotFoundMessage(String fileName){
		System.out.println("Could not find file " + fileName);
	}
	
	private void printUsage(){
		System.out.println("Usage: java -jar mcguide.jar [file_name]");
		System.out.println("Example: java -jar mcguide.jar note.txt");
	}
	
}
