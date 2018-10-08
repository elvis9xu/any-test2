package com.xjd.test.any.performance;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ==========
 * cost: 2874999837ms, avg: 28
 * cost: 695127721ms, avg: 6
 * ==========
 * cost: 2061908102ms, avg: 20
 * cost: 663692128ms, avg: 6
 * ==========
 * cost: 2192461845ms, avg: 21
 * cost: 685268636ms, avg: 6
 * ==========
 * cost: 2114096891ms, avg: 21
 * cost: 671669102ms, avg: 6
 * ==========
 * cost: 2186316833ms, avg: 21
 * cost: 673376308ms, avg: 6
 * @author elvis.xu
 * @since 2018-08-30 10:15
 */
public class LockerVSAtomicPerf {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		int a = 0;
		int times = 100000000;
		for (int j = 0; j < 5; j++) {
			System.out.println("==========");

			int work = 1;
			Lock lock = new ReentrantLock();
			{
				long start = System.nanoTime();
				for (int i = 0; i < times; i++) {
					lock.lock();
					a++;
					lock.unlock();
				}
				long cost = System.nanoTime() - start;
				System.out.println("cost: " + cost + "ms, avg: " + (cost / times));
			}
			{
				long start = System.nanoTime();
				for (int i = 0; i < times; i++) {
					atomicInteger.incrementAndGet();
				}
				long cost = System.nanoTime() - start;
				System.out.println("cost: " + cost + "ms, avg: " + (cost / times));
			}
		}
	}
}
