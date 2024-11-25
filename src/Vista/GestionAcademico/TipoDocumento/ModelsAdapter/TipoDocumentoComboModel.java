package Vista.GestionAcademico.TipoDocumento.ModelsAdapter;

import Controlador.Controladores.TipoDocumentoControlador;
import Modelo.Entidades.TipoDocumento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class TipoDocumentoComboModel extends DefaultComboBoxModel<AdapterTipoDocumentoView>{
    private TipoDocumentoControlador controlador;
    private List<TipoDocumento> list;

    public TipoDocumentoComboModel(TipoDocumentoControlador controlador) {
        this.controlador = controlador;
        list = new ArrayList<>();
    }
    
     public void updateCombo() 
    {
        if(controlador!=null){
        list =controlador.getAll();
        removeAllElements();
        for(TipoDocumento get:list)
        {
            addElement(new AdapterTipoDocumentoView(get));
        }
        }
    }
    public List<AdapterTipoDocumentoView> getValue() {
    List<AdapterTipoDocumentoView> obtenido = new ArrayList<>();
    int size = getSize();

    for (int i = 0; i < size; i++) {
        AdapterTipoDocumentoView get = getElementAt(i);
       obtenido.add(get);
    }
        
    return obtenido;
}
    
    
    
}
