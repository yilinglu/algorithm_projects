package com.yiling.lu.algorithm.problem.sorting.comparasionbased;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Coursera, Stanford Online Algorithm: Design and Analysis, Part 1
 * 
 * This file contains all of the 100,000 integers between 1 and 100,000
 * (inclusive) in some order, with no integer repeated.
 * 
 * Your task is to compute the number of inversions in the file given, where the
 * ith row of the file indicates the ith entry of an array. Because of the large
 * size of this array, you should implement the fast divide-and-conquer
 * algorithm covered in the video lectures. The numeric answer for the given
 * input file should be typed in the space below. So if your answer is
 * 1198233847, then just type 1198233847 in the space provided without any space
 * / commas / any other punctuation marks. You can make up to 5 attempts, and
 * we'll use the best one for grading. (We do not require you to submit your
 * code, so feel free to use any programming language you want --- just type the
 * final numeric answer in the following space.)
 * 
 * @author ylu
 * 
 */
public class MergeSortFileContent {
	private ArrayList<Integer> input = new ArrayList<Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSortFileContent mergesortFile = new MergeSortFileContent();
		
		if(args.length != 1){
			
			System.out.println("file path needed!");
			
		}else {
			
			String curDir = System.getProperty("user.dir");
			String filePath = curDir + args[0];
			// process the argument as file name
			File file = new File(filePath);
			
			try {
				
				mergesortFile.processInput(new FileReader(file));
				
				Integer[] array = mergesortFile.getArray();
				
				MergeSort mergesort = new MergeSort();
				
				Integer[] sortedArray = mergesort.mergeSort(array);
				
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
				
				System.out.println("Inversion count: " + mergesort.getInversionCount());
				
				
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
