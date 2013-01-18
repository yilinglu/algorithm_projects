package com.yiling.lu.algorithm.datastructure.hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 3-29. [6] Give an algorithm for finding an ordered word pair (e.g., “New
 * York”) occurring with the greatest frequency in a given webpage. Which data
 * structures would you use? Optimize both time and space.
 * 
 * @author yiling
 * 
 */
public class WordFrequencyCounter {

	private Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();

	private Integer maxcount = 0;
	private String maxphrase;

	private static final int arraySize = 1000;

	private String lastWord = null;

	public static void main(String[] args) {
		WordFrequencyCounter frequencyCounter = new WordFrequencyCounter();
		frequencyCounter.processFile(args[0]);
	}

	public void processFile(String filePath) {
		Scanner scanner = null;
		try {
			FileReader fileReader = new FileReader(new File(filePath));
			scanner = new Scanner(fileReader);
			scanner.useDelimiter("[\\t\\s\\$]+");

			ArrayList<String> list = new ArrayList<String>();
			int count = 0;

			while (scanner.hasNext()) {
				String str = scanner.next();
				System.out.println(str);
				list.add(str.toLowerCase());
				count++;

				if (count == arraySize) {
					processList(list);
				}
			}

			if (!list.isEmpty()) {
				processList(list);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	

	private void processList(List<String> list) {
		String[] input = new String[1];
		readInput(list.toArray(input));
		list = new ArrayList<String>();
	}

	public void readInput(String[] input) {
		int len = input.length;

		if (lastWord != null && len > 0) {
			addToTable(lastWord, input[len - 1]);
		}

		for (int i = 0; i < len - 1; i++) {
//			System.out.print("\"");
//			System.out.print(input[i]);
//			System.out.print("\"");
			
			addToTable(input[i], input[i + 1]);
		}
		lastWord = input[len - 1];
	}

	private void addToTable(String a, String b) {
		String key = a.concat(" ").concat(b);

		Integer count = hashtable.get(key);
		if (count != null) {
			hashtable.put(key, ++count);
		}else{
			hashtable.put(key, 1);
		}
		if(count != null && count > maxcount){
			maxcount = count;
			maxphrase = key;
		}
		
	}

	public int getMaxCount() {
		return maxcount;
	}

	public String getMaxword() {
		return maxphrase;
	}
}
