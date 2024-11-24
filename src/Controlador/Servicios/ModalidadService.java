package Controlador.Servicios;

import Modelo.DAO.Control.MasterDAO;
import Modelo.Entidades.Modalidad;
import Modelo.Interfaces.Control.IMaster;
import java.util.List;

public class ModalidadService {
    private final IMaster dao = new MasterDAO();

    public List<Modalidad> getAll() {
        return dao.modalidadI().findAll();
    }

    public List<Modalidad> getNames(String modalidad) {
        return dao.modalidadI().findNames(modalidad);
    }

    public boolean save(Modalidad modalidad) {
        boolean message = false;
        if (modalidad!=null) {
            dao.modalidadI().create(modalidad);
            message = true;
        }

        return message;
    }

    public boolean update(Modalidad modalidad) {
        boolean message = true;
        dao.modalidadI().update(modalidad);
        return message;
    }

    public Modalidad getOne(String id) {
        return dao.modalidadI().findById(id);
    }

    public void delete(String id) {
        dao.modalidadI().delete(id);
    }

    public String newCode() {
        return dao.modalidadI().newCode();
    }
}
