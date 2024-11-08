package Modelo;
import Modelo.Entidades.Acceso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoDAO {
    
     private Connection conexion;
    
     private Conexion conn = new Conexion();
    public boolean Verificacion_Acceso(Acceso entidad) {
        String sql = "SELECT * FROM acceso WHERE usuario = ? AND contra = ?";
        conexion = conn.getConexion();
        try (
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, entidad.getUsuario());
            pstmt.setString(2, entidad.getContra());
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
