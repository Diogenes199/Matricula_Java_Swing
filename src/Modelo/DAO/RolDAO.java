package Modelo.DAO;

import Modelo.Conexion;
import Modelo.Entidades.Rol;
import Modelo.Interfaces.IRol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements IRol{

    private Connection conexion;    
     private Conexion conn = new Conexion();
    
    private String INSERT = "INSERT INTO roles(id_rol,nombre_rol) VALUES(?,?)";
     private String UPDATE = "UPDATE roles SET nombre_rol = ?  ";
     private String DELETE = "DELETE FROM roles ";
     private String GETALL = "SELECT id_rol, nombre_rol FROM roles ";
     private String GETONE = " WHERE id_rol = ?";
     private String GETROLES = " WHERE nombre_rol = ?";
      private String NEWCOD = "SELECT SUBSTRING(MAX(id_rol),3) FROM roles";
    
     private Rol  Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("id_rol");
          String nombre = resultado_data.getString("nombre_rol");
          
         
          Rol getRol =new Rol(id,nombre);
                    
          return getRol;
    }
     
     
    @Override
    public List<Rol> findAll() {
        PreparedStatement prepared = null;
       List<Rol> lista = new ArrayList<>();       
       ResultSet resultado_data = null;
       conexion = conn.getConexion();        
        try
        {
            prepared=conexion.prepareStatement(GETALL);
            resultado_data=prepared.executeQuery();
            
            while(resultado_data.next())
            {
              lista.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                System.out.println("ERROR : "+ ex.getMessage());
            }
        
        return lista;
    }

    @Override
    public void create(Rol rol) {
         PreparedStatement prepared = null;
         conexion = conn.getConexion();   
    try
    {
         prepared=conexion.prepareStatement(INSERT);
         
         prepared.setString(1,rol.getId());
         prepared.setString(2,rol.getRol());
          
         
            if(prepared.executeUpdate()==0)
                {
                    System.out.println("ERROR ");
                }
     
    }catch (SQLException ex) 
    {
        
          System.out.println("ERROR "+ ex.getMessage());
        
    }  
    }

    @Override
    public void update(Rol rol) {
           PreparedStatement prepared = null;
         conexion = conn.getConexion();   
    try
    {
         prepared=conexion.prepareStatement(UPDATE + GETONE);
         
         prepared.setString(1,rol.getRol());
         prepared.setString(2,rol.getId());
          
         
            if(prepared.executeUpdate()==0)
                {
                    System.out.println("ERROR ");
                }
     
    }catch (SQLException ex) 
    {
        
          System.out.println("ERROR "+ ex.getMessage());
        
    }  
    }

    @Override
    public void delete(String id) {
         PreparedStatement prepared = null;        
         conexion = conn.getConexion();
          try
    {
         prepared=conexion.prepareStatement(DELETE + GETONE);
         
         prepared.setString(1,id);
         
            if(prepared.executeUpdate()==0)
                {
                    System.out.println("ERROR ");
                }
            
    }catch (SQLException ex) 
    {
      System.out.println("ERROR ");
     
    }
    }

    @Override
    public Rol findById(String id) {
         PreparedStatement prepared = null;
      Rol getRol = null;       
       ResultSet resultado_data = null;
       conexion = conn.getConexion();        
        try
        {
            prepared=conexion.prepareStatement(GETALL + GETONE);
            prepared.setString(1, id);
            resultado_data=prepared.executeQuery();
            
            if(resultado_data.next())
            {
             getRol= Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                System.out.println("ERROR : "+ ex.getMessage());
            }
        
        return getRol;
    }
   

    @Override
    public List<Rol> findNames(String role) {
          PreparedStatement prepared = null;
       List<Rol> lista = new ArrayList<>();       
       ResultSet resultado_data = null;
       conexion = conn.getConexion();        
        try
        {
            prepared=conexion.prepareStatement(GETALL+ GETROLES);
            prepared.setString(1, role);
            resultado_data=prepared.executeQuery();
            
            while(resultado_data.next())
            {
              lista.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                System.out.println("ERROR : "+ ex.getMessage());
            }
        
        return lista;
    }
    
    @Override
    public String newCode() {
         String cod = "R0001";
        PreparedStatement prepare_new_code=null;
        conexion = conn.getConexion();
        ResultSet result_data=null;
		try{
			prepare_new_code = conexion.prepareStatement(NEWCOD);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
				DecimalFormat formato_decimal = new DecimalFormat("0000");
				cod = "R" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); 
			}
			
		}catch (SQLException e) {
		                  System.out.println("ERROR "+e.getMessage());
		}
		return cod;
    }
    
}
