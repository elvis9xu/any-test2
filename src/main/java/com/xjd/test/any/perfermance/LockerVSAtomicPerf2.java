package com.xjd.test.any.perfermance;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ==========
 * cost: 2475587775ms, avg: 24
 * cost: 2436409794ms, avg: 24
 * ==========
 * cost: 2150966943ms, avg: 21
 * cost: 2501657980ms, avg: 25
 * ==========
 * cost: 2182052952ms, avg: 21
 * cost: 2490803337ms, avg: 24
 * ==========
 * cost: 2205167174ms, avg: 22
 * cost: 2462438031ms, avg: 24
 * ==========
 * cost: 2202267240ms, avg: 22
 * cost: 2521769560ms, avg: 25
 * @author elvis.xu
 * @since 2018-08-30 10:15
 */
public class LockerVSAtomicPerf2 {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		AtomicInteger atomicInteger2 = new AtomicInteger(0);
		AtomicInteger atomicInteger3 = new AtomicInteger(0);
		int a = 0, a2=0, a3=0;
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
				}
				long cost = System.nanoTime() - start;
				System.out.println("cost: " + cost + "ms, avg: " + (cost / times));
			}
		}
	}
}
