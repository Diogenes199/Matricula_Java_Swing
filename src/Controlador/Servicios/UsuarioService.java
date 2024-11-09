package Controlador.Servicios;

import Modelo.DAO.UsuarioDAO;
import Modelo.Entidades.Usuario;

public class UsuarioService {

    private UsuarioDAO accesodao = new UsuarioDAO();

    public boolean isAcceso(Usuario acceso) {
    
                   return !acceso.getUsuario().isEmpty() || !acceso.getContra().isEmpty() ? accesodao.findByUser(acceso):false;    
        }
       
}
