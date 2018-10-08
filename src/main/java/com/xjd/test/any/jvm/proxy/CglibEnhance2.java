package com.xjd.test.any.jvm.proxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 被增强的类Class不能再进行增强
 * getClass不能被代理: class $java.util.List$$EnhancerByCGLIB$$1964e348
 * @author elvis.xu
 * @since 2018-09-12 22:39
 */
public class CglibEnhance2 {
	public static void main(String[] args) {
		List proxy1 = createProxy(new Object());
		System.out.println(proxy1.size());
		System.out.println(proxy1.getClass());
		System.out.println(proxy1.getClass().getName());
		System.out.println(Enhancer.isEnhanced(proxy1.getClass()));
		List proxy2 = createProxy(proxy1);
	}

	public static List createProxy(Object obj) {
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(obj.getClass());
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
			if ("getClass".equals(method.getName())) {
				return Object.class;
			}
			System.out.println("obj=" + obj);
			System.out.println("method=" + method);
			System.out.println("args=" + Arrays.toString(args));
			System.out.println("proxy=" + proxy);
			return null;
		}
	}
}
