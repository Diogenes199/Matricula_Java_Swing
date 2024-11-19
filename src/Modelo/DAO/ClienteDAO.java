package Modelo.DAO;

import Modelo.Conexion;
import Modelo.Entidades.Cliente;
import Modelo.Entidades.Rol;
import Modelo.Entidades.TipoDocumento;
import Modelo.Entidades.Usuario;
import Modelo.Interfaces.ICliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ClienteDAO implements ICliente{

    private Connection conexion;    
     private Conexion conn = new Conexion();

     private String INSERT = "INSERT INTO clientes (id_cliente, id_usuario, tipo_documento, numero_documento, sexo, fecha_nacimiento, ubigeo, pais, departamento, provincia, distrito)VALUES (?,?,?,?,?,?,?,?,?,?,?);";
     private String UPDATE = "UPDATE clientes SET tipo_documento = ?, numero_documento = ?, sexo = ?, fecha_nacimiento = ?, ubigeo = ?, pais = ?, departamento = ?, provincia = ?,distrito = ?";
     private String DELETE = "DELETE FROM clientes ";
     private String GETALL = "SELECT \n" +
"	U.id_usuario,\n" +
"    C.id_cliente,     \n" +
"    TD.descripcion, \n" +
"    C.numero_documento, \n" +
"    C.sexo, \n" +
"    C.fecha_nacimiento, \n" +
"    C.ubigeo, \n" +
"    C.pais, \n" +
"    C.departamento, \n" +
"    C.provincia, \n" +
"    C.distrito, \n" +
"    U.nombre, \n" +
"    U.apellido_paterno, \n" +
"    U.apellido_materno, \n" +
"    U.dni, \n" +
"    U.usuario, \n" +
"    U.celular1, \n" +
"    U.celular2, \n" +
"    U.direccion, \n" +
"    R.nombre_rol\n" +
"FROM \n" +
"    clientes C\n" +
"INNER JOIN \n" +
"    usuarios U ON C.id_usuario = U.id_usuario\n" +
"INNER JOIN \n" +
"    tipos_documentos TD  ON TD.id_tipo_documento = C.tipo_documento\n" +
"INNER JOIN \n" +
"	roles R ON U.id_rol = R.id_rol";
     private String GETONE = " WHERE id_cliente = ?";
     
     private String NEWCOD = "SELECT SUBSTRING(MAX(id_cliente),3) FROM clientes";

      public Cliente Data(ResultSet resultado_data) throws SQLException {
          String id_cliente=resultado_data.getString("id_cliente");
          String numeroDocumento = resultado_data.getString("numero_documento");
          String sexo = resultado_data.getString("sexo");
          Date fechaNacimiento = resultado_data.getDate("fecha_nacimiento");
          String ubigeo = resultado_data.getString("ubigeo");
          String pais = resultado_data.getString("pais");
          String departamento = resultado_data.getString("departamento");
          String provincia = resultado_data.getString("provincia");
          String distrito = resultado_data.getString("distrito");
          
          String id_user = resultado_data.getString("id_usuario");
          String nombre = resultado_data.getString("nombre");
          String apellidoPaterno = resultado_data.getString("apellido_paterno");
          String apellidoMaterno = resultado_data.getString("apellido_materno");
          String dni = resultado_data.getString("dni");
          String username = resultado_data.getString("usuario");
          String contra = resultado_data.getString("contra");
          String celularone = resultado_data.getString("celular1");
          String celulartwo = resultado_data.getString("celular2");
          String direccion = resultado_data.getString("direccion");
          
          Rol rol=new Rol();
          rol.setRol(resultado_data.getString("nombre_rol"));
          
          Usuario usuario = new Usuario(id_user,nombre,apellidoPaterno,apellidoMaterno,dni,username,contra,celularone,celulartwo,direccion,rol);
          TipoDocumento tipoDocumento = new TipoDocumento();
          tipoDocumento.setDescripcion(resultado_data.getString("descripcion"));
          
          Cliente cliente = new Cliente(id_cliente,usuario,tipoDocumento,numeroDocumento,sexo,fechaNacimiento,ubigeo,pais,departamento,provincia,distrito);
          
         
          return cliente;
    }
     

    @Override
    public List<Cliente> findAll() {
       PreparedStatement prepared = null;
       List<Cliente> lista = new ArrayList<>();       
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
        return lista.isEmpty() ? null : lista;    
        }catch (SQLException ex) 
            {
                System.out.println("ERROR  : "+ ex.getMessage());
                return null;
            }
    }

    @Override
    public void create(Cliente cliente) {
        PreparedStatement prepared = null;
         conexion = conn.getConexion();   
    try
    {
         prepared=conexion.prepareStatement(INSERT);
         prepared.setString(1, cliente.getId());
         prepared.setString(2, cliente.getUsuario().getId());
         prepared.setString(3, cliente.getDocumento().getId());
         prepared.setString(4, cliente.getNumeroDocumento());
         prepared.setString(5, cliente.getSexo());
         prepared.setDate(6, cliente.getFechaNacimiento());
         prepared.setString(7, cliente.getUbigeo());
         prepared.setString(8, cliente.getPais());
         prepared.setString(9, cliente.getPais());
         prepared.setString(10, cliente.getProvincia());
         prepared.setString(11, cliente.getDistrito());
                
            if(prepared.executeUpdate()==0)
                {
                    System.out.println("ERROR ");
                }
     
    }catch (SQLException ex) 
    {
          System.out.println("ERROR CREATE "+ ex.getMessage());
    }  
    }

    @Override
    public void update(Cliente cliente) {
        PreparedStatement prepared = null;        
         conexion = conn.getConexion();   
    try
    {
         prepared=conexion.prepareStatement(UPDATE + GETONE);
         prepared.setString(1, cliente.getUsuario().getId());
         prepared.setString(2, cliente.getDocumento().getId());
         prepared.setString(3, cliente.getNumeroDocumento());
         prepared.setString(4, cliente.getSexo());
         prepared.setDate(5,cliente.getFechaNacimiento());
         prepared.setString(6, cliente.getUbigeo());
         prepared.setString(7, cliente.getPais());
         prepared.setString(8, cliente.getPais());
         prepared.setString(9, cliente.getProvincia());
         prepared.setString(10, cliente.getDistrito());
         prepared.setString(11, cliente.getId());
            if(prepared.executeUpdate()==0)
                {
                    System.out.println("ERROR UPDATE");
                }
     
    }catch (SQLException ex) 
    {
        
          System.out.println("ERROR UPDATE"+ ex.getMessage());
        
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
      System.out.println("ERROR DELETE ");
                }
            
    }catch (SQLException ex) 
    {
      System.out.println("ERROR DELETE "+ ex.getMessage());
     
    }
    }

    @Override
    public Cliente findById(String id) {
        PreparedStatement prepared = null;
      Cliente getCliente = null;       
       ResultSet resultado_data = null;
       conexion = conn.getConexion();        
        try
        {
            prepared=conexion.prepareStatement(GETALL + GETONE);
            prepared.setString(1, id);
            resultado_data=prepared.executeQuery();
            
            if(resultado_data.next())
            {
             getCliente= Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                System.out.println("ERROR SEARCH : "+ ex.getMessage());
            }
        
        return getCliente;
    }

    
 @Override
    public String newCode() {
        String cod = "C0001";
        PreparedStatement prepare_new_code=null;
        conexion = conn.getConexion();
        ResultSet result_data=null;
		try{
			prepare_new_code = conexion.prepareStatement(NEWCOD);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
				DecimalFormat formato_decimal = new DecimalFormat("0000");
				cod = "C" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); 
			}
			
		}catch (SQLException e) {
		                  System.out.println("ERROR "+e.getMessage());
		}
		return cod;
    }

}
