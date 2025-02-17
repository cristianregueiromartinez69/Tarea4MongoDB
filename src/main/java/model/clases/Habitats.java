package model.clases;

import java.util.List;

public class Habitats {



    private String nome;
    private String localizacion;

    private List<String> especiesPinguins;

    private String descripcion;
    private String temperatura;
    private String caracteristicas;

    public Habitats(String nome, String localizacion, List<String> especiesPinguins, String descripcion, String temperatura, String caracteristicas) {
        this.nome = nome;
        this.localizacion = localizacion;
        this.especiesPinguins = especiesPinguins;
        this.descripcion = descripcion;
        this.temperatura = temperatura;
        this.caracteristicas = caracteristicas;
    }


    public Habitats() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public List<String> getEspeciesPinguins() {
        return especiesPinguins;
    }

    public void setEspeciesPinguins(List<String> especiesPinguins) {
        this.especiesPinguins = especiesPinguins;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "\nHabitats: " +
                "\nnome: " + nome +
                "\nlocalizacion: " + localizacion +
                "\nespeciesPinguins: " + especiesPinguins +
                "\ndescripcion: " + descripcion +
                "\ntemperatura: " + temperatura +
                "\ncaracteristicas: " + caracteristicas;
    }
}
