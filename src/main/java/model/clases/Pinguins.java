package model.clases;

/**
 * Representa un pingüino con información sobre su nombre, nombre científico, hábitat,
 * descripción, alimentación, tamaño, peso y características.
 * @author cristian
 * @version 1.0
 */
public class Pinguins {

    //atributos de clase
    private String nome;
    private String nomeCientifico;
    private String habitat;
    private String descripcion;
    private String alimentacion;
    private String tamaño;
    private String peso;
    private String caracteristicas;

    /**
     * Constructor con parámetros para inicializar un pingüino.
     *
     * @param nome Nombre del pingüino.
     * @param nomeCientifico Nombre científico del pingüino.
     * @param habitat Hábitat del pingüino.
     * @param descripcion Descripción del pingüino.
     * @param alimentacion Alimentación del pingüino.
     * @param tamaño Tamaño del pingüino.
     * @param peso Peso del pingüino.
     * @param caracteristicas Características adicionales del pingüino.
     */
    public Pinguins(String nome, String nomeCientifico, String habitat, String descripcion, String alimentacion, String tamaño, String peso, String caracteristicas) {
        this.nome = nome;
        this.nomeCientifico = nomeCientifico;
        this.habitat = habitat;
        this.descripcion = descripcion;
        this.alimentacion = alimentacion;
        this.tamaño = tamaño;
        this.peso = peso;
        this.caracteristicas = caracteristicas;
    }



    public Pinguins() {

    }


    //getter y setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "\nPinguins: " +
                "\nnome: " + nome +
                "\nnomeCientifico: " + nomeCientifico +
                "\nhabitat: " + habitat +
                "\ndescripcion: " + descripcion +
                "\nalimentacion: " + alimentacion +
                "\ntamaño: " + tamaño +
                "\npeso: " + peso +
                "\ncaracteristicas: " + caracteristicas;
    }
}
