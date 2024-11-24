package Vista.GestionAcademico.TipoDocumento.ModelsAdapter;

import Controlador.Controladores.TipoDocumentoControlador;
import Modelo.Entidades.TipoDocumento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TipoDocumentoTableModel extends AbstractTableModel {
     private TipoDocumentoControlador controller;
     
    private List<TipoDocumento> getAll = null;
    
    public TipoDocumentoTableModel(TipoDocumentoControlador controller) {
        this.controller=controller;
    }
    
    public void findAll() {
        getAll= controller.getAll();
    }
    
    public void finByIds(String id) {
        getAll= controller.getAll();
    }

      
      
    
    @Override
    public String getColumnName(int colum)
    {
        switch (colum)
        {
            case 0: return "CODIGO";
            case 1: return "DOCUMENTO";            
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
        TipoDocumento documento=getAll.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return documento.getId();
            case 1:return documento.getDescripcion();            
            default: return "";
        }
    }
}
