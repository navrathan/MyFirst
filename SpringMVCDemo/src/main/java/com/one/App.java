package com.one;

import java.net.UnknownHostException;
import java.util.Iterator;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class App {
	public static boolean isValid(String n,String p) throws UnknownHostException {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("Registration");
		DBCollection table = db.getCollection("Registration");
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("username",n);

		DBCursor cursor = table.find(searchQuery);
		System.out.println(cursor.getKeysWanted());
		
		Iterator<DBObject> abc=cursor.iterator();
		String a=null,b=null;
		
		if(abc.hasNext())
		{
			DBObject dbObj=abc.next();
			a=dbObj.get("username").toString();
			b=dbObj.get("password").toString();
				
		}
		System.out.println(a + b);
		
		if(n.equals(a)&&p.equals(b))
			return true;
		else
			return false;
		
	}

}
