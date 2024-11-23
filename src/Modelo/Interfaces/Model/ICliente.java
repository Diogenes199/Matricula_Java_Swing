package Modelo.Interfaces.Model;

import Modelo.Interfaces.Repository.IRepositoryDAO;
import Modelo.Entidades.Cliente;

public interface ICliente extends IRepositoryDAO<Cliente>{
    String newCode();
    
}
