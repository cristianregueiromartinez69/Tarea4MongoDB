package service.ficheros;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.wrapper.HabitatsWrapper;
import model.wrapper.PinguinsWrapper;
import service.metodosclases.MetodosHabitats;
import service.metodosclases.MetodosPinguinos;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Clase que gestiona la lectura y escritura de archivos XML
 * relacionados con pingüinos y hábitats.
 * @author cristian
 * @version 1.0
 */
public class LecturaEscrituraFicheros {

    /**
     * Lee un archivo XML de pingüinos y devuelve una lista de mapas con los datos.
     * @param path Ruta del archivo XML.
     * @return Lista de mapas con los datos de los pingüinos o null si ocurre un error.
     */
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

    /**
     * Lee un archivo XML de hábitats y devuelve una lista de mapas con los datos.
     * @param path Ruta del archivo XML.
     * @return Lista de mapas con los datos de los hábitats o null si ocurre un error.
     */
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

    /**
     * Escribe un archivo XML actualizado de pingüinos a partir de los datos de la base de datos.
     * @param object Lista de mapas con los datos actualizados de los pingüinos.
     * @param metodosPinguinos Instancia de MetodosPinguinos para procesar los datos.
     */
    public void writeXmlActualizadoFromDbPentas(List<Map<String, Object>> object, MetodosPinguinos metodosPinguinos){
        XmlMapper xmlMapper = new XmlMapper();
        try{
            File file = new File("pingüinosActuFromDB.xml");
            metodosPinguinos.deleteIdToXml(object);
            PinguinsWrapper pinguinsWrapper = new PinguinsWrapper();
            pinguinsWrapper.setPinguinsMap(object);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, pinguinsWrapper);
            System.out.println("Fichero pinguinos escrito correctamente en el xml");
        }catch (IOException e){
            System.out.println("Ups, error al crear el xml actualizado de pingüinos");
        }
    }

    /**
     * Escribe un archivo XML actualizado de hábitats a partir de los datos de la base de datos.
     * @param object Lista de mapas con los datos actualizados de los hábitats.
     * @param metodosHabitats Instancia de MetodosHabitats para procesar los datos.
     */
    public void writeXmlActualizadoFromDbHabitats(List<Map<String, Object>> object, MetodosHabitats metodosHabitats){
        XmlMapper xmlMapper = new XmlMapper();
        try{
            File file = new File("habitatsActuFromDB.xml");
            metodosHabitats.deleteIdToXml(object);
            HabitatsWrapper habitatsWrapper = new HabitatsWrapper();
            habitatsWrapper.setHabitatsMap(object);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, habitatsWrapper);
            System.out.println("Fichero habitats escrito correctamente en el xml");
        }catch (IOException e){
            System.out.println("Ups, error al crear el xml actualizado de pingüinos");
        }
    }
}
