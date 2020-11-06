package dtos;

public class DTOSumatoriaDescuentos {
    private double sumatoriaTotal;

    public DTOSumatoriaDescuentos(double sumatoriaTotal) {
        this.sumatoriaTotal = sumatoriaTotal;
    }

    public double getSumatoriaTotal() {
        return sumatoriaTotal;
    }
    public void setSumatoriaTotal(double sumatoriaTotal) {
        this.sumatoriaTotal = sumatoriaTotal;
    }

    @Override
    public String toString() {
        return "Sumatoria total = $" + sumatoriaTotal;
    }
}
