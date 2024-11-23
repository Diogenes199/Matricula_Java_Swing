package Controlador;

import Controlador.Servicios.CursoService;
import Modelo.Entidades.Curso;
import java.util.List;

public class CursoControlador {
    CursoService service = new CursoService();
   

public boolean create(Curso  curso){
    return service.save(curso);
}

public boolean update(Curso curso){
    return service.update(curso);
}
public void delete(String id){
    service.delete(id);
}

public List<Curso> getAll(){
    return service.getAll();
}

public Curso getOne(String id){
    return service.getOne(id);
}

public String newCode(){
    return service.newCode();
}

    public List<Curso> getCurses(String curse) {
        return service.getCurses(curse);
    }
}
