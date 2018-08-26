package com.xjd.test.any;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author elvis.xu
 * @since 2018-08-26 16:26
 */
public class AnyTest {
	public static void main(String[] args) throws InterruptedException {
		String s = new String("HELLO");
		ReferenceQueue<String> queue = new ReferenceQueue<>();
		WeakReference<String> ref = new WeakReference<>(s, queue);
		for (int i = 0; i < 100; i++) {
			Reference<? extends String> poll = queue.poll();
			if (poll != null) {
				System.out.println(poll == ref);
			}
			System.gc();
			Thread.sleep(1000L);
			if (i == 3) {
				s = null;
			}
//			if (i == 6) {
//				ref = null;
//			}
		}

	}
}
