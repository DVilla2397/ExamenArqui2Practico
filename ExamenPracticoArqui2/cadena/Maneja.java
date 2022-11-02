package cadena;
import modelo.Servicio;

public interface Maneja {
    void setN(Maneja m);
    void maneja(Servicio solicitud);
    void clienteAtencion(Servicio solicitud);
}

/* Chain of Responsability - Lo usaremos porque su patrón nos ayuda a poder procesar la solicitud dada y pasarla al siguiente controlador en una cadena de controladores */