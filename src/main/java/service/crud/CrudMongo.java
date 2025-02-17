package service.crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.MongoConfig;
import org.bson.Document;

import java.util.List;
import java.util.Map;

public class CrudMongo {

    MongoDatabase mongoDatabase = MongoConfig.getConnectionMongoDB();

    public void inserdataPenguins(List<Map<String, Object>> penguinsMap){
        MongoCollection<Document> collection = mongoDatabase.getCollection("penguins");

        for(Map<String, Object> penguin : penguinsMap){
            Document document = new Document(penguin);
            collection.insertOne(document);
        }
        System.out.println("Coleccion de pingüinos insertada correctamente");
    }

    public void inserdataHabitats(List<Map<String, Object>> habitatsMaps){
        MongoCollection<Document> collection = mongoDatabase.getCollection("habitats");

        for(Map<String, Object> habitat : habitatsMaps){
            Document document = new Document(habitat);
            collection.insertOne(document);
        }
        System.out.println("Coleccion de habitats insertada correctamente");
    }
}
