package Modelo.Interfaces;

import Modelo.Entidades.Rol;
import java.util.List;




public interface IRol extends IRepositoryDAO<Rol>{
    List<Rol> findNames(String role);
    String  newCode();
}
