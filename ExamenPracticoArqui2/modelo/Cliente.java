package modelo;

public class Cliente {
    private double monto;
    private String n;
    private int clabeDeCuenta;

    public double getCantidadMonto() {
        return monto;
    }

    public void setCantidadMonto(double monto) {
        this.monto = monto;
    }

    public String getName() {
        return n;
    }

    public void setName(String n) {
        this.n = n;
    }

    public int getClabeDeCuenta() {
        return clabeDeCuenta;
    }

    public void setClabeDeCuenta(int clabeDeCuenta) {
        this.clabeDeCuenta = clabeDeCuenta;
    }


}
