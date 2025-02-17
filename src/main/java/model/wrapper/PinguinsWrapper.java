package model.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import model.clases.Pinguins;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@JacksonXmlRootElement(localName = "pinguins")
public class PinguinsWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("pinguin")
    private List<Map<String, Object>> pinguinsMap;

    public List<Map<String, Object>> getPinguinsMap() {
        return pinguinsMap;
    }

    public void setPinguinsMap(List<Map<String, Object>> pinguinsMap) {
        this.pinguinsMap = pinguinsMap;
    }
}
