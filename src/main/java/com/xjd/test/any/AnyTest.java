package com.xjd.test.any;

import java.util.LinkedHashMap;

/**
 * @author elvis.xu
 * @since 2018-08-26 16:26
 */
public class AnyTest {

	public static void main(String[] args) throws InterruptedException, NoSuchMethodException {
//		{
//			System.out.println(Integer.toBinaryString(99999));
//			System.out.println(Integer.toHexString(99999));
//			//		Integer integer = Integer.valueOf("\\x12\\x0f");
//			int integer = Integer.valueOf("120f", 16);
//			System.out.println(Integer.toBinaryString(integer));
//			System.out.println(Integer.toHexString(integer));
//			System.out.println((char) integer);
//		}
//		{
//			int integer = Integer.valueOf("12", 16);
//			System.out.println(Integer.toBinaryString(integer));
//			System.out.println(Integer.toHexString(integer));
//			System.out.println((char) integer);
//		}
//		{
//			int integer = Integer.valueOf("0f", 16);
//			System.out.println(Integer.toBinaryString(integer));
//			System.out.println(Integer.toHexString(integer));
//			System.out.println((char) integer);
//		}
//		{
//			int integer = Integer.valueOf("120f", 16);
//			System.out.println(Integer.toBinaryString(integer));
//			System.out.println(Integer.toHexString(integer));
//			System.out.println((char) integer);
//		}
//		{
//			int integer = Integer.valueOf((int)'@');
//			System.out.println(Integer.toBinaryString(integer));
//			System.out.println(Integer.toHexString(integer));
//			System.out.println((char) integer);
//		}
//		{
//			System.out.println("=======");
//			int integer = Integer.valueOf((int)'3');
//			System.out.println(integer);
//			System.out.println(Integer.toBinaryString(integer));
//			System.out.println(Integer.toHexString(integer));
//			System.out.println((char) integer);
//			byte b = Byte.valueOf(Integer.toBinaryString(integer), 2);
//			System.out.println(b);
//		}
//		{
//			System.out.println("=======");
//			int integer = Integer.valueOf(3);
//			System.out.println(integer);
//			System.out.println(Integer.toBinaryString(integer));
//			System.out.println(Integer.toHexString(integer));
//			System.out.println((char) integer);
//			byte b = Byte.valueOf((byte)3);
//			System.out.println(b);
//		}

//		{
//			String s = "中国";
//			byte[] bytes = s.getBytes(Charset.forName("utf8"));
//
//			System.out.println(bytes.length);
//			for (byte aByte : bytes) {
//				System.out.println(Integer.toHexString((int) aByte & 0xff));
//			}
//		}
//		{
//			String s = "Spark 和 Hadoop 你好";
//			byte[] bytes = s.getBytes(Charset.forName("utf8"));
//			StringBuilder sb = new StringBuilder();
//			System.out.println(bytes.length);
//			for (byte aByte : bytes) {
//				int i = (int) aByte;
//				if (i > 0) {
//					System.out.println((char) i);
//					sb.append((char) i);
//				} else {
//					System.out.println(Integer.toHexString(i & 0xff));
//					sb.append("\\x");
//					sb.append(Integer.toHexString(i & 0xff));
//				}
//			}
//			System.out.println(sb.toString());
//		}

//		String c = "\n\r\b\"";
//		String s = StringEscapeUtils.escapeJson(c);
//		System.out.println(s);
//		s = StringEscapeUtils.unescapeJava(s);
//		System.out.println(s);

		LinkedHashMap map = new LinkedHashMap();
		for (int i = 10; i > 0; i--) {
			map.put(i, i);
		}
		for (Object o : map.keySet()) {
			System.out.println(o);
		}
	}


	public static class A {

	}



}
