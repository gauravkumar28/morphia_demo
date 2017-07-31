package com.gaurav;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MorphiaService {
	Datastore datastore = null;
    public Datastore getDatastore() {
		return datastore;
	}
	public void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}
	public MorphiaService() {
    	MorphiaClient morphiaClient =  MorphiaClient.getInstance();
    	Morphia morphia = morphiaClient.getMorphia();
    	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    	datastore = morphia.createDatastore(mongoClient, "oms");
    	datastore.ensureIndexes();
    }
}
