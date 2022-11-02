import modelo.Cajero;
import modelo.Servicio;
import modelo.Banquero;
import servicios.Banco;
import servicios.Movimiento;

import java.util.Scanner;

public class Menu {

    public static void start(){
        while (true){
            Servicio req = new Servicio();
            req = Donde(req);
            req = queOperacion(req);
        }
    }

    private static Servicio Donde(Servicio req){
        int opc;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escoja un Banco ingresando la letra en Mayusculas (En caso de necesitar la opcion sucursal pon la opcion en mayusculas)");
        System.out.println("Banco A ");
        System.out.println("Banco B");
        System.out.println("Banco C");
        System.out.println("Sucursal");

        
        opc = scanner.nextInt();
        switch (opc){
            case 1:
                req.setBancoNo(Banco.A);
                break;
            case 2:
                req.setBancoNo(Banco.B);
                break;
            case 3:
                req.setBancoNo(Banco.C);
                break;
            case 4:
                req.setBancoNo(Banco.SUCURSAL);
                break;
            default:
                System.out.println("No existe esa opcion");
                break;
        }
    
    }

    private static Servicio queOperacion(Servicio req){
        int opc;
        double monto;
        String n;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Que desea hacer? (porfavor solo ingrese el numero)");
        System.out.println("1.- Ingresar cliente");
        System.out.println("2.- Depositar un monto");
        System.out.println("3.- Sacar dinero");
        System.out.println("4.- Consultar mi monto");
        opc = scanner.nextInt();
        switch (opc){
            case 1:
                req.setMovimiento(Movimiento.HACER);
                System.out.println("Ingrese su accion deseada:");
                n = scanner.next();
                req.setName(n);
                break;
            case 2:
                req.setMovimiento(Movimiento.DEPOSITAR);
                req = auth(req);
                System.out.println("Cuanto va a ingresar:");
                monto = scanner.nextDouble();
                req.setCantidadMonto(monto);
                break;
            case 3:
                req.setMovimiento(Movimiento.SACAR);
            case 4:
                req.setMovimiento(Movimiento.REVISAR);
                req = auth(req);
                break;
            default:
                System.out.println("Error");
                break;
        }
        return req;
    }

    