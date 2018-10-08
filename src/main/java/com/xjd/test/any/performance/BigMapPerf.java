package com.xjd.test.any.performance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author elvis.xu
 * @since 2018-10-08 15:34
 */
public class BigMapPerf {
	public static void main(String[] args) {
		int size = 10000000;
		map(size);
		concurrentMap(size);
		map(size);
		concurrentMap(size);
	}

	public static void map(int size) {
		Map map = new HashMap(size);
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			map.put(i, i);
		}
		long cost = System.currentTimeMillis() - start;
		System.out.println(cost);
	}

	public static void concurrentMap(int size) {
		Map map = new ConcurrentHashMap(size);
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			map.put(i, i);
		}
		long cost = System.currentTimeMillis() - start;
		System.out.println(cost);
	}
}
