package com.xjd.test.any.jvm.clazz;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author elvis.xu
 * @since 2018-09-13 00:35
 */
public class GenericClazz {
	public static void main(String[] args) {
		Type type = B.class.getGenericSuperclass();
		System.out.println(type.getClass());
		ParameterizedType ptype = (ParameterizedType) type;
		System.out.println(Arrays.toString(ptype.getActualTypeArguments()));
		System.out.println(ptype.getOwnerType());
		System.out.println(ptype.getRawType());
	}

	public static class A<T> {

	}

	public static class B extends A<String> {

	}
}
