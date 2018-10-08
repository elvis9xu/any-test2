package com.xjd.test.any.serialize.protobuf.protostuff;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @author elvis.xu
 * @since 2018-09-19 17:13
 */
public class ProtostuffUtil {

	public static byte[] serialize(Object bean) {
		RuntimeSchema schema = RuntimeSchema.createFrom(bean.getClass());
		return ProtostuffIOUtil.toByteArray(bean, schema, LinkedBuffer.allocate(512));
	}

	public static <T> T deserialize(byte[] bytes, Class<T> clazz) {
		RuntimeSchema<T> schema = RuntimeSchema.createFrom(clazz);
		T t = schema.newMessage();
		ProtostuffIOUtil.mergeFrom(bytes, t, schema);
		return t;
	}
}
