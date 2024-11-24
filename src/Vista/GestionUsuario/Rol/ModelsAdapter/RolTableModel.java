package Vista.GestionUsuario.Rol.ModelsAdapter;

import Controlador.Controladores.RolControlador;
import Modelo.Entidades.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RolTableModel extends AbstractTableModel {
     private RolControlador controller;
    private List<Rol> getAll = new ArrayList<>();
    
    public RolTableModel(RolControlador controller) {
        this.controller=controller;
    }
    
    public void findAll() {
        getAll= controller.getAll();
    }
    
    public void finByIds(String id) {
        getAll= controller.getAll();
    }

    public void findByNameAndLastName(String data){
        getAll =  controller.getNames(data);
    }
     
      
    
    @Override
    public String getColumnName(int colum)
    {
        switch (colum)
        {
            case 0: return "CODIGO";
            case 1: return "ROL";            
            default: return "[no]";
        }
    }
    
    @Override
    public int getRowCount() {
        return getAll.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rol rol=getAll.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return rol.getId();
            case 1:return rol.getRol();            
            default: return "";
        }
    }
}
