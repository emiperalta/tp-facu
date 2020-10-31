package models;

public class Curso {
    private int idCurso;
    private String tema;
    private String descripcion;
    private double costo;

    public Curso(int idCurso, String tema, String descripcion, double costo) {
        this.idCurso = idCurso;
        this.tema = tema;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "ID: " + idCurso + ", Tema: " + tema + ", Descripción: " + descripcion + ", Costo: $" + costo;
    } 
}
