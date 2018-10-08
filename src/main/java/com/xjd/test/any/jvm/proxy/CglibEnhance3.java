package com.xjd.test.any.jvm.proxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 这样还是可以的
 * @author elvis.xu
 * @since 2018-09-12 22:39
 */
public class CglibEnhance3 {
	public static void main(String[] args) {
		List proxy1 = createProxy(new ArrayList<>(), List.class);
		List proxy2 = createProxy(proxy1, List.class);
		proxy2.size();
	}

	public static List createProxy(Object obj, Class clazz) {
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(clazz);
		enhancer.setInterfaces(new Class[]{List.class});
		enhancer.setCallback(new MyMethodInterceptor(obj));

		List list = (List) enhancer.create();
		return list;
	}

	public static class MyMethodInterceptor implements MethodInterceptor {
		Object target;

		public MyMethodInterceptor(Object target) {
			this.target = target;
		}

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//			System.out.println("obj=" + obj);
			System.out.println("method=" + method);
			System.out.println("args=" + Arrays.toString(args));
			System.out.println("proxy=" + proxy);
			return proxy.invoke(target, args);
		}
	}
}
