package Modelo.Interfaces.Model;

import Modelo.Entidades.Modalidad;
import Modelo.Interfaces.Repository.IRepositoryDAO;
import java.util.List;

public interface IModalidad extends IRepositoryDAO<Modalidad>{

    public String newCode();

    public List<Modalidad> findNames(String modalidad);
    
}
