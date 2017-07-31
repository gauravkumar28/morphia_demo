package com.gaurav;

import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MorphiaClient {
   
	private static Morphia morphia = null;
	private static volatile MorphiaClient morphiaClient = null;
    
	public static MorphiaClient getInstance() {
		if( morphiaClient == null){
			synchronized(MorphiaClient.class){
				if( morphiaClient == null){
			        morphiaClient = new MorphiaClient();
				}
			}
		} 
		return morphiaClient;
	}
	
	private  MorphiaClient(){
		morphia = new Morphia();
	}

	public Morphia getMorphia() {
		// TODO Auto-generated method stub
		return morphia;
	} 
	
}
