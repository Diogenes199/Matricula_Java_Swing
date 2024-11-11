package Vista.GestionUsuario.Rol;

import Modelo.Entidades.Rol;
import java.util.Objects;


public class AdapterRolView {
     private Rol rol;

    public AdapterRolView(Rol rol) {
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setMenu(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.rol);
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
        final AdapterRolView other = (AdapterRolView) obj;
        return Objects.equals(this.rol, other.rol);
    }

    @Override
    public String toString() {
        return rol.getRol();
    }
}
