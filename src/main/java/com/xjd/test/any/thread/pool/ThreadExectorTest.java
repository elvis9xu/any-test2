package com.xjd.test.any.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author elvis.xu
 * @since 2018-09-10 18:45
 */
public class ThreadExectorTest {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 6, TimeUnit.SECONDS, new LinkedBlockingQueue<>(7));
		executor.allowCoreThreadTimeOut(true);

		for (int i = 0; i < 11; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		for (int i = 0; i < 100; i++) {
			System.out.println("========");
			System.out.println(executor.getPoolSize());
			System.out.println(executor.getActiveCount());
			System.out.println(executor.getCorePoolSize());
			System.out.println(executor.getMaximumPoolSize());
			System.out.println(executor);
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
