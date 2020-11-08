package dtos;

public class DTODescargasProgramaFinal {
    private int idProgramaFinal;
    private int descargas;

    public DTODescargasProgramaFinal(int idProgramaFinal, int descargas) {
        this.idProgramaFinal = idProgramaFinal;
        this.descargas = descargas;
    }

    public int getIdProgramaFinal() {
        return idProgramaFinal;
    }
    public void setIdProgramaFinal(int idProgramaFinal) {
        this.idProgramaFinal = idProgramaFinal;
    }
    public int getDescargas() {
        return descargas;
    }
    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }
}
