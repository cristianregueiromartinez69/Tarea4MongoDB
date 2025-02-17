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

        /* lectura de xml sin actualizar
        metodosPinguinos.readListPinguins(pinguinsMapSinActualizar);
        metodosHabitats.readListHabitats(habitatsMapSinActualizar);
         */

        /* inserccion datos mongo
        logicaInserccionDatos(pinguinsMap, habitatsMap, crudMongo);
         */

        /* lectura base de datos
        metodosPinguinos.readListPinguins(crudMongo.getDataFromDb("penguins"));
        metodosHabitats.readListHabitats(crudMongo.getDataFromDb("habitats"));
         */

        List<Map<String, Object>> pinguinsMapActualizado = leFich.readXmlFilePinguienos("pingüinosActualizado.xml");
        List<Map<String, Object>> habitatsMapActualizado = leFich.readXmlFileHabitats("habitatsActualizado.xml");
        metodosPinguinos.readListPinguins(pinguinsMapActualizado);
        metodosHabitats.readListHabitats(habitatsMapActualizado);

    }


    public void logicaInserccionDatos(List<Map<String, Object>> pinguinsMap, List<Map<String, Object>> habitatsMap, CrudMongo crudMongo){
        crudMongo.inserdataHabitats(habitatsMap);
        crudMongo.inserdataPenguins(pinguinsMap);
    }
}
