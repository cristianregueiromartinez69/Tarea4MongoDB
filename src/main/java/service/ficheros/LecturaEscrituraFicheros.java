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

    public List<Map<String, Object>> readXmlFilePinguienos(String path){
        XmlMapper xmlMapper = new XmlMapper();
        try{

            PinguinsWrapper wrapper = xmlMapper.readValue(new File(path), PinguinsWrapper.class);
            return wrapper.getPinguinsMap();
        } catch (IOException e) {
            System.out.println("Ups, error al leer el fichero xml de pinguinos");
        }
        return null;
    }

    public List<Map<String, Object>> readXmlFileHabitats(String path){
        XmlMapper xmlMapper = new XmlMapper();
        try{

            HabitatsWrapper wrapper = xmlMapper.readValue(new File(path), HabitatsWrapper.class);
            return wrapper.getHabitatsMap();
        } catch (IOException e) {
            System.out.println("Ups, error al leer el fichero xml de habitats");
        }
        return null;
    }

    public void writeXmlActualizadoFromDbPentas(List<Map<String, Object>> object){
        XmlMapper xmlMapper = new XmlMapper();
        try{
            File file = new File("pingüinosActuFromDB.xml");
            PinguinsWrapper pinguinsWrapper = new PinguinsWrapper();
            pinguinsWrapper.setPinguinsMap(object);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, pinguinsWrapper);
        }catch (IOException e){
            System.out.println("Ups, error al crear el xml actualizado de pingüinos");
        }
    }
}
