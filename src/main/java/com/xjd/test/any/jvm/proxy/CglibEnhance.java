package com.xjd.test.any.jvm.proxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 当返回类型为primitive时, 代理返回null, 结果是自动默认值
 * @author elvis.xu
 * @since 2018-09-12 22:39
 */
public class CglibEnhance {
	public static void main(String[] args) {
		A proxy = createProxy();
		System.err.println(proxy.getInt());
		System.err.println(proxy.getBoolean());
		System.err.println(proxy.getChar());
	}

	public static A createProxy() {
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(A.class);
		enhancer.setInterfaces(new Class[]{List.class});
		enhancer.setCallback(new MyMethodInterceptor());

		A list = (A) enhancer.create();
		return list;
	}

	public static class MyMethodInterceptor implements MethodInterceptor {
		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			if ("toString".equals(method.getName())) {
				return null;
			}
			System.out.println("obj=" + obj);
			System.out.println("method=" + method);
			System.out.println("args=" + Arrays.toString(args));
			System.out.println("proxy=" + proxy);
			return null;
		}
	}

	public static class A {
		int getInt() {return 1;}
		boolean getBoolean() {return true;}
		char getChar() {return 'A';}
	}
}
