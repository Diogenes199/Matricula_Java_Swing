package Controlador.Servicios;

import Modelo.DAO.Control.MasterDAO;
import Modelo.Entidades.Horario;
import Modelo.Interfaces.Control.IMaster;
import java.util.List;

public class HorarioService {
     private final IMaster dao = new MasterDAO();

    public List<Horario> getAll() {
        return dao.horarioI().findAll();
    }

    public boolean save(Horario horario) {
        boolean message = false;
        if (horario != null) {
            dao.horarioI().create(horario);
            message = true;
        }

        return message;
    }

    public boolean update(Horario horario) {
        boolean message = true;
        dao.horarioI().update(horario);
        return message;
    }

    public Horario getOne(String id) {
        return dao.horarioI().findById(id);
    }

    public void delete(String id) {
        dao.horarioI().delete(id);
    }

    public String newCode() {
        return dao.horarioI().newCode();
    }

    public List<Horario> getHorarios(String curse) {
        return dao.horarioI().findByHorarios(curse);
    } 
}
