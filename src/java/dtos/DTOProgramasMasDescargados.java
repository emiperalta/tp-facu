package dtos;

public class DTOProgramasMasDescargados {
    private String nombrePrograma;
    private int cantidadDescargas;

    public DTOProgramasMasDescargados(String nombrePrograma, int cantidadDescargas) {
        this.nombrePrograma = nombrePrograma;
        this.cantidadDescargas = cantidadDescargas;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }
    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }
    public int getCantidadDescargas() {
        return cantidadDescargas;
    }
    public void setCantidadDescargas(int cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    @Override
    public String toString() {
        return "Nombre del programa = " + nombrePrograma + ", Cantidad de descargas = " + cantidadDescargas;
    }
}
