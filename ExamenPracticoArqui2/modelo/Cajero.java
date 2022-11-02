package modelo;
import cadena.Maneja;
import servicios.Banco;
import servicios.Servicios;
import servicios.Movimiento;

public class Cajero implements Maneja {
    private Banco bancoNo;
    private Maneja nextManeja;

    public Cajero(Banco bancoNo) {
        setBancoNo(bancoNo);
    }

    public Banco getBancoId() {
        return bancoNo;
    }

    public void setBancoNo(Banco bancoNo) {
        this.bancoNo = bancoNo;
    }

    @Override
    public void setN(Maneja m) {
        nextManeja = m;
    }

    @Override
    public void clienteAtencion(Servicio solicitud) {
        Servicios servicios = new Servicios();
        switch (solicitud.getMovimiento()){
            case REVISAR:
                if(solicitud.getClabeCuenta() == 0){
                    servicios.revisarCuentas(solicitud.getRevisarCuentas());
                }else{
                    servicios.consultarCuentaClabe(solicitud.getClabeCuenta());
                }
                break;

            case DEPOSITAR:
                servicios.depositar(solicitud.getRevisarCuentas(), solicitud.getCantidadMonto());
                break;
        }
    }
}
