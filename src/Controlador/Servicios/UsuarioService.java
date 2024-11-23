package Controlador.Servicios;

import Modelo.DAO.Control.MasterDAO;
import Modelo.Entidades.Usuario;
import Modelo.Interfaces.Control.IMaster;
import java.util.List;

public class UsuarioService {

    private final IMaster dao = new MasterDAO();

    public boolean isAcceso(Usuario acceso) {
        return !acceso.getUsuario().isEmpty() || !acceso.getContra().isEmpty() ? dao.usuarioI().findByUser(acceso) : false;
    }

    public List<Usuario> getAll() {
        return dao.usuarioI().findAll();
    }

    public List<Usuario> getIds(String id) {
        return dao.usuarioI().findByIdAll(id);
    }

    public List<Usuario> getNames(String id) {
        return dao.usuarioI().findByNameAndLastName(id);
    }

    public List<Usuario> getRoles(String id) {
        return dao.usuarioI().findByRol(id);
    }

    public boolean save(Usuario usuario) {

        boolean message = false;
        if (usuario !=null) {
            dao.usuarioI().create(usuario);
            message = true;
        }

        return message;

    }

    public boolean update(Usuario usuario) {
        boolean message = true;
        dao.usuarioI().update(usuario);
        return message;
    }

    public Usuario getOne(String id) {
        return dao.usuarioI().findById(id);
    }

    public void delete(String id) {
        dao.usuarioI().delete(id);
    }

    public String newCode() {
        return dao.usuarioI().newCode();
    }

}
