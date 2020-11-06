package dtos;

public class DTOTotalFacturadoPorCurso {
    private int idCurso;
    private String tema;
    private double totalFacturado;

    public DTOTotalFacturadoPorCurso(int idCurso, String tema, double totalFacturado) {
        this.idCurso = idCurso;
        this.tema = tema;
        this.totalFacturado = totalFacturado;
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
    public double getTotalFacturado() {
        return totalFacturado;
    }
    public void setTotalFacturado(double totalFacturado) {
        this.totalFacturado = totalFacturado;
    }    

    @Override
    public String toString() {
        return "ID = " + idCurso + ", Tema = " + tema + ", Total facturado = $" + totalFacturado;
    }
}
