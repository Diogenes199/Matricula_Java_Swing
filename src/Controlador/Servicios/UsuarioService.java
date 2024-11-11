package Controlador.Servicios;

import Modelo.DAO.UsuarioDAO;
import Modelo.Entidades.Usuario;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public boolean isAcceso(Usuario acceso) {
    
                   return !acceso.getUsuario().isEmpty() || !acceso.getContra().isEmpty() ? dao.findByUser(acceso):false;    
        }
    
    public List<Usuario> getAll(){
        return dao.findAll();
    }
    
    public List<Usuario> getIds(String id){
        return dao.findByIdAll(id);
    }
    
    public List<Usuario> getNames(String id){
        return dao.findByNameAndLastName(id);
    }
    
    public List<Usuario> getRoles(String id){
        return dao.findByRol(id);
    }
    
    public boolean save(Usuario usuario){
       
       boolean message = false;      
        if(!usuario.getDni().trim().isEmpty() && !usuario.getNombre().trim().isEmpty() && !usuario.getPaterno().trim().isEmpty() && !usuario.getMaterno().trim().isEmpty() && !usuario.getUsuario().trim().isEmpty() && !usuario.getContra().trim().isEmpty() && !usuario.getCelular1().trim().isEmpty() && !usuario.getRol().getId().trim().isEmpty() ){
        dao.create(usuario);
       message = true;
        }
        
        return message;
       
    }
    
    public boolean update(Usuario usuario){
        boolean message = true;      
        dao.update(usuario);
        return message;
    }
    
    public Usuario getOne(String id){
    return     dao.findById(id);
    }
    
    public void delete(String id){
        dao.delete(id);
    }
    
     public String newCode(){
        return dao.newCode();
    }
       
}
