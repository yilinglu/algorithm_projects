package com.yiling.lu.algorithm.problem.coursera.stanford;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFileUtil {

	private ArrayList<Integer> input = new ArrayList<Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReadFileUtil fileUtil = new ReadFileUtil();
		
		if(args.length != 1){
			
			System.out.println("file path needed!");
			
		}else {
			
			String curDir = System.getProperty("user.dir");
			String filePath = curDir + args[0];
			// process the argument as file name
			File file = new File(filePath);
			
			try {
				
				fileUtil.processInput(new FileReader(file));
				
				Integer[] array = fileUtil.getArray();
				
				QuickSortAlt<Integer> quickSortAlt = new QuickSortAlt<Integer>();
				
				quickSortAlt.qsort(array);
				
//				for (int i = 1; i < sortedArray.length; i++) {
//					Comparable str1 = sortedArray[i - 1];
//					Comparable str2 = sortedArray[i];
//					int result = str1.compareTo(str2);
//					
//					if(result == 1){
//						System.out.println("wrong order : " + str1 + ", " + str2);
//					}
//
//				}
				
				System.out.println("Inversion count: " + quickSortAlt.getComparisonCount());
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		}

	}

	public void processInput(Reader reader){
		
		Scanner scanner = new Scanner(reader);	
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			
			if(line.length()>0){
				Integer value = Integer.valueOf(line);
				input.add(value);
				
//				System.out.println("value read: " + value);
			}
		}
		scanner.close();
	}	
	
	public Integer[] getArray(){
		return input.toArray(new Integer[]{});
	}

}
