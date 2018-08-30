package com.xjd.test.any.perfermance;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ==========
 * cost: 31544629ms, avg: 31
 * cost: 27371038ms, avg: 27
 * ==========
 * cost: 20240455ms, avg: 20
 * cost: 32459426ms, avg: 32
 * ==========
 * cost: 23361437ms, avg: 23
 * cost: 27076167ms, avg: 27
 * ==========
 * cost: 21020442ms, avg: 21
 * cost: 33171694ms, avg: 33
 * ==========
 * cost: 20757138ms, avg: 20
 * cost: 25072818ms, avg: 25
 * @author elvis.xu
 * @since 2018-08-30 09:44
 */
public class LockerSynchronizedPerf {
	public static void main(String[] args) {
		int times = 10000000;
		for (int j = 0; j < 5; j++) {
			System.out.println("==========");

			int work = 1;
			Lock lock = new ReentrantLock();
			{
				long start = System.nanoTime();
				for (int i = 0; i < times; i++) {
					lock.lock();
					work = 1;
					lock.unlock();
				}
				long cost = System.nanoTime() - start;
				System.out.println("cost: " + cost + "ms, avg: " + (cost / times));
			}
			{
				long start = System.nanoTime();
				for (int i = 0; i < times; i++) {
					synchronized (lock) {
						// do-nothing
						work = 1;
					}
				}
				long cost = System.nanoTime() - start;
				System.out.println("cost: " + cost + "ms, avg: " + (cost / times));
			}
		}
	}
}
