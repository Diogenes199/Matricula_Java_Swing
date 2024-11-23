package Modelo.Interfaces.Control;

import Modelo.Interfaces.Model.*;

public interface IMaster {
    ICliente clienteI();
    ICurso cursoI();
    IHorario horarioI();
    IMatricula matriculaI();
    IModalidad modalidadI();
    IPago pagoI();
    IRol rolI();
    ITipoComprobante comprobanteI();
    ITipoDocumento documentoI();
    IUsuario usuarioI();
    
}
