package Modelo.Interfaces.Model;

import Modelo.Interfaces.Repository.IRepositoryDAO;
import Modelo.Entidades.TipoDocumento;

public interface ITipoDocumento extends IRepositoryDAO<TipoDocumento>{
    String newCode();
    
}
