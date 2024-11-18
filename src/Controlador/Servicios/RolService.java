
package Controlador.Servicios;

import Modelo.DAO.RolDAO;
import Modelo.Entidades.Rol;
import java.util.List;

public class RolService {
    
     private RolDAO dao = new RolDAO();
    public List<Rol> getAll(){
        return dao.findAll();
    }
    
    public List<Rol> getNames(String role){
        return dao.findNames(role);
    }
    
    public boolean save(Rol rol){
        boolean message = false;      
        if(!rol.getId().trim().isEmpty() && !rol.getRol().trim().isEmpty() ){
        dao.create(rol);
       message = true;
        }
        
        return message;
    }
    
    public boolean update(Rol rol){
        boolean message = true;      
        dao.update(rol);
        return message;
    }
    
    public Rol getOne(String id){
    return     dao.findById(id);
    }
    
    public void delete(String id){
        dao.delete(id);
    }

    public String newCode() {
         return dao.newCode();
    }
}
