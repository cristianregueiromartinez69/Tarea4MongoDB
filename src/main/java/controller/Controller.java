package controller;

import service.crud.CrudMongo;
import service.ficheros.LecturaEscrituraFicheros;
import service.metodosclases.MetodosHabitats;
import service.metodosclases.MetodosPinguinos;

import java.util.List;
import java.util.Map;

/**
 * Clase controller con la lógica de la aplicación
 * @author cristian
 * @version 1.0
 */
public class Controller {

    public void logicaPrograma(){

        //instanciamos los objetos
        LecturaEscrituraFicheros leFich = new LecturaEscrituraFicheros();
        MetodosPinguinos metodosPinguinos = new MetodosPinguinos();
        MetodosHabitats metodosHabitats = new MetodosHabitats();
        CrudMongo crudMongo = new CrudMongo();


        //creamos una lista igual al metodo que leee los xmls
        List<Map<String, Object>> pinguinsMapSinActualizar= leFich.readXmlFilePinguienos("pingüinos.xml");
        List<Map<String, Object>> habitatsMapSinActualizar = leFich.readXmlFileHabitats("habitats.xml");

        //leemos la lista que viene del xml
        metodosPinguinos.readListPinguins(pinguinsMapSinActualizar);
        metodosHabitats.readListHabitats(habitatsMapSinActualizar);

        //insertamos los datos en mongo
        logicaInserccionDatos(pinguinsMapSinActualizar, habitatsMapSinActualizar, crudMongo);

        //leemos los datos de la base de mongo
        metodosPinguinos.readListPinguins(crudMongo.getDataFromDb("penguins"));
        metodosHabitats.readListHabitats(crudMongo.getDataFromDb("habitats"));

        //creamos una lista igual a los datos leidos del xml actualizado
        List<Map<String, Object>> pinguinsMapActualizado = leFich.readXmlFilePinguienos("pingüinosActualizado.xml");
        List<Map<String, Object>> habitatsMapActualizado = leFich.readXmlFileHabitats("habitatsActualizado.xml");

        //leemos los datos del xml actualizado
        metodosPinguinos.readListPinguins(pinguinsMapActualizado);
        metodosHabitats.readListHabitats(habitatsMapActualizado);

        //actualizamos los datos de mongo
        logicaActualizacionDatos(pinguinsMapActualizado, habitatsMapActualizado, crudMongo);

        //exportamos los datos de la base de datos a un xml de mongo
        leFich.writeXmlActualizadoFromDbPentas(crudMongo.getDataFromDb("penguins"), metodosPinguinos);
        leFich.writeXmlActualizadoFromDbHabitats(crudMongo.getDataFromDb("habitats"), metodosHabitats);

        //borramos los datos de mongo
        crudMongo.deleteDataFromDb("penguins");
        crudMongo.deleteDataFromDb("habitats");


    }


    /**
     * Metodo auxiliar para insertar los datos en mongoDB
     * @param pinguinsMap la lista de pingüinos
     * @param habitatsMap la lista de habitats
     * @param crudMongo el objeto crud para realizar las insercciones
     */
    public void logicaInserccionDatos(List<Map<String, Object>> pinguinsMap, List<Map<String, Object>> habitatsMap, CrudMongo crudMongo){
        crudMongo.inserdataHabitats(habitatsMap);
        crudMongo.inserdataPenguins(pinguinsMap);
    }

    /**
     * Metodo auxiliar para actualizar los datos en mongoDB
     * @param pinguinsMap la lista de pingüinos
     * @param habitatsMap la lista de habitats
     * @param crudMongo el objeto crud para realizar las actualizaciones
     */
    public void logicaActualizacionDatos(List<Map<String, Object>> pinguinsMap, List<Map<String, Object>> habitatsMap, CrudMongo crudMongo){
        crudMongo.updateDataPinguinos(pinguinsMap);
        crudMongo.updateDataHabitats(habitatsMap);
    }
}
