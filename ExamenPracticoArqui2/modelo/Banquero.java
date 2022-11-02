package modelo;
import cadena.Maneja;
import servicios.Banco;
import servicios.Servicios;

public class Banquero implements Maneja {
    private  Banco bancoNo;
    private Maneja nextManeja = null;

    public Banquero(Banco bancoNo){
        setBancoNo(bancoNo);
    }

    public void setBancoNo(Banco bancoNo) {
        this.bancoNo = bancoNo;
    }

    @Override
    public void setN(Maneja m) {
        nextManeja = m;
    }

    @Override
    public void maneja(Servicio solicitud) {
        solicitud.setBancoNo(this.bancoNo);
        clienteAtencion(solicitud);
    }

    @Override
    public void clienteAtencion(Servicio solicitud) {
        System.out.println("Necesita ayuda?");
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
            
            case SACAR:
                servicios.sacar(solicitud.getRevisarCuentas(), solicitud.getCantidadMonto(), solicitud.getBancoNo());
                break;

            case NUEVO:
                servicios.crearCliente(solicitud.getName());
                break;
                
        }
    }
}
