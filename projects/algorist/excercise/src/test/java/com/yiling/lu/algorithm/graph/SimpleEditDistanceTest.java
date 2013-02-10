package com.yiling.lu.algorithm.graph;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yiling.lu.algorithm.util.AssortedUtils;

public class SimpleEditDistanceTest {
	HashSet<String> dict = new HashSet<String>();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		
		String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "free", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
		setupDictionary(words);		
		
		String[] more = {"lanp", "damp", "limp", "lime", "like", "pamp", "xamp", 
				"loop", "damm", "lamm", "lbmm", "limm"};
		setupDictionary(more);
	}
	
	public HashSet<String> setupDictionary(String[] words) {
		for (String word : words) {
			dict.add(word);
		}
		return dict;
	}	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOneEditWorlds() {
		char[] array = {'a', 'b'};
		
		List<String> actual = SimpleEditDistance.getOneEditWorlds(array);
		
		assertEquals(5, actual.size());
		
		AssortedUtils.printCollection(actual);
	}
	
	@Test
	public void testTransform(){
		String s1 = "tree";
		String s2 = "flat";
		
		List<String> path = SimpleEditDistance.transform(s1, s2, dict);
		
		AssortedUtils.printCollection(path);
	}
	
	@Test
	public void testTransform2(){
		String s1 = "limp";
		String s2 = "like";
		
		List<String> path = SimpleEditDistance.transform(s1, s2, dict);
		
		AssortedUtils.printCollection(path);
	}	
	
	@Test
	public void testTransform3(){
		String s1 = "damp";
		String s2 = "like";
		
		List<String> path = SimpleEditDistance.transform(s1, s2, dict);
		
		AssortedUtils.printCollection(path);
	}	

}
