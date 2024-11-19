package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexion {
    private Connection conexion;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    Config.DRIVER+"://"+Config.URL+":"+Config.PORT+"/"+Config.BDNAME, 
                    Config.USERNAME,
                    Config.PASSWORD
            );
        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

  
}
