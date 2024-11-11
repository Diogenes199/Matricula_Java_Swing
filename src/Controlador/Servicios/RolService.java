
package Controlador.Servicios;

import Modelo.DAO.RolDAO;
import Modelo.Entidades.Rol;
import java.util.List;

public class RolService {
    
     private RolDAO dao = new RolDAO();
    public List<Rol> getAll(){
        return dao.findAll();
    }
    
    public void save(Rol rol){
        dao.create(rol);
    }
    
    public void update(Rol rol){
        dao.update(rol);
    }
    
    public Rol getOne(String id){
    return     dao.findById(id);
    }
    
    public void delete(String id){
        dao.delete(id);
    }
}
