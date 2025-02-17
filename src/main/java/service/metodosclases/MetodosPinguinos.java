package service.metodosclases;


import java.util.List;
import java.util.Map;

/**
 * Clase con los métodos adicionales de la clase de Pinguinos
 * @author cristian
 * @version 1.0
 */
public class MetodosPinguinos {

    /**
     * Metodo que lee una lista de objetos
     * @param pinguinsMap la lista de pinguinos
     */
    public void readListPinguins(List<Map<String, Object>> pinguinsMap) {
        for(Map<String, Object> equipo : pinguinsMap) {
            System.out.println("\nPingúino bonito: ");
            for(Map.Entry<String, Object> pinguins : equipo.entrySet()){
                System.out.println(pinguins.getKey() + ": " + pinguins.getValue());
            }
        }
    }

    /**
     * metodo que borra el id para no escribirlo en el xml
     * @param penguinsMap la lista de pinguinos
     */
    public void deleteIdToXml(List<Map<String, Object>> penguinsMap){
        for(Map<String, Object> penguin : penguinsMap){
            penguin.remove("_id");
        }
    }
}
