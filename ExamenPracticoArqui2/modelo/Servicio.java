package modelo;
import servicios.Banco;
import servicios.Movimiento;

public class Servicio {
    private String n;
    private int ClabeCuenta;
    private int revisarCuenta;
    private Banco bancNo;
    private Movimiento movimiento;
    private double monto;

    public String getName() {
        return n;
    }

    public void setName(String n) {
        this.n = n;
    }

    public int getClabeCuenta() {
        return ClabeCuenta;
    }

    public void setClabeCuenta(int ClabeCuenta) {
        this.ClabeCuenta = ClabeCuenta;
    }

    public int getRevisarCuentas() {
        return revisarCuenta;
    }

    public void setRevisarCuenta(int revisarCuenta) {
        this.revisarCuenta = revisarCuenta;
    }

    public Banco getBancoNo() {
        return bancNo;
    }

    public void setBancoNo(Banco bancNo) {
        this.bancNo = bancNo;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public double getCantidadMonto() {
        return monto;
    }

    public void setCantidadMonto(double monto) {
        this.monto = monto;
    }
}
