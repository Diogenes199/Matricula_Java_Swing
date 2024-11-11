package Vista.GestionUsuario.Usuario.ModelsAdapter;

import Controlador.UsuarioControlador;
import Modelo.Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel {
     private UsuarioControlador usuarioController;
    private List<Usuario> getAll = new ArrayList<>();
    
    public UsuarioTableModel(UsuarioControlador usuarioController) {
        this.usuarioController=usuarioController;
    }
    
    public void findAll() {
        getAll= usuarioController.getAll();
    }
    
    public void findByIdAll(String id){
        getAll =  usuarioController.getByIds(id);
    }
    
    public void findByNameAndLastName(String data){
        getAll =  usuarioController.getNames(data);
    }
    
    public void findByRol(String rol) {
        getAll =  usuarioController.getRoles(rol);
    }
      
    
    @Override
    public String getColumnName(int colum)
    {
        switch (colum)
        {
            case 0: return "CODIGO";
            case 1: return "NOMBRE";
            case 2: return "APELLIDOS";
            case 3: return "TELEFONO";
            case 4: return "DIRECCION";
            case 5: return "ROL";            
            default: return "[no]";
        }
    }
    
    @Override
    public int getRowCount() {
        return getAll.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario=getAll.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return usuario.getId();
            case 1:return usuario.getNombre();
            case 2:return usuario .getPaterno() +", "+ usuario.getMaterno() ;
            case 3:return usuario.getCelular1();
            case 4:return usuario.getDireccion();
            case 5:return usuario.getRol().getRol();            
            default: return "";
        }
    }
}
