package service.metodosclases;

import model.clases.Pinguins;

import java.util.List;
import java.util.Map;

public class MetodosPinguinos {

    public void readListPinguins(List<Map<String, Object>> pinguinsMap) {
        for(Map<String, Object> equipo : pinguinsMap) {
            System.out.println("\nPingúino bonito: ");
            for(Map.Entry<String, Object> pinguins : equipo.entrySet()){
                System.out.println(pinguins.getKey() + ": " + pinguins.getValue());
            }
        }
    }
}
