package com.xjd.test.any.db.mongo.mapper;

import java.util.function.Consumer;

import org.bson.Document;

/**
 * @author elvis.xu
 * @since 2018-09-06 16:11
 */
public class DocumentWrapper2<T> extends Document {

	public DocumentWrapper2 append(Consumer<T> key, Object value) {
		return null;
	}

	public String getString(Consumer<T> key) {
		return null;
	}

}
