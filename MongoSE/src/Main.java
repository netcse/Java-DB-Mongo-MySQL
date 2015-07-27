import com.mongodb.*;
import com.mongodb.DBCollection;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.File;
import java.io.PrintWriter;
import java.net.UnknownHostException;



public class Main {

    public static void main(String[] args) throws UnknownHostException{
        MongoClient mongoClient = new MongoClient(new ServerAddress("169.254.36.27", 27017));

        MongoDatabase db = mongoClient.getDatabase("local");


        MongoCollection<Document> collection = db.getCollection("staff");

        FindIterable<Document> iterable = db.getCollection("staff")
                                .find()
                                .sort(and(new Document("district", -1), new Document("age", -1)));

        BasicDBObject field = new BasicDBObject();
        field.put("name",1);
        field.put("age", 1);
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.get("name") + " : " + document.get("age"));
            }
        });



        /*
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("district","dhaka");

        FindIterable<Document> iterable = db.getCollection("people").find(new Document("district","dhaka"));
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });

        //System.out.println(collection.find().first().toJson());

        Document doc = collection.find(eq("name", "guru")).first();

        String x = doc.get("college").toString();
        System.out.println(x);
        if(x.compareToIgnoreCase("mvc") == 0){
            System.out.println("Found");
        }
        System.out.println(doc.toJson());



        MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
        while(cursor.hasNext()){
            if(cursor.next().put("name","sadi")){
                System.out.println(cursor.next());
            }
        }
        cursor.close();


        MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
        try {

            PrintWriter pw = new PrintWriter(new File("out.json"));
            while (cursor.hasNext()) {
                //System.out.println(cursor.next().toJson());
                pw.write(cursor.next().toJson());
                //System.out.println(",");
            }
            pw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            cursor.close();
        }
        */


        /*

        MongoCollection collection = db.getCollection("sadi");


        BasicDBObject obj = new BasicDBObject("name","amran")
                                .append("age","30")
                                .append("college","psc");
        collection.insertOne(obj);

        */

    }
}
