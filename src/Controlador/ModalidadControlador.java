package Controlador;

import Controlador.Servicios.ModalidadService;
import Modelo.Entidades.Modalidad;
import java.util.List;

public class ModalidadControlador {
    private final ModalidadService service = new ModalidadService();
    
    public boolean create(Modalidad modalidad) {
        return service.save(modalidad);
    }

    public boolean update(Modalidad modalidad) {
        return service.update(modalidad);
    }

    public void delete(String id) {
        service.delete(id);
    }

    public List<Modalidad> getAll() {
        return service.getAll();
    }

    public List<Modalidad> getModalidades(String role) {
        return service.getNames(role);
    }

    public Modalidad getOne(String id) {
        return service.getOne(id);
    }

    public String newCode() {
        return service.newCode();
    }
    
}
