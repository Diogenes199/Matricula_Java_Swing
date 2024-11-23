package Controlador;

import Controlador.Servicios.RolService;
import Modelo.Entidades.Rol;
import java.util.List;

public class RolControlador {

    RolService service = new RolService();

    public boolean create(Rol rol) {
        return service.save(rol);
    }

    public boolean update(Rol rol) {
        return service.update(rol);
    }

    public void delete(String id) {
        service.delete(id);
    }

    public List<Rol> getAll() {
        return service.getAll();
    }

    public List<Rol> getNames(String role) {
        return service.getNames(role);
    }

    public Rol getOne(String id) {
        return service.getOne(id);
    }

    public String newCode() {
        return service.newCode();
    }
}
