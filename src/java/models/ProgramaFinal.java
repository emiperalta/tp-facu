package models;

public class ProgramaFinal {
    private int idProgramaFinal;
    private String nombrePrograma;
    private String descripcion;
    private int descargas;
    private boolean disponible;
    private Curso curso;
    private Alumno alumno;

    public ProgramaFinal(int idProgramaFinal, String nombrePrograma, String descripcion, int descargas, boolean disponible, Curso curso, Alumno alumno) {
        this.idProgramaFinal = idProgramaFinal;
        this.nombrePrograma = nombrePrograma;
        this.descripcion = descripcion;
        this.descargas = descargas;
        this.disponible = disponible;
        this.curso = curso;
        this.alumno = alumno;
    }

    public int getIdProgramaFinal() {
        return idProgramaFinal;
    }
    public void setIdProgramaFinal(int idProgramaFinal) {
        this.idProgramaFinal = idProgramaFinal;
    }
    public String getNombrePrograma() {
        return nombrePrograma;
    }
    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getDescargas() {
        return descargas;
    }
    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "ID: " + idProgramaFinal + ", Nombre del programa: " + nombrePrograma + ", Descripcion: " + descripcion + ", Descargas: " + descargas + ", Disponible: " + disponible + ", Curso: " + curso.getTema() + ", Alumno: " + alumno.getNombre() + " " + alumno.getApellido();
    }
}