package service.crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import config.MongoConfig;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrudMongo {

    MongoDatabase mongoDatabase = MongoConfig.getConnectionMongoDB();

    public void inserdataPenguins(List<Map<String, Object>> penguinsMap) {
        MongoCollection<Document> collection = mongoDatabase.getCollection("penguins");

        for (Map<String, Object> penguin : penguinsMap) {
            Document document = new Document(penguin);
            collection.insertOne(document);
        }
        System.out.println("Coleccion de pingüinos insertada correctamente");
    }

    public void inserdataHabitats(List<Map<String, Object>> habitatsMaps) {
        MongoCollection<Document> collection = mongoDatabase.getCollection("habitats");

        for (Map<String, Object> habitat : habitatsMaps) {
            Document document = new Document(habitat);
            collection.insertOne(document);
        }
        System.out.println("Coleccion de habitats insertada correctamente");
    }

    public List<Map<String, Object>> getDataFromDb(String coleccion) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(coleccion);
        return collection.find().into(new ArrayList<>());
    }


    public void updateDataPinguinos(List<Map<String, Object>> penguinsMap) {
        MongoCollection<Document> collectionPinguinos = mongoDatabase.getCollection("penguins");

        for (Map<String, Object> pinguino : penguinsMap) {
            String nome = (String) pinguino.get("nome");

            if (nome != null) {
                Document document = collectionPinguinos.find(Filters.eq("nome", nome)).first();

                if (document != null) {
                    collectionPinguinos.updateOne(
                            Filters.eq("nome", nome),
                            Updates.combine(
                                    Updates.set("nomeCientifico", pinguino.get("nomeCientifico")),
                                    Updates.set("habitat", pinguino.get("habitat")),
                                    Updates.set("descripcion", pinguino.get("descripcion")),
                                    Updates.set("alimentacion", pinguino.get("alimentacion")),
                                    Updates.set("tamaño", pinguino.get("tamaño")),
                                    Updates.set("peso", pinguino.get("peso")),
                                    Updates.set("caracteristicas", pinguino.get("caracteristicas"))
                            )
                    );
                    System.out.println("Documento actualizado: " + nome);
                } else {
                    System.out.println("Pingüino no encontrado en la base de datos: " + nome);
                }
            }
        }
    }


}
