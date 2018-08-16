package com.mapmerge;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;


public class MapMergeUtil {
	/**
	 * Merge 2 map as per behaviour
	 * 
	 * @param firstMap
	 * @param secondMap
	 * @param behaviour
	 * @return
	 */
	public static <K, V> Map<K, V> merge(Map<K, V> firstMap,  Map<K, V> secondMap, BiFunction<V,V,V> behaviour) {   
		Map<K,V> smallMap, bigMap = new HashMap<>();
		if(firstMap.size() >= secondMap.size()){
			bigMap.putAll(firstMap);
			smallMap = secondMap;
		} else {
			bigMap.putAll(secondMap);
			smallMap = firstMap;
		}
		
		//Merge smallMap to BigMap
		smallMap.forEach((K,V) -> bigMap.merge(K, V, behaviour));
		return bigMap;
	}
	
	/**
	 * Merge list of maps as per behaviour through stream 
	 * 
	 * @param mapList
	 * @param behaviour
	 * @return
	 */
	/*public static <K, V> Map<K, V> merge(List<Map<K, V>> mapList, BiFunction<V,V,V> behaviour) {
		return mapList.stream().reduce(new HashMap<>(), (x, y) -> merge(x, y, behaviour));
	}*/
	
	/**
	 * Merge list of maps as per behaviour through parallelStream
	 *  
	 * @param mapList
	 * @param behaviour
	 * @return
	 */
	public static <K, V> Map<K, V> merge(List<Map<K, V>> mapList, BiFunction<V,V,V> behaviour) {
		return mapList.parallelStream().reduce(new HashMap<>(), (x, y) -> merge(x, y, behaviour));
	}
}
