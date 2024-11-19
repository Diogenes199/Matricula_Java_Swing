package Controlador.Servicios;

import Modelo.DAO.TipoDocumentoDAO;
import Modelo.Entidades.TipoDocumento;
import java.util.List;

public class TipoDocumentoService {
     
     private TipoDocumentoDAO dao = new TipoDocumentoDAO();
    public List<TipoDocumento> getAll(){
        return dao.findAll();
    }
    
  
    public boolean save(TipoDocumento documento){
        boolean message = false;      
        if(documento!=null ){
        dao.create(documento);
       message = true;
        }
        
        return message;
    }
    
    public boolean update(TipoDocumento documento){
        boolean message = true;      
        dao.update(documento);
        return message;
    }
    
    public TipoDocumento getOne(String id){
        return dao.findById(id);
    }
    
    public void delete(String id){
        dao.delete(id);
    }

    public String newCode() {
         return dao.newCode();
    }
}
