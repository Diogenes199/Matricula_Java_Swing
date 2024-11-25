package Vista.GestionAcademico.Estudiante.ModelsAdapter;

import Controlador.Controladores.ClienteControlador;
import Modelo.Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;


public class ClienteTableModel extends AbstractTableModel {
     private ClienteControlador controller;
     
    private List<Cliente> getAll = null;
    
    public ClienteTableModel(ClienteControlador controller) {
           this.controller = controller;
        this.getAll();
    }
    
    public void getAll() {
        getAll = controller.getAll();
    }
    
    public void getOne(String id){
       Cliente getId = controller.getOne(id);
       if(getId!=null){
        getAll = new ArrayList<>();
        getAll.add(getId);
       }else{
       getAll = null;
       }
    }
    
      public void getType(String curse) {
//        getAll = controller.getN(curse);
    }
    
    @Override
    public String getColumnName(int colum) {
        if(getAll != null){
        switch (colum) {
            case 0:
                return "CODIGO";
            case 1:
                return "NOMBRE";
            case 2:
                return "PATERNO";
            case 3:
                return "MATERNO";            
            default:
                return "[no]";
        }
        }else{
            return "MESSAGE";
        }
    }
    
    @Override
    public int getRowCount() {
        if(getAll!=null){
        return getAll.size();
        }else{
            return 1;
        }
    }

    @Override
    public int getColumnCount() {
         if(getAll!=null){
        return 4;
        }else{
            return 1;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
       
      if(getAll !=null){
          Cliente cliente = getAll.get(i);
        switch (i1) {
            case 0:
                return cliente.getId()!=null?cliente.getId():"";
            case 1:
                return cliente.getNombre()!=null?cliente.getNombre():"";
            case 2:
                return cliente.getPaterno()!=null?cliente.getPaterno():"";
            case 3:
                return cliente.getMaterno()!=null?cliente.getMaterno():"";
            default:
                return "";
        }
      }else{
          return "\tCURSO NO ENCONTRADO";
      }
    }
    
     @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;  // Asegura que todos los valores sean tratados como String para facilitar la alineación
    }

    public void centrarContenido(JTable table) {

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

//        TableColumn column;
//        for (int i = 0; i < getColumnCount(); i++) {
            /*column =*/ table.getColumnModel().getColumn(0).setCellRenderer(renderer);
//            switch (i) {
//                case 0 -> column.setCellRenderer(renderer);
//            }
//        }
    }
    
     public void ajustarTamanioColumnas(JTable table) {
        TableColumn column;
        for (int i = 0; i < getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            switch (i) {
                case 0 -> column.setPreferredWidth(100);
                case 1 -> column.setPreferredWidth(200);
                case 2 -> column.setPreferredWidth(150);
                case 3 -> column.setPreferredWidth(150);
                default -> column.setPreferredWidth(100);
            }
            column.setResizable(false);
            table.getTableHeader().setReorderingAllowed(false) ;
        }
    }
}