package Modelo.DAO.Model;

import Modelo.Entidades.Cliente;
import Modelo.Entidades.Rol;
import Modelo.Entidades.TipoDocumento;
import Modelo.Entidades.Usuario;
import Modelo.Interfaces.Model.ICliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends BaseDAO implements ICliente {

    private final String INSERT = "INSERT INTO clientes (id_cliente, id_usuario, tipo_documento, numero_documento, sexo, fecha_nacimiento, ubigeo, pais, departamento, provincia, distrito)VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    private final String UPDATE = "UPDATE clientes SET tipo_documento = ?, numero_documento = ?, sexo = ?, fecha_nacimiento = ?, ubigeo = ?, pais = ?, departamento = ?, provincia = ?,distrito = ?";
    private final String DELETE = "DELETE FROM clientes ";
    private final String GETALL = "SELECT \n"
            + "    id_cliente,     \n"
            + "    tipo_documento, \n"
            + "    numero_documento, \n"
            + "    nombres, \n"
            + "    apellido_paterno, \n"
            + "    apellido_materno, \n"
            + "    email, \n"
            + "    celular1, \n"
            + "    celular2, \n"
            + "    sexo, \n"
            + "    fecha_nacimiento, \n"
            + "    ubigeo, \n"
            + "    pais, \n"
            + "    departamento, \n"
            + "    provincia, \n"
            + "    distrito, \n"
            + "    id_usuario_registro\n"
            + "FROM \n"
            + "    clientes ";
    
    private final String GETONE = " WHERE id_cliente = ?";

    private final String NEWCOD = "SELECT SUBSTRING(MAX(id_cliente),3) FROM clientes";

    public Cliente Data(ResultSet result) throws SQLException {

        return new Cliente(
                result.getString("id_cliente"),
                new TipoDocumento("tipo_documento"),
                result.getString("numero_documento"),
                result.getString("nombres"),
                result.getString("apellido_paterno"),
                result.getString("apellido_materno"),
                result.getString("email"),
                result.getString("celular1"),
                result.getString("celular2"),
                result.getString("sexo"),
                result.getDate("fecha_nacimiento").toLocalDate(),
                result.getString("ubigeo"),
                result.getString("pais"),
                result.getString("departamento"),
                result.getString("provincia"),
                result.getString("distrito"),
                new Usuario(result.getString("id_usuario_registro"))                
        );
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> lista = new ArrayList<>();
        
        try(PreparedStatement prepared = getConnection().prepareStatement(GETALL);) {
            
            try(ResultSet resultado_data = prepared.executeQuery();){
                
            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }
            return lista.isEmpty() ? null : lista;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR  : " + ex.getMessage());
            return null;
        } 
    }

    @Override
    public void create(Cliente cliente) {
        
        try(PreparedStatement prepared = getConnection().prepareStatement(INSERT);) {
           
            prepared.setString(1, cliente.getId());
            prepared.setString(2, cliente.getUsuario().getId());
            prepared.setString(3, cliente.getDocumento().getId());
            prepared.setString(4, cliente.getNumeroDocumento());
            prepared.setString(5, cliente.getSexo());
            prepared.setDate(6, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
            prepared.setString(7, cliente.getUbigeo());
            prepared.setString(8, cliente.getPais());
            prepared.setString(9, cliente.getPais());
            prepared.setString(10, cliente.getProvincia());
            prepared.setString(11, cliente.getDistrito());

            if (prepared.executeUpdate() == 0) {
                System.out.println("ERROR ");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR CREATE " + ex.getMessage());
        }         
    }

    @Override
    public void update(Cliente cliente) {
        
        connection = getConnection();
        try(PreparedStatement prepared = getConnection().prepareStatement(UPDATE + GETONE);) 
        {
            prepared.setString(1, cliente.getUsuario().getId());
            prepared.setString(2, cliente.getDocumento().getId());
            prepared.setString(3, cliente.getNumeroDocumento());
            prepared.setString(4, cliente.getSexo());
            prepared.setDate(5, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
            prepared.setString(6, cliente.getUbigeo());
            prepared.setString(7, cliente.getPais());
            prepared.setString(8, cliente.getPais());
            prepared.setString(9, cliente.getProvincia());
            prepared.setString(10, cliente.getDistrito());
            prepared.setString(11, cliente.getId());
            if (prepared.executeUpdate() == 0) {
                System.out.println("ERROR UPDATE");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATE" + ex.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        try (PreparedStatement  prepared = getConnection().prepareStatement(DELETE + GETONE);){
            prepared.setString(1, id);
            
            if (prepared.executeUpdate() == 0) {
                System.out.println("ERROR DELETE ");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR DELETE " + ex.getMessage());

        } 
    }

    @Override
    public Cliente findById(String id) {
        Cliente getCliente = null;
        connection = getConnection();
        try(PreparedStatement prepared = connection.prepareStatement(GETALL + GETONE);)
        {
            prepared.setString(1, id);
           try(ResultSet resultado_data = prepared.executeQuery())
           {
            if (resultado_data.next()) {
                getCliente = Data(resultado_data);
            }   
           }
        } catch (SQLException ex) {
            System.out.println("ERROR SEARCH : " + ex.getMessage());
        } 

        return getCliente;
    }

    @Override
    public String newCode() {
        String cod = "C0001";
        try (
            PreparedStatement prepare_new_code = getConnection().prepareStatement(NEWCOD);
            ResultSet result_data = prepare_new_code.executeQuery();
                ){
            if (result_data.next()) {
                DecimalFormat formato_decimal = new DecimalFormat("0000");
                cod = "C" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1);
            }

        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        } 
        return cod;
    }

}
