package service.crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import config.MongoConfig;
import org.bson.Document;

import java.util.*;

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
                    System.out.println("Documento de pingüinos actualizado correctamente");
                } else {
                    Document auxDocument = new Document(pinguino);
                    askInsertDataMongo(collectionPinguinos, auxDocument);
                }
            }
        }
    }

    public void updateDataHabitats(List<Map<String, Object>> habitatsList){
        MongoCollection<Document> collectionHabitat = mongoDatabase.getCollection("habitats");
        for (Map<String, Object> habitat : habitatsList) {
            String nome = (String) habitat.get("nome");
            if (nome != null) {
                Document document = collectionHabitat.find(Filters.eq("nome", nome)).first();
                if(document != null) {
                    collectionHabitat.updateOne(
                            Filters.eq("nome", nome),
                            Updates.combine(
                                    Updates.set("localizacion", habitat.get("localizacion")),
                                    Updates.set("especiesPinguins", habitat.get("especiesPinguins")),
                                    Updates.set("descripcion", habitat.get("descripcion")),
                                    Updates.set("temperatura", habitat.get("temperatura")),
                                    Updates.set("caracteristicas", habitat.get("caracteristicas"))
                            )
                    );
                    System.out.println("Documento de habitats actualizado correctamente");
                }
                else{
                    Document auxDocument = new Document(habitat);
                    askInsertDataMongo(collectionHabitat, auxDocument);
                }
            }
        }
    }

    public void deleteDataFromDb(String nameCollection){

        boolean collectionExists = mongoDatabase.listCollectionNames()
                .into(new ArrayList<>())
                .contains(nameCollection);
        if(collectionExists) {
            MongoCollection<Document> collection = mongoDatabase.getCollection(nameCollection);
            collection.deleteMany(new Document());
            System.out.println("Coleccion de " + nameCollection + " eliminada correctamente");
        }
        else{
            System.out.println("La coleccion no existe en la base de datos");
        }
    }

    private void askInsertDataMongo(MongoCollection<Document> collection,Document document) {
        System.out.println("Se ha encontrado unos datos en el xml que no están en la base de datos, desea introducirlos?");
        System.out.println("responde (si) para introducirlos, responde (no) para no introducirlos");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();

        while(!checkResponse(response)) {
            System.out.println("No te he entendido, responde sí o no");
        }
        if(response.equalsIgnoreCase("si")){
            collection.insertOne(document);
            System.out.println("Nuevo documento insertado correctamente");
        }
    }

    private boolean checkResponse(String response) {
        return response.equals("si") || response.equals("no");
    }

}
