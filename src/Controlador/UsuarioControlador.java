package Controlador;

import Controlador.Servicios.UsuarioService;
import Modelo.Entidades.Usuario;

public class UsuarioControlador {
    
    UsuarioService serviceAcceso = new UsuarioService();
  
 
    
public boolean isAcceso(Usuario acceso){
    return  serviceAcceso.isAcceso(acceso);
}

}
