package Controlador.Servicios;

import Modelo.DAO.Control.MasterDAO;
import Modelo.Entidades.Cliente;
import Modelo.Interfaces.Control.IMaster;
import java.util.List;

public class ClienteService {

    private final IMaster dao = new MasterDAO();

    public List<Cliente> getAll() {
        return dao.clienteI().findAll();
    }

    public boolean save(Cliente cliente) {
        boolean message = false;
        if (cliente != null) {
            dao.clienteI().create(cliente);
            message = true;
        }

        return message;
    }

    public boolean update(Cliente cliente) {
        boolean message = true;
        dao.clienteI().update(cliente);
        return message;
    }

    public Cliente getOne(String id) {
        return dao.clienteI().findById(id);
    }

    public void delete(String id) {
        dao.clienteI().delete(id);
    }

    public String newCode() {
        return dao.clienteI().newCode();
    }
}
