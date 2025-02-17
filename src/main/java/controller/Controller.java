package controller;

import model.clases.Habitats;
import model.clases.Pinguins;
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

        List<Map<String, Object>> pinguinsMap= leFich.readXmlFilePinguienos();
        List<Map<String, Object>> habitatsMap = leFich.readXmlFileHabitats();

        metodosPinguinos.readListPinguins(pinguinsMap);
        metodosHabitats.readListHabitats(habitatsMap);

    }
}
