package com.mapmerge;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MapMergeUtilTest {
	Map<String, Integer> intMap1 = new HashMap<>();
	Map<String, Integer> intMap2 = new HashMap<>();
	Map<String, Integer> intAddMap = new HashMap<>();
	Map<String, Integer> intMultiplyMap = new HashMap<>();
	
	Map<String, Double> doubleMap1 = new HashMap<>();
	Map<String, Double> doubleMap2 = new HashMap<>();
	Map<String, Double> doubleAddMap = new HashMap<>();
	Map<String, Double> doubleMultiplyMap = new HashMap<>();
	
	Map<String, String> stringMap1 = new HashMap<>();
	Map<String, String> stringMap2 = new HashMap<>();
	Map<String, String> stringConcatMap = new HashMap<>();
	
	List<Map<String, Integer>> mapList = Arrays.asList(intMap1, intMap2);
	
	@Before
	public void setup() {
		// Integer Map Preparation
		intMap1.put("key1", 20);
		intMap1.put("key2", 30);
		intMap2.put("key3", 40);
		intMap2.put("key1", 50);
		
		intAddMap.put("key1", 70);
		intAddMap.put("key2", 30);
		intAddMap.put("key3", 40);
		
		intMultiplyMap.put("key1", 1000);
		intMultiplyMap.put("key2", 30);
		intMultiplyMap.put("key3", 40);
		
		//Double Map Preparation
		doubleMap1.put("key1", 20d);
		doubleMap1.put("key2", 30d);
		doubleMap2.put("key3", 40d);
		doubleMap2.put("key1", 50d);
		
		doubleAddMap.put("key1", 70d);
		doubleAddMap.put("key2", 30d);
		doubleAddMap.put("key3", 40d);
		
		doubleMultiplyMap.put("key1", 1000d);
		doubleMultiplyMap.put("key2", 30d);
		doubleMultiplyMap.put("key3", 40d);
		
		// String Map Preparation
		stringMap1.put("key1", "A");
		stringMap1.put("key2", "B");
		stringMap2.put("key3", "C");
		stringMap2.put("key1", "D");
		
		stringConcatMap.put("key1", "AD");
		stringConcatMap.put("key2", "B");
		stringConcatMap.put("key3", "C");
		
		/*//Integer Map List
		mapList.add(intMap1);
		mapList.add(intMap2);*/
	}

	@Test
	public void testIntegerAddBehaviour() {
		Assert.assertEquals(intAddMap, MapMergeUtil.merge(intMap1, intMap2, Behaviours.ADD_INTEGER));
	}
	
	@Test
	public void testIntegerMultiplyBehaviour() {
		Assert.assertEquals(intMultiplyMap, MapMergeUtil.merge(intMap1, intMap2, Behaviours.MULTIPLY_INTEGER));
	}
	
	@Test
	public void testDoubleAddBehaviour() {
		Assert.assertEquals(doubleAddMap, MapMergeUtil.merge(doubleMap1, doubleMap2, Behaviours.ADD_DOUBLE));
	}
	
	@Test
	public void testDoubleMultiplyBehaviour() {
		Assert.assertEquals(doubleMultiplyMap, MapMergeUtil.merge(doubleMap1, doubleMap2, Behaviours.MULTIPLY_DOUBLE));
	}
	
	@Test
	public void testStringConcatBehaviour() {
		Assert.assertEquals(stringConcatMap, MapMergeUtil.merge(stringMap1, stringMap2, Behaviours.CONCAT));
	}
	
	@Test
	public void testIntegerMergeListAddBehaviour() {
		Assert.assertEquals(intAddMap, MapMergeUtil.merge(mapList, Behaviours.ADD_INTEGER));
	}
	
	@Test
	public void testIntegerMergeListMultiplyBehaviour() {
		Assert.assertEquals(intMultiplyMap, MapMergeUtil.merge(mapList, Behaviours.MULTIPLY_INTEGER));
	}
}
