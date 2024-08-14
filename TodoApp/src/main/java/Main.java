import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//To Do App Using MongoDb
//Create new task using date, name, task status,time
public class Main {
    public static void main(String[] args) {
        //Add the maven in java for mongodb
        var client = MongoClients.create("mongodb://localhost:27017/");
        //to create or access database
        var tododb = client.getDatabase("todoDb");
        //to create collection
    //    tododb.createCollection("todoList");
        //to access collection
        var todocollection = tododb.getCollection("todoList");
        //to create document and add data
        var todoDocument = new Document();
        todoDocument.append("TaskName","Work on mongodb");
        todoDocument.append("TaskDate","13 August 2024");
        todoDocument.append("TaskTime","20 hrs");
        todoDocument.append("TaskStatus",false);

        //to add document in collection
        todocollection.insertOne(todoDocument);

        //to update the document
        //to change date if status is false in all documents
        todocollection.updateMany(new Document("TaskStatus",false),
        new Document("$set" , new Document("TaskDate","17 August 2024")));

        //delete document if status is true
        todocollection.deleteOne(new Document("TaskStatus",true));

        //to fetch document from collection
        FindIterable<Document> todolist = todocollection.find();
        for (Document document : todolist) {
            //System.out.println("My Document " + document);
            System.out.println("Task Name " + document.getString("TaskName") + " Task Date " + document.getString("TaskDate"));
        }
    }
}