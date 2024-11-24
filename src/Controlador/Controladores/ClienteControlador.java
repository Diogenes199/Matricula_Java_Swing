package Controlador.Controladores;

import Controlador.Servicios.ClienteService;
import Modelo.Entidades.Cliente;
import java.util.List;

public class ClienteControlador {
    ClienteService service = new ClienteService();
   

public boolean create(Cliente  cliente){
    return service.save(cliente);
}

public boolean update(Cliente cliente){
    return service.update(cliente);
}
public void delete(String id){
    service.delete(id);
}

public List<Cliente> getAll(){
    return service.getAll();
}



public Cliente getOne(String id){
    return service.getOne(id);
}

public String newCode(){
    return service.newCode();
}    
}
