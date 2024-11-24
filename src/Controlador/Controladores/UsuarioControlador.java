package Controlador.Controladores;

import Controlador.Servicios.UsuarioService;
import Modelo.Entidades.Usuario;
import java.util.List;

public class UsuarioControlador {
    
    UsuarioService serviceAcceso = new UsuarioService();
  
 
    
public boolean isAcceso(Usuario acceso){
    return  serviceAcceso.isAcceso(acceso);
}

public boolean create(Usuario usuario){
   return  serviceAcceso.save(usuario);
}

public boolean update(Usuario usuario){
    return serviceAcceso.update(usuario);
}
public void delete(String id){
    serviceAcceso.delete(id);
}

public List<Usuario> getAll(){
    return serviceAcceso.getAll();
}

public List<Usuario> getByIds(String id){
    return serviceAcceso.getIds(id);
}

public List<Usuario> getNames(String id){
    return serviceAcceso.getNames(id);
}

public List<Usuario> getRoles(String id){
    return serviceAcceso.getRoles(id);
}


public Usuario getOne(String id){
    return serviceAcceso.getOne(id);
}

public String newCode(){
    return serviceAcceso.newCode();
}


}
