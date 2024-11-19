package Modelo.Interfaces;

import Modelo.Entidades.TipoDocumento;

public interface ITipoDocumento extends IRepositoryDAO<TipoDocumento>{
    String newCode();
    
}
