package Modelo.Interfaces.Model;

import Modelo.Entidades.Horario;
import Modelo.Interfaces.Repository.IRepositoryDAO;
import java.util.List;

public interface IHorario extends IRepositoryDAO<Horario>{

    public String newCode();

    public List<Horario> findByHorarios(String curse);
    
}
