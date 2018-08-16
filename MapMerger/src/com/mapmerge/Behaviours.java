package com.mapmerge;


import java.util.function.BiFunction;


public interface Behaviours {
	public static final BiFunction<String, String, String> CONCAT = (s1,s2) -> s1.concat(s2); 
	public static final BiFunction<Integer, Integer, Integer> ADD_INTEGER = (s1,s2) -> s1+s2;
	public static final BiFunction<Integer, Integer, Integer> MULTIPLY_INTEGER = (s1,s2) -> s1*s2;
	public static final BiFunction<Double, Double, Double> ADD_DOUBLE = (s1,s2) -> s1+s2;
	public static final BiFunction<Double, Double, Double> MULTIPLY_DOUBLE = (s1,s2) -> s1*s2;
}
