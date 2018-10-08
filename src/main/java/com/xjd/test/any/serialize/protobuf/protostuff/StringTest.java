package com.xjd.test.any.serialize.protobuf.protostuff;

import java.util.Arrays;

/**
 * @author elvis.xu
 * @since 2018-09-19 17:28
 */
public class StringTest {
	public static void main(String[] args) {
		String abc = "abc";
		String abc2 = "abc";

		{
			byte[] serialize = ProtostuffUtil.serialize(abc);
			byte[] serialize1 = ProtostuffUtil.serialize(abc2);
			System.out.println(Arrays.equals(serialize, serialize1));
		}
		{
			byte[] serialize = ProtostuffUtil.serialize(abc);
			abc.hashCode(); // 出问题了
			byte[] serialize1 = ProtostuffUtil.serialize(abc2);
			System.out.println(Arrays.equals(serialize, serialize1));
		}
	}
}
