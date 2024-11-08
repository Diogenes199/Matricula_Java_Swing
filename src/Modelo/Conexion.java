package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexion {
    private Connection conexion;

    public Conexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_prototipo", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

  
}
