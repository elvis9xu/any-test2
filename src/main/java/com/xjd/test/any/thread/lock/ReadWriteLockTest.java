package com.xjd.test.any.thread.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author elvis.xu
 * @since 2018-09-14 14:05
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {
		ReadWriteLock lock = new ReentrantReadWriteLock();


//		lock.readLock().lock();
//		lock.writeLock().lock();
//		System.out.println("OK");
//		lock.writeLock().unlock();
//		lock.readLock().unlock();

		lock.writeLock().lock();
		lock.readLock().lock();
		System.out.println("OK");
		lock.readLock().unlock();
		lock.writeLock().unlock();

	}
}
