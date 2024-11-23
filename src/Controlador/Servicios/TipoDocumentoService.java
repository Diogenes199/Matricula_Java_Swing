package Controlador.Servicios;

import Modelo.DAO.Control.MasterDAO;
import Modelo.Entidades.TipoDocumento;
import Modelo.Interfaces.Control.IMaster;
import java.util.List;

public class TipoDocumentoService {

    private final IMaster dao = new MasterDAO();

    public List<TipoDocumento> getAll() {
        return dao.documentoI().findAll();
    }

    public boolean save(TipoDocumento documento) {
        boolean message = false;
        if (documento != null) {
            dao.documentoI().create(documento);
            message = true;
        }

        return message;
    }

    public boolean update(TipoDocumento documento) {
        boolean message = true;
        dao.documentoI().update(documento);
        return message;
    }

    public TipoDocumento getOne(String id) {
        return dao.documentoI().findById(id);
    }

    public void delete(String id) {
        dao.documentoI().delete(id);
    }

    public String newCode() {
        return dao.documentoI().newCode();
    }
}
