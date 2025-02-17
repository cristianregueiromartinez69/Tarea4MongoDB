package service.ficheros;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.clases.Habitats;
import model.clases.Pinguins;
import model.wrapper.HabitatsWrapper;
import model.wrapper.PinguinsWrapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LecturaEscrituraFicheros {

    public List<Map<String, Object>> readXmlFilePinguienos(){
        XmlMapper xmlMapper = new XmlMapper();
        try{

            PinguinsWrapper wrapper = xmlMapper.readValue(new File("pingüinos.xml"), PinguinsWrapper.class);
            return wrapper.getPinguinsMap();
        } catch (IOException e) {
            System.out.println("Ups, error al leer el fichero xml de pinguinos");
        }
        return null;
    }

    public List<Map<String, Object>> readXmlFileHabitats(){
        XmlMapper xmlMapper = new XmlMapper();
        try{

            HabitatsWrapper wrapper = xmlMapper.readValue(new File("habitats.xml"), HabitatsWrapper.class);
            return wrapper.getHabitatsMap();
        } catch (IOException e) {
            System.out.println("Ups, error al leer el fichero xml de habitats");
        }
        return null;
    }
}
