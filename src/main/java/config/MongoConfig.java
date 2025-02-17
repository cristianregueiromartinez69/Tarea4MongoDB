package config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Clase de configuración de la base de datos de mongoDB
 * @author cristian
 * @version 1.0
 */
public class MongoConfig {

    /**
     * variables provadas, estáticas y finales del path donde está la base de mongo  y el nombre de la base de datos
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
