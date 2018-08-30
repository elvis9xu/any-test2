package com.xjd.test.any.perfermance;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ==========
 * cost: 2376823705ms, avg: 23
 * cost: 3782235706ms, avg: 37
 * ==========
 * cost: 2249586738ms, avg: 22
 * cost: 3750178113ms, avg: 37
 * ==========
 * cost: 2249278521ms, avg: 22
 * cost: 3849433044ms, avg: 38
 * ==========
 * cost: 2296149063ms, avg: 22
 * cost: 3793871680ms, avg: 37
 * ==========
 * cost: 2268164222ms, avg: 22
 * cost: 3760786235ms, avg: 37
 * @author elvis.xu
 * @since 2018-08-30 10:15
 */
public class LockerVSAtomicPerf3 {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		AtomicInteger atomicInteger2 = new AtomicInteger(0);
		AtomicInteger atomicInteger3 = new AtomicInteger(0);
		AtomicInteger atomicInteger4 = new AtomicInteger(0);
		AtomicInteger atomicInteger5 = new AtomicInteger(0);
		int a = 0, a2=0, a3=0, a4 = 0, a5 = 0;
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
					a2++;
					a3++;
					a4++;
					a5++;
					lock.unlock();
				}
				long cost = System.nanoTime() - start;
				System.out.println("cost: " + cost + "ms, avg: " + (cost / times));
			}
			{
				long start = System.nanoTime();
				for (int i = 0; i < times; i++) {
					atomicInteger.incrementAndGet();
					atomicInteger2.incrementAndGet();
					atomicInteger3.incrementAndGet();
					atomicInteger4.incrementAndGet();
					atomicInteger5.incrementAndGet();
				}
				long cost = System.nanoTime() - start;
				System.out.println("cost: " + cost + "ms, avg: " + (cost / times));
			}
		}
	}
}
