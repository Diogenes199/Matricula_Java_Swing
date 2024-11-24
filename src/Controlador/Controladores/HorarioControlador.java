package Controlador.Controladores;

import Controlador.Servicios.HorarioService;
import Modelo.Entidades.Horario;
import java.util.List;

public class HorarioControlador {
    private final HorarioService service = new HorarioService();
   

public boolean create(Horario  horario){
    return service.save(horario);
}

public boolean update(Horario  horario){
    return service.update(horario);
}
public void delete(String id){
    service.delete(id);
}

public List<Horario> getAll(){
    return service.getAll();
}

public Horario getOne(String id){
    return service.getOne(id);
}

public String newCode(){
    return service.newCode();
}

    public List<Horario> getHorarios(String hora) {
        return service.getHorarios(hora);
    }
}
