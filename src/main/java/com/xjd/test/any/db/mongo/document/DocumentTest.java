package com.xjd.test.any.db.mongo.document;

import org.bson.Document;

/**
 * @author elvis.xu
 * @since 2018-09-12 23:35
 */
public class DocumentTest {
	public static void main(String[] args) {
		Document document = Document.parse("{_id: ObjectId('5b9932c41ea4ff42d9511f0e'), long: NumberLong(100)}");
//		Document document = Document.parse("{ \"_id\" : { \"$oid\" : \"5b9932c41ea4ff42d9511f0e\" } }");
		System.out.println(document);
		System.out.println(document.toJson());
		System.out.println(document.get("_id").getClass());
	}
}
