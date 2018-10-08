package com.xjd.test.any.performance;

import java.util.LinkedList;
import java.util.List;

/**
 * @author elvis.xu
 * @since 2018-09-09 10:09
 */
public class ClassVsPerf {
	public static void main(String[] args) {
//		instanceOf();
		classAssign();
	}

	/**
	 * ======instanceof======
	 * 10000000/24 ms - 416666 /ms
	 * 10000000/8 ms - 1250000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 * 10000000/0 ms - 10000000 /ms
	 */
	public static void instanceOf() {
		LinkedList list = new LinkedList();
		int times = 10000000;
		System.out.println("======instanceof======");
		for (int j = 0; j < 10; j++) {
			{
				long start = System.currentTimeMillis();
				for (int i = 0; i < times; i++) {
					if (list instanceof LinkedList) {
					}
				}
				long cost = System.currentTimeMillis() - start;
				print(times, cost);
			}{
				long start = System.currentTimeMillis();
				for (int i = 0; i < times; i++) {
					if (list instanceof List) {
					}
				}
				long cost = System.currentTimeMillis() - start;
				print(times, cost);
			}{
				long start = System.currentTimeMillis();
				for (int i = 0; i < times; i++) {
					if (list instanceof Object) {
					}
				}
				long cost = System.currentTimeMillis() - start;
				print(times, cost);
			}
		}
	}
	public static void classAssign() {
		LinkedList list = new LinkedList();
		int times = 10000000;
		System.out.println("======isAssignableFrom======");
		for (int j = 0; j < 10; j++) {
			{
				long start = System.currentTimeMillis();
				for (int i = 0; i < times; i++) {
					if (LinkedList.class.isAssignableFrom(LinkedList.class)) {
					}
				}
				long cost = System.currentTimeMillis() - start;
				print(times, cost);
			}{
				long start = System.currentTimeMillis();
				for (int i = 0; i < times; i++) {
					if (List.class.isAssignableFrom(LinkedList.class)) {
					}
				}
				long cost = System.currentTimeMillis() - start;
				print(times, cost);
			}{
				long start = System.currentTimeMillis();
				for (int i = 0; i < times; i++) {
					if (Object.class.isAssignableFrom(LinkedList.class)) {
					}
				}
				long cost = System.currentTimeMillis() - start;
				print(times, cost);
			}
		}
	}

	public static void print(int times, long cost) {
		System.out.println(times + "/" + cost + " ms - " + (times / (cost == 0 ? 1: cost)) + " /ms");
	}
}
