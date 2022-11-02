package servicios;

import modelo.Cliente;
import singleton.Base;
import java.util.Random;

public class Servicios {

    private Cliente baseCuenta = Cliente.getInstancia();
    Random random = new Random();

    public void crearCliente(String n){
        Cliente cliente = new Cliente();
        cliente.setName(n);
        cliente.setClabeDeCuenta(random.nextInt(40000));
        cliente.setCantidadMonto(0.0);
        baseCuenta.agregarCliente(cliente);
        System.out.println("Cliente creado");
        consultarCuentaClabe(cliente.getClabeDeCuenta());
    }

    public void consultarCuentaClabe(int ClabeCuenta){
        Cliente cliente = baseCuenta.obtenerPorClabe(ClabeCuenta);
        System.out.println("DATOS");
        System.out.println("Numero de Clabe: "+cliente.getClabeDeCuenta());
        System.out.println("Nombre: "+cliente.getName());
        System.out.println("Cantidad: "+cliente.getCantidadMonto());
    }

    public void revisarCuentas(int i){
        Cliente cliente = baseCuenta.obtenerCliente(i);
        System.out.println("CUENTA INFO");
        System.out.println("Numero de Clabe: "+cliente.getClabeDeCuenta());
        System.out.println("Nombre: "+cliente.getName());
        System.out.println("Saldo: "+cliente.getCantidadMonto());
    }

    public void depositar(int i, double monto){
        Cliente cliente = baseCuenta.obtenerCliente(i);
        Double monto = cliente.getCantidadMonto() + monto;
        cliente.setCantidadMonto(monto);
        revisarCuentas(i);
        baseCuenta.actualizarMonto(i,monto);
        System.out.println("Proceso Exitoso");
    }

    public void sacar(int i, double monto,Banco banco){
        Cliente cliente = baseCuenta.obtenerCliente(i);
        double cargo =0;
        double monto= 0;
        double saca=0;
        switch (banco){
            case A:
                cargo = 30;
                break;
            case B:
                cargo = 15;
                break;
            case C:
                cargo = 10;
                break;
            case SUCURSAL:
                cargo = 0;
                break;
        }
        System.out.println("La cargo es " + cargo);
        saca = monto + cargo;
        if(cliente.getCantidadMonto() > saca){
            monto = cliente.getCantidadMonto();
            cliente.setCantidadMonto(monto);
            revisarCuentas(i);
            baseCuenta.actualizarMonto(i,monto);
            System.out.println("Proceso Exitoso");
        }else {
            System.out.println("POCO DINERO");
            revisarCuentas(i);
        }
    }
}
