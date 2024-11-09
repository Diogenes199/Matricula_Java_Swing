package Modelo.Interfaces;

import Modelo.Entidades.Usuario;

public interface IUsuario extends IRepositoryDAO<Usuario>{
    
    boolean findByUser(Usuario usuario);
    
}
