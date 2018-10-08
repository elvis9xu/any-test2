package com.xjd.test.any.performance;

/**
 * @author elvis.xu
 * @since 2018-10-08 13:44
 */
public class SetVsGetPerf {
	public static void main(String[] args) {
		int i = 0, times = 100000000;

		{
			long start = System.currentTimeMillis();
			for (int j = 0; j < times; j++) {
				i = 0;
			}
			long cost = System.currentTimeMillis() - start;
			System.out.println(cost);
		}
		{
			long start = System.currentTimeMillis();
			for (int j = 0; j < times; j++) {
				if (i == 0) {

				}
			}
			long cost = System.currentTimeMillis() - start;
			System.out.println(cost);
		}
		{
			long start = System.currentTimeMillis();
			for (int j = 0; j < times; j++) {
				i = 0;
			}
			long cost = System.currentTimeMillis() - start;
			System.out.println(cost);
		}
		{
			long start = System.currentTimeMillis();
			for (int j = 0; j < times; j++) {
				if (i == 0) {

				}
			}
			long cost = System.currentTimeMillis() - start;
			System.out.println(cost);
		}
	}
}
