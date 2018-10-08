package com.xjd.test.any.serialize.protobuf.protostuff;

import java.io.*;

/**
 * @author elvis.xu
 * @since 2018-09-19 17:30
 */
public class StringTest2 {
	public String abc;

	public static void main(String[] args) {
		String abc = "abc";

		save(ProtostuffUtil.serialize(abc));
		abc.hashCode();
		String deserialize = ProtostuffUtil.deserialize(read(), String.class);
		System.out.println(deserialize);
	}

	public static void save(byte[] bytes) {
		try (OutputStream out = new FileOutputStream("/data/tmp/tmp01.data")) {
			out.write(bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] read() {
		try (InputStream in = new FileInputStream("/data/tmp/tmp01.data")) {
			ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
			int i = -1;
			while ((i = in.read()) != -1) {
				out.write(i);
			}
			return out.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
