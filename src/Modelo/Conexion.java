package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexion {
    private Connection conexion;

    public Conexion() {
        try {
            conexion = DriverManager.getConnection(
                    Config.DRIVER+"://"+Config.URL+":"+Config.PORT+"/"+Config.BDNAME, 
                    Config.USERNAME,
                    Config.PASSWORD
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

  
}
