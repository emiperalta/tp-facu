package dtos;

public class DTOListadoProgramasFinales {
    private String nombrePrograma;
    private String descripcion;
    private int descargas;
    private boolean disponible;
    private String temaPrograma;
    private String nombreAlumno;

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
    public String getTemaPrograma() {
        return temaPrograma;
    }
    public void setTemaPrograma(String temaPrograma) {
        this.temaPrograma = temaPrograma;
    }
    public String getNombreAlumno() {
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }    

    public DTOListadoProgramasFinales(String nombrePrograma, String descripcion, int descargas, boolean disponible, String temaPrograma, String nombreAlumno) {
        this.nombrePrograma = nombrePrograma;
        this.descripcion = descripcion;
        this.descargas = descargas;
        this.disponible = disponible;
        this.temaPrograma = temaPrograma;
        this.nombreAlumno = nombreAlumno;
    }    
}
