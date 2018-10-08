package com.xjd.test.any.db.mongo;

import java.util.function.Consumer;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * @author elvis.xu
 * @since 2018-09-06 17:38
 */
public class TestMongo {
	public static void main(String[] args) {
		MongoClientURI uri = new MongoClientURI("mongodb://120.78.12.247:27190");
		MongoClient mongoClient = new MongoClient(uri);

		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection collection = database.getCollection("test2");

		{
			Document document = new Document("num", new Document("$gt", 20).append("$lt", 150));
			System.out.println(document.toString());
			FindIterable iterable = collection.find(document);
			iterable.forEach((Consumer) t -> {
				System.out.println(t.toString());
			});
		}
		System.out.println("=====");
		{
			Bson and = Filters.and(Filters.gt("num", 20), Filters.lt("num", 150));
			System.out.println(and);
			FindIterable iterable = collection.find(and);
			iterable.forEach((Consumer) t -> {
				System.out.println(t.toString());
			});
		}

	}
}
