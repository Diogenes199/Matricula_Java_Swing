package Controlador.Servicios;

import Modelo.DAO.ClienteDAO;
import Modelo.Entidades.Cliente;
import java.util.List;

public class ClienteService {
  private ClienteDAO dao = new ClienteDAO();
    public List<Cliente> getAll(){
        return dao.findAll();
    }
    
    
    public boolean save(Cliente cliente){
        boolean message = false;      
        if(cliente != null){
        dao.create(cliente);
       message = true;
        }
        
        return message;
    }
    
    public boolean update(Cliente cliente){
        boolean message = true;      
        dao.update(cliente);
        return message;
    }
    
    public Cliente getOne(String id){
    return     dao.findById(id);
    }
    
    public void delete(String id){
        dao.delete(id);
    }

    public String newCode() {
         return dao.newCode();
    }    
}
