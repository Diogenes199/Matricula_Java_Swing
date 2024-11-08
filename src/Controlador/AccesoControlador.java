package Controlador;

import Modelo.AccesoDAO;
import Modelo.Entidades.Acceso;

public class AccesoControlador {
    
    private AccesoDAO accesodao = new AccesoDAO();
  
 
    
public boolean isAcceso(Acceso acceso){
    return  accesodao.Verificacion_Acceso(acceso);
}

}
