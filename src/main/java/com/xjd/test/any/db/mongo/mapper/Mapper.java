package com.xjd.test.any.db.mongo.mapper;

import java.util.function.Consumer;

import org.bson.Document;

/**
 * @author elvis.xu
 * @since 2018-09-06 11:02
 */
public interface Mapper<T> {

	T decode(Document document);

	void decode(Decoder<T> decoder);

	Document encode(T t);

	Document encode(T t, boolean nonNull);

	Document encode(T t, IncludeProps<T> includeProps, boolean nonNull);

	Document encode(T t, boolean nonNull, ExcludeProps<T> excludeProps);

	Document encode(Encoder<T> encoder);

	Document encode(Document root, Encoder<T> encoder);

	Property prop(Consumer<T> prop);

	PropertySetting propSetting();

	T getter();
	<E> E wrap(E e);

	DocumentWrapper2<T> wrap2(Document d);

	public static interface Property {

		String key(); // 使用设置
		String key(int tail); // +1 -1
		String[] keyChain();
		String name();
		String name(int tail);
		String[] nameChain();

		String toString();
	}

	public static interface PropertySetting {
		PropertySetting setTail(int tail);
		PropertySetting resetTail();
	}

	public static interface CludeProps<T> {
		void clude(T getter, Clude clude);
	}

	public static interface Clude {
		Clude add(Object ob);
	}

	public static interface IncludeProps<T> extends CludeProps<T> {

	}
	public static interface ExcludeProps<T> extends CludeProps<T> {

	}

	public static interface Encoder<T> {
		void encode(T getter, DocumentAppender document, Mapper<T> mapper);
	}

	public static interface Decoder<T> {
		void encode(T getter, DocumentGetter dg, Mapper<T> mapper);
	}

	public static interface DocumentAppender {
		DocumentAppender append(Object key, Object value);

		DocumentAppender newWrapper();
	}

	public static interface DocumentGetter {
		<T> T wrap(T t);
	}

}
