package config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConfig {

    /**
     * variables provadas, estáticas y finales de la url donde está la base de mongo en la nube y el nombre de la base de datos
     */
    private static final String connectionMongoDb = "mongodb://localhost:27017";
    private static final String databaseName = "dbpentas";

    /**
     * Metodo que crea la conexión a mongo con las variables anteriores
     * @return la base de datos de mongo
     */
    public static MongoDatabase getConnectionMongoDB(){
        MongoClient mongoClient = MongoClients.create(connectionMongoDb);
        System.out.println("Conexion exitosa con la base de datos de mongo db");
        return mongoClient.getDatabase(databaseName);

    }
}
