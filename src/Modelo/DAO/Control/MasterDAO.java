package Modelo.DAO.Control;

import Modelo.DAO.Model.*;
import Modelo.Interfaces.Model.*;
import Modelo.Interfaces.Control.IMaster;


public class MasterDAO implements IMaster{

    private ICliente clienteI = null;
    private ICurso cursoI = null;
    private IHorario horarioI = null;
    private IMatricula matriculaI = null;
    private IModalidad modalidadI = null;
    private IPago pagoI = null;
    private IRol rolI = null;
    private ITipoComprobante comprobanteI = null;
    private ITipoDocumento documentoI = null;
    private IUsuario usuarioI = null;

    public MasterDAO() {
    
    }
    
    @Override
    public ICliente clienteI() {
       return clienteI == null?clienteI = new ClienteDAO():clienteI;
    }

    @Override
    public ICurso cursoI() {
       return cursoI == null?cursoI = new CursoDAO():cursoI;
    }

    @Override
    public IHorario horarioI() {
        return horarioI == null?horarioI = new HorarioDAO():horarioI;
    }

    @Override
    public IMatricula matriculaI() {
       return matriculaI == null ? matriculaI = new MatriculaDAO():matriculaI;
    }

    @Override
    public IModalidad modalidadI() {
       return modalidadI == null ? modalidadI = new ModalidadDAO():modalidadI; 
    }

    @Override
    public IPago pagoI() {
        return pagoI == null ? pagoI = new PagoDAO():pagoI;
    }

    @Override
    public IRol rolI() {
        return rolI == null ? rolI = new RolDAO():rolI;
    }

    @Override
    public ITipoComprobante comprobanteI() {
        return comprobanteI == null ? comprobanteI= new TipoComprobanteDAO():comprobanteI;
    }

    @Override
    public ITipoDocumento documentoI() {
        return documentoI == null ? documentoI= new TipoDocumentoDAO():documentoI;
    }

    @Override
    public IUsuario usuarioI() {
        return usuarioI==null ? usuarioI = new UsuarioDAO() : usuarioI;
    }
}
