package controller;

import model.clases.Habitats;
import model.clases.Pinguins;
import service.crud.CrudMongo;
import service.ficheros.LecturaEscrituraFicheros;
import service.metodosclases.MetodosHabitats;
import service.metodosclases.MetodosPinguinos;

import java.util.List;
import java.util.Map;

public class Controller {

    public void logicaPrograma(){

        LecturaEscrituraFicheros leFich = new LecturaEscrituraFicheros();
        MetodosPinguinos metodosPinguinos = new MetodosPinguinos();
        MetodosHabitats metodosHabitats = new MetodosHabitats();
        CrudMongo crudMongo = new CrudMongo();


        List<Map<String, Object>> pinguinsMapSinActualizar= leFich.readXmlFilePinguienos("pingüinos.xml");
        List<Map<String, Object>> habitatsMapSinActualizar = leFich.readXmlFileHabitats("habitats.xml");

        /*
        metodosPinguinos.readListPinguins(pinguinsMapSinActualizar);
        metodosHabitats.readListHabitats(habitatsMapSinActualizar);


        logicaInserccionDatos(pinguinsMapSinActualizar, habitatsMapSinActualizar, crudMongo);


        metodosPinguinos.readListPinguins(crudMongo.getDataFromDb("penguins"));
        metodosHabitats.readListHabitats(crudMongo.getDataFromDb("habitats"));

        */
        List<Map<String, Object>> pinguinsMapActualizado = leFich.readXmlFilePinguienos("pingüinosActualizado.xml");
        List<Map<String, Object>> habitatsMapActualizado = leFich.readXmlFileHabitats("habitatsActualizado.xml");

        //metodosPinguinos.readListPinguins(pinguinsMapActualizado);
        //metodosHabitats.readListHabitats(habitatsMapActualizado);
        //logicaActualizacionDatos(pinguinsMapActualizado, habitatsMapActualizado, crudMongo);

        //leFich.writeXmlActualizadoFromDbPentas(crudMongo.getDataFromDb("penguins"));
        //leFich.writeXmlActualizadoFromDbHabitats(crudMongo.getDataFromDb("habitats"));

        crudMongo.deleteDataFromDb("penguins");
        crudMongo.deleteDataFromDb("habitats");


    }


    public void logicaInserccionDatos(List<Map<String, Object>> pinguinsMap, List<Map<String, Object>> habitatsMap, CrudMongo crudMongo){
        crudMongo.inserdataHabitats(habitatsMap);
        crudMongo.inserdataPenguins(pinguinsMap);
    }

    public void logicaActualizacionDatos(List<Map<String, Object>> pinguinsMap, List<Map<String, Object>> habitatsMap, CrudMongo crudMongo){
        crudMongo.updateDataPinguinos(pinguinsMap);
        crudMongo.updateDataHabitats(habitatsMap);
    }
}
