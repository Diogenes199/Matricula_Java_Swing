package Controlador.Controladores;

import Controlador.Servicios.TipoDocumentoService;
import Modelo.Entidades.TipoDocumento;
import java.util.List;

public class TipoDocumentoControlador {
    TipoDocumentoService service = new TipoDocumentoService();
   

public boolean create(TipoDocumento  documento){
    return service.save(documento);
}

public boolean update(TipoDocumento documento){
    return service.update(documento);
}
public void delete(String id){
    service.delete(id);
}

public List<TipoDocumento> getAll(){
    return service.getAll();
}


public TipoDocumento getOne(String id){
    return service.getOne(id);
}

public String newCode(){
    return service.newCode();
}
}
