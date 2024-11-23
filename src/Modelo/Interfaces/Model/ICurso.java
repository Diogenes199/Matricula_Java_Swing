package Modelo.Interfaces.Model;

import Modelo.Entidades.Curso;
import Modelo.Interfaces.Repository.IRepositoryDAO;
import java.util.List;

public interface ICurso extends IRepositoryDAO<Curso>{

    public String newCode();

    public List<Curso> findByCurses(String curse);
    
}
