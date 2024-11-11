package Controlador;

import Controlador.Servicios.RolService;
import Modelo.Entidades.Rol;
import java.util.List;


public class RolControlador {
     RolService service = new RolService();
   

public void create(Rol  rol){
    service.save(rol);
}

public void update(Rol rol){
    service.update(rol);
}
public void delete(String id){
    service.delete(id);
}

public List<Rol> getAll(){
    return service.getAll();
}

public Rol getOne(String id){
    return service.getOne(id);
}
}
