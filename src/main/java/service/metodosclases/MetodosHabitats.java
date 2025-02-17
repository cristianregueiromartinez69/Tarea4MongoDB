package service.metodosclases;

import model.clases.Habitats;

import java.util.List;
import java.util.Map;

public class MetodosHabitats {

    public void readListHabitats(List<Map<String, Object>> habitatsMap){
        for(Map<String, Object> equipo : habitatsMap){
            System.out.println("\nHabitat: ");
            for(Map.Entry<String, Object> habitat : equipo.entrySet()){
                System.out.println(habitat.getKey() + ": " + habitat.getValue());
            }
        }
    }
}
