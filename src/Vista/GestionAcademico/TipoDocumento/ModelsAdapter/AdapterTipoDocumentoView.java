package Vista.GestionAcademico.TipoDocumento.ModelsAdapter;

import Modelo.Entidades.TipoDocumento;
import java.util.Objects;

public class AdapterTipoDocumentoView {
    private TipoDocumento documento;

    public AdapterTipoDocumentoView(TipoDocumento documento) {
        this.documento = documento;
    }

    public TipoDocumento getDocumento() {
        return documento;
    }

    public void setDocumento(TipoDocumento documento) {
        this.documento = documento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.documento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdapterTipoDocumentoView other = (AdapterTipoDocumentoView) obj;
        return Objects.equals(this.documento, other.documento);
    }

    @Override
    public String toString() {
        return documento.getDescripcion();
    }
    
    
}
