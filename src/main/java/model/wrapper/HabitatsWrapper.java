package model.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import model.clases.Habitats;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Clase para envolver la lista de objetos de tipo Habitat
 * @author cristian
 * @version 1.0
 */
@JacksonXmlRootElement(localName = "habitats")
public class HabitatsWrapper {

    //atributo de clase
    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("habitat")
    private List<Map<String, Object>> habitatsMap;

    //getter y setter
    public List<Map<String, Object>> getHabitatsMap() {
        return habitatsMap;
    }

    public void setHabitatsMap(List<Map<String, Object>> habitatsMap) {
        this.habitatsMap = habitatsMap;
    }
}
