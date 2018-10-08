package com.xjd.test.any.jvm.proxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author elvis.xu
 * @since 2018-09-12 22:39
 */
public class CglibEnhance4 {
	public static void main(String[] args) {
		List proxy = createProxy();
		boolean f = proxy.isEmpty();
		if (f) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		System.out.println(proxy.size());
	}

	public static List createProxy() {
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(Integer.class);
		enhancer.setInterfaces(new Class[]{List.class});
		enhancer.setCallback(new MyMethodInterceptor());

		List list = (List) enhancer.create();
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
}
