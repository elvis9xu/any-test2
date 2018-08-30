package com.xjd.test.any.perfermance;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * =======
 * cost: 15425453ns, avg: 15
 * cost: 5210299ns, avg: 5
 * =======
 * cost: 20098121ns, avg: 20
 * cost: 90370ns, avg: 0
 * =======
 * cost: 13538555ns, avg: 13
 * cost: 105ns, avg: 0
 * =======
 * cost: 14248001ns, avg: 14
 * cost: 69ns, avg: 0
 * =======
 * cost: 12673623ns, avg: 12
 * cost: 96ns, avg: 0
 * @author elvis.xu
 * @since 2018-08-29 16:55
 */
public class AtomicIntegerPerf {
	public static void main(String[] args) {
		for (int j = 0; j < 5; j++) {
			System.out.println("=======");
			{
				AtomicInteger atomicInteger = new AtomicInteger(0);
				long start = System.nanoTime();
				for (int i = 0; i < 1000000; i++) {
					atomicInteger.incrementAndGet();
				}
				long cost = System.nanoTime() - start;
				System.out.println("cost: " + cost + "ns, avg: " + (cost / 1000000));
			}
			{
				int atomicInteger = 0;
				long start = System.nanoTime();
				for (int i = 0; i < 1000000; i++) {
					atomicInteger ++;
				}
				long cost = System.nanoTime() - start;
				System.out.println("cost: " + cost + "ns, avg: " + (cost / 1000000));
			}
		}

	}
}
