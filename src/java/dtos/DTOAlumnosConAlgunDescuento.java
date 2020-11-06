package dtos;

public class DTOAlumnosConAlgunDescuento {
    private int idAlumno;
    private String nombreCompleto;
    private String dni;

    public DTOAlumnosConAlgunDescuento(int idAlumno, String nombreCompleto, String dni) {
        this.idAlumno = idAlumno;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
    }

    public int getIdAlumno() {
        return idAlumno;
    }
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "ID: " + idAlumno + ", Nombre completo = " + nombreCompleto + ", DNI = " + dni;
    }
}
