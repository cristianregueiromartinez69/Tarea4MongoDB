package service.metodosclases;

import java.util.List;
import java.util.Map;

/**
 * Clase con métodos adicionales de la clase Habitats
 * @author cristian
 * @version 1.0
 */
public class MetodosHabitats {

    /**
     * Metodo para leer la lista de objetos
     * @param habitatsMap la lista de habitats
     */
    public void readListHabitats(List<Map<String, Object>> habitatsMap){
        for(Map<String, Object> equipo : habitatsMap){
            System.out.println("\nHabitat: ");
            for(Map.Entry<String, Object> habitat : equipo.entrySet()){
                System.out.println(habitat.getKey() + ": " + habitat.getValue());
            }
        }
    }

    /**
     * metodo que borra el id para no escribirlo en el xml
     * @param habitatsMap la lista de habitats
     */
    public void deleteIdToXml(List<Map<String, Object>> habitatsMap){
        for(Map<String, Object> habitat : habitatsMap){
            habitat.remove("_id");
        }
    }
}
