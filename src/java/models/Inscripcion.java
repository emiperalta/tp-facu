package models;

public class Inscripcion {
    private int idInscripcion;
    private Alumno alumno;
    private Curso curso;
    private Descuento descuento;
    private String fechaInicio;
    private String fechaFin;
    private double monto;
    private double montoDescuento;

    public Inscripcion(int idInscripcion, Alumno alumno, Curso curso, Descuento descuento, String fechaInicio, String fechaFin, double monto, double montoDescuento) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.curso = curso;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.montoDescuento = montoDescuento;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }
    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }
    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Descuento getDescuento() {
        return descuento;
    }
    public void setDescuent(Descuento descuento) {
        this.descuento = descuento;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public double getMontoDescuento() {
        return montoDescuento;
    }
    public void setMontoDescuento(double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    @Override
    public String toString() {
        return "ID: " + idInscripcion + ", Alumno: " + alumno.getNombre() + " " + alumno.getApellido() +
                ", Curso: " + curso.getTema() + ", Descuento: %" + descuento.getPorcentaje() +
                ", Fecha de inicio: " + fechaInicio + ", Fecha de finalización: " + fechaFin + 
                ", Monto: $" + monto + ", Monto del descuento aplicado: " + montoDescuento;
    }    
}
