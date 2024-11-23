package Controlador.Servicios;

import Modelo.DAO.Control.MasterDAO;
import Modelo.Entidades.Rol;
import Modelo.Interfaces.Control.IMaster;
import java.util.List;

public class RolService {

    private final IMaster dao = new MasterDAO();

    public List<Rol> getAll() {
        return dao.rolI().findAll();
    }

    public List<Rol> getNames(String role) {
        return dao.rolI().findNames(role);
    }

    public boolean save(Rol rol) {
        boolean message = false;
        if (rol!=null) {
            dao.rolI().create(rol);
            message = true;
        }

        return message;
    }

    public boolean update(Rol rol) {
        boolean message = true;
        dao.rolI().update(rol);
        return message;
    }

    public Rol getOne(String id) {
        return dao.rolI().findById(id);
    }

    public void delete(String id) {
        dao.rolI().delete(id);
    }

    public String newCode() {
        return dao.rolI().newCode();
    }
}
