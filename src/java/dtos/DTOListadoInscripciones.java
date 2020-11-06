package dtos;

public class DTOListadoInscripciones {
    private int idInscripcion;
    private String nombreAlumno;
    private String temaCurso;
    private int porcentajeDescuento;
    private String fechaInicio;
    private String fechaFin;
    private double monto;
    private double montoDescuento;

    public DTOListadoInscripciones(int idInscripcion, String nombreAlumno, String temaCurso, int porcentajeDescuento, String fechaInicio, String fechaFin, double monto, double montoDescuento) {
        this.idInscripcion = idInscripcion;
        this.nombreAlumno = nombreAlumno;
        this.temaCurso = temaCurso;
        this.porcentajeDescuento = porcentajeDescuento;
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
    public String getNombreAlumno() {
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    public String getTemaCurso() {
        return temaCurso;
    }
    public void setTemaCurso(String temaCurso) {
        this.temaCurso = temaCurso;
    }
    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
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
        return "ID = " + idInscripcion + ", Nombre del alumno = " + nombreAlumno + 
                ", Tema del curso = " + temaCurso + ", Porcentaje de descuento = %" + porcentajeDescuento +
                ", Fecha de inicio = " + fechaInicio + ", Fecha de finalización = " + fechaFin +
                ", Monto = $" + monto + ", Monto del descuento = $" + montoDescuento;
    }
}
