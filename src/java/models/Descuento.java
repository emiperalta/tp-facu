package models;

public class Descuento {
    private int idDescuento;
    private double porcentaje;

    public Descuento(int idDescuento, double porcentaje) {
        this.idDescuento = idDescuento;
        this.porcentaje = porcentaje;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "ID: " + idDescuento + ", Porcentaje: %" + porcentaje;
    }
}
