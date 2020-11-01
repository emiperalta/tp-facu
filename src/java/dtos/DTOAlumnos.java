package dtos;

public class DTOAlumnos {
    private int idAlumno;
    private String nombre;
    private String apellido;    
    private String dni;

    public DTOAlumnos(int idAlumno, String nombre, String apellido, String dni) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getIdAlumno() {
        return idAlumno;
    }
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "DTOAlumnos{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + '}';
    }    
}
