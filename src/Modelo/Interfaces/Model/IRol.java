package Modelo.Interfaces.Model;

import Modelo.Interfaces.Repository.IRepositoryDAO;
import Modelo.Entidades.Rol;
import java.util.List;




public interface IRol extends IRepositoryDAO<Rol>{
    List<Rol> findNames(String role);
    String  newCode();
}
