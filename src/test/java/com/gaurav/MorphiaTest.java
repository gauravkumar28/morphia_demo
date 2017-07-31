package com.gaurav;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

public class MorphiaTest {
	public static Datastore datastore = null;
	public static Address address = null;
	
	@BeforeClass
	public static void setup(){
		MorphiaService morphiaService = new MorphiaService();
		datastore = morphiaService.getDatastore();
		address = new Address();
		address.setCity("delhi");
		address.setCountry("India");
		address.setStreet("DLF");
	}
	
	@Test
	public void testInsertMorphia() {
		User usr = new User();
		usr.setEmail("gaurav.kumar3@olacabs.com");
		usr.setName("Gaurav Kumar");
		usr.setPhone("7022727530");
		usr.setAddress(address);
		datastore.save(usr);
		System.out.println(datastore.createQuery(User.class).field("phone").equal("7022727530").asList());
	}
	
	@Test
	public void testUpdateMorphia() {
		Query<User> phoneQuery = datastore.createQuery(User.class).filter("phone = ", "7022727530");
		UpdateOperations<User> updateOperations = datastore.createUpdateOperations(User.class).set("phone", "99999999999");
		UpdateResults results = datastore.update(phoneQuery, updateOperations);
		
		System.out.println(results);
		System.out.println(datastore.find(User.class).field("phone").equal("99999999999").asList());
	}
	
	@Test
	public void testQueryMorphia() {
		System.out.println(datastore.createQuery(User.class).count());
		System.out.println(datastore.createQuery(User.class).filter("email = ", "gaurav.kumar3@olacabs.com").count());
	}
	
	
	@Test
	public void testDeleteMorphia() {
		System.out.println(datastore.createQuery(User.class).count());
		Query<User> phoneQuery = datastore.createQuery(User.class).filter("phone = ", "7022727530");
		datastore.delete(phoneQuery);
		System.out.println(datastore.createQuery(User.class).count());
	}
}
