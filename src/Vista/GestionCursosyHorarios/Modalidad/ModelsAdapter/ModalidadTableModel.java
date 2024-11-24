package Vista.GestionCursosyHorarios.Modalidad.ModelsAdapter;

import Controlador.ModalidadControlador;
import Modelo.Entidades.Modalidad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ModalidadTableModel extends AbstractTableModel {

    private final ModalidadControlador Controller;
    private List<Modalidad> getAll;

    public ModalidadTableModel(ModalidadControlador Controller) {
        this.Controller = Controller;
        this.getAll();
    }
    
    public void getAll() {
        getAll = Controller.getAll();
    }
    
    public void getOne(String id){
       Modalidad getIdCurse = Controller.getOne(id);
       if(getIdCurse!=null){
        getAll = new ArrayList<>();
        getAll.add(getIdCurse);
       }else{
       getAll = null;
       }
    }
    
      public void getModalidades(String curse) {
        getAll = Controller.getModalidades(curse);
    }
    
    @Override
    public String getColumnName(int colum) {
        if(getAll != null){
            return switch (colum) {
                case 0 -> "CODIGO";
                case 1 -> "MODALIDAD";
                default -> "[no]";
            };
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
        return 2;
        }else{
            return 1;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
       
      if(getAll !=null){
           Modalidad modalidad = getAll.get(i);
          return switch (i1) {
              case 0 -> modalidad.getId()!=null?modalidad.getId():"";
              case 1 -> modalidad.getDescripcion()!=null?modalidad.getDescripcion():"";
              default -> "";
          };
      }else{
          return "MODALIDAD NO ENCONTRADO";
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
