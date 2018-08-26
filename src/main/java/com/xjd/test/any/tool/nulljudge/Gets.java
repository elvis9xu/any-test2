package com.xjd.test.any.tool.nulljudge;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author elvis.xu
 * @since 2018-08-26 13:13
 */
public abstract class Gets {
	private static final Logger log = LoggerFactory.getLogger(Gets.class);

	public static <T> T wrap(T source) {
		if (source == null) {
			throw new IllegalArgumentException("The input parameter cannot be null or use wrap(T source, Class<T> clazz) instead");
		}
		return wrap(source, (Class<T>) source.getClass());
	}

	public static <T> T wrap(T source, Class<T> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("The class parameter cannot be null");
		}
		if (Modifier.isFinal(clazz.getModifiers())) {
			log.info("cannot proxy final class {}", clazz);
			return source;
		}

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setInterfaces(new Class[]{Wrap.class});
		enhancer.setCallback(new GetInterceptor<T>(source, clazz));
		T wrap = createWrap(enhancer, clazz);

		return wrap;
	}

	protected static <T> T createWrap(Enhancer enhancer, Class<T> clazz) {
		try {
			return (T) enhancer.create();
		} catch (Exception e) {
			for (Constructor<?> constructor : clazz.getConstructors()) {
				Class<?>[] parameterTypes = constructor.getParameterTypes();
				Object[] args = new Object[parameterTypes.length];
				for (int i = 0; i < parameterTypes.length; i++) {
					args[i] = casualValueForType(parameterTypes[i]);
				}
				try {
					return (T) enhancer.create(parameterTypes, args);
				} catch (Exception t) {
					log.debug("try create instance of class '{}' using constructor({}) failed.", clazz, Arrays.toString(args), t);
				}
			}
		}
		throw new IllegalArgumentException("no constructor can be use for class '" + clazz + "'");
	}

	protected static Object casualValueForType(Class clazz) {
		if (!clazz.isPrimitive()) {
			return null;
		}
		if (char.class.equals(clazz)) {
			return ' ';
		}
		if (boolean.class.equals(clazz)) {
			return false;
		}
		// other primitives are numbers
		return Byte.valueOf((byte) 0);
	}

	protected static String cacheKey(Object source, Class clazz) {
		return clazz + ":" + source;
	}

	public static boolean isNull(Object object) {
		if (object instanceof Wrap) return ((Wrap) object)._source() == null;
		return object == null;
	}

	public static <T> T get(T object) {
		return get(object, null);
	}

	public static <T> T get(T object, T defaultValue) {
		T source = (object instanceof Wrap) ? ((Wrap<T>) object)._source() : object;
		return source != null ? source : defaultValue;
	}

	protected static interface Wrap<T> {
		T _source();
		T _class();
	}

	protected static class GetInterceptor<T> implements MethodInterceptor {
		protected T source;
		protected Class<T> clazz;
		protected Map<Method, Object> cache = new HashMap<>();

		public GetInterceptor(T source, Class<T> clazz) {
			this.source = source;
			this.clazz = clazz;
		}

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			// Wrap
			if (method.getName().equals("_source")) {
				return source;
			}
			if (method.getName().equals("_class")) {
				return clazz;
			}
			// Object
			if (method.getName().equals("getClass")) {
				return clazz;
			}
			if (method.getName().equals("equals")) {
				return source == null ? source == args[0] : source.equals(args[0]);
			}
			// return primitives
			if (method.getReturnType().isPrimitive()) {
				return proxy.invoke(source, args);
			}
			// return final type
			if (Modifier.isFinal(method.getReturnType().getModifiers())) {
				return source == null ? null : proxy.invoke(source, args);
			}
			// return non final type
			Object cachedRt = cache.get(method);
			if (cachedRt != null) return cachedRt;

			Object rt = source == null ? null : proxy.invoke(source, args);
			Object wrapRt = Gets.wrap(rt, (Class<Object>)(rt == null ? method.getReturnType() : rt.getClass()));
			if (wrapRt instanceof Wrap) { // 只缓存代理对象
				cache.put(method, wrapRt);
			}
			return wrapRt;
		}

	}

	protected static class ObjectWeakReference extends WeakReference {
		protected String key;
		public ObjectWeakReference(Object referent, ReferenceQueue q, String key) {
			super(referent, q);
			this.key = key;
		}
	}



}
