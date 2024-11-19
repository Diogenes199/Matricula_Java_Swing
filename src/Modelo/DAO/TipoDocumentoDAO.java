package Modelo.DAO;

import Modelo.Conexion;
import Modelo.Entidades.TipoDocumento;
import Modelo.Interfaces.ITipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TipoDocumentoDAO implements ITipoDocumento{

     private Connection conexion;    
     private Conexion conn = new Conexion();
    
    private String INSERT = "INSERT INTO tipos_documentos(id_tipo_documento,descripcion) VALUES(?,?)";
     private String UPDATE = "UPDATE tipos_documentos SET descripcion = ?  ";
     private String DELETE = "DELETE FROM tipos_documentos ";
     private String GETALL = "SELECT id_tipo_documento, descripcion FROM tipos_documentos ";
     private String GETONE = " WHERE id_tipo_documento = ?";
      private String NEWCOD = "SELECT SUBSTRING(MAX(id_tipo_documento),3) FROM tipos_documentos";
    
     private TipoDocumento  Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("id_tipo_documento");
          String nombre = resultado_data.getString("descripcion");
          
         
          TipoDocumento getTipoDocumento =new TipoDocumento(id,nombre);
                    
          return getTipoDocumento;
    }
     
     
    @Override
    public List<TipoDocumento> findAll() {
        PreparedStatement prepared = null;
       List<TipoDocumento> lista = new ArrayList<>();       
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
    public void create(TipoDocumento documento) {
         PreparedStatement prepared = null;
         conexion = conn.getConexion();   
    try
    {
         prepared=conexion.prepareStatement(INSERT);
         
         prepared.setString(1,documento.getId());
         prepared.setString(2,documento.getDescripcion());
          
         
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
    public void update(TipoDocumento documento) {
           PreparedStatement prepared = null;
         conexion = conn.getConexion();   
    try
    {
         prepared=conexion.prepareStatement(UPDATE + GETONE);
         
         prepared.setString(1,documento.getDescripcion());
         prepared.setString(2,documento.getId());
          
         
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
    public TipoDocumento findById(String id) {
         PreparedStatement prepared = null;
      TipoDocumento getTipoDocumento = null;       
       ResultSet resultado_data = null;
       conexion = conn.getConexion();        
        try
        {
            prepared=conexion.prepareStatement(GETALL + GETONE);
            prepared.setString(1, id);
            resultado_data=prepared.executeQuery();
            
            if(resultado_data.next())
            {
             getTipoDocumento= Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                System.out.println("ERROR : "+ ex.getMessage());
            }
        
        return getTipoDocumento;
    }
   

   
    
    @Override
    public String newCode() {
         String cod = "D0001";
        PreparedStatement prepare_new_code=null;
        conexion = conn.getConexion();
        ResultSet result_data=null;
		try{
			prepare_new_code = conexion.prepareStatement(NEWCOD);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
				DecimalFormat formato_decimal = new DecimalFormat("0000");
				cod = "D" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); 
			}
			
		}catch (SQLException e) {
		                  System.out.println("ERROR "+e.getMessage());
		}
		return cod;
    }
}