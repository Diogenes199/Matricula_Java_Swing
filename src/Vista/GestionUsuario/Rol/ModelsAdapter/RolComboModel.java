package Vista.GestionUsuario.Rol.ModelsAdapter;

import Vista.GestionUsuario.Rol.ModelsAdapter.AdapterRolView;
import Controlador.Controladores.RolControlador;
import Modelo.Entidades.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class RolComboModel extends DefaultComboBoxModel<AdapterRolView> {
    private RolControlador Irol;
    private List<Rol> lista_rol;

    public RolComboModel(RolControlador Irol) {
        this.Irol = Irol;
        lista_rol= new ArrayList<>();
    }
    
    public void updateCombo() 
    {
        if(Irol!=null){
        lista_rol =Irol.getAll();
        removeAllElements();
        for(Rol data_rol:lista_rol)
        {
            addElement(new AdapterRolView(data_rol));
        }
        }
    }
    public List<AdapterRolView> getRoles() {
    List<AdapterRolView> rols = new ArrayList<>();
    int size = getSize();

    for (int i = 0; i < size; i++) {
        AdapterRolView rol = getElementAt(i);
       rols.add(rol);
    }
        
    return rols;
}

}
