package Controlador.Servicios;

import Modelo.DAO.Control.MasterDAO;
import Modelo.Entidades.Curso;
import Modelo.Interfaces.Control.IMaster;
import java.util.List;

public class CursoService {
    
     private final IMaster dao = new MasterDAO();

    public List<Curso> getAll() {
        return dao.cursoI().findAll();
    }

    public boolean save(Curso curso) {
        boolean message = false;
        if (curso != null) {
            dao.cursoI().create(curso);
            message = true;
        }

        return message;
    }

    public boolean update(Curso curso) {
        boolean message = true;
        dao.cursoI().update(curso);
        return message;
    }

    public Curso getOne(String id) {
        return dao.cursoI().findById(id);
    }

    public void delete(String id) {
        dao.cursoI().delete(id);
    }

    public String newCode() {
        return dao.cursoI().newCode();
    }

    public List<Curso> getCurses(String curse) {
        return dao.cursoI().findByCurses(curse);
    }
}
