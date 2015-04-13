package com.journaldev.spring.mongodb.main;

import java.net.UnknownHostException;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.mongodb.model.Person;
import com.mongodb.MongoClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:Spring_dataase123.xml"
		})
public class SpringDataMongoDBMain {

	public static final String DB_NAME = "test";
	public static final String PERSON_COLLECTION = "products";
	public static final String MONGO_HOST = "192.168.56.101";
	public static final int MONGO_PORT = 27017;

	
	
	@Repeat(100)
	@Test
	public void test123(){
		System.out.println("fds");
	}
	
	@Test
	@Repeat(100)
	public void insertNative() {
		try {
			MongoClient mongo = new MongoClient(
					MONGO_HOST, MONGO_PORT);
			MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
			
			for(int i=0; i< 10000; i++){
				Person p = new Person(UUID.randomUUID().toString(), "Yang HuaJie" + i, "159 Lorong Sarina" + i);
				mongoOps.insert(p, PERSON_COLLECTION);
			}
			

//			Person p1 = mongoOps.findOne(
//					new Query(Criteria.where("name").is("PankajKr")),
//					Person.class, PERSON_COLLECTION);
//
//			System.out.println(p1);
			
			//mongoOps.dropCollection(PERSON_COLLECTION);
			mongo.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
