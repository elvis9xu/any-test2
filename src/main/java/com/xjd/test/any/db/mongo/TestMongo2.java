package com.xjd.test.any.db.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author elvis.xu
 * @since 2018-09-06 17:38
 */
public class TestMongo2 {
	public static void main(String[] args) {
		MongoClientURI uri = new MongoClientURI("mongodb://120.78.12.247:27190");
		MongoClient mongoClient = new MongoClient(uri);

		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection collection = database.getCollection("map");

//		{
//			FindIterable iterable = collection.find();
//			iterable.forEach((Consumer) t -> {
//				System.out.println(t.toString());
//			});
//		}

		Document document = new Document("name", "xxxx");
		collection.insertOne(document);
		System.out.println(document);

	}
}
