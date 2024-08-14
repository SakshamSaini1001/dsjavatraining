import com.mongodb.client.MongoClient;
import com.mongodb.MongoDriverInformation;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Note MongoDb is a no sql database and high speed easy maintain
    //1. Establish the mongo database connection with java
    //2. Create the collection
    //3. get the collection
    //4. Insert the document in collections
    //5. Update the document in collections
    //6. delete the document in collections
    //7. get the document in collections
    //8. Get the specific document from collection
    public static void main(String[] args) {
//
//        //TO ESTABLISH MONGODB CONNECTION WITH JAVA
//        MongoClient client = MongoClients.create("mongodb://localhost:27017");
//        MongoDatabase database = client.getDatabase("AdvanceJava1");
//        //System.out.println(database.getName());
//
//        //TO FETCH COLLECTION FROM DATABASE
//        for(String name : database.listCollectionNames()) {
//            System.out.println(name);
//        }
//
//        //CREATE NEW COLLECTION USING JAVA
//        database.createCollection("Faculty");
//        System.out.println("Collection created");
//
//        //CREATE NEW COLLECTION IN AdvanceJava1
//        database.createCollection("Friends");
//        System.out.println("Collection created");

        //user train route station staff

        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        //MongoDatabase database = client.getDatabase("RailwayDb");
        var database = client.getDatabase("RailwayDb");

//        database.createCollection("User");
//        System.out.println("Collection created");

        //TO DROP THE COLLECTION
//        usercollection.drop();

        //TO ACCESS LIST OF COLLECTION FROM DATABASE
        for(String name : database.listCollectionNames()) {
            System.out.println(name);
        }

        //TO INSERT DOCUMENT INTO COLLECTION
        //TO INSERT USER DATA INTO User COLLECTION
        var usercollection = database.getCollection("User");
        //CREATE NEW DOCUMENT FOR User COLLECTION
        var userDocument = new Document();
        userDocument.append("name","Saksham");
        usercollection.insertOne(userDocument);
    }
}