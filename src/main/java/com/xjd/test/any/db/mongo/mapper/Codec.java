package com.xjd.test.any.db.mongo.mapper;

import java.util.List;

/**
 * @author elvis.xu
 * @since 2018-09-06 14:03
 */
public interface Codec<T> {
	Object encode(T value);
	T decode(Object doc);

	public static class ListCodec<T> implements Codec<List<T>> {
		@Override
		public Object encode(List<T> value) {
			return null;
		}

		@Override
		public List<T> decode(Object doc) {
			return null;
		}
	}
}
