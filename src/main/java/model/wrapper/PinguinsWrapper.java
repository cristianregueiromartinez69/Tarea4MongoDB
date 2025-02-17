package model.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import model.clases.Pinguins;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Clase para envolver la lista de objetos de tipo pinguin
 * @author cristian
 * @version 1.0
 */
@JacksonXmlRootElement(localName = "pinguins")
public class PinguinsWrapper {

    //atributos de clase
    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("pinguin")
    private List<Map<String, Object>> pinguinsMap;

    //getter y setter
    public List<Map<String, Object>> getPinguinsMap() {
        return pinguinsMap;
    }

    public void setPinguinsMap(List<Map<String, Object>> pinguinsMap) {
        this.pinguinsMap = pinguinsMap;
    }
}
