package dtos;

public class DTOListadoProgramasFinales {
    private String nombrePrograma;
    private String descripcion;
    private int descargas;
    private boolean disponible;
    private String temaPrograma;
    private String nombreAlumno;
    private String filename;
    private String path;
    
    public DTOListadoProgramasFinales(String nombrePrograma, String descripcion, int descargas, boolean disponible, String temaPrograma, String nombreAlumno, String filename, String path) {
        this.nombrePrograma = nombrePrograma;
        this.descripcion = descripcion;
        this.descargas = descargas;
        this.disponible = disponible;
        this.temaPrograma = temaPrograma;
        this.nombreAlumno = nombreAlumno;
        this.filename = filename;
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
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
}
