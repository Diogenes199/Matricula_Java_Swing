package Modelo.Interfaces.Model;

import Modelo.Interfaces.Repository.IRepositoryDAO;
import Modelo.Entidades.Usuario;
import java.sql.ResultSet;
import java.util.List;

public interface IUsuario extends IRepositoryDAO<Usuario>{
    
    boolean findByUser(Usuario usuario);
    List<Usuario>findByNameAndLastName(String id);
    List<Usuario>findByIdAll(String id);
    List<Usuario>findByRol(String id);
    String newCode();
    
}
