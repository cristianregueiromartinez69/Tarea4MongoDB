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

        //lectura de xml
        List<Map<String, Object>> pinguinsMap= leFich.readXmlFilePinguienos();
        List<Map<String, Object>> habitatsMap = leFich.readXmlFileHabitats();
        //metodosPinguinos.readListPinguins(pinguinsMap);
        //metodosHabitats.readListHabitats(habitatsMap);

        //inserccion de datos en mongo
        logicaInserccionDatos(pinguinsMap, habitatsMap, crudMongo);
    }

    public void logicaInserccionDatos(List<Map<String, Object>> pinguinsMap, List<Map<String, Object>> habitatsMap, CrudMongo crudMongo){
        crudMongo.inserdataHabitats(habitatsMap);
        crudMongo.inserdataPenguins(pinguinsMap);
    }
}
