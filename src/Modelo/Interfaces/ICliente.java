package Modelo.Interfaces;

import Modelo.Entidades.Cliente;

public interface ICliente extends IRepositoryDAO<Cliente>{
    String newCode();
    
}
