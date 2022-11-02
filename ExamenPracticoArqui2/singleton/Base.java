package singleton;
import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

/* Singleton  Unico punto de acceso para la informacion necesitad*/

public class Base {

    private static Base instancia = new Base();
    private List<Cliente> clientes;

    Base(){
        clientes = new ArrayList<>();
    }

    public static Base getInstancia(){
        return  instancia;
    }

    public Cliente obtenerCliente(int i){
        return clientes.get(i);
    }

    public void agregarCliente(Cliente c){
        clientes.add(c);
    }

    public Cliente obtenerPorClabe(int numeroCliente){
        for (Cliente c: clientes){
            if(c.getNumeroCliente() == numeroCliente){
                return c;
            }
        }
        return null;
    }

    public void actualizarMonto(int i, double monto){
        Cliente cuenta = obtenerCliente(i);
        if (cuenta != null){
            cuenta.setCantidadMonto(monto);
        }
    }

    public void eliminarCliente(int i){
        clientes.remove(i);
    }
}
